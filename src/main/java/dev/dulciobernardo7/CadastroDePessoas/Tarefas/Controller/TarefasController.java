package dev.dulciobernardo7.CadastroDePessoas.Tarefas.Controller;

import dev.dulciobernardo7.CadastroDePessoas.Pessoas.Model.PessoaModel;
import dev.dulciobernardo7.CadastroDePessoas.Tarefas.Model.TarefasModel;
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
    public  String CadastraPessoa(){
        return "Cadastrada com sucesso";
    }
    //Mostrar todos os ninjas (READ)
    @GetMapping("/lista")
    public List<TarefasModel> TodasPessoas(){
        return tarefasService.ListatodasPessoas();
    }

    //Mostrar ninja por id (READ)
    @GetMapping("/todoID")
    public  String MostrarTodasPessoasPorId(){
        return "Mostrar Todas Pessoas";
    }

    // Alterar dados dos ninjas (UPDATE)
    @PostMapping("/alteraID")
    public String AlteraPorId(){
        return "Alterar por Id";
    }

    // Deletar Ninja (DELETE)
    @DeleteMapping("/DeletarID")
    public String ExcluirPessoaPorId(){
        return"Pessoa Deletada por id";
    }
}
