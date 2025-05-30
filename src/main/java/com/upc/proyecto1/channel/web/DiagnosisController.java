package com.upc.proyecto1.channel.web;

import com.upc.proyecto1.channel.business.ProcessBusiness;
import com.upc.proyecto1.channel.model.aggregate.DiagnosticRegisterCommand;
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

  @PostMapping("/save")
  public Mono<DiagnosticEntity> save(@RequestBody DiagnosticRegisterCommand command) {

    return processBusiness.save(command);
  }


}
