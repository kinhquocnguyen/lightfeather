package com.lightleather.encoding;

import org.springframework.stereotype.Service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;

@Service
public class EncodingService {

    String ENCODED_MESSAGE_SAVED_DIR = "/Users/qnguyen/Download/EncodedMessage";
    String ENCODED_MESSAGE_SAVED_FILE = "message.txt";

    public String encode(MessageEntity rawMessage) throws Exception{
        String result = "";
        char blank = ' ';

        if (rawMessage != null && rawMessage.getShift() != null && rawMessage.getMessage()!=null){
            String message = rawMessage.getMessage();
            int shift = rawMessage.getShift();
            for (int i=0;i <message.length(); i++){
                char c = message.charAt(i);
                if (!Character.isLetter(c) && c!=blank){
                    throw new Exception("Not supported character!");
                }
                result = result +  ((c != blank)? (char) (c+shift):' ');
            }
        }

        return  result;
    }

    public void saveEncodeMessage(String encodeMessage) {
        try {
            File directory = new File(ENCODED_MESSAGE_SAVED_DIR);
            if (! directory.exists()){
                boolean done = directory.mkdirs();
                System.out.println(done);
            }

            File file = new File(ENCODED_MESSAGE_SAVED_DIR+"/"+ENCODED_MESSAGE_SAVED_FILE);

            if(!file.exists()) {
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file,true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("\n"+encodeMessage);
            bw.close();


        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

    }
}
