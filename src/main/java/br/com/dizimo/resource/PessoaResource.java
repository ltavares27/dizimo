package br.com.dizimo.resource;

import br.com.dizimo.model.Pessoa;
import br.com.dizimo.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/pessoas")
@RestController
@CrossOrigin
public class PessoaResource  {

    @Autowired
    private PessoaService pessoaService;

    @GetMapping("/pessoa/{idPessoa}") //READ
    public ResponseEntity<?> getPessoa(@PathVariable("idPessoa") Integer id) {
        if(id != null) {
            Pessoa pessoa = pessoaService.findPessoaId(id);
            return ResponseEntity.ok(pessoa);
        }
        return ResponseEntity.badRequest().build();
    }

    @PostMapping("/save") //CREATE
    public ResponseEntity<Pessoa> salvarPessoa(@RequestBody Pessoa pessoa){
        Pessoa pessoaResponse = null;
        if(pessoa.getId() == null){
            pessoaResponse = pessoaService.salvarPessoa(pessoa);
        } if(pessoaResponse != null) {
            return ResponseEntity.ok(pessoaResponse);
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/update/{idPessoa}") //UPDATE
    public ResponseEntity<?> editarPessoas(@RequestBody Pessoa pessoaAtual, @PathVariable("idPessoa") Integer id) {
       if(id != null){
          Pessoa pessoaOld = pessoaService.findPessoaId(id);
         if(pessoaOld != null) {
            pessoaService.editarPessoa(pessoaOld, pessoaAtual);
             return ResponseEntity.ok("Atualizado com Sucesso");
         }
       }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/delete/{idPessoa}") //DELETE
    public ResponseEntity<?> deletarPessoa(@PathVariable("idPessoa") Integer id){
       if(id != null) {
          Pessoa pessoa = pessoaService.findPessoaId(id);
          pessoaService.deletarPessoa(pessoa);
           return ResponseEntity.ok("Deletado com Sucesso");
       }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/list") //READ
    public ResponseEntity<List<?>> getListAllDizimo(){
        return new ResponseEntity<>(this.pessoaService.getAllPesssoas(), HttpStatus.OK);
    }
}
