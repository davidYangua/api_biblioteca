package com.bibliotec.libro;

import com.bibliotec.domain.ejemplar.Ejemplar;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"idLibro"})
@Entity(name = "Libro")
@Table(name = "libros")
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLibro;
    private String titulo;
    private String autor;
    private String isbn;
    private String imagen;
    @OneToMany(mappedBy = "libro", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Ejemplar> ejemplares;

    public void addEjemplar(Ejemplar ejemplar){
        if(ejemplares==null){
            ejemplares = new ArrayList<>();
        }
        ejemplar.setLibro(this);
        ejemplares.add(ejemplar);
    }
}
