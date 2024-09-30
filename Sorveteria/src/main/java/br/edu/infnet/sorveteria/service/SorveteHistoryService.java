package br.edu.infnet.sorveteria.service;

import br.edu.infnet.sorveteria.model.SorveteHistory;
import br.edu.infnet.sorveteria.repository.SorveteHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SorveteHistoryService {

    @Autowired
    private SorveteHistoryRepository sorveteHistoryRepository;

    public List<SorveteHistory> getHistory(Long sorveteId) {
        return sorveteHistoryRepository.findBySorveteId(sorveteId);
    }
}
