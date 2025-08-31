package com.example.avsk.lms.controller;

import com.example.avsk.lms.model.Author;
import com.example.avsk.lms.model.Publisher;
import com.example.avsk.lms.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/publisher")
public class PublisherController {

    @Autowired
    private PublisherService publisherService;

    @GetMapping
    public ResponseEntity<List<Publisher>> getAllPublishers(){
        List<Publisher> publishers = publisherService.getAllPublishers();
        return ResponseEntity.ok(publishers);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePublisher(@PathVariable int id){
        Publisher publisher = publisherService.getPublisherById(id);
        if(publisher == null){
            return ResponseEntity.notFound().build();
        }
        publisherService.deletePublisherById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Publisher> getPublisher(@PathVariable int id){
        Publisher publisher = publisherService.getPublisherById(id);
        if(publisher == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(publisher);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Publisher> updatePublisher(@PathVariable int id, @RequestBody Publisher publisher){
        Publisher existingPublisher = publisherService.getPublisherById(id);
        if(existingPublisher == null){
            return ResponseEntity.notFound().build();
        }
        publisher.setId(id);
        publisherService.saveOrUpdatePublisher(publisher);
        return ResponseEntity.ok(publisher);
    }

    @PostMapping
    public ResponseEntity<Publisher> savePublisher(@RequestBody Publisher publisher){
        Publisher createdPublisher = publisherService.saveOrUpdatePublisher(publisher);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPublisher);
    }

}

