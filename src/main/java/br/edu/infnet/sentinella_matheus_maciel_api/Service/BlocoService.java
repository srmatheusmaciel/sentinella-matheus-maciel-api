package br.edu.infnet.sentinella_matheus_maciel_api.Service;

import br.edu.infnet.sentinella_matheus_maciel_api.dto.DadosAtualizacaoBlocoDTO;
import br.edu.infnet.sentinella_matheus_maciel_api.dto.DadosCadastroBlocoDTO;
import br.edu.infnet.sentinella_matheus_maciel_api.dto.DadosListagemBlocoDTO;

import java.util.List;


public interface BlocoService {

    DadosListagemBlocoDTO cadastrar(DadosCadastroBlocoDTO dados);

    List<DadosListagemBlocoDTO> listarTodos();

    DadosListagemBlocoDTO atualizar(DadosAtualizacaoBlocoDTO dados);

    void excluir(Long id);

}
