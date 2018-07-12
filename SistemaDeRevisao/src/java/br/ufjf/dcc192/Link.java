package br.ufjf.dcc192;


public class Link {
    private long id_link;
    private long id_item;
    private String nome;

    public long getId_link() {
        return id_link;
    }

    public void setId_link(long id_link) {
        this.id_link = id_link;
    }

    public long getId_item() {
        return id_item;
    }

    public void setId_item(long id_item) {
        this.id_item = id_item;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
}
