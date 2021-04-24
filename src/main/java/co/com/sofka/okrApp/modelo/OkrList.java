package co.com.sofka.okrApp.modelo;

import lombok.Data;

@Data
public class OkrList {
    private String id;
    private String nombre;
    private float avancePorcentual;

    public OkrList(String id, String nombre, float avancePorcentual) {
        this.id = id;
        this.nombre = nombre;
        this.avancePorcentual = avancePorcentual;
    }
}
