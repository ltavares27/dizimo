package br.com.dizimo.model;
import br.com.dizimo.domain.Mes;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Dizimo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Double valor;

    @Temporal(TemporalType.DATE)
    private Date dataPagamento;

    @ManyToOne
    private Pessoa pessoa;

    @Column(name = "observacao_pagamento")
    private String observacao;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "mes_referencia")
    private Mes mes;
}
