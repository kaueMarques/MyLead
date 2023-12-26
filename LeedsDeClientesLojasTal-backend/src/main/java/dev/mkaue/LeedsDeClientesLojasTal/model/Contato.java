package dev.mkaue.LeedsDeClientesLojasTal.model;

import javax.validation.constraints.NotNull;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Contato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(unique = true)
    private String numeroTelefone;
    
    @NotNull
    @Column(unique = true)
    private String email;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

}
