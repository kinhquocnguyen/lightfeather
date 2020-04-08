package com.lightleather.encoding;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("api/")
public class EncodingController {

    @Autowired
    private EncodingService encodingService;

    @RequestMapping("/test")
    public String index(){
        return "Hello!!!";
    }

    @PostMapping(path = "/encoding")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<EncodedEntity> encoding(@RequestBody MessageEntity messageEntity) {
        try {
            String encodedMessge = encodingService.encode(messageEntity);

            if (encodedMessge != null && encodedMessge.length() > 0) {
                encodingService.saveEncodeMessage(encodedMessge);
                return ResponseEntity.ok(new EncodedEntity(encodedMessge));
            }
        }catch (Exception e){
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
}
