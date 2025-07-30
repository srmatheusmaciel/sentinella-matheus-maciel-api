package br.edu.infnet.sentinella_matheus_maciel_api.repository;

import br.edu.infnet.sentinella_matheus_maciel_api.model.domain.Bloco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlocoRepository extends JpaRepository<Bloco, Long> {
}
