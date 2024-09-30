package br.edu.infnet.fornecedorservice.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FornecedorEventPublisher {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    private final String EXCHANGE_NAME = "fornecedor.exchange";
    private final String ROUTING_KEY = "fornecedor.key";

    public void publicarEventoDeFornecedor(String mensagem) {
        rabbitTemplate.convertAndSend(EXCHANGE_NAME, ROUTING_KEY, mensagem);
        System.out.println("Mensagem publicada: " + mensagem);
    }
}