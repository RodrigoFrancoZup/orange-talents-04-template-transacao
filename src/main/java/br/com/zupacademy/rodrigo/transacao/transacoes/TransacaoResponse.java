package br.com.zupacademy.rodrigo.transacao.transacoes;


import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TransacaoResponse {

    private String id;
    private BigDecimal valor;
    private LocalDateTime efetivadaEm;
    private String estabelecimento;
    private String cidade;
    private String endereco;
    private String email;
    private String cartao;

    public TransacaoResponse(Transacao transacao) {
        this.id = transacao.getId();
        this.valor = transacao.getValor();
        this.efetivadaEm = transacao.getEfetivadaEm();
        this.estabelecimento = transacao.getEstabelecimento().getNome();
        this.cidade = transacao.getEstabelecimento().getCidade();
        this.endereco = transacao.getEstabelecimento().getEndereco();
        this.email = transacao.getCartao().getEmail();
        this.cartao = transacao.getCartao().getId();
    }

    public static List<TransacaoResponse> converteParaListaDeTransacaoResponse(List<Transacao> transacoes) {
        List<TransacaoResponse> transacoesResponse = new ArrayList<>();
        for(Transacao aux : transacoes){
            TransacaoResponse response = new TransacaoResponse(aux);
            transacoesResponse.add(response);
        }
        return transacoesResponse;
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

    public String getEstabelecimento() {
        return estabelecimento;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getEmail() {
        return email;
    }

    public String getCartao() {
        return cartao;
    }
}
