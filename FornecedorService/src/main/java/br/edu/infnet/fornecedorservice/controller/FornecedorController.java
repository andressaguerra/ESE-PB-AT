package br.edu.infnet.fornecedorservice.controller;

import br.edu.infnet.fornecedorservice.model.Fornecedor;
import br.edu.infnet.fornecedorservice.service.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fornecedores")
public class FornecedorController {

    @Autowired
    private FornecedorService fornecedorService;

    @GetMapping
    public List<Fornecedor> listarTodos() {
        return fornecedorService.listarTodos();
    }

    @GetMapping("/{id}")
    public Fornecedor buscarPorId(@PathVariable Long id) {
        return fornecedorService.buscarPorId(id);
    }

    @PostMapping
    public Fornecedor criarFornecedor(@RequestBody Fornecedor fornecedor) {
        return fornecedorService.salvarFornecedor(fornecedor);
    }

    @PutMapping("/{id}")
    public Fornecedor atualizarFornecedor(@PathVariable Long id, @RequestBody Fornecedor fornecedor) {
        Fornecedor fornecedorExistente = fornecedorService.buscarPorId(id);
        if (fornecedorExistente != null) {
            fornecedorExistente.setNome(fornecedor.getNome());
            fornecedorExistente.setCnpj(fornecedor.getCnpj());
            fornecedorExistente.setEndereco(fornecedor.getEndereco());
            return fornecedorService.salvarFornecedor(fornecedorExistente);
        } else {
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public void deletarFornecedor(@PathVariable Long id) {
        fornecedorService.deletarFornecedor(id);
    }
}