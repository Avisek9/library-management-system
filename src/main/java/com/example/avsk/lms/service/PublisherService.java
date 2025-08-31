package com.example.avsk.lms.service;

import com.example.avsk.lms.model.Publisher;
import com.example.avsk.lms.repo.PublisherRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublisherService {

    @Autowired
    private PublisherRepo publisherRepo;

    public List<Publisher> getAllPublishers(){
        return publisherRepo.findAll();
    }

    public Publisher getPublisherById(int id){
        return publisherRepo.findById(id).orElseThrow(() -> new RuntimeException("Given Id is incorrect"));
    }

    public Publisher saveOrUpdatePublisher(Publisher publisher){
        return publisherRepo.save(publisher);
    }

    public void deletePublisherById(int id){
        publisherRepo.findById(id).orElseThrow(() -> new RuntimeException("Given Id is incorrect"));
        publisherRepo.deleteById(id);
    }
}

