package br.edu.infnet.sentinella_matheus_maciel_api.service;





import br.edu.infnet.sentinella_matheus_maciel_api.dto.bloco.DadosAtualizacaoBlocoDTO;
import br.edu.infnet.sentinella_matheus_maciel_api.dto.bloco.DadosCadastroBlocoDTO;
import br.edu.infnet.sentinella_matheus_maciel_api.dto.bloco.DadosListagemBlocoDTO;
import br.edu.infnet.sentinella_matheus_maciel_api.model.domain.Bloco;

import java.util.List;


public interface BlocoService {

    DadosListagemBlocoDTO cadastrar(DadosCadastroBlocoDTO dados);

    List<DadosListagemBlocoDTO> listarTodos();

    DadosListagemBlocoDTO atualizar(DadosAtualizacaoBlocoDTO dados);

    void excluir(Long id);

    Bloco buscarPorId(Long id);

}
