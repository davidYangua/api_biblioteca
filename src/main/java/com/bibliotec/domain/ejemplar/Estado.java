package com.bibliotec.domain.ejemplar;

public enum Estado {
    DISPONIBLE("DISPONIBLE"),
    PRESTADO("PRESTADO"),
    DAÑADO("DAÑADO"),
    PERDIDO("PERDIDO"),
    RESERVADO("RESERVADO"),
    NO_DISPONIBLE("NO_DISPONIBLE");

    private String value;

    Estado(String value){
        this.value = value;
    }

    public static String toString(Estado estado){
        for(Estado i: Estado.values()){
            if(i.equals(estado)){
                return i.value;
            }
        }
        throw new IllegalArgumentException("Estado no válido");
    }

    public static Estado toEnum(String valor){
        for(Estado i: Estado.values()){
            if(i.value.equals(valor)){
                return i;
            }
        }
        throw new IllegalArgumentException("Estado no válido");
    }
}
