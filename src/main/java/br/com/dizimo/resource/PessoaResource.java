package br.com.dizimo.resource;

import br.com.dizimo.model.Pessoa;
import br.com.dizimo.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/pessoas")
@RestController
public class PessoaResource  {

    @Autowired
    private PessoaService pessoaService;

    @PostMapping("/save")
    public ResponseEntity<Pessoa> salvarPessao(@RequestBody Pessoa pessoa){
        Pessoa pessoaResponse = null;
        if(pessoa.getId() == null){
            pessoaResponse = pessoaService.salvarPessoa(pessoa);
        } if(pessoaResponse != null) {
            return ResponseEntity.ok(pessoaResponse);
        }
        return ResponseEntity.badRequest().build();
    }
}
