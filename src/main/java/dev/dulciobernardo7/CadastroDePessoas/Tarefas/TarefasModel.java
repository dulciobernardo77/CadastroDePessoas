package dev.dulciobernardo7.CadastroDePessoas.Tarefas;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.dulciobernardo7.CadastroDePessoas.Pessoas.PessoaModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name = "tb_tarefas")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TarefasModel {

    //Atributos da classe tarefa

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "nomedatarefas")
    private String nomeDaTarefa;

    @Column(name = "dificuldade")
    private String dificuldade;

    //OneToMany - uma tarefa pode ter varios ninjas
    @OneToMany(mappedBy = "tarefa")
    @JsonIgnore
    private List<PessoaModel> pessoas;

}