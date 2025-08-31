package com.example.avsk.lms.service;

import com.example.avsk.lms.model.Author;
import com.example.avsk.lms.model.Category;
import com.example.avsk.lms.repo.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepo categoryRepo;

    public List<Category> getAllCategories(){
        return categoryRepo.findAll();
    }

    public Category getCategoryById(int id){
        return categoryRepo.findById(id).orElseThrow(() -> new RuntimeException("Given Id is incorrect"));
    }

    public Category saveOrUpdateCategory(Category category){
        return categoryRepo.save(category);
    }

    public void deleteCategoryById(int id){
        categoryRepo.findById(id).orElseThrow(() -> new RuntimeException("Given Id is incorrect"));
        categoryRepo.deleteById(id);
    }
}


