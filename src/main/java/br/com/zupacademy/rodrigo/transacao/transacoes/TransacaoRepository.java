package br.com.zupacademy.rodrigo.transacao.transacoes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransacaoRepository extends JpaRepository<Transacao, String> {

    List<Transacao> findByCartaoId(String cartaoId);

    List<Transacao> findTop10ByCartaoIdOrderByEfetivadaEmDesc(String cartaoId);
}
