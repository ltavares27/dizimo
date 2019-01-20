package br.com.dizimo.resource;

import br.com.dizimo.model.Dizimo;
import br.com.dizimo.service.DizimoService;
import br.com.dizimo.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RequestMapping("/dizimo")
@RestController
public class DizimoResource {

    @Autowired
    private PessoaService pessoaService;

    @Autowired
    private DizimoService dizimoService;

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public ResponseEntity getDizimo(){
        return ResponseEntity.ok("ok");
    }

    @PostMapping("/save")
    public ResponseEntity<Dizimo> saveDizimo(@RequestBody Dizimo dizimo){
        Dizimo dizimoResponse = null;
        if(dizimo.getId() == null && dizimo.getPessoa().getId() != null){
            dizimo.setPessoa(this.pessoaService.findPessoaId(dizimo.getPessoa().getId()));
            dizimoResponse = dizimoService.salvarDizimo(dizimo);
            if(dizimoResponse != null) {
                return ResponseEntity.ok(dizimoResponse);
            }
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/update/{idDizimo}")
    public ResponseEntity<String> editarDizimo(@RequestBody Dizimo DizimoAtual, @PathVariable Integer idDizimo){
        if(idDizimo != null) {
            Dizimo oldDizimo = dizimoService.findDizimoId(idDizimo);
            if (oldDizimo != null) {
                if (oldDizimo != null) {
                    oldDizimo.setPessoa(DizimoAtual.getPessoa());
                    oldDizimo.setDataPagamento(new Date());
                    oldDizimo.setMes(DizimoAtual.getMes());
                    oldDizimo.setValor(DizimoAtual.getValor());
                    oldDizimo.setObservacao(DizimoAtual.getObservacao());
                    dizimoService.salvarDizimo(DizimoAtual);
                    return ResponseEntity.ok("Atualizado com Sucesso");
                }
            }
        }
        return ResponseEntity.badRequest().build();
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletarDizimo(@PathVariable("id") Integer id) {
        if(id != null) {
            Dizimo dizimo = dizimoService.findDizimoId(id);
            if(dizimo != null) {
                dizimoService.deletarDizimo(dizimo);
                return ResponseEntity.ok("Deletado com sucesso!");
            }
        }
        return ResponseEntity.badRequest().build();
    }
}
