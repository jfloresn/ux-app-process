package com.upc.proyecto1.channel.model.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;


@Table("parametro")
@Setter
@Getter
@Builder
public class ParameterEntity {

  @Id
  @Column("codigo")
  private Integer codigo;
  @Column("nombre")
  private String nombre;
  @Column("valor")
  private String valor;

}
