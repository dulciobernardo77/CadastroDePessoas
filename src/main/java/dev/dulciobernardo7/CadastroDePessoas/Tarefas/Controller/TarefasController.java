package dev.dulciobernardo7.CadastroDePessoas.Tarefas.Controller;

import dev.dulciobernardo7.CadastroDePessoas.Pessoas.Model.PessoaModel;
import dev.dulciobernardo7.CadastroDePessoas.Tarefas.Model.TarefasModel;
import dev.dulciobernardo7.CadastroDePessoas.Tarefas.TarefasDTO;
import dev.dulciobernardo7.CadastroDePessoas.Tarefas.TarefasService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarefas")
public class TarefasController {

    private TarefasService tarefasService;

    public TarefasController(TarefasService tarefasService) {
        this.tarefasService = tarefasService;
    }

    // Adicionar ninja (CREATE)
    @PostMapping("/cadastrar")
    public  TarefasDTO CadastraPessoa(@RequestBody TarefasDTO tarefasDTO){
        return tarefasService.cadastroDeTarefas(tarefasDTO);
    }
    //Mostrar todos os ninjas (READ)
    @GetMapping("/lista")
    public List<TarefasDTO> TodasPessoas(){
        return tarefasService.ListatodasPessoas();
    }

    //Mostrar ninja por id (READ)
    @GetMapping("/lista/{number}")
    public TarefasDTO MostrarTodasPessoasPorId(@PathVariable Long number){
        return tarefasService.ListatodasPessoasPorId(number);
    }

    // Alterar dados dos ninjas (UPDATE)
    @PostMapping("/altera/{number}")
    public TarefasDTO AlteraPorId(@PathVariable Long number, @RequestBody TarefasDTO tarefas){
        return tarefasService.AtualizarTarefas(number,tarefas);
    }

    // Deletar Ninja (DELETE)
    @DeleteMapping("/Deletar/{number}")
    public void ExcluirPessoaPorId(@PathVariable Long number){
        tarefasService.ExcluirPessoaPorId(number);
    }
}
