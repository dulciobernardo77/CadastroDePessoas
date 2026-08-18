package dev.dulciobernardo7.CadastroDePessoas.Pessoas.Model;

import dev.dulciobernardo7.CadastroDePessoas.Tarefas.Model.TarefasModel;
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
     @Column(name = "name")
    private String nome ;

    @Column(name = "idade")
    private   int idade;

    @Column(name = "nacionalidade")
    private String nacionalidade;

    @Column(unique = true)
    private String BI;

    @Column(name = "sexo")
    private char sexo;

    @Column(unique = true)
    private String email;

    @Column(unique = true)
    private int telefone;

    //@ManyToOne - um pessoa tem uma unica tarefa
    @ManyToMany
    @JoinColumn(name =  "tarefas_id")//foreing Key ou chave estrangeira
    private List<TarefasModel> tarefas;


}