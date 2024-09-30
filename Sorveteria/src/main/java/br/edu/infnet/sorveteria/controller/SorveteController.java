package br.edu.infnet.sorveteria.controller;

import br.edu.infnet.sorveteria.model.Sorvete;
import br.edu.infnet.sorveteria.model.SorveteHistory;
import br.edu.infnet.sorveteria.service.SorveteHistoryService;
import br.edu.infnet.sorveteria.service.SorveteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sorvetes")
public class SorveteController {

    @Autowired
    private SorveteService sorveteService;

    @Autowired
    private SorveteHistoryService sorveteHistoryService;

    @GetMapping
    public ResponseEntity<List<Sorvete>> listarTodos() {
        List<Sorvete> sorvetes = sorveteService.listarTodos();
        return new ResponseEntity<>(sorvetes, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sorvete> buscarPorId(@PathVariable Long id) {
        Sorvete sorvete = sorveteService.buscarPorId(id);
        if (sorvete != null) {
            return new ResponseEntity<>(sorvete, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Sorvete> criarSorvete(@RequestBody Sorvete sorvete) {
        Sorvete novoSorvete = sorveteService.salvar(sorvete);
        return new ResponseEntity<>(novoSorvete, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Sorvete> atualizarSorvete(@PathVariable Long id, @RequestBody Sorvete sorveteAtualizado) {
        Sorvete sorveteExistente = sorveteService.buscarPorId(id);
        if (sorveteExistente != null) {
            sorveteExistente.setSabor(sorveteAtualizado.getSabor());
            sorveteExistente.setTipo(sorveteAtualizado.getTipo());
            sorveteExistente.setPreco(sorveteAtualizado.getPreco());
            Sorvete sorveteSalvo = sorveteService.salvar(sorveteExistente);
            return new ResponseEntity<>(sorveteSalvo, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarSorvete(@PathVariable Long id) {
        sorveteService.deletar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{id}/history")
    public List<SorveteHistory> getHistory(@PathVariable Long id) {
        return sorveteHistoryService.getHistory(id);
    }

    @GetMapping("/fornecedores")
    public List<Object> listarFornecedores() {
        return sorveteService.obterListaDeFornecedores();
    }
}