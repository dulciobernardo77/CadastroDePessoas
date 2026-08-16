package dev.dulciobernardo7.CadastroDeNinjas;

import jakarta.persistence.*;


//Entity ele transforma uma classe em entidade do banco de dados
@Entity
@Table(name = "tv_Cadastro_de_Pessoas")
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

   //construtores vazio e o preenchido
    //no-args constructo
    public PessoaModel() {
    }
    //parameterized constructor
    public PessoaModel(String nome, int idade, String nacionalidade, String NIF, String BI, char sexo, String email, int telefone) {
        this.nome = nome;
        this.idade = idade;
        Nacionalidade = nacionalidade;
        this.NIF = NIF;
        this.BI = BI;
        this.sexo = sexo;
        this.email = email;
        this.telefone = telefone;
    }


    //metodos getter e setter

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getNacionalidade() {
        return Nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        Nacionalidade = nacionalidade;
    }

    public String getNIF() {
        return NIF;
    }

    public void setNIF(String NIF) {
        this.NIF = NIF;
    }

    public String getBI() {
        return BI;
    }

    public void setBI(String BI) {
        this.BI = BI;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }
}
