package br.com.zupacademy.rodrigo.transacao.estabelecimento;

public class EstabelecimentoMensagem {

    private String nome;
    private String cidade;
    private String endereco;

    public EstabelecimentoMensagem(String nome, String cidade, String endereco) {
        this.nome = nome;
        this.cidade = cidade;
        this.endereco = endereco;
    }

    public EstabelecimentoMensagem() {
    }

    public String getNome() {
        return nome;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEndereco() {
        return endereco;
    }

    public Estabelecimento converteParaEstabelecimento(){
        return new Estabelecimento(this.nome, this.cidade, this.endereco);
    }
}
