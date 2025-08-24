package com.bibliotec.service;

import com.bibliotec.domain.ejemplar.DatosDetalleEjemplar;
import com.bibliotec.repository.EjemplarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class EjemplarService {

    @Autowired
    private EjemplarRepository ejemplarRepository;

    public Page<DatosDetalleEjemplar> obetenerEjemplares(Long id,Pageable page) {
        return ejemplarRepository. findEjemplaresDisponiblesPorLibro(id,page).map(DatosDetalleEjemplar::new);
    }
}
