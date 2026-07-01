package com.example.demo.models.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Clima {
    // TODO: ver si es float o que tipo de dato es
    private Long id;
    private float temperatura;
    private float humedad;

    public Clima(float temperatura, float humedad) {
        this.temperatura = temperatura;
        this.humedad = humedad;
    }

    public boolean esPeligroso() {
        return temperatura > 35.0f && humedad > 60.0f;
    }
}
