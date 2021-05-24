package br.com.zupacademy.rodrigo.transacao.transacoes;

import br.com.zupacademy.rodrigo.transacao.cartao.Cartao;
import br.com.zupacademy.rodrigo.transacao.cartao.CartaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/transacao")
public class TransacaoController {

    @Autowired
    private TransacaoRepository transacaoRepository;

    @Autowired
    private CartaoRepository cartaoRepository;

    @GetMapping("/cartao/{idCartao}")
    public ResponseEntity<?> listar(@PathVariable String idCartao) {
        Optional<Cartao> possivelCartao = cartaoRepository.findById(idCartao);
        if (possivelCartao.isPresent()) {
            List<Transacao> transacoes = transacaoRepository.findByCartaoId(idCartao);
            List<TransacaoResponse> response = TransacaoResponse.converteParaListaDeTransacaoResponse(transacoes);
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/atuais/cartao/{idCartao}")
    public ResponseEntity<?> listarRecentes(@PathVariable String idCartao) {
        Optional<Cartao> possivelCartao = cartaoRepository.findById(idCartao);
        if (possivelCartao.isPresent()) {
            List<Transacao> transacoes = transacaoRepository.findTop10ByCartaoIdOrderByEfetivadaEmDesc(idCartao);
            List<TransacaoResponse> response = TransacaoResponse.converteParaListaDeTransacaoResponse(transacoes);
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.notFound().build();
    }
}
