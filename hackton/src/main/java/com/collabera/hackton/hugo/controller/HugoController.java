package com.collabera.hackton.hugo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

import com.collabera.hackton.hugo.model.ChatHistory;
import com.collabera.hackton.hugo.services.IHugoAIChatService;
import com.collabera.hackton.hugo.services.IHugoChatDataService;

@RestController
@CrossOrigin("*")
public class HugoController {

	private static final Logger logger = LoggerFactory.getLogger(HugoController.class);
	
	@Autowired
	IHugoAIChatService runtimeClient;
	
	@Autowired
	IHugoChatDataService dataService;
	
	@GetMapping(path = "/")
	@CrossOrigin("*")
	public String welcome() {
		logger.info("request for hugo");
		return "Weclome to Hugo";
	}
	
	@PostMapping(path = "/advice", produces = MediaType.APPLICATION_JSON_VALUE)
	@CrossOrigin("*")
	public String chat(@RequestPart(value="text",required=true) String text,
						@RequestPart(value="userid",required=true) String userid,
						@RequestPart(value="usertype",required=true) String userType) {
		
		String hugoResp = runtimeClient.getAdvice(text,userid);
		
		dataService.saveChatData(userid, userType, text, hugoResp);
		//String hugoResp ="abc";
		return hugoResp;
	}
	
	
	@PostMapping(path = "/chathist", produces = MediaType.APPLICATION_JSON_VALUE)
	@CrossOrigin("*")
	public List<ChatHistory> getChatHistory(@RequestPart(value="username",required=true) String name
						) {
		logger.info("request to get chat history for {}",name);
		return dataService.getChatDataByName(name);
	}
	
}
