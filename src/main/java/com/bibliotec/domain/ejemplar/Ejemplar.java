package com.bibliotec.domain.ejemplar;

import com.bibliotec.domain.prestamos.Prestamo;
import com.bibliotec.domain.libro.Libro;
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
@EqualsAndHashCode(of = {"ejemplar_id"})
@Entity(name = "Ejemplar")
@Table(name = "ejemplares")
public class Ejemplar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ejemplar_id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "libro_id")
    private Libro libro;
    private String codigo_unico;
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
