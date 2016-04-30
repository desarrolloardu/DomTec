package com.example.matiasdaniel.domtec;

/**
 * Created by MatiasDaniel on 8/4/2016.
 */
public class Tv extends Objeto{

    private int posicion;

    public Tv (int idImagen, String textoEncima, String textoDebajo, int posicion) {
        super(idImagen, textoEncima, textoDebajo);
        this.setTipo("Tv");
        this.posicion = posicion;
    }

    public int getPosicion() {
        return posicion;
    }

}
