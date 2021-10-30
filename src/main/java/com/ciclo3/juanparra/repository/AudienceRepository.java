package com.ciclo3.juanparra.repository;

import com.ciclo3.juanparra.model.Audience;
import com.ciclo3.juanparra.repository.crud.AudienceCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository

public class AudienceRepository {

    @Autowired
    AudienceCrudRepository audienceCrudRepository;
    
    public List<Audience>getAll(){
        return (List<Audience>)audienceCrudRepository.findAll();
    }

    public Optional<Audience>getAudience(int id){
        return audienceCrudRepository.findById(id);
    }
    
    public Audience save (Audience audi){
        return audienceCrudRepository.save(audi);
    }

    public void delete(Audience audi){
        audienceCrudRepository.delete(audi);
    }

}


