package dev.dulciobernardo7.CadastroDePessoas.Pessoas;

import dev.dulciobernardo7.CadastroDePessoas.Pessoas.Model.PessoaModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoasRepository extends JpaRepository<PessoaModel, Long> {
}
