package com.example.matiasdaniel.domtec;

/**
 * Created by MatiasDaniel on 8/4/2016.
 */
public class Objeto {

    private int idImagen;
    private String textoEncima;
    private String textoDebajo;
    private String tipo;

    public Objeto (int idImagen, String textoEncima, String textoDebajo) {
        this.idImagen = idImagen;
        this.textoEncima = textoEncima;
        this.textoDebajo = textoDebajo;
        this.tipo = "Objeto";
    }

    public String get_textoEncima() {
        return textoEncima;
    }

    public String get_textoDebajo() {
        return textoDebajo;
    }

    public int get_idImagen() {
        return idImagen;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
