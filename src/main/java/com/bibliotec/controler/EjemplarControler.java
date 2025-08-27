package com.bibliotec.controler;

import com.bibliotec.domain.ejemplar.DatosActualizarEjemplar;
import com.bibliotec.domain.ejemplar.DatosDetalleEjemplar;
import com.bibliotec.domain.ejemplar.DatosRegistroEjemplar;
import com.bibliotec.service.EjemplarService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/api/libros")
public class EjemplarControler {

    @Autowired
    private EjemplarService ejemplarService;

    @GetMapping("/{id}/items")
    public ResponseEntity<Page<DatosDetalleEjemplar>> obetenerEjemplares(
            @PathVariable Long id,
            @RequestParam(name = "codigo", required = false) String codigo,
            @PageableDefault Pageable page){
        return ResponseEntity.ok(ejemplarService.obetenerEjemplares(id, codigo ,page));
    }

    @GetMapping("/{id}/items/{item}")
    public ResponseEntity<DatosDetalleEjemplar> obtenerEjemplar(@PathVariable(name = "id") Long idLibro, @PathVariable(name = "item") Long idEjemplar){
        return ResponseEntity.ok(ejemplarService.obetenerEjemplar(idLibro, idEjemplar));
    }

    @PostMapping("{id}/items")
    public ResponseEntity<DatosDetalleEjemplar> registrarNuevoEjemplar(
            @PathVariable Long id,
            @RequestBody @Valid DatosRegistroEjemplar datos,
            UriComponentsBuilder uriComponentsBuilder){
        var libro = ejemplarService.registrarNuevoEjemplar(id,datos);
        var uri = uriComponentsBuilder.path("/api/libros/items/{id}").buildAndExpand(libro.idEjemplar()).toUri();
        return ResponseEntity.created(uri).body(libro);
    }

    @PutMapping("/items/{id}")
    public ResponseEntity<DatosDetalleEjemplar> actualizarEjemplar(@PathVariable Long id, @RequestBody DatosActualizarEjemplar datos){
        return ResponseEntity.ok(ejemplarService.actualizarEjemplar(id, datos));
    }

    @DeleteMapping("/items/{id}")
    public ResponseEntity<Void> eliminarEjemplar(@PathVariable Long id, @RequestParam(name = "estado", required = false) String estado){
        ejemplarService.eliminar(id, estado);
        return ResponseEntity.noContent().build();
    }
}
