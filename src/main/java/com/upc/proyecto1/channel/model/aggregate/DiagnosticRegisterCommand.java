package com.upc.proyecto1.channel.model.aggregate;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DiagnosticRegisterCommand {

  String prediccion;
  String enfermedad;
  String usuario ;

}
