package br.com.accenture.report.demo.Enum;

public enum TipoConta {
    UNICA("Única"),
    MENSAL("Mensal"),
    ANUAL("Anual"),
    SEM_VENCIMENTO("Sem vencimento");

    private String descricao;

    TipoConta(String única) {
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
