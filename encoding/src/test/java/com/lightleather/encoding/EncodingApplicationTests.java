package com.lightleather.encoding;

import com.fasterxml.jackson.databind.JsonNode;
import org.json.JSONObject;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)

class EncodingApplicationTests {

	@Autowired
	private EncodingService encodingService;

	@Autowired
	Environment environment;

	@Test
	public void encodingServiceTest() {
		try {
			String encodedStr = encodingService.encode(new MessageEntity(1, "Abc"));
			assertTrue(encodedStr.equals("Bcd"));

			encodedStr = encodingService.encode(new MessageEntity(3, "dad"));
			assertTrue(encodedStr.equals("gdg"));

			encodedStr = encodingService.encode(new MessageEntity(2, "the eagle has landed"));
			assertTrue(encodedStr.equals("vjg gcing jcu ncpfgf"));
		}catch (Exception e){
			assertTrue(false);
		}
	}


	@Test
	public void encodingControllerTest() throws Exception
	{
		String port = environment.getProperty("local.server.port");
		String encodingUrl = "http://localhost:"+port+"/api/encoding";

		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		JSONObject messageJsonObject = new JSONObject();
		messageJsonObject = new JSONObject();
		messageJsonObject.put("shift", "1");
		messageJsonObject.put("message", "We are united");

		HttpEntity<String> request = new HttpEntity<String>(messageJsonObject.toString(), headers);

		ResponseEntity<EncodedEntity> messageResult = restTemplate.postForEntity(encodingUrl, request, EncodedEntity.class);

		assertNotNull(messageResult.getBody());
		assertNotNull(messageResult.getBody().getEncodedMessage());
	}

}
