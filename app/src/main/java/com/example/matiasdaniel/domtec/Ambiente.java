package com.example.matiasdaniel.domtec;

/**
 * Created by MatiasDaniel on 8/4/2016.
 */
public class Ambiente {
    private int idImagen;
    private String textoEncima;
    private String textoDebajo;
    private String nombre;
    private String ip; //ip del arduino que esta en el ambiente.

    public Ambiente (int idImagen, String textoEncima, String textoDebajo, String nombre, String ip) {
        this.idImagen = idImagen;
        this.textoEncima = textoEncima;
        this.textoDebajo = textoDebajo;
        this.nombre = nombre;
        this.ip = ip;
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
}
