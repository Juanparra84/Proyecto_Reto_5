package com.ciclo3.juanparra.service;

import com.ciclo3.juanparra.model.Audience;
import com.ciclo3.juanparra.repository.AudienceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service

public class AudienceService {

    @Autowired
    private AudienceRepository audienceRepository;

    public List<Audience> getAll() {
        return audienceRepository.getAll();
    }

    public Optional<Audience> getAudience(int id) {
        return audienceRepository.getAudience(id);
    }

    public Audience save(Audience audi) {
        if (audi.getId() == null) {
            return audienceRepository.save(audi);
        } else {
            Optional<Audience> consulta = audienceRepository.getAudience(audi.getId());
            if (consulta.isEmpty()) {
                return audienceRepository.save(audi);
            } else {
                return audi;
            }
        }
    }

    public Audience update(Audience audi){
        if(audi.getId()!=null){
            Optional<Audience> consulta = audienceRepository.getAudience(audi.getId());
            if(!consulta.isEmpty()){
                if(audi.getOwner()!=null){
                    consulta.get().setOwner(audi.getOwner());
                }
                if(audi.getName()!=null){
                   consulta.get().setName(audi.getName());
                }
                if(audi.getCapacity()!=null){
                    consulta.get().setCapacity(audi.getCapacity());
                 }
                 if(audi.getDescription()!=null){
                    consulta.get().setDescription(audi.getDescription());
                 }
                return audienceRepository.save(consulta.get());
            }
        }
        return audi;
    }

    public boolean deleteAudience(int audienceId){
        Boolean auBoolean=getAudience(audienceId).map(audience -> {
           audienceRepository.delete(audience);
            return true;
        }).orElse(false);
        return auBoolean;
    }
}
