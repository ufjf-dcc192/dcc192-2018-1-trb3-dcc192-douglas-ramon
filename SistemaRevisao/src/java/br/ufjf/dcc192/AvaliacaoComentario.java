package br.ufjf.dcc192;

public class AvaliacaoComentario {
    private Long id_avaliacao;
    private Long id_usuario;
    private Long id_comentario;
    private boolean tipo;

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

    public Long getId_comentario() {
        return id_comentario;
    }

    public void setId_comentario(Long id_comentario) {
        this.id_comentario = id_comentario;
    }

    public boolean isTipo() {
        return tipo;
    }

    public void setTipo(boolean tipo) {
        this.tipo = tipo;
    }
    
}
