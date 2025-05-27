package com.upc.proyecto1.channel.web;

import com.upc.proyecto1.channel.business.ProcessBusiness;
import com.upc.proyecto1.channel.model.aggregate.DiagnosticRegisterCommand;
import com.upc.proyecto1.channel.model.aggregate.ProcesamientoOutput;
import com.upc.proyecto1.channel.model.entity.DiagnosticEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/procesar")
@RequiredArgsConstructor
public class ProcessController {


  private final ProcessBusiness processBusiness;


  @PostMapping
  public Mono<ProcesamientoOutput> procesar() {

    return processBusiness.procesar();
  }

  @PostMapping("/save")
  public Mono<DiagnosticEntity> save(@RequestBody DiagnosticRegisterCommand command) {

    return processBusiness.save(command);
  }


}
