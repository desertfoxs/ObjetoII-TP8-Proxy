package model;

import java.util.Set;

public class Persona {
    private int id;
    private String nombre;
    private ProxySet telefonos; // este es el sujeto //ESTE CAMBIO ESTUVO BIEN?
    public Persona(int id, String nombre, ProxySet telefonos) {
        this.id = id;
        this.nombre = nombre;
        this.telefonos = telefonos;
    }
    public Telefono[] telefonos() {
        return (Telefono[]) telefonos.toArray(new Telefono[telefonos.size()]); //aca utilzia un metodo set ESTE CAMBIO ESTUVO BIEN?
    }
    public String nombre() {
        return nombre;
    }
}