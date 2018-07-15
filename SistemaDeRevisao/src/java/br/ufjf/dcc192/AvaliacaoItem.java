package br.ufjf.dcc192;

public class AvaliacaoItem {
    private Long id_avaliacao;
    private Long id_usuario;
    private Long id_item;
    private Boolean tipo;

    public Long getId_avaliacao() {
        return id_avaliacao;
    }

    public void setId_avaliacao(Long id_avaliacao) {
        this.id_avaliacao = id_avaliacao;
    }

    public Long getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Long id_usuario) {
        this.id_usuario = id_usuario;
    }

    public Long getId_item() {
        return id_item;
    }

    public void setId_item(Long id_item) {
        this.id_item = id_item;
    }

    public Boolean isTipo() {
        return tipo;
    }

    public void setTipo(Boolean tipo) {
        this.tipo = tipo;
    }
    
}
