package com.example.demo.schedulers;

import com.example.demo.services.ClimaService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ActualizacionTemporalScheduler {
    private final ClimaService climaService;

    public ActualizacionTemporalScheduler(ClimaService climaService) {
        this.climaService = climaService;
    }

    @Scheduled(fixedRate = 300000) // 300000 ms = 5 minutos
    public void obtenerClimaActual() {
        climaService.obtenerYGuardarClima();
    }
}
