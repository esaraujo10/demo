package br.com.accenture.report.demo.vo;

import java.math.BigDecimal;
import java.util.Date;

public class RelatorioContaVO {
    private String descricao;
    private BigDecimal valor;
    private Date data;
    private String tipoCompra;
    private long qtdParcela;
    private String mes;
    private long parcela;
    private BigDecimal valorParcela;
    private BigDecimal totalMensal;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getTipoCompra() {
        return tipoCompra;
    }

    public void setTipoCompra(String tipoCompra) {
        this.tipoCompra = tipoCompra;
    }

    public long getQtdParcela() {
        return qtdParcela;
    }

    public void setQtdParcela(long qtdParcela) {
        this.qtdParcela = qtdParcela;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public long getParcela() {
        return parcela;
    }

    public void setParcela(long parcela) {
        this.parcela = parcela;
    }

    public BigDecimal getValorParcela() {
        return valorParcela;
    }

    public void setValorParcela(BigDecimal valorParcela) {
        this.valorParcela = valorParcela;
    }

    public BigDecimal getTotalMensal() {
        return totalMensal;
    }

    public void setTotalMensal(BigDecimal totalMensal) {
        this.totalMensal = totalMensal;
    }
}
