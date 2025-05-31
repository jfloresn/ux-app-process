package com.upc.proyecto1.channel.model.aggregate;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DiseaseStateOfVineOutput {

  private Integer countSampleDiagnosis;
  private Long countDiseases;
  private Long countHealth;

}
