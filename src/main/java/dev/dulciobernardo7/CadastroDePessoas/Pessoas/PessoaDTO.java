package dev.dulciobernardo7.CadastroDePessoas.Pessoas;

import dev.dulciobernardo7.CadastroDePessoas.Tarefas.Model.TarefasModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PessoaDTO {

    private Long id;
    private String nome ;
    private   int idade;
    private String nacionalidade;
    private String bi;
    private char sexo;
    private String email;
    private String telefone;
    private String nivel;
    private String imgUrl;
    private TarefasModel tarefa;
}
