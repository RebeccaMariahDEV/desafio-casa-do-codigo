package br.com.zup.desafioCasaCodigo.repository;

import br.com.zup.desafioCasaCodigo.model.Pais;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PaisRepository extends JpaRepository<Pais, Long> {

    Optional<Pais> findByPais(String pais);

}
