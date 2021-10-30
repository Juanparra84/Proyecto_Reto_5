package com.ciclo3.juanparra.repository;

import java.util.List;
import java.util.Optional;
import com.ciclo3.juanparra.model.Message;
import com.ciclo3.juanparra.repository.crud.MessageCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository

public class MessageRepository {
    
    @Autowired
    MessageCrudRepository messageCrudRepository;
    
    public List<Message>getAll(){
        return (List<Message>)messageCrudRepository.findAll();
        
    }

    public Optional<Message>getMessage(int id){
        return messageCrudRepository.findById(id);
    }
    
    public Message save (Message msg){
        return messageCrudRepository.save(msg);
    }

    public void delete(Message msg){
        messageCrudRepository.delete(msg);
    }
    

}
