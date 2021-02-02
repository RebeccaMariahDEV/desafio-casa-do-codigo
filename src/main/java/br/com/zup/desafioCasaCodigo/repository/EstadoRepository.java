package br.com.zup.desafioCasaCodigo.repository;

import br.com.zup.desafioCasaCodigo.model.Estados;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EstadoRepository extends JpaRepository<Estados, Long> {

    Optional<Estados> findByEstado(String estado);
}
