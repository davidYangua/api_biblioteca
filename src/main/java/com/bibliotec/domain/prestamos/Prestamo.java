package com.bibliotec.domain.prestamos;

import com.bibliotec.domain.ejemplar.Ejemplar;
import com.bibliotec.domain.usuario.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"prestamo_id"})
@Entity(name = "Prestamo")
@Table(name = "prestamos")
public class Prestamo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long prestamo_id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ejemplar_id")
    private Ejemplar ejemplar;
    private LocalDateTime fecha_prestamo;
    private LocalDateTime fecha_devolucion;
    private LocalDateTime fecha_devuelto;
    private Boolean cancelado;
    private LocalDateTime fecha_cancelacion;
}
