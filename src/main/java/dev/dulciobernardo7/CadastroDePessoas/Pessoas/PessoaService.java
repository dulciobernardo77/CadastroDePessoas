package dev.dulciobernardo7.CadastroDePessoas.Pessoas;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PessoaService {
    private final PessoasRepository pessoasRepository;
    private final PessoaMapper pessoaMapper;

    public PessoaService(PessoasRepository pessoasRepository, PessoaMapper pessoaMapper) {
        this.pessoasRepository = pessoasRepository;
        this.pessoaMapper = pessoaMapper;
    }

    //Metodo para lista todo o pessoas
    public List<PessoaDTO> ListatodasPessoas(){
        List<PessoaModel> pessoaModelList = pessoasRepository.findAll();
        return  pessoaModelList.stream()
        .map(pessoaMapper::map).collect(Collectors.toList());
    }

    //Metodo para lista todo as pessoas pelo id
    public PessoaDTO ListatodasPessoasporId(Long number){
      Optional<PessoaModel> pessoaModel = pessoasRepository.findById(number);
      return  pessoaModel.map(pessoaMapper::map)
              .orElse(null);
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
    public  PessoaDTO Atualizarfuncionario(Long number, PessoaDTO pessoaDTO){
        Optional<PessoaModel> pessoaExistente = pessoasRepository.findById(number);
        if (pessoaExistente.isPresent()){
            PessoaModel pessoaAtualizada = pessoaMapper.map(pessoaDTO);
            pessoaAtualizada.setId(number);
            PessoaModel pessoaSalva = pessoasRepository.save(pessoaAtualizada);
            return pessoaMapper.map(pessoaSalva) ;
        }
        return null;
    }
}
