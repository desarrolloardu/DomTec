package com.example.matiasdaniel.domtec;

/**
 * Created by MatiasDaniel on 8/4/2016.
 */

public class OnOff extends Objeto{

    private int posicion;

    public OnOff (int idImagen, String textoEncima, String textoDebajo, int posicion) {
        super(idImagen, textoEncima, textoDebajo);
        this.setTipo("OnOff");
        this.posicion = posicion;
    }

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

}
