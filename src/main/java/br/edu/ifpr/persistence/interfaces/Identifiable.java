package br.edu.ifpr.persistence.interfaces;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public abstract class Identifiable {

    UUID id = UUID.randomUUID();

}
