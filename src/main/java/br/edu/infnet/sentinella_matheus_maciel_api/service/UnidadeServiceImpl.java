package br.edu.infnet.sentinella_matheus_maciel_api.service;

import br.edu.infnet.sentinella_matheus_maciel_api.dto.unidade.DadosAtualizacaoUnidadeDTO;
import br.edu.infnet.sentinella_matheus_maciel_api.dto.unidade.DadosCadastroUnidadeDTO;
import br.edu.infnet.sentinella_matheus_maciel_api.dto.unidade.DadosListagemUnidadeDTO;
import br.edu.infnet.sentinella_matheus_maciel_api.model.domain.Unidade;
import br.edu.infnet.sentinella_matheus_maciel_api.repository.UnidadeRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UnidadeServiceImpl implements UnidadeService{

    private final UnidadeRepository unidadeRepository;
    private final BlocoService blocoService;

    public UnidadeServiceImpl(UnidadeRepository unidadeRepository, BlocoService blocoService){
        this.unidadeRepository = unidadeRepository;
        this.blocoService = blocoService;
    }

    @Override
    @Transactional
    public DadosListagemUnidadeDTO cadastrar(DadosCadastroUnidadeDTO dados) {

        var bloco = blocoService.buscarPorId(dados.blocoId());
        var unidade = new Unidade(null, dados.numero(), dados.descricao(), bloco);
        unidadeRepository.save(unidade);

        return new DadosListagemUnidadeDTO(unidade);
    }

    @Override
    public List<DadosListagemUnidadeDTO> listarTodas() {
        return unidadeRepository.findAll()
                .stream()
                .map(DadosListagemUnidadeDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public DadosListagemUnidadeDTO atualizar(DadosAtualizacaoUnidadeDTO dados) {
        var unidade = unidadeRepository.findById(dados.id())
                .orElseThrow(() -> new EntityNotFoundException("Unidade com ID " + dados.id() + " não encontrada."));

            Optional.ofNullable(dados.numero()).ifPresent(unidade::setNumero);
            Optional.ofNullable(dados.descricao()).ifPresent(unidade::setDescricao);

            Optional.ofNullable(dados.blocoId()).ifPresent(blocoId -> {
                var bloco = blocoService.buscarPorId(blocoId);
                unidade.setBloco(bloco);
            });
            return new DadosListagemUnidadeDTO(unidade);
    }

    @Override
    @Transactional
    public void excluir(Long id) {

        if(!unidadeRepository.existsById(id)){
            throw new EntityNotFoundException("Unidade com ID " + id + " não encontrada.");
        }

        unidadeRepository.deleteById(id);
    }
}
