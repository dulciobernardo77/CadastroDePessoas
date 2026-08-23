package dev.dulciobernardo7.CadastroDePessoas.Pessoas;

import dev.dulciobernardo7.CadastroDePessoas.Pessoas.Model.PessoaModel;
import dev.dulciobernardo7.CadastroDePessoas.Tarefas.Model.TarefasModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {
    private PessoasRepository pessoasRepository;

    public PessoaService(PessoasRepository pessoasRepository){
        this.pessoasRepository = pessoasRepository;
    }

    //Metodo para lista todo o pessoas
    public List<PessoaModel> ListatodasPessoas(){
        return pessoasRepository.findAll();
    }

    //Metodo para lista todo as pessoas pelo id
    public PessoaModel ListatodasPessoasporId(Long number){
      Optional<PessoaModel> pessoaModel = pessoasRepository.findById(number);
      return  pessoaModel.orElse(null);
    }

    //Metodo para cadastro de fucionario
    public PessoaModel cadastroDeFuncionario(PessoaModel pessoas){
        return pessoasRepository.save(pessoas);
    }


}
