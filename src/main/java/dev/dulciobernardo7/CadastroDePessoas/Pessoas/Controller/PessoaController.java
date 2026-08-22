package dev.dulciobernardo7.CadastroDePessoas.Pessoas.Controller;

import dev.dulciobernardo7.CadastroDePessoas.Pessoas.Model.PessoaModel;
import dev.dulciobernardo7.CadastroDePessoas.Pessoas.PessoaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {
    private PessoaService pessoaService;

    public PessoaController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    @GetMapping(  "/boavindas")
    public String boaVindas(){
        return "Seja bem vindo na minha aplicao backend de cadastro de pessoas";
    }

    // Adicionar ninja (CREATE)
    @PostMapping("/cadastrar")
    public  String CadastraPessoa(){
        return "Cadastrada com sucesso";
    }
    //Mostrar todos os ninjas (READ)
    @GetMapping("/lista")
    public List<PessoaModel> TodasPessoas(){
        return pessoaService.ListatodasPessoas();
    }

    //Mostrar ninja por id (READ)
    @GetMapping("/lista/{number}")
    public  PessoaModel MostrarTodasPessoasPorId(@PathVariable Long number){
        return pessoaService.ListatodasPessoasporId(number);
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