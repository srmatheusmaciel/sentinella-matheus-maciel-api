package br.edu.infnet.sentinella_matheus_maciel_api.repository;

import br.edu.infnet.sentinella_matheus_maciel_api.model.domain.Unidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnidadeRepository extends JpaRepository<Unidade, Long> {
}
