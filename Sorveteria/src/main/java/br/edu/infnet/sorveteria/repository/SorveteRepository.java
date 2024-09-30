package br.edu.infnet.sorveteria.repository;

import br.edu.infnet.sorveteria.model.Sorvete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SorveteRepository extends JpaRepository<Sorvete, Long> {
}