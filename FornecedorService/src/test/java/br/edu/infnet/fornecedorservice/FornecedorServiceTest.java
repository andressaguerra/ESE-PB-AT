package br.edu.infnet.fornecedorservice;

import br.edu.infnet.fornecedorservice.model.Fornecedor;
import br.edu.infnet.fornecedorservice.service.FornecedorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class FornecedorServiceTest {

    @Mock
    private FornecedorService fornecedorService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testListarTodos() {
        Fornecedor fornecedor1 = new Fornecedor("Fornecedor de morango", "12.345.678/0001-00", "Rua das Rosas, 50");
        Fornecedor fornecedor2 = new Fornecedor("Fornecedor de baunilha", "98.765.432/0001-00", "Rua das Conchas, 303");

        when(fornecedorService.listarTodos()).thenReturn(Arrays.asList(fornecedor1, fornecedor2));

        List<Fornecedor> resultado = fornecedorService.listarTodos();
        assertEquals(2, resultado.size());
        assertEquals("Fornecedor de morango", resultado.get(0).getNome());
    }

    @Test
    public void testBuscarPorId() {
        Fornecedor fornecedor = new Fornecedor("Fornecedor de morango", "12.345.678/0001-00", "Rua das Rosas, 50");

        when(fornecedorService.buscarPorId(1L)).thenReturn(fornecedor);

        Fornecedor resultado = fornecedorService.buscarPorId(1L);
        assertNotNull(resultado);
        assertEquals("Fornecedor de morango", resultado.getNome());
    }

    @Test
    public void testSalvarFornecedor() {
        Fornecedor fornecedor = new Fornecedor("Fornecedor de baunilha", "98.765.432/0001-00", "Rua das Conchas, 303");

        when(fornecedorService.salvarFornecedor(any(Fornecedor.class))).thenReturn(fornecedor);

        Fornecedor resultado = fornecedorService.salvarFornecedor(fornecedor);
        assertNotNull(resultado);
        assertEquals("Fornecedor de baunilha", resultado.getNome());
    }

    @Test
    public void testAtualizarFornecedor() {
        Fornecedor fornecedorExistente = new Fornecedor("Fornecedor de morango", "12.345.678/0001-00", "Rua das Rosas, 50");
        Fornecedor fornecedorAtualizado = new Fornecedor("Fornecedor de morango atualizado", "12.345.678/0001-00", "Rua das Rosas, 50");

        when(fornecedorService.buscarPorId(1L)).thenReturn(fornecedorExistente);
        when(fornecedorService.salvarFornecedor(any(Fornecedor.class))).thenReturn(fornecedorAtualizado);

        Fornecedor resultado = fornecedorService.salvarFornecedor(fornecedorAtualizado);
        assertEquals("Fornecedor de morango atualizado", resultado.getNome());
    }

    @Test
    public void testDeletarFornecedor() {
        Fornecedor fornecedor = new Fornecedor("Fornecedor de morango", "12.345.678/0001-00", "Rua das Rosas, 50");

        doNothing().when(fornecedorService).deletarFornecedor(1L);

        fornecedorService.deletarFornecedor(1L);

        verify(fornecedorService, times(1)).deletarFornecedor(1L);
    }
}