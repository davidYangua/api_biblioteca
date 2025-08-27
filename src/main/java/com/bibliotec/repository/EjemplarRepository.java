package com.bibliotec.repository;

import com.bibliotec.domain.ejemplar.DatosDetalleEjemplar;
import com.bibliotec.domain.ejemplar.Ejemplar;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface EjemplarRepository extends JpaRepository<Ejemplar,Long> {
    @Query("""
            select e from Ejemplar e
            join e.libro l
            where e.estado = 'DISPONIBLE' and e.libro.idLibro = :id and l.activo = True
            """)
    Page<Ejemplar> findEjemplaresDisponiblesPorLibro(Long id, Pageable page);

    @Query("""
            select e from Ejemplar e
            join e.libro l
            where l.idLibro = :idLibro and e.idEjemplar = :idEjemplar
            """)
    Optional<Ejemplar> findByidLibroAndCodigo(Long idLibro, Long idEjemplar);

    @Query("""
            select e from Ejemplar e
            join e.libro l
            where l.idLibro = :idLibro and e.codigoUnico = :codigo and e.estado = 'DISPONIBLE'
            """)
    Page<DatosDetalleEjemplar> findEjemplaresDisponiblesPorCodigo(Long idLibro, String codigo, Pageable page);
}
