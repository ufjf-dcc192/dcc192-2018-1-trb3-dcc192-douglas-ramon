package br.ufjf.dcc192;


public class Link {
    private Long id_link;
    private Long id_item;
    private String nome;

    public Long getId_link() {
        return id_link;
    }

    public void setId_link(Long id_link) {
        this.id_link = id_link;
    }

    public Long getId_item() {
        return id_item;
    }

    public void setId_item(Long id_item) {
        this.id_item = id_item;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
}
