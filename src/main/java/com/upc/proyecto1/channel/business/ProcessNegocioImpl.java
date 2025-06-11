package com.upc.proyecto1.channel.business;

import com.upc.proyecto1.channel.infraestructure.database.DiagnosticSortRepository;
import com.upc.proyecto1.channel.infraestructure.database.DiagnosticoRepository;
import com.upc.proyecto1.channel.infraestructure.database.ParameterRepository;
import com.upc.proyecto1.channel.model.aggregate.DiagnosisStatuOutput;
import com.upc.proyecto1.channel.model.aggregate.DiagnosticRegisterCommand;
import com.upc.proyecto1.channel.model.aggregate.DiseaseStateOfVineOutput;
import com.upc.proyecto1.channel.model.aggregate.ProcesamientoOutput;
import com.upc.proyecto1.channel.model.entity.DiagnosticEntity;
import com.upc.proyecto1.channel.model.entity.ParameterEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Service
public class ProcessNegocioImpl implements ProcessBusiness {


  @Autowired
  private DiagnosticoRepository diagnosticoRepository;

  @Autowired
  private ParameterRepository parameterRepository;

  @Autowired
  private DiagnosticSortRepository diagnosticSortRepository;

  @Override
  public Mono<DiagnosticEntity> save(DiagnosticRegisterCommand diagnosticRegisterCommand) {

    return diagnosticoRepository.save(DiagnosticEntity.builder()
            .fechaHoraRegistro(LocalDateTime.now())
            .prediccion(diagnosticRegisterCommand.getPrediccion())
            .nombreEnfermedad(diagnosticRegisterCommand.getEnfermedad())
            .codigoPlantacion(diagnosticRegisterCommand.getCodigoPlantacion())
            .usuario(diagnosticRegisterCommand.getUsuario())
        .build());

  }

  @Override
  public Flux<DiagnosticEntity> retrieve() {

    return diagnosticSortRepository.findAll(Sort.by(Sort.Direction.DESC, "fechaHoraRegistro"));
  }

  @Override
  public Mono<DiagnosisStatuOutput> retrieveDiagnosisStatus() {


    return Mono.zip(
            parameterRepository.findById(1).map(ParameterEntity::getValor),
            diagnosticoRepository.count()
        )
        .map(tuple -> {
          String valorParametro = tuple.getT1();
          Long cantidadDiagnosticos = tuple.getT2();

          return DiagnosisStatuOutput.builder()
              .countDiagnosis( cantidadDiagnosticos)
              .countSampleDiagnosis(Integer.parseInt(valorParametro))
              .build();
        });
  }

  @Override
  public Mono<DiseaseStateOfVineOutput> retrieveDiseaseStateOfVine() {
    return Mono.zip(
            parameterRepository.findById(1).map(ParameterEntity::getValor),
            diagnosticoRepository.countByEstadoHealthy(),
            diagnosticoRepository.countByEstadoNotHealthy()
        )
        .map(tuple -> {
          String valorParametro = tuple.getT1();
          Long countByHealthy = tuple.getT2();
          Long countByNotHealthy = tuple.getT3();

          return DiseaseStateOfVineOutput.builder()
              .countSampleDiagnosis(Integer.parseInt(valorParametro))
              .countHealth(countByHealthy)
              .countDiseases(countByNotHealthy)
              .build();
        });
  }

  @Override
  public Mono<Boolean> verificarSiExisteCodigoPlantacion(String codigoPlantacion) {
    return diagnosticoRepository.existsByCodigoPlantacion(codigoPlantacion);
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
