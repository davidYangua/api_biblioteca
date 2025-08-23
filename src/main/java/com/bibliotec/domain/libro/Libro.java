package com.bibliotec.domain.libro;

import com.bibliotec.domain.ejemplar.Ejemplar;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"libro_id"})
@Entity(name = "Libro")
@Table(name = "libros")
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long  libro_id;
    private String titulo;
    private String autor;
    private String isbn;
    private String imagen;
    private Boolean activo;
    @OneToMany(mappedBy = "libro", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Ejemplar> ejemplares;

    public Libro(DatosRegistroLibro datos){
        this.titulo = datos.titulo();
        this.autor = datos.autor();
        this.isbn = datos.isbn();
        this.imagen = datos.imagen();
        this.activo=true;
    }

    public void addEjemplar(Ejemplar ejemplar){
        if(ejemplares==null){
            ejemplares = new ArrayList<>();
        }
        ejemplar.setLibro(this);
        ejemplares.add(ejemplar);
    }
}
