package com.bibliotec.service;

import com.bibliotec.domain.ejemplar.*;
import com.bibliotec.repository.EjemplarRepository;
import com.bibliotec.repository.LibroRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class EjemplarService {

    @Autowired
    private EjemplarRepository ejemplarRepository;

    @Autowired
    private LibroRepository libroRepository;

    public Page<DatosDetalleEjemplar> obetenerEjemplares(Long idLibro, String codigo,Pageable page) {
        if(codigo!=null && !codigo.isBlank()){
            return ejemplarRepository.findEjemplaresDisponiblesPorCodigo(idLibro,codigo,page);
        }else{
            return ejemplarRepository. findEjemplaresDisponiblesPorLibro(idLibro,page).map(DatosDetalleEjemplar::new);
        }
    }

    @Transactional
    public DatosDetalleEjemplar registrarNuevoEjemplar(Long id, DatosRegistroEjemplar datos) {
        var ejemplar = new Ejemplar(datos);
        var libro = libroRepository.getReferenceById(id);
        libro.addEjemplar(ejemplar);

        var ejemplarGuardado = ejemplarRepository.save(ejemplar);
        ejemplarGuardado.setCodigoUnico(generarCodigo(ejemplarGuardado.getIdEjemplar()));
        return new DatosDetalleEjemplar(ejemplarGuardado);
    }

    public DatosDetalleEjemplar obetenerEjemplar(Long idLibro, Long idEjemplar) {
        var ejemplar = ejemplarRepository.findByidLibroAndCodigo(idLibro,idEjemplar).orElseThrow(() -> new RuntimeException("Libro no encontrado"));
        return new DatosDetalleEjemplar(ejemplar);
    }

    @Transactional
    public DatosDetalleEjemplar actualizarEjemplar(Long id, DatosActualizarEjemplar datos) {
        var ejemplar = ejemplarRepository.getReferenceById(id);
        ejemplar.setEstado(Estado.toEnum(datos.estado().toUpperCase()));
        return new DatosDetalleEjemplar(ejemplar);
    }

    @Transactional
    public void eliminar(Long id, String estado) {
        var ejemplar = ejemplarRepository.getReferenceById(id);
        if(estado!=null && !estado.isBlank()){
            ejemplar.setEstado(Estado.toEnum(estado));
        }else{
            ejemplar.setEstado(Estado.NO_DISPONIBLE);
        }
    }

    public String generarCodigo(Long id) {
        return String.format("INV-%06d", id);
    }
}
