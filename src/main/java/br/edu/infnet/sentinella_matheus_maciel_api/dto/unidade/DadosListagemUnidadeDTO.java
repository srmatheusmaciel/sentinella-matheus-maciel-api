package br.edu.infnet.sentinella_matheus_maciel_api.dto.unidade;

import br.edu.infnet.sentinella_matheus_maciel_api.model.domain.Unidade;

public record DadosListagemUnidadeDTO(
        Long id,
        String numero,
        String descricao,
        Long blocoId,
        String blocoNome
) {
    public DadosListagemUnidadeDTO(Unidade unidade){
        this(unidade.getId(),
                unidade.getNumero(),
                unidade.getDescricao(),
                unidade.getBloco().getId(),
                unidade.getBloco().getNome());
    }
}
