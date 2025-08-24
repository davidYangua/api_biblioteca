package com.bibliotec.repository;

import com.bibliotec.domain.libro.Libro;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface LibroRepository extends JpaRepository<Libro,Long> {
    Page<Libro> findAllByActivoTrue(Pageable page);

    @Query("""
            select l from Libro l
            where l.idLibro = :id and l.activo = True
            """)
    Optional<Libro> findByIdAndActivoTrue(Long id);

    @Query("""
            select l from Libro l
            where l.titulo like LOWER(CONCAT('%', :titulo, '%')) and l.activo = True
            """)
    Page<Libro> findByTitulo(String titulo, Pageable page);
}
