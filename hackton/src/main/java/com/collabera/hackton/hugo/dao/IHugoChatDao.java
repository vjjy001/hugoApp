package com.collabera.hackton.hugo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.collabera.hackton.hugo.model.ChatHistory;


public interface IHugoChatDao extends JpaRepository<ChatHistory, Long>{

	public List<ChatHistory> findByUserNameOrderBySubmissionDateDesc(String userName);
	
	@Query(value = "SELECT * FROM chat_history c WHERE c.userName = :userName ORDER BY c.submission_date DESC limit 20",
            nativeQuery = true)
	public List<ChatHistory> findChatByUserNameOrderByDate(@Param("userName") String userName);

}