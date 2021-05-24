package br.com.zupacademy.rodrigo.transacao.cartao;

public class CartaoMensagem {

    private String id;
    private String email;

    public CartaoMensagem(String id, String email) {
        this.id = id;
        this.email = email;
    }

    public CartaoMensagem() {
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public Cartao converteParaCartao(){
        return new Cartao(this.id, this.email);
    }
}
