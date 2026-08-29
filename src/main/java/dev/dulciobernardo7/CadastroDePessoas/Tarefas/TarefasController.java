package dev.dulciobernardo7.CadastroDePessoas.Tarefas;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarefas")
public class TarefasController {

    private final TarefasService tarefasService;

    public TarefasController(TarefasService tarefasService) {
        this.tarefasService = tarefasService;
    }

    // Adicionar Tarefas (CREATE)
    @PostMapping("/cadastrar")
    public ResponseEntity<String> CadastraPessoa(@RequestBody TarefasDTO tarefasDTO){
        TarefasDTO tarefasDTO1 = tarefasService.cadastroDeTarefas(tarefasDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Tarefa  Cadastrado: "+tarefasDTO1.getNomeDaTarefa()+" com Sucesso");
    }
    //Mostrar todos os Tarefas (READ)
    @GetMapping("/lista")
    public ResponseEntity<List<TarefasDTO>> TodasPessoas(){
        List<TarefasDTO> tarefasDTOS = tarefasService.ListatodasPessoas();
        return ResponseEntity.ok(tarefasDTOS);
    }

    //Mostrar Tarefas por id (READ)
    @GetMapping("/lista/{number}")
    public ResponseEntity<String> MostrarTodasPessoasPorId(@PathVariable Long number){
      TarefasDTO tarefasDTO =  tarefasService.ListatodasPessoasPorId(number);
      if (tarefasDTO != null) {
          return ResponseEntity.ok("Tarefa  encontrado: "+tarefasDTO.getNomeDaTarefa());
      }else {
          return ResponseEntity.status(HttpStatus.NOT_FOUND).body("O ninja com IDs "+number+" Nao encontrado");
      }

    }

    // Alterar dados das Tarefas (UPDATE)
    @PostMapping("/altera/{number}")
    public ResponseEntity<?> AlteraPorId(@PathVariable Long number, @RequestBody TarefasDTO tarefas){
        TarefasDTO tarefasDTO = tarefasService.AtualizarTarefas(number,tarefas);
        if (tarefasDTO != null){
            return ResponseEntity.ok(tarefasDTO);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("O ninja com IDs "+number+" Nao encontrado");
        }
    }

    // Deletar Tarefas (DELETE)
    @DeleteMapping("/Deletar/{number}")
    public ResponseEntity<String> ExcluirPessoaPorId(@PathVariable Long number){
        if(tarefasService.ListatodasPessoasPorId(number) != null) {
            tarefasService.ExcluirPessoaPorId(number);
            return ResponseEntity.ok("O funcionario  com o IDs "+ number+" Excluido.");
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("O ninja com IDs "+number+" Nao encontrado");
        }
    }
}
