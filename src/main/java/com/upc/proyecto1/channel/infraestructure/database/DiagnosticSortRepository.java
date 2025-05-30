package com.upc.proyecto1.channel.infraestructure.database;

import com.upc.proyecto1.channel.model.entity.DiagnosticEntity;
import org.springframework.data.repository.reactive.ReactiveSortingRepository;

public interface DiagnosticSortRepository extends ReactiveSortingRepository<DiagnosticEntity, Integer> {



}
