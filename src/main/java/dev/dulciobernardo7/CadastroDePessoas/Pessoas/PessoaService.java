package dev.dulciobernardo7.CadastroDePessoas.Pessoas;

import dev.dulciobernardo7.CadastroDePessoas.Pessoas.Model.PessoaModel;
import dev.dulciobernardo7.CadastroDePessoas.Tarefas.Model.TarefasModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {
    private PessoasRepository pessoasRepository;
    private  PessoaMapper pessoaMapper;

    public PessoaService(PessoasRepository pessoasRepository, PessoaMapper pessoaMapper) {
        this.pessoasRepository = pessoasRepository;
        this.pessoaMapper = pessoaMapper;
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
    public PessoaDTO cadastroDeFuncionario(PessoaDTO pessoaDTO){
        PessoaModel pessoaModel =  pessoaMapper.map(pessoaDTO);
        pessoaModel =   pessoasRepository.save(pessoaModel);
        return  pessoaMapper.map(pessoaModel);
    }

    //Metodo para eliminar  fucionario
    public void ExcluirPessoaPorId(Long number){
        pessoasRepository.deleteById(number);
    }

    // Metodo para Alterar dados dos ninjas (UPDATE)
    public  PessoaModel Atualizarfuncionario(Long number, PessoaModel pessoa){
        if (pessoasRepository.existsById(number)){
            pessoa.setId(number);
            return pessoasRepository.save(pessoa);
        }
        return null;
    }
}
