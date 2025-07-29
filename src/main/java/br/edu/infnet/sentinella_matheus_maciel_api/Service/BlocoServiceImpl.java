package br.edu.infnet.sentinella_matheus_maciel_api.Service;

import br.edu.infnet.sentinella_matheus_maciel_api.dto.DadosCadastroBlocoDTO;
import br.edu.infnet.sentinella_matheus_maciel_api.dto.DadosListagemBlocoDTO;
import br.edu.infnet.sentinella_matheus_maciel_api.model.domain.Bloco;
import br.edu.infnet.sentinella_matheus_maciel_api.repository.BlocoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BlocoServiceImpl implements BlocoService {

    private final BlocoRepository repository;

    public BlocoServiceImpl(BlocoRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public DadosListagemBlocoDTO cadastrar(DadosCadastroBlocoDTO dados) {
        var bloco = new Bloco(null, dados.nome());
        repository.save(bloco);
        return new DadosListagemBlocoDTO(bloco);
    }

    @Override
    @Transactional
    public List<DadosListagemBlocoDTO> listarTodos() {
            return repository.findAll()
                             .stream()
                             .map(DadosListagemBlocoDTO::new)
                             .toList();
    }
}
