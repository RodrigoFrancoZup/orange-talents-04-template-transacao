package br.com.zupacademy.rodrigo.transacao.kafka;


import br.com.zupacademy.rodrigo.transacao.transacoes.Transacao;
import br.com.zupacademy.rodrigo.transacao.transacoes.TransacaoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ListenerDeTransacao {

    private final Logger logger = LoggerFactory.getLogger(ListenerDeTransacao.class);

    @Autowired
    TransacaoRepository transacaoRepository;

    @KafkaListener(topics = "${spring.kafka.topic.transactions}")
    public void ouvir(TransacaoMensagem transacaoMensagem) {
        logger.info("A transação {} com valor {} e o cartão {} foi lida!", transacaoMensagem.getId(), transacaoMensagem.getValor(), transacaoMensagem.getCartao().getId());
        Transacao transacao = transacaoMensagem.converteParaTransacao();
        transacaoRepository.save(transacao);
    }
}

