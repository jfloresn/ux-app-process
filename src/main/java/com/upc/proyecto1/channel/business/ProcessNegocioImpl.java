package com.upc.proyecto1.channel.business;

import com.upc.proyecto1.channel.infraestructure.database.DiagnosticoRepository;
import com.upc.proyecto1.channel.model.aggregate.DiagnosticRegisterCommand;
import com.upc.proyecto1.channel.model.aggregate.ProcesamientoOutput;
import com.upc.proyecto1.channel.model.entity.DiagnosticEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Service
public class ProcessNegocioImpl implements ProcessBusiness {


  @Autowired
  private DiagnosticoRepository diagnosticoRepository;

  @Override
  public Mono<DiagnosticEntity> save(DiagnosticRegisterCommand diagnosticRegisterCommand) {

    return diagnosticoRepository.save(DiagnosticEntity.builder()
            .fechaHoraRegistro(LocalDateTime.now())
            .prediccion(diagnosticRegisterCommand.getPrediccion())
            .nombreEnfermedad(diagnosticRegisterCommand.getEnfermedad())
            .usuario(diagnosticRegisterCommand.getUsuario())
        .build());

  }

  @Override
  public Mono<ProcesamientoOutput> procesar() {

    return Mono.just(ProcesamientoOutput.builder()
        .estado("001")
        .message("Se proceso corectamente la deteción de enfermedad en la uva")
        .diagnostico("Tiene la enfermedad ESCA")
        .tieneEnfermedad(true)
        .build());

  }
}
