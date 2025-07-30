package br.edu.infnet.sentinella_matheus_maciel_api.controller;

import br.edu.infnet.sentinella_matheus_maciel_api.dto.DadosAtualizacaoBlocoDTO;
import br.edu.infnet.sentinella_matheus_maciel_api.dto.DadosCadastroBlocoDTO;
import br.edu.infnet.sentinella_matheus_maciel_api.dto.DadosListagemBlocoDTO;
import br.edu.infnet.sentinella_matheus_maciel_api.service.BlocoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/blocos")
public class BlocoController {

    public final BlocoService blocoService;

    public BlocoController(BlocoService blocoService){
        this.blocoService = blocoService;
    }

    @PostMapping
    public ResponseEntity<DadosListagemBlocoDTO> cadastrar(@RequestBody @Valid DadosCadastroBlocoDTO dados,
                                                           UriComponentsBuilder uriBuilder){
        var dadosBlocoCadastrado = blocoService.cadastrar(dados);
        var uri = uriBuilder.path("/blocos/{id}").buildAndExpand(dadosBlocoCadastrado.id()).toUri();
        return ResponseEntity.created(uri).body(dadosBlocoCadastrado);
    }

    @GetMapping
    public ResponseEntity<List<DadosListagemBlocoDTO>> listar(){
        var listaDeBlocos = blocoService.listarTodos();
        return ResponseEntity.ok(listaDeBlocos);
    }

    @PutMapping
    public ResponseEntity<DadosListagemBlocoDTO> atualizar(@RequestBody @Valid DadosAtualizacaoBlocoDTO dados){
        var dadosBlocoAtualizado = blocoService.atualizar(dados);
        return ResponseEntity.ok(dadosBlocoAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id){
        blocoService.excluir(id);
        return ResponseEntity.noContent().build();
    }


}
