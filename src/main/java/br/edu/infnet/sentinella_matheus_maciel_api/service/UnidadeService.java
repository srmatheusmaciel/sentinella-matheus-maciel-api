package br.edu.infnet.sentinella_matheus_maciel_api.service;

import br.edu.infnet.sentinella_matheus_maciel_api.dto.unidade.DadosCadastroUnidadeDTO;
import br.edu.infnet.sentinella_matheus_maciel_api.dto.unidade.DadosAtualizacaoUnidadeDTO;
import br.edu.infnet.sentinella_matheus_maciel_api.dto.unidade.DadosListagemUnidadeDTO;

import java.util.List;

public interface UnidadeService {

    DadosListagemUnidadeDTO cadastrar(DadosCadastroUnidadeDTO dados);
    List<DadosListagemUnidadeDTO> listarTodas();
    DadosListagemUnidadeDTO atualizar(DadosAtualizacaoUnidadeDTO dados);
    void excluir(Long id);

}
