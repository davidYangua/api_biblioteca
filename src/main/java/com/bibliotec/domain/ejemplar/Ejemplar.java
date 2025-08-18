package com.bibliotec.domain.ejemplar;

import com.bibliotec.domain.prestamos.Prestamo;
import com.bibliotec.libro.Libro;
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
@EqualsAndHashCode(of = {"idEjemplar"})
@Entity(name = "Ejemplar")
@Table(name = "ejemplares")
public class Ejemplar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEjemplar;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idLibro")
    private Libro libro;
    private String codigoUnico;
    @Enumerated(EnumType.STRING)
    private Estado estado;
    @OneToMany(mappedBy = "ejemplar", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    List<Prestamo> prestamos;

    public void addPrestamo(Prestamo prestamo){
        if(prestamos==null){
            prestamos = new ArrayList<>();
        }
        prestamo.setEjemplar(this);
        prestamos.add(prestamo);
    }
}
