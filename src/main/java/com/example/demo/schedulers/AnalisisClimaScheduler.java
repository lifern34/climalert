package com.example.demo.schedulers;

import com.example.demo.services.ClimaService;
import org.springframework.scheduling.annotation.Scheduled;

public class AnalisisClimaScheduler {
    private final ClimaService climaService;

    public AnalisisClimaScheduler(ClimaService climaService) {
        this.climaService = climaService;
    }

    @Scheduled(fixedRate = 60000) // 60000 ms = 1 minuto
    public void analizarClimaActual() {
        climaService.analizarClima();
    }
}
