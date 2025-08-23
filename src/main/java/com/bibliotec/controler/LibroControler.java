package com.bibliotec.controler;

import com.bibliotec.domain.libro.DatosActualizarLibro;
import com.bibliotec.domain.libro.DatosDetalleLibro;
import com.bibliotec.domain.libro.DatosRegistroLibro;
import com.bibliotec.service.LibroService;
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
public class LibroControler {

    @Autowired
    private LibroService libroService;

    @PostMapping
    public ResponseEntity<DatosDetalleLibro> agregarLibro(@RequestBody @Valid DatosRegistroLibro datos, UriComponentsBuilder uriComponentsBuilder){
        var libro = libroService.agregarLibro(datos);
        var uri = uriComponentsBuilder.path("/api/libros/{id}").buildAndExpand(libro.libro_id()).toUri();
        return ResponseEntity.created(uri).body(libro);
    }

    @GetMapping
    public ResponseEntity<Page<DatosDetalleLibro>> obtenerLibros(@PageableDefault(sort = {"titulo"}) Pageable page){
        var libros = libroService.obtenerLibros(page);
        return ResponseEntity.ok(libros);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DatosDetalleLibro> actualizarLibro(@PathVariable Long id, @RequestBody DatosActualizarLibro datos){
        var libroActualizado = libroService.actualizarLibro(id, datos);
        return ResponseEntity.ok(libroActualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarLibro(@PathVariable Long id){
        libroService.eliminarLibro(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("{id}")
    private ResponseEntity<DatosDetalleLibro> obtenerLibro(@PathVariable Long id){
        var libro = libroService.obtenerLibro(id);
        return ResponseEntity.ok(libro);
    }
}