/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufjf.dcc192;

import java.util.Date;

/**
 *
 * @author douglas
 */
public class Comentario {

    private long id_comentario;
    private long id_usuario;
    private String texto;
    private Date data_insert;
    private Date data_update;

    public Comentario() {
        data_insert = new Date();
    }

    public long getId_comentario() {
        return id_comentario;
    }

    public void setId_comentario(long id_comentario) {
        this.id_comentario = id_comentario;
    }

    public long getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(long id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Date getData_insert() {
        return data_insert;
    }

    public void setData_insert(Date data_insert) {
        this.data_insert = data_insert;
    }

    public Date getData_update() {
        return data_update;
    }

    public void setData_update(Date data_update) {
        this.data_update = data_update;
    }

}
