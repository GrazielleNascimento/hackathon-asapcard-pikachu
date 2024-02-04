package com.microsservicos.pikachu.produtor.connections;

import jakarta.annotation.PostConstruct;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Configuration;


import com.microsservicos.pikachu.produtor.constants.RabbitmqConstants;

/**
 * Componente Spring que lida com a conexão e configuração do RabbitMQ.
 */
@Configuration
public class RabbitmqConnection {
    private static final String NOME_EXCHANGE = "amq.direct";
    private AmqpAdmin amqpAdmin; // Interface para gerenciar componentes do RabbitMQ como filas, exchanges e bindings.

    /**
     * Construtor da classe que injeta a dependência AmqpAdmin.
     *
     * @param amqpAdmin Interface do Spring AMQP para trabalhar com o admin do broker.
     */
    public RabbitmqConnection(AmqpAdmin amqpAdmin) {
        this.amqpAdmin = amqpAdmin;
    }

    /**
     * Cria um objeto Queue representando uma fila no RabbitMQ.
     *
     * @param nomeFila O nome da fila a ser criada.
     * @return Uma nova Queue.
     */
    private Queue fila(String transactions_queue) {
        return new Queue(transactions_queue, true, false, false);
    }

    /**
     * Cria um objeto DirectExchange representando uma exchange direta onde as mensagens são roteadas pela chave de roteamento exata.
     *
     * @return Uma nova DirectExchange.
     */
    private DirectExchange trocaDireta() {
        return new DirectExchange(NOME_EXCHANGE);
    }

    /**
     * Cria um vinculo (binding) entre uma fila e uma exchange.
     *
     * @param fila   A fila que será vinculada.
     * @param troca  A exchange à qual a fila será vinculada.
     * @return Um novo Binding.
     */
    private Binding relacionamento(Queue fila, DirectExchange troca) {
        return new Binding(fila.getName(), Binding.DestinationType.QUEUE, troca.getName(), fila.getName(), null);
    }

    /**
     * Método responsável por criar as filas, exchanges e bindings depois que o bean da classe é construído.
     */
    @PostConstruct
    private void adiciona() {
        // Criação das filas utilizando o nome fornecido pelas constantes.
        Queue transactionsQueue = this.fila(RabbitmqConstants.FILA_TRANSACTIONS);

        // Criação da exchange direta.
        DirectExchange troca = this.trocaDireta();

        // Configuração dos bindings entre as filas criadas e a exchange.
        Binding ligacaoTransactions = this.relacionamento(transactionsQueue, troca);

        // Declara as filas no broker do RabbitMQ.
        this.amqpAdmin.declareQueue(transactionsQueue);

        // Declara a exchange no RabbitMQ.
        this.amqpAdmin.declareExchange(troca);

        // Declara os bindings no RabbitMQ.
        this.amqpAdmin.declareBinding(ligacaoTransactions);
    }
}