package br.com.zupacademy.rodrigo.transacao.kafka;


import br.com.zupacademy.rodrigo.transacao.cartao.CartaoMensagem;
import br.com.zupacademy.rodrigo.transacao.estabelecimento.EstabelecimentoMensagem;
import br.com.zupacademy.rodrigo.transacao.transacoes.Transacao;


import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransacaoMensagem {

    private String id;
    private BigDecimal valor;
    private LocalDateTime efetivadaEm;
    private EstabelecimentoMensagem estabelecimento;
    private CartaoMensagem cartao;

    public TransacaoMensagem(String id, BigDecimal valor, LocalDateTime efetivadaEm, EstabelecimentoMensagem estabelecimento, CartaoMensagem cartao) {
        this.id = id;
        this.valor = valor;
        this.efetivadaEm = efetivadaEm;
        this.estabelecimento = estabelecimento;
        this.cartao = cartao;
    }

    public TransacaoMensagem() {
    }

    public Transacao converteParaTransacao(){
        return new Transacao(this.id, this.valor, this.efetivadaEm, this.estabelecimento.converteParaEstabelecimento(), this.cartao.converteParaCartao());
    }

    public String getId() {
        return id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public LocalDateTime getEfetivadaEm() {
        return efetivadaEm;
    }

    public EstabelecimentoMensagem getEstabelecimento() {
        return estabelecimento;
    }

    public CartaoMensagem getCartao() {
        return cartao;
    }
}
