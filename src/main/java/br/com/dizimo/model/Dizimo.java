package br.com.dizimo.model;
import br.com.dizimo.domain.Mes;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table
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

    public Mes getMes() {
        return mes;
    }

    public void setMes(Mes mes) {
        this.mes = mes;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
