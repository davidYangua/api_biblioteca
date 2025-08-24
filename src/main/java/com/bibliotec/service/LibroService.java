package com.bibliotec.service;

import com.bibliotec.domain.libro.DatosActualizarLibro;
import com.bibliotec.domain.libro.DatosDetalleLibro;
import com.bibliotec.domain.libro.DatosRegistroLibro;
import com.bibliotec.domain.libro.Libro;
import com.bibliotec.repository.LibroRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Set;

@Service
public class LibroService {

    @Autowired
    private LibroRepository libroRepository;

    @Transactional
    public DatosDetalleLibro agregarLibro(DatosRegistroLibro datos) {
        var libro = new Libro(datos);
        return new DatosDetalleLibro(libroRepository.save(libro));
    }

    @Transactional
    public DatosDetalleLibro actualizarLibro(Long id, DatosActualizarLibro datos) {
        var libro = libroRepository.getReferenceById(id);
        if(datos.titulo()!=null){
            libro.setTitulo(datos.titulo());
        }
        if(datos.autor()!=null){
            libro.setAutor(datos.autor());
        }
        if(datos.imagen()!=null){
            libro.setImagen(datos.imagen());
        }
        return new DatosDetalleLibro(libro);
    }

    @Transactional
    public void eliminarLibro(Long id) {
        var libro = libroRepository.getReferenceById(id);
        libro.setActivo(false);
    }

    public DatosDetalleLibro obtenerLibro(Long id) {
        //var libro = libroRepository.findById(id);
        var libro = libroRepository.findByIdAndActivoTrue(id).orElseThrow(() -> new RuntimeException("Libro no encontrado o inactivo"));
        return new DatosDetalleLibro(libro);
    }

    public Page<DatosDetalleLibro> obtenerLibros(String titulo, Pageable page, Map<String, String> allParams){

        Set<String> parametros = Set.of("titulo","autor","size","sort");
        for(String param: allParams.keySet()){
            if(!parametros.contains(param)){
                throw new IllegalArgumentException("Parámtro no vaĺido: "+param);
            }
        }

        if(titulo!=null && !titulo.isBlank()){
            return libroRepository.findByTitulo(titulo, page).map(DatosDetalleLibro::new);
        }
        return libroRepository.findAllByActivoTrue(page).map(DatosDetalleLibro::new);
    }
}
