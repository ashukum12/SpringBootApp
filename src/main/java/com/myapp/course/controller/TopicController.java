package com.myapp.course.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.myapp.course.dao.TopicDao;
import com.myapp.course.model.Topic;
import com.myapp.course.model.Topics;

@RestController
@RequestMapping(path = "/topic")
public class TopicController {
	
	@Autowired
	private TopicDao topicDao;
	
	@GetMapping(path="/", produces = "application/json")
	public Topics getTopics(){
		
		return topicDao.getAllTopic();
	}
	
	@PostMapping(path= "/", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> addEmployee(@RequestBody Topic topic){
		Integer id = topicDao.getAllTopic().getTopicList().size()+1;
        
		topic.setId(id);
        
		topicDao.addTopic(topic);
         	
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                                    .path("/{id}")
                                    .buildAndExpand(topic.getId())
                                    .toUri();
         
        return ResponseEntity.created(location).build();
    }

}
