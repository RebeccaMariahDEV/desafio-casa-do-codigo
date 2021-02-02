package br.com.zup.desafioCasaCodigo.repository;

import br.com.zup.desafioCasaCodigo.model.Categorias;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface CategoriaRepository extends JpaRepository<Categorias, Long> {
    Optional<Categorias> findByNomeCategoria(String nomeCategoria);

}
