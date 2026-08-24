package dev.dulciobernardo7.CadastroDePessoas.Tarefas;

import dev.dulciobernardo7.CadastroDePessoas.Tarefas.Model.TarefasModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TarefasRepository  extends JpaRepository<TarefasModel,Long> {
}
