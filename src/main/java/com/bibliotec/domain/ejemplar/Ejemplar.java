package com.bibliotec.domain.ejemplar;

import com.bibliotec.domain.prestamos.Prestamo;
import com.bibliotec.domain.libro.Libro;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"idEjemplar"})
@Entity(name = "Ejemplar")
@Table(name = "ejemplares")
public class Ejemplar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ejemplar_id")
    private Long idEjemplar;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "libro_id")
    private Libro libro;
    @Column(name = "codigo_unico")
    private String codigoUnico;
    @Enumerated(EnumType.STRING)
    private Estado estado;
    @OneToMany(mappedBy = "ejemplar", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    List<Prestamo> prestamos;

    public Ejemplar(DatosRegistroEjemplar datos) {
        this.codigoUnico = "";
        this.estado = Estado.toEnum(datos.estado());
    }

    public void addPrestamo(Prestamo prestamo){
        if(prestamos==null){
            prestamos = new ArrayList<>();
        }
        prestamo.setEjemplar(this);
        prestamos.add(prestamo);
    }
}
