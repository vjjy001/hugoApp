package com.collabera.hackton.hugo.services;

import java.util.List;

import com.collabera.hackton.hugo.model.ChatHistory;

public interface IHugoChatDataService {
	public void saveChatData(String userName, String userType, String question, String answer);
	public List<ChatHistory> getChatDataByName(String name);
}
