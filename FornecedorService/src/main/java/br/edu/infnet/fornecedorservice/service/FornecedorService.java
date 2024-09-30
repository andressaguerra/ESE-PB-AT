package br.edu.infnet.fornecedorservice.service;

import br.edu.infnet.fornecedorservice.model.Fornecedor;
import br.edu.infnet.fornecedorservice.repository.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FornecedorService {

    @Autowired
    private FornecedorRepository fornecedorRepository;

    @Autowired
    private FornecedorEventPublisher fornecedorEventPublisher;

    public List<Fornecedor> listarTodos() {
        return fornecedorRepository.findAll();
    }

    public Fornecedor buscarPorId(Long id) {
        return fornecedorRepository.findById(id).orElse(null);
    }

    public Fornecedor salvarFornecedor(Fornecedor fornecedor) {
        Fornecedor savedFornecedor = fornecedorRepository.save(fornecedor);
        fornecedorEventPublisher.publicarEventoDeFornecedor("Novo fornecedor adicionado: " + savedFornecedor.getNome());
        return savedFornecedor;
    }

    public void deletarFornecedor(Long id) {
        fornecedorRepository.deleteById(id);
    }
}