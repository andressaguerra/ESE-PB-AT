package br.edu.infnet.sorveteria.service;

import br.edu.infnet.sorveteria.client.FornecedorClient;
import br.edu.infnet.sorveteria.model.Sorvete;
import br.edu.infnet.sorveteria.model.SorveteHistory;
import br.edu.infnet.sorveteria.repository.SorveteHistoryRepository;
import br.edu.infnet.sorveteria.repository.SorveteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SorveteService {

    @Autowired
    private SorveteRepository sorveteRepository;

    @Autowired
    private SorveteHistoryRepository sorveteHistoryRepository;

    @Autowired
    private FornecedorClient fornecedorClient;

    public List<Sorvete> listarTodos() {
        return sorveteRepository.findAll();
    }

    public Sorvete buscarPorId(Long id) {
        return sorveteRepository.findById(id).orElse(null);
    }

    @Transactional
    public Sorvete salvar(Sorvete sorvete) {
        Sorvete savedSorvete = sorveteRepository.save(sorvete);
        saveHistory(savedSorvete);
        return savedSorvete;
    }

    public void deletar(Long id) {
        sorveteRepository.deleteById(id);
    }

    private void saveHistory(Sorvete sorvete) {
        SorveteHistory history = new SorveteHistory();
        history.setSorveteId(sorvete.getId());
        history.setSabor(sorvete.getSabor());
        history.setTipo(sorvete.getTipo());
        history.setPreco(sorvete.getPreco());
        history.setModifiedDate(sorvete.getLastModified());
        sorveteHistoryRepository.save(history);
    }

    public List<Object> obterListaDeFornecedores() {
        return fornecedorClient.listarFornecedores();
    }
}