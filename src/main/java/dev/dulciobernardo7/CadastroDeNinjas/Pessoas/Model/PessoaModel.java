package dev.dulciobernardo7.CadastroDeNinjas.Pessoas.Model;

import dev.dulciobernardo7.CadastroDeNinjas.Tarefas.Model.TarefasModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


//Entity ele transforma uma classe em entidade do banco de dados
@Entity
@Table(name = "tv_Cadastro_de_Pessoas")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PessoaModel {

     //Atributos de uma pessoa
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    private String nome ;
    private   int idade;
    private String Nacionalidade;
    private String NIF;
    private String BI;
    private char sexo;
    private String email;
    private int telefone;

    //@ManyToOne - um pessoa tem uma unica tarefa
    @ManyToMany
    @JoinColumn(name =  "tarefas_id")//foreing Key ou chave estrangeira
    private List<TarefasModel> tarefas;


}
