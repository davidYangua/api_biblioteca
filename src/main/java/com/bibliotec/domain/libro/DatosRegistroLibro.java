package com.bibliotec.domain.libro;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.ISBN;

public record DatosRegistroLibro(
        @NotBlank(message = "El título no puede ser nulo")
        String titulo,
        @NotBlank(message = "El autor no puede ser nulo")
        String autor,
        @NotBlank(message = "El ISBN no puede estar vacío")
        @ISBN(type = ISBN.Type.ISBN_13,message = "ISBN inválido")
        @Size(min = 13, max = 13, message = "El ISBN debe tener 13 caracteres")
        String isbn,
        @NotBlank(message = "La imagen es requerida")
        String imagen
) {

}
