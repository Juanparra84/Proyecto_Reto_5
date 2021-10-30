package com.ciclo3.juanparra.repository;

import java.util.List;
import java.util.Optional;
import com.ciclo3.juanparra.model.Category;
import com.ciclo3.juanparra.repository.crud.CategoryCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository

public class CategoryRepository {

    @Autowired
    CategoryCrudRepository categoryCrudRepository;
    
    public List<Category>getAll(){
        return (List<Category>)categoryCrudRepository.findAll();
    }

    public Optional<Category>getCategory(int id){
        return categoryCrudRepository.findById(id);
    }
    
    public Category save (Category catd){
        return categoryCrudRepository.save(catd);
    }

    
    public void delete(Category catd){
        categoryCrudRepository.delete(catd);
    }

}
