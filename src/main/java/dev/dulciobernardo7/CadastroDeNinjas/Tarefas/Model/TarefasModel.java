package dev.dulciobernardo7.CadastroDeNinjas.Tarefas.Model;

import dev.dulciobernardo7.CadastroDeNinjas.Pessoas.Model.PessoaModel;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "tb_tarefas")
public class TarefasModel {

    //Atributos da classe tarefa

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String nomeDaTarefa;
    private String dificuldade;

    //OneToMany - uma tarefa pode ter varios ninjas
    @OneToMany(mappedBy = "tarefa")
    private List<PessoaModel> pessoa;


    //construtores vazio e o preenchido
    //no-args constructo
    public TarefasModel(){

    }

    public TarefasModel(String nomeDaTarefa, String dificuldade){
        this.nomeDaTarefa = nomeDaTarefa;
        this.dificuldade = dificuldade;
    }

    //metodos getter e setter
    public String getTarefas() {
        return nomeDaTarefa;
    }

    public void setTarefas(String tarefas) {
        this.nomeDaTarefa = tarefas;
    }

    public String getDificuldade() {
        return dificuldade;
    }

    public void setDificuldade(String dificuldade) {
        this.dificuldade = dificuldade;
    }
}