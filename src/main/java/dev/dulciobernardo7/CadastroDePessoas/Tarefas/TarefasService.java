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

    //Metodo para lista todo as tarefas
    public List<TarefasModel> ListatodasPessoas(){
         return tarefasRepository.findAll();
    }

    //Metodo para lista todo as Tarefas pelo id
   public TarefasModel ListatodasPessoasPorId(Long number){
        Optional<TarefasModel> tarefasModel = tarefasRepository.findById(number);
        return tarefasModel.orElse(null);
    }

    // Metodo para Alterar dados dos ninjas (UPDATE)
    public TarefasModel AtualizarTarefas(Long number , TarefasModel tarefas){
        if (tarefasRepository.existsById(number)){
            tarefas.setId(number);
            return tarefasRepository.save(tarefas);
        }
        return null;
    }

    //Metodo para Deletar funcionario (DELETE)
    public void ExcluirPessoaPorId(Long number){
        tarefasRepository.deleteById(number);
    }


}
