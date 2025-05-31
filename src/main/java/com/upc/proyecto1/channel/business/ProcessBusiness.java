package com.upc.proyecto1.channel.business;

import com.upc.proyecto1.channel.model.aggregate.DiagnosisStatuOutput;
import com.upc.proyecto1.channel.model.aggregate.DiagnosticRegisterCommand;
import com.upc.proyecto1.channel.model.aggregate.DiseaseStateOfVineOutput;
import com.upc.proyecto1.channel.model.aggregate.ProcesamientoOutput;
import com.upc.proyecto1.channel.model.entity.DiagnosticEntity;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProcessBusiness {

  Mono<ProcesamientoOutput> procesar();
  Mono<DiagnosticEntity> save(DiagnosticRegisterCommand command);
  Flux<DiagnosticEntity> retrieve();
  Mono<DiagnosisStatuOutput> retrieveDiagnosisStatus();
  Mono<DiseaseStateOfVineOutput> retrieveDiseaseStateOfVine();
}
