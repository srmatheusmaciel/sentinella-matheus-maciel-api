package br.edu.infnet.sentinella_matheus_maciel_api.service;



import br.edu.infnet.sentinella_matheus_maciel_api.dto.bloco.DadosAtualizacaoBlocoDTO;
import br.edu.infnet.sentinella_matheus_maciel_api.dto.bloco.DadosCadastroBlocoDTO;
import br.edu.infnet.sentinella_matheus_maciel_api.dto.bloco.DadosListagemBlocoDTO;
import br.edu.infnet.sentinella_matheus_maciel_api.model.domain.Bloco;
import br.edu.infnet.sentinella_matheus_maciel_api.repository.BlocoRepository;
import jakarta.persistence.EntityNotFoundException;
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

    @Override
    @Transactional
    public DadosListagemBlocoDTO atualizar(DadosAtualizacaoBlocoDTO dados){
        var bloco = repository.findById(dados.id())
                .orElseThrow(() -> new EntityNotFoundException("Bloco não encontrado com o ID: " + dados.id()));

        if(dados.nome() != null && !dados.nome().isBlank()){
            bloco.setNome(dados.nome());
        }

        return new DadosListagemBlocoDTO(bloco);
    }

    @Override
    @Transactional
    public void excluir(Long id){
        if(!repository.existsById(id)){
            throw new EntityNotFoundException("Bloco não encontrado com o ID: " + id);
        }

        repository.deleteById(id);
    }

    @Override
    public Bloco buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Bloco não encontrado com o id: " + id));
    }


}
