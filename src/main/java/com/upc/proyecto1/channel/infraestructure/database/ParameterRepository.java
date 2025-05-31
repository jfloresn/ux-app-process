package com.upc.proyecto1.channel.infraestructure.database;

import com.upc.proyecto1.channel.model.entity.ParameterEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;


public interface ParameterRepository extends ReactiveCrudRepository<ParameterEntity, Integer> {

}
