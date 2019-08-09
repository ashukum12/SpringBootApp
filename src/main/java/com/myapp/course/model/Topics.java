package com.myapp.course.model;

import java.util.ArrayList;
import java.util.List;

public class Topics {
	
	public List<Topic> topicList;

	public List<Topic> getTopicList() {
		if(topicList == null){
			topicList = new ArrayList<>();
		}
		return topicList;
	}

	public void setTopicList(List<Topic> topicList) {
		this.topicList = topicList;
	}
	
}
