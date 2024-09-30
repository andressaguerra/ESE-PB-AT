package br.edu.infnet.sorveteria.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class SorveteHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long sorveteId;
    private String sabor;
    private String tipo;
    private Double preco;
    private LocalDateTime modifiedDate;

    public SorveteHistory() {
    }

    public SorveteHistory(Long sorveteId, String sabor, String tipo, Double preco, LocalDateTime modifiedDate) {
        this.sorveteId = sorveteId;
        this.sabor = sabor;
        this.tipo = tipo;
        this.preco = preco;
        this.modifiedDate = modifiedDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSorveteId() {
        return sorveteId;
    }

    public void setSorveteId(Long sorveteId) {
        this.sorveteId = sorveteId;
    }

    public String getSabor() {
        return sabor;
    }

    public void setSabor(String sabor) {
        this.sabor = sabor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public LocalDateTime getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(LocalDateTime modifiedDate) {
        this.modifiedDate = modifiedDate;
    }
}