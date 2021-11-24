package br.com.accenture.report.demo.entity;

import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

@Entity
public class Conta {
    @Id
    @GeneratedValue()
    public int id;

    @Column(name ="descricao")
    public String descricao;

    @Column(name ="valor", precision=10, scale=2)
    public BigDecimal valor;

    @Column(name ="tipoConta")
    public String tipoConta;

    @Column(name ="qtdParcela")
    public BigDecimal qtdParcela;

    @Column(name ="dataInicio")
    @DateTimeFormat(pattern="dd/MM/yyyy")
    public Timestamp dataInicio;

    @Column(name ="dataFim")
    @DateTimeFormat(pattern="dd/MM/yyyy")
    public Date dataFim;

    @Column(name ="mes")
    public String mes;

    @Column(name ="parcela")
    public Long parcela;

    @Column(name ="valorParcela")
    public BigDecimal valorParcela;

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) { this.valor = valor; }

    public String getTipoConta() { return tipoConta; }

    public void setTipoConta(String tipoConta) { this.tipoConta = tipoConta; }

    public BigDecimal getQtdParcela() { return qtdParcela; }

    public void setQtdParcela(BigDecimal qtdParcela) { this.qtdParcela = qtdParcela; }

    public Timestamp getDataInicio() { return dataInicio; }

    public void setDataInicio(Timestamp dataInicio) { this.dataInicio = dataInicio; }

    public Date getDataFim() { return dataFim;  }

    public void setDataFim(Date dataFim) { this.dataFim = dataFim; }

    public String getMes() { return mes; }

    public void setMes(String mes) { this.mes = mes; }

    public Long getParcela() {
        return parcela;
    }

    public void setParcela(Long parcela) {
        this.parcela = parcela;
    }

    public BigDecimal getValorParcela() {
        return valorParcela;
    }

    public void setValorParcela(BigDecimal valorParcela) {
        this.valorParcela = valorParcela;
    }
}