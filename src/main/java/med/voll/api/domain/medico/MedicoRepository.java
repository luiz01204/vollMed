package med.voll.api.domain.medico;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

// Herença de paRepository e passo o tipo de dados e qual o tipo do identificador.
public interface MedicoRepository extends JpaRepository<Medico, Long> {

    // O Spring data tem um padrão de escrita que ele interpreta como um querry:
    Page<Medico> findByAtivoTrue(Pageable pagina);
}
