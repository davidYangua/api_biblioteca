package com.bibliotec.controler;

import com.bibliotec.domain.ejemplar.DatosDetalleEjemplar;
import com.bibliotec.service.EjemplarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/libros")
public class EjemplarControler {

    @Autowired
    private EjemplarService ejemplarService;

    @GetMapping("/{id}/items")
    public ResponseEntity<Page<DatosDetalleEjemplar>> obetenerEjemplares(@PathVariable Long id, @PageableDefault Pageable page){
        return ResponseEntity.ok(ejemplarService.obetenerEjemplares(id, page));
    }
}
