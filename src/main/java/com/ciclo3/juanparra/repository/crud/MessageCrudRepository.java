package com.ciclo3.juanparra.repository.crud;

import com.ciclo3.juanparra.model.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageCrudRepository extends CrudRepository <Message, Integer>{
    
}
