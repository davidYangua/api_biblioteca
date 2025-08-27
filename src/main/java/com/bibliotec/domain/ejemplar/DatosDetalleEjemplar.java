package com.bibliotec.domain.ejemplar;

public record DatosDetalleEjemplar(
        Long idEjemplar,
        Long idLibro,
        String codigoUnico,
        String estado
) {
    public DatosDetalleEjemplar (Ejemplar datos){
        this(datos.getIdEjemplar(),datos.getLibro().getIdLibro(), datos.getCodigoUnico(),Estado.toString(datos.getEstado()));
    }
}