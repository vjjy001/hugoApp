package com.collabera.hackton.hugo.services;


import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.collabera.hackton.hugo.dao.IHugoChatDao;
import com.collabera.hackton.hugo.model.ChatHistory;

@Service
public class HugoChatDataServiceImpl implements IHugoChatDataService {

	private static final Logger logger = LoggerFactory.getLogger(HugoChatDataServiceImpl.class);

	@Autowired
	private IHugoChatDao hugoChatDao;
	
	
	public void saveChatData(String userName, String userType, String question, String answer) {
		ChatHistory chat = new ChatHistory();
		chat.setUserName(userName);
		chat.setUserType(userType);
		chat.setQuestions(question);
		chat.setAnswer(answer);
		chat.setSubmissionDate(new Date(System.currentTimeMillis()));		
		hugoChatDao.save(chat);
		logger.info("save user :: {} chat data into db",userName);
	}
	
	
	public List<ChatHistory> getChatDataByName(String name) {
		/*
		 * List<ChatHistory> list =
		 * hugoChatDao.findByUserNameOrderBySubmissionDateDesc(name); return list.size()
		 * < 20 ? list: list.subList(0, 19);
		 */
		
		return hugoChatDao.findChatByUserNameOrderByDate(name);
	}
}
