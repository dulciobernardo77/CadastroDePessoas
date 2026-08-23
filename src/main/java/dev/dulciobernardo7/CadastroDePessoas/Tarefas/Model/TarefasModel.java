package dev.dulciobernardo7.CadastroDePessoas.Tarefas.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.dulciobernardo7.CadastroDePessoas.Pessoas.Model.PessoaModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "tb_tarefas")
@Data
@NoArgsConstructor
@AllArgsConstructor
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