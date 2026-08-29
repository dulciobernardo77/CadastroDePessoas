package dev.dulciobernardo7.CadastroDePessoas.Tarefas;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarefas")
@Tag(name = "Tarefas", description = "Operações para gerenciamento de tarefas")
public class TarefasController {

    private final TarefasService tarefasService;

    public TarefasController(TarefasService tarefasService) {
        this.tarefasService = tarefasService;
    }

    @PostMapping("/cadastrar")
    @Operation(summary = "Cadastrar tarefa", description = "Cria uma nova tarefa no sistema.")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Tarefa cadastrada com sucesso."),
            @ApiResponse(responseCode = "400", description = "Dados inválidos para o cadastro.")
    })
    public ResponseEntity<String> CadastraPessoa(@RequestBody TarefasDTO tarefasDTO) {
        TarefasDTO tarefasDTO1 = tarefasService.cadastroDeTarefas(tarefasDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Tarefa  Cadastrado: " + tarefasDTO1.getNomeDaTarefa() + " com Sucesso");
    }

    @GetMapping("/lista")
    @Operation(summary = "Listar tarefas", description = "Retorna todas as tarefas cadastradas.")
    @ApiResponse(responseCode = "200", description = "Lista de tarefas retornada com sucesso.")
    public ResponseEntity<List<TarefasDTO>> TodasPessoas() {
        List<TarefasDTO> tarefasDTOS = tarefasService.ListatodasTarefas();
        return ResponseEntity.ok(tarefasDTOS);
    }

    @GetMapping("/lista/{number}")
    @Operation(summary = "Buscar tarefa por ID", description = "Consulta uma tarefa específica pelo identificador.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Tarefa encontrada com sucesso."),
            @ApiResponse(responseCode = "404", description = "Tarefa não encontrada.")
    })
    public ResponseEntity<String> MostrarTodasPessoasPorId(
            @Parameter(name = "number", description = "ID da tarefa", required = true, in = ParameterIn.PATH)
            @PathVariable Long number) {
        TarefasDTO tarefasDTO = tarefasService.ListatodasTarefasPorId(number);
        if (tarefasDTO != null) {
            return ResponseEntity.ok("Tarefa  encontrado: " + tarefasDTO.getNomeDaTarefa());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("O ninja com IDs " + number + " Nao encontrado");
        }
    }

    @PutMapping("/altera/{number}")
    @Operation(summary = "Atualizar tarefa", description = "Atualiza os dados de uma tarefa existente pelo ID.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Tarefa atualizada com sucesso."),
            @ApiResponse(responseCode = "404", description = "Tarefa não encontrada para atualização.")
    })
    public ResponseEntity<?> AlteraPorId(
            @Parameter(name = "number", description = "ID da tarefa a ser atualizada", required = true, in = ParameterIn.PATH)
            @PathVariable Long number,
            @RequestBody TarefasDTO tarefas) {
        TarefasDTO tarefasDTO = tarefasService.AtualizarTarefas(number, tarefas);
        if (tarefasDTO != null) {
            return ResponseEntity.ok(tarefasDTO);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("O ninja com IDs " + number + " Nao encontrado");
        }
    }

    @DeleteMapping("/Deletar/{number}")
    @Operation(summary = "Excluir tarefa", description = "Remove uma tarefa do sistema pelo ID.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Tarefa excluída com sucesso."),
            @ApiResponse(responseCode = "404", description = "Tarefa não encontrada para exclusão.")
    })
    public ResponseEntity<String> ExcluirPessoaPorId(
            @Parameter(name = "number", description = "ID da tarefa a ser excluída", required = true, in = ParameterIn.PATH)
            @PathVariable Long number) {
        if (tarefasService.ListatodasTarefasPorId(number) != null) {
            tarefasService.ExcluirTarefasPorId(number);
            return ResponseEntity.ok("O funcionario  com o IDs " + number + " Excluido.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("O ninja com IDs " + number + " Nao encontrado");
        }
    }
}
