package dev.dulciobernardo7.CadastroDePessoas.Pessoas;

import dev.dulciobernardo7.CadastroDePessoas.Pessoas.Model.PessoaModel;
import org.springframework.stereotype.Component;


@Component
public class PessoaMapper {

    public PessoaModel map(PessoaDTO pessoaDTO){
        PessoaModel pessoaModel = new PessoaModel();
        pessoaModel.setId(pessoaDTO.getId());
        pessoaModel.setNome(pessoaDTO.getNome());
        pessoaModel.setIdade(pessoaDTO.getIdade());
        pessoaModel.setNacionalidade(pessoaDTO.getNacionalidade());
        pessoaModel.setBi(pessoaDTO.getBi());
        pessoaModel.setSexo(pessoaDTO.getSexo());
        pessoaModel.setEmail(pessoaDTO.getEmail());
        pessoaModel.setTelefone(pessoaDTO.getTelefone());
        pessoaModel.setNivel(pessoaDTO.getNivel());
        pessoaModel.setImgUrl(pessoaModel.getImgUrl());
        pessoaModel.setTarefa(pessoaDTO.getTarefa());
        return pessoaModel;
    }

    public PessoaDTO map(PessoaModel pessoaModel){
        PessoaDTO pessoaDTO = new PessoaDTO();

        pessoaDTO.setId(pessoaModel.getId());
        pessoaDTO.setNome(pessoaModel.getNome());
        pessoaDTO.setIdade(pessoaModel.getIdade());
        pessoaDTO.setNacionalidade(pessoaModel.getNacionalidade());
        pessoaDTO.setBi(pessoaModel.getBi());
        pessoaDTO.setSexo(pessoaModel.getSexo());
        pessoaDTO.setEmail(pessoaModel.getEmail());
        pessoaDTO.setTelefone(pessoaModel.getTelefone());
        pessoaDTO.setNivel(pessoaModel.getNivel());
        pessoaDTO.setImgUrl(pessoaModel.getImgUrl());
        pessoaDTO.setTarefa(pessoaModel.getTarefa());
        return pessoaDTO;
    }
}
