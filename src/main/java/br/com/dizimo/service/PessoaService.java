package br.com.dizimo.service;

import br.com.dizimo.model.Pessoa;
import br.com.dizimo.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public Pessoa salvarPessoa(Pessoa pessoa){
        if(pessoa != null){
            return this.pessoaRepository.save(pessoa);
        }
        return null;
    }

    public Pessoa findPessoaId(Integer id){
        return this.pessoaRepository.findPessoaById(id);
    }
}
