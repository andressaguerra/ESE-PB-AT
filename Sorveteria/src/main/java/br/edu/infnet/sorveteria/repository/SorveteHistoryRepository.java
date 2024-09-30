package br.edu.infnet.sorveteria.repository;

import br.edu.infnet.sorveteria.model.SorveteHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SorveteHistoryRepository extends JpaRepository<SorveteHistory, Long> {
    List<SorveteHistory> findBySorveteId(Long sorveteId);
}