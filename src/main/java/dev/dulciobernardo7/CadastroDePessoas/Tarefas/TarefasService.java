package dev.dulciobernardo7.CadastroDePessoas.Tarefas;

import dev.dulciobernardo7.CadastroDePessoas.Pessoas.Model.PessoaModel;
import dev.dulciobernardo7.CadastroDePessoas.Pessoas.PessoasRepository;
import dev.dulciobernardo7.CadastroDePessoas.Tarefas.Model.TarefasModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TarefasService {

    private TarefasRepository tarefasRepository;

    public TarefasService(TarefasRepository tarefasRepository) {
        this.tarefasRepository = tarefasRepository;
    }

    //Metodo para lista todo o pessoas
    public List<TarefasModel> ListatodasPessoas(){
         return tarefasRepository.findAll();
    }

    //Metodo para lista todo as pessoas pelo id
   /* public PessoaModel ListatodasPessoas(int number){
        Optional<PessoaModel> pessoaModel = PessoasRepository.findAllById(number);
        return  PessoasRepository. ;
    }*/

}
