package br.edu.infnet.fornecedorservice.repository;

import br.edu.infnet.fornecedorservice.model.Fornecedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FornecedorRepository extends JpaRepository<Fornecedor, Long> {
}