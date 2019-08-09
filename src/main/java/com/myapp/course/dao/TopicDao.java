package com.myapp.course.dao;

import org.springframework.stereotype.Repository;

import com.myapp.course.model.Topic;
import com.myapp.course.model.Topics;

@Repository
public class TopicDao {
	
	private static Topics list = new Topics();
	
	static
	{
		list.getTopicList().add(new Topic(101, "Java", " Java IS a programming language" ));
		list.getTopicList().add(new Topic(102 , "Angular", "Angular is very good  ui"));
		list.getTopicList().add(new Topic(103, "Spring Boot", "Spring Boot is most popular framwork in java"));
	}
	
	public Topics getAllTopic(){
		return list;
	}
	
	public void addTopic(Topic topic){
		list.getTopicList().add(topic);
	}
}
