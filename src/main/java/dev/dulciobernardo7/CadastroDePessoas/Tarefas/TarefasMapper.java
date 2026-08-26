package dev.dulciobernardo7.CadastroDePessoas.Tarefas;


import dev.dulciobernardo7.CadastroDePessoas.Tarefas.Model.TarefasModel;
import org.springframework.stereotype.Component;

@Component
public class TarefasMapper {

    public TarefasModel map(TarefasDTO tarefasDTO){
        TarefasModel tarefasModel = new TarefasModel();
        tarefasModel.setId(tarefasDTO.getId());
        tarefasModel.setNomeDaTarefa(tarefasDTO.getNomeDaTarefa());
        tarefasModel.setDificuldade(tarefasDTO.getDificuldade());
        return tarefasModel;
    }

    public TarefasDTO map(TarefasModel tarefasModel){

        TarefasDTO tarefasDTO = new TarefasDTO();
        tarefasDTO.setId(tarefasModel.getId());
        tarefasDTO.setNomeDaTarefa(tarefasModel.getNomeDaTarefa());
        tarefasDTO.setDificuldade(tarefasModel.getDificuldade());
        return tarefasDTO;

    }
}
