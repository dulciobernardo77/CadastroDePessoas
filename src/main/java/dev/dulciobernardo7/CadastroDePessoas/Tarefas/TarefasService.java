package dev.dulciobernardo7.CadastroDePessoas.Tarefas;


import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TarefasService {

    private final TarefasMapper tarefasMapper;
    private final TarefasRepository tarefasRepository;

    public TarefasService(TarefasRepository tarefasRepository, TarefasMapper tarefasMapper) {
        this.tarefasRepository = tarefasRepository;
        this.tarefasMapper = tarefasMapper;
    }


    //Metodo para lista todo as tarefas
    public List<TarefasDTO> ListatodasPessoas(){
        List<TarefasModel> tarefasModelList = tarefasRepository.findAll();
         return tarefasModelList.stream()
                 .map(tarefasMapper::map)
                 .collect(Collectors.toList());
    }

    //Metodo para lista todo as Tarefas pelo id
   public TarefasDTO ListatodasPessoasPorId(Long number){
        Optional<TarefasModel> tarefasModel = tarefasRepository.findById(number);
        return tarefasModel.map(tarefasMapper::map)
                .orElse(null);
    }
    //Metodo para cadastro de Tarefas
    public TarefasDTO cadastroDeTarefas(TarefasDTO tarefasDTO){
        TarefasModel tarefasModel = tarefasMapper.map(tarefasDTO);
        tarefasModel = tarefasRepository.save(tarefasModel);
        return tarefasMapper.map(tarefasModel);
    }


    // Metodo para Alterar dados das Tarefas (UPDATE)
    public TarefasDTO AtualizarTarefas(Long number ,TarefasDTO tarefasDTO){
        Optional<TarefasModel> tarefasExistente = tarefasRepository.findById(number);
        if (tarefasExistente.isPresent()){
            TarefasModel tarefasAtualizadas = tarefasMapper.map(tarefasDTO);
            tarefasAtualizadas.setId(number);
            TarefasModel tarefaSalvas = tarefasRepository.save(tarefasAtualizadas);
            return tarefasMapper.map(tarefaSalvas);
        }
        return null;
    }

    //Metodo para Deletar Tarefas (DELETE)
    public void ExcluirPessoaPorId(Long number){
        tarefasRepository.deleteById(number);
    }


}
