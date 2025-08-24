package com.bibliotec.domain.libro;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.ISBN;

public record DatosDetalleLibro(
        Long libro_id,
        String titulo,
        String autor,
        String isbn,
        String imagen
) {
    public DatosDetalleLibro(Libro libro){
        this(libro.getIdLibro(),libro.getTitulo(),libro.getAutor(),libro.getIsbn(),libro.getImagen());
    }
}
