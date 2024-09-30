package br.edu.infnet.sorveteria.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

@FeignClient(name = "FornecedorService")
public interface FornecedorClient {

    @GetMapping("/fornecedores")
    List<Object> listarFornecedores();
}