package med.voll.api.controllers;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.domain.medico.*;
import med.voll.api.domain.medico.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController // Sinalzia que isso é um controller rest.
@RequestMapping("/medicos") // cominho HTTP.
public class MedicoController {
    @Autowired // digo para sprig instanciar o atributo.
    private MedicoRepository repository;

    @PostMapping // toda vez que for feita um POST chamara esse método.
    @Transactional // toda alteração no banco de dados precisa dessa anotação.
    public ResponseEntity cadastrar(@RequestBody @Valid DadosMedico dados, UriComponentsBuilder uriBuilder){
        var medico = new Medico(dados);
        repository.save(medico); // Salvando no banco usando interface que herda da JpaRepository.
        var uri = uriBuilder.path("/medicos/{id}").buildAndExpand(medico.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoMedico(medico));
    }

    @GetMapping // anotação para sinalziar que é um Get.
    public ResponseEntity<Page<DadosListagemMedico>> listar(@PageableDefault(size = 10, sort = "nome") Pageable page){
        var pagina = repository.findByAtivoTrue(page).map(DadosListagemMedico:: new);
        return ResponseEntity.ok(pagina);
    }

    @GetMapping("/{id}")
    public ResponseEntity listarPorId(@PathVariable Long id){
        var medico = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoMedico(medico));
    }

    @PutMapping // Anotação para sinalizar que é um Put.
    @Transactional
    public  ResponseEntity atualziar(@RequestBody @Valid DadosAtualziacaoMedico dados){
        var medio = repository.getReferenceById(dados.id());
        medio.atualizaInformacoes(dados);
        return ResponseEntity.ok(new DadosDetalhamentoMedico(medio));
    }

    /* Deletando do banco com id:
    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id){
        repository.deleteById(id);
    }
    */

    // Iantivando médico:

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id){
        var medio = repository.getReferenceById(id);
        medio.inativar();
        return ResponseEntity.noContent().build();
    }
}
