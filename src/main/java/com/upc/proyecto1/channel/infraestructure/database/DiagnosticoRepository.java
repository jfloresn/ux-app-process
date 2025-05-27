package com.upc.proyecto1.channel.infraestructure.database;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import com.upc.proyecto1.channel.model.entity.DiagnosticEntity;

public interface DiagnosticoRepository extends ReactiveCrudRepository<DiagnosticEntity, Integer> {

}
