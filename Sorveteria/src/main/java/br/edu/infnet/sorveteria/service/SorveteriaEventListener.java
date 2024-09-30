package br.edu.infnet.sorveteria.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class SorveteriaEventListener {

    @RabbitListener(queues = "fornecedor.queue")
    public void ouvirEventoDeFornecedor(String mensagem) {
        System.out.println("Mensagem recebida: " + mensagem);
    }
}