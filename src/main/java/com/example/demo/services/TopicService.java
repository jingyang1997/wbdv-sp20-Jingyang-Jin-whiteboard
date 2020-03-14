package com.example.demo.services;

import com.example.demo.models.Topic;
import com.example.demo.models.Widget;
import com.example.demo.repositories.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicService {
    @Autowired
    TopicRepository topicRepository;
    //Here I don't assume that the input topic has set lessonId.
    public Topic createTopic(String lid, Topic topic){
        topic.setLessonId(lid);
        return topicRepository.save(topic);
    }

    public List<Topic> findTopicsForLesson(String lid){
        return topicRepository.findTopicsForLesson(lid);
    }
    //If failed to update, return 0. Else, return 1. Here I assume that the input topic has setId.
    public int updateTopic(int tid, Topic topic){
        if (!topicRepository.findById(tid).isPresent()){
            return 0;
        }

        topicRepository.save(topic);
        return 1;
    }

    public int deleteTopic(int tid){
        if(!topicRepository.findById(tid).isPresent()){
            return 0;
        }
        topicRepository.deleteById(tid);
        return 1;
    }

    //Return a List of all topics.
    public List<Topic> findAllTopics(){
        return (List<Topic>) topicRepository.findAll();
    }

    public Topic findTopicById(Integer tid){
        return topicRepository.findTopicById(tid);
    }
}
