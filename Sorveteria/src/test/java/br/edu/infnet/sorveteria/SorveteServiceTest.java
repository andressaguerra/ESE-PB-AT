package br.edu.infnet.sorveteria;

import br.edu.infnet.sorveteria.model.Sorvete;
import br.edu.infnet.sorveteria.service.SorveteService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class SorveteServiceTest {

    @Autowired
    private SorveteService sorveteService;

    @Test
    public void testSalvarComHistorico() {
        Sorvete sorvete = new Sorvete("Baunilha", "Cremoso", 5.50);
        Sorvete savedSorvete = sorveteService.salvar(sorvete);

        assertNotNull(savedSorvete.getId());
        assertEquals("Baunilha", savedSorvete.getSabor());
    }

//    @Test
//    public void testObterListaDeFornecedores() {
//        List<Object> fornecedores = sorveteService.obterListaDeFornecedores();
//        assertFalse(fornecedores.isEmpty(), "A lista de fornecedores não deve estar vazia");
//    }

    @Test
    public void testBuscarPorId() {
        Sorvete sorvete = new Sorvete("Morango", "Sorbet", 4.50);
        Sorvete savedSorvete = sorveteService.salvar(sorvete);

        Sorvete encontrado = sorveteService.buscarPorId(savedSorvete.getId());
        assertNotNull(encontrado);
        assertEquals("Morango", encontrado.getSabor());
    }

    @Test
    public void testListarTodos() {
        Sorvete sorvete1 = new Sorvete("Chocolate", "Cremoso", 6.00);
        Sorvete sorvete2 = new Sorvete("Limão", "Sorbet", 4.00);
        sorveteService.salvar(sorvete1);
        sorveteService.salvar(sorvete2);

        List<Sorvete> sorvetes = sorveteService.listarTodos();
        assertTrue(sorvetes.size() >= 2, "Deve haver pelo menos dois sorvetes na lista");
    }

    @Test
    public void testAtualizarSorvete() {
        Sorvete sorvete = new Sorvete("Baunilha", "Cremoso", 5.50);
        Sorvete savedSorvete = sorveteService.salvar(sorvete);

        savedSorvete.setSabor("Chocolate");
        savedSorvete.setPreco(6.00);
        Sorvete atualizado = sorveteService.salvar(savedSorvete);

        assertEquals("Chocolate", atualizado.getSabor());
        assertEquals(6.00, atualizado.getPreco());
    }

    @Test
    public void testDeletarSorvete() {
        Sorvete sorvete = new Sorvete("Limão", "Sorbet", 4.00);
        Sorvete savedSorvete = sorveteService.salvar(sorvete);

        sorveteService.deletar(savedSorvete.getId());
        Sorvete encontrado = sorveteService.buscarPorId(savedSorvete.getId());

        assertNull(encontrado, "O sorvete deletado não deve ser encontrado");
    }
}