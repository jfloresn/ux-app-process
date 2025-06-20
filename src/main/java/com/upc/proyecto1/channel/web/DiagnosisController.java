package com.upc.proyecto1.channel.web;

import com.upc.proyecto1.channel.business.ProcessBusiness;
import com.upc.proyecto1.channel.model.aggregate.DiagnosisStatuOutput;
import com.upc.proyecto1.channel.model.aggregate.DiagnosticRegisterCommand;
import com.upc.proyecto1.channel.model.aggregate.DiseaseStateOfVineOutput;
import com.upc.proyecto1.channel.model.entity.DiagnosticEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/diagnosis")
@RequiredArgsConstructor
public class DiagnosisController {


  private final ProcessBusiness processBusiness;


  @GetMapping
  public Flux<DiagnosticEntity> retrieve() {

    return processBusiness.retrieve();
  }

  @GetMapping("/status")
  public Mono<DiagnosisStatuOutput> statusDiagnosis() {

    return processBusiness.retrieveDiagnosisStatus();
  }
  @GetMapping("/health")
  public Mono<DiseaseStateOfVineOutput> retrieveDiseaseStateOfVine() {

    return processBusiness.retrieveDiseaseStateOfVine();
  }


  @GetMapping("/exists/{codigoPlantacion}")
  public Mono<Boolean> verificarExistenciaCodigoPlantacion(@PathVariable String codigoPlantacion) {
    return processBusiness.verificarSiExisteCodigoPlantacion(codigoPlantacion);
  }


  @PostMapping("/save")
  public Mono<DiagnosticEntity> save(@RequestBody DiagnosticRegisterCommand command) {

    return processBusiness.save(command);
  }


}
