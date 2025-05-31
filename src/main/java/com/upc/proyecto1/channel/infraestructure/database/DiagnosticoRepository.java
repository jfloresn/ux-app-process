package com.upc.proyecto1.channel.infraestructure.database;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;
import com.upc.proyecto1.channel.model.entity.DiagnosticEntity;

public interface DiagnosticoRepository extends ReactiveCrudRepository<DiagnosticEntity, Integer> {

  @Query("SELECT COUNT(id_diagnostic) FROM dbo.tb_vid_diagnostic WHERE nombre_enfermedad = 'Healthy'")
  Mono<Long> countByEstadoHealthy();

  @Query("SELECT COUNT(id_diagnostic) FROM dbo.tb_vid_diagnostic WHERE nombre_enfermedad <> 'Healthy'")
  Mono<Long> countByEstadoNotHealthy();

}
