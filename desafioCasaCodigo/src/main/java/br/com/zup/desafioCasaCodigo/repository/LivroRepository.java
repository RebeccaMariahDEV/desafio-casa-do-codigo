package br.com.zup.desafioCasaCodigo.repository;

import br.com.zup.desafioCasaCodigo.dto.LivroDetalhado;
import br.com.zup.desafioCasaCodigo.dto.LivroIdTitulo;
import br.com.zup.desafioCasaCodigo.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {
    List<LivroIdTitulo> findBy();
    Optional<Livro> findByTitulo(String titulo);
    Optional<Livro> findByIsbn(String isbn);
    Optional<Livro> findByCategoriasId(Long categorias_id);
    Optional<Livro> findByAutorId(Long autor);

}
