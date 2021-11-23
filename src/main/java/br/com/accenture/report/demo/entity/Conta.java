package br.com.accenture.report.demo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Conta {
    @Id
    @GeneratedValue()
    public int id;

    @Column(name ="descricao")
    public String descricao;


    @Column(name ="valor", precision=10, scale=2)
    public Long valor;

    @Column(name ="tipoConta")
    public String tipoConta;

    @Column(name ="qtdParcela")
    public Long qtdParcela;

    @Column(name ="dataInicio")
    @DateTimeFormat(pattern="dd/MM/yyyy")
    public Date dataInicio;

    @Column(name ="dataFim")
    @DateTimeFormat(pattern="dd/MM/yyyy")
    public Date dataFim;

    @Column(name ="mes")
    public String mes;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Long getValor() {
        return valor;
    }

    public void setValor(Long valor) { this.valor = valor; }

    public String getTipoConta() { return tipoConta; }

    public void setTipoConta(String tipoConta) { this.tipoConta = tipoConta; }

    public Long getQtdParcela() {
        return qtdParcela;
    }

    public void setQtdParcela(Long qtdParcela) {
        this.qtdParcela = qtdParcela;
    }

    public Date getDataInicio() { return dataInicio; }

    public void setDataInicio(Date dataInicio) { this.dataInicio = dataInicio; }

    public Date getDataFim() { return dataFim;  }

    public void setDataFim(Date dataFim) { this.dataFim = dataFim; }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }
}
