package com.collabera.hackton.hugo.services;

import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.amazonaws.services.lexruntime.AmazonLexRuntime;
import com.amazonaws.services.lexruntime.AmazonLexRuntimeClientBuilder;
import com.amazonaws.services.lexruntime.model.PostTextRequest;
import com.amazonaws.services.lexruntime.model.PostTextResult;
import com.collabera.hackton.common.HugoHelper;
import com.collabera.hackton.hugo.controller.HugoController;

@Service
public class HugoAIChatServiceImpl implements IHugoAIChatService{

	private static final Logger logger = LoggerFactory.getLogger(HugoAIChatServiceImpl.class);
	
	@Value( "${hugo.name}" )
	private String botName;
	
	@Value( "${hugo.alias}" )
	private String botAlias;
		
	
	public String getAdvice(String text,String userid) {
		
		if(text == null || text.isBlank()) return "Not valid input";
		text = HugoHelper.dataValidation(text);
		AmazonLexRuntime client = AmazonLexRuntimeClientBuilder.standard().build();
		
		PostTextRequest pReq = new PostTextRequest();
		pReq.withBotName(botName);
		pReq.withBotAlias(botAlias);
		pReq.withInputText(text);
		pReq.withUserId(userid);
		
		logger.info("received getAdvice request for {} with question {}",userid,text);
		PostTextResult result = null;
		String erroResp = null;
		try  {
			result = client.postText(pReq);
		} catch (Exception e) {
			// TODO: handle exception
			erroResp = "Hugo unable to anwser your question. please try again";
		}
		logger.info("return response {}",result.getMessageFormat());

		return erroResp == null? result.getMessage(): erroResp;
	}
}
