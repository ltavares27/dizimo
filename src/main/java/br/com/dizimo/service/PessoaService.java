package br.com.dizimo.service;

import br.com.dizimo.model.Dizimo;
import br.com.dizimo.model.Pessoa;
import br.com.dizimo.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<Pessoa> getAllPesssoas() {
        return this.pessoaRepository.findAll();
    }

    public void editarPessoa(Pessoa pessoaOld, Pessoa pessoaAtual) {
        if(pessoaAtual != null && pessoaOld != null) {
           pessoaOld.setNome(pessoaAtual.getNome());
           pessoaOld.setCpf(pessoaAtual.getCpf());
           pessoaOld.setDataNascimento(pessoaAtual.getDataNascimento());
           pessoaOld.setTelefone(pessoaAtual.getTelefone());
           pessoaOld.setEnderecos(pessoaAtual.getEnderecos());
           pessoaRepository.save(pessoaOld);
        }
    }

    public void deletarPessoa(Pessoa pessoa) {
       this.pessoaRepository.delete(pessoa);
    }
}
