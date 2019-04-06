package br.com.dizimo.resource;

import br.com.dizimo.model.Dizimo;
import br.com.dizimo.service.DizimoService;
import br.com.dizimo.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/dizimos")
@RestController
@CrossOrigin
public class DizimoResource {

    @Autowired
    private PessoaService pessoaService;

    @Autowired
    private DizimoService dizimoService;

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public ResponseEntity getDizimo(){
        return ResponseEntity.ok("ok");
    }

    @GetMapping("/list") //READ
    public ResponseEntity<List<?>> getListAllDizimo(){
        return new ResponseEntity<>(this.dizimoService.getAllDizimos(), HttpStatus.OK);
    }

    @GetMapping("/{idDizimo}") //READ
    public ResponseEntity<Dizimo> getDizimiById(@PathVariable("idDizimo") Integer id) {
        Dizimo dizimo = this.dizimoService.findDizimoId(id);
        if(dizimo != null) {
            return ResponseEntity.ok(dizimo);
        }
        return ResponseEntity.badRequest().build();
    }

    @PostMapping("/save") //CREATE
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

    @PutMapping("/update/{idDizimo}") //UPDATE
    public ResponseEntity<String> editarDizimo(@RequestBody Dizimo dizimoAtual, @PathVariable("idDizimo") Integer id){
        if(id != null) {
            Dizimo oldDizimo = dizimoService.findDizimoId(id);
            if (oldDizimo != null) {
                dizimoService.editarDizimo(oldDizimo, dizimoAtual);
                return ResponseEntity.ok("Atualizado com Sucesso");
            }
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/delete/{idDizimo}") //DELETE
    public ResponseEntity<?> deletarDizimo(@PathVariable("idDizimo") Integer id) {
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
