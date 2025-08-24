package com.bibliotec.domain.ejemplar;

public enum Estado {
    DISPONIBLE("DISPONIBLE"),
    PRESTADO("PRESTADO"),
    DAÑADO("DAÑADO"),
    PERDIDO("PERDIDO"),
    NO_DISPONIBLE("NO_DISPONIBLE");

    private String value;

    Estado(String value){
        this.value = value;
    }

    public static String getValor(Estado estado){
        for(Estado i: Estado.values()){
            if(i.equals(estado)){
                return i.value;
            }
        }
        throw new IllegalArgumentException("Estado no válido");
    }
}
