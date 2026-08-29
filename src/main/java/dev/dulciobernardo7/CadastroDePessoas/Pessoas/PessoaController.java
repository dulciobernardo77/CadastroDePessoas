package dev.dulciobernardo7.CadastroDePessoas.Pessoas;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {
    private final PessoaService pessoaService;

    public PessoaController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    @GetMapping(  "/boavindas")
    public String boaVindas(){
        return "Seja bem vindo na minha aplicao backend de cadastro de pessoas";
    }

    // Adicionar Funcionario (CREATE)
    @PostMapping("/cadastrar")
    public ResponseEntity<String> CadastraPessoa(@RequestBody PessoaDTO pessoaDTO){
        PessoaDTO pessoaDTO1 =  pessoaService.cadastroDeFuncionario(pessoaDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("Funcionario Cadastrado"+pessoaDTO1.getNome()+" com Sucesso") ;
    }

     //Mostrar todos os Funcionarios (READ)
    @GetMapping("/lista")
    public ResponseEntity<List<PessoaDTO>> TodasPessoas(){
        List<PessoaDTO> pessoaDTOList = pessoaService.ListatodasPessoas();
        return ResponseEntity.ok(pessoaDTOList);
    }

    //Mostrar Funcionario por id (READ)
    @GetMapping("/lista/{number}")
    public  ResponseEntity<String> MostrarTodasPessoasPorId(@PathVariable Long number){

          PessoaDTO pessoaDTO =  pessoaService.ListatodasPessoasporId(number);
          if (pessoaDTO != null){
              return ResponseEntity.ok("Funcionario encontrado: "+pessoaDTO.getNome());
          }else {
              return ResponseEntity.status(HttpStatus.NOT_FOUND).body("O Funcionario com IDs "+number+" Nao encontrado");

          }
    }

    // Alterar dados dos Funcionario (UPDATE)
    @PutMapping("/alterar/{number}")
    public ResponseEntity<?> AlteraPorId(@PathVariable Long number,@RequestBody PessoaDTO pessoa){
        PessoaDTO pessoaDTO = pessoaService.Atualizarfuncionario(number, pessoa);
        if (pessoaDTO != null) {
            return ResponseEntity.ok(pessoaDTO);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("O Funcionario com IDs "+number+" Nao encontrado");
        }
    }

    // Deletar Funcionario (DELETE)
    @DeleteMapping("/deletar/{number}")
    public ResponseEntity<String> ExcluirPessoaPorId(@PathVariable Long number ){
        if (pessoaService.ListatodasPessoasporId(number)!= null) {
            pessoaService.ExcluirPessoaPorId(number);
            return ResponseEntity.ok("O funcionario  com o IDs "+ number+" Excluido.");
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("O ninja com IDs "+number+" Nao encontrado");
        }
    }
}