package br.com.dizimo.service;

import br.com.dizimo.model.Dizimo;
import br.com.dizimo.repository.DizimoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class DizimoService {

    @Autowired
    private DizimoRepository dizimoRepository;

    public Dizimo salvarDizimo(Dizimo dizimo){
       if(dizimo != null){
           return this.dizimoRepository.save(dizimo);
       }
       return null;
    }

    public void deletarDizimo(Dizimo dizimo){
        if(dizimo.getId() != null){
           this.dizimoRepository.delete(dizimo);
        }
    }

    public Dizimo findDizimoId(Integer id){
       return this.dizimoRepository.findDizimoById(id);
    }

}
