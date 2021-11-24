package br.com.accenture.report.demo.Enum;

public enum TipoConta {
    UNICA(1, "Única"),
    MENSAL(2, "Mensal"),
    ANUAL(3, "Anual"),
    SEM_VENC(4, "Sem Vencimento");

    private int codigo;
    private String descricao;

    TipoConta(int codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public int getCodigo() { return codigo; }

    public void setCodigo(int codigo) { this.codigo = codigo; }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
