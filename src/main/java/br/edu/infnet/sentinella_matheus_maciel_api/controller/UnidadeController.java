package br.edu.infnet.sentinella_matheus_maciel_api.controller;

import br.edu.infnet.sentinella_matheus_maciel_api.dto.unidade.DadosAtualizacaoUnidadeDTO;
import br.edu.infnet.sentinella_matheus_maciel_api.dto.unidade.DadosCadastroUnidadeDTO;
import br.edu.infnet.sentinella_matheus_maciel_api.dto.unidade.DadosListagemUnidadeDTO;
import br.edu.infnet.sentinella_matheus_maciel_api.service.UnidadeService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/unidades")
public class UnidadeController {

    private final UnidadeService unidadeService;

    public UnidadeController(UnidadeService unidadeService){
        this.unidadeService = unidadeService;
    }

    @PostMapping
    public ResponseEntity<DadosListagemUnidadeDTO> cadastrar(@RequestBody @Valid DadosCadastroUnidadeDTO dados, UriComponentsBuilder uriBuilder){

        var dadosUnidadeCadastrada = unidadeService.cadastrar(dados);
        var uri = uriBuilder.path("/unidades/{id}").buildAndExpand(dadosUnidadeCadastrada.id()).toUri();

        return ResponseEntity.created(uri).body(dadosUnidadeCadastrada);
    }

    @GetMapping
    public ResponseEntity<List<DadosListagemUnidadeDTO>> listar(){
        var listaDeUnidades = unidadeService.listarTodas();
        return ResponseEntity.ok(listaDeUnidades);
    }

    @PutMapping
    public ResponseEntity<DadosListagemUnidadeDTO> atualizar(@RequestBody @Valid DadosAtualizacaoUnidadeDTO dados){
        var dadosUnidadeAtualizada = unidadeService.atualizar(dados);
        return ResponseEntity.ok(dadosUnidadeAtualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id){
        unidadeService.excluir(id);
        return ResponseEntity.noContent().build();
    }

}
