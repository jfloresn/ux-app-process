package com.upc.proyecto1.channel.model.entity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import java.time.LocalDateTime;


@Table("tb_vid_diagnostic")
@Setter
@Getter
@Builder
public class DiagnosticEntity {

  @Id
  @Column("id_diagnostic")
  private Integer idDiagnostic;

  @Column("fecha_hora_registro")
  private LocalDateTime fechaHoraRegistro;
  @Column("prediccion")
  private String prediccion;
  @Column("nombre_enfermedad")
  private String nombreEnfermedad;
  @Column("usuario")
  private String usuario;
  @Column("codigoPlantacion")
  private String codigoPlantacion;


}
