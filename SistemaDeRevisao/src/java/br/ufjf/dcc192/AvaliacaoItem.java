package br.ufjf.dcc192;

public class AvaliacaoItem {
    private long id_avaliacao;
    private long id_usuario;
    private long id_item;
    private boolean tipo;

    public long getId_avaliacao() {
        return id_avaliacao;
    }

    public void setId_avaliacao(long id_avaliacao) {
        this.id_avaliacao = id_avaliacao;
    }

    public long getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(long id_usuario) {
        this.id_usuario = id_usuario;
    }

    public long getId_item() {
        return id_item;
    }

    public void setId_item(long id_item) {
        this.id_item = id_item;
    }

    public boolean isTipo() {
        return tipo;
    }

    public void setTipo(boolean tipo) {
        this.tipo = tipo;
    }
    
}
