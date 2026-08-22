package dev.dulciobernardo7.CadastroDePessoas.Pessoas;

import dev.dulciobernardo7.CadastroDePessoas.Pessoas.Model.PessoaModel;
import dev.dulciobernardo7.CadastroDePessoas.Tarefas.Model.TarefasModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService {
    private PessoasRepository pessoasRepository;

    public PessoaService(PessoasRepository pessoasRepository){
        this.pessoasRepository = pessoasRepository;
    }

    //Metodo para lista todo o pessoas
    public List<PessoaModel> ListatodasPessoas(){
        return pessoasRepository.findAll();
    }

    //Metodo para lista todo as pessoas pelo id
   // public List<TarefasModel> ListatodasPessoasporId(){
 //       return pessoasRepository.getReferenceById(1L);
  //  }
}
