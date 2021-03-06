package br.com.dizimo.service;

import br.com.dizimo.model.Dizimo;
import br.com.dizimo.repository.DizimoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Dictionary;
import java.util.List;

@Service
public class DizimoService {

    @Autowired
    private DizimoRepository dizimoRepository;

    public Dizimo salvarDizimo(Dizimo dizimo){
        if(dizimo != null){
            dizimo.setDataPagamento(new Date());
            return this.dizimoRepository.save(dizimo);
        }
        return null;
    }

    public Dizimo editarDizimo(Dizimo oldDizimo, Dizimo dizimoAtual){
        if(oldDizimo != null){
            oldDizimo.setDataPagamento(new Date());
            oldDizimo.setMes(dizimoAtual.getMes());
            oldDizimo.setValor(dizimoAtual.getValor());
            oldDizimo.setObservacao(dizimoAtual.getObservacao());
            return this.dizimoRepository.save(oldDizimo);
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

    public List<Dizimo> getAllDizimos() {
        return this.dizimoRepository.findAll();
    }
}
