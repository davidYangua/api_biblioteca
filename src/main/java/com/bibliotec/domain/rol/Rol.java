package com.bibliotec.domain.rol;

import com.bibliotec.domain.usuario.Usuario;
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
@EqualsAndHashCode(of = {"idRol"})
@Entity(name = "Rol")
@Table(name = "roles")
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRol;
    @Enumerated(EnumType.STRING)
    private Roles rol;
    @OneToMany(mappedBy = "rol", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Usuario> usuarios;

    public void addUsuario(Usuario usuario){
        if(usuarios==null){
            usuarios = new ArrayList<>();
        }
        usuario.setRol(this);
        usuarios.add(usuario);
    }
}
