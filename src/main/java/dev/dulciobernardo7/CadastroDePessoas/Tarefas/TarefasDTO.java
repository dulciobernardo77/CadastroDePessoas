package dev.dulciobernardo7.CadastroDePessoas.Tarefas;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TarefasDTO {

    private Long id;
    private String nomeDaTarefa;
    private String dificuldade;

}
