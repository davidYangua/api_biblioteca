package com.bibliotec.domain.usuario;

import com.bibliotec.domain.prestamos.Prestamo;
import com.bibliotec.domain.rol.Rol;
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
@EqualsAndHashCode(of = {"usuario_id"})
@Entity(name = "Usuario")
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long usuario_id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rol_id")
    private Rol rol;
    private String nombre;
    private String email;
    private String password;
    private Boolean estado;
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    List<Prestamo>prestamos;

    public void addPrestamo(Prestamo prestamo){
        if(prestamos==null){
            prestamos = new ArrayList<>();
        }
        prestamo.setUsuario(this);
        prestamos.add(prestamo);
    }
}
