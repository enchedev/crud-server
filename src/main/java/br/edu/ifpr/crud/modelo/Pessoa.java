package br.edu.ifpr.crud.modelo;

import br.edu.ifpr.persistence.interfaces.Identifiable;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;

@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@ToString
@NoArgsConstructor
abstract class Pessoa extends Identifiable {

    protected String nome;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSz")
    protected ZonedDateTime nascimento;
    protected Endereco endereco;

}
