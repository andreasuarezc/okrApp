package co.com.sofka.okrApp.modelo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.ArrayList;
import java.util.Date;

@Data
@Document
public class Okr {
    @Id
    private String id;
    private String nombre;
    private String objetivo;
    private String responsable;
    private ArrayList<Kr> resultadosClave;
    private Date fechaInicio;
    private Date fechaFinalizacion;
    private float avancePorcentual;

    public Okr(String id, String nombre, String objetivo, String responsable, ArrayList<Kr> resultadosClave, Date fechaInicio, Date fechaFinalizacion, float avancePorcentual) {
        this.id = id;
        this.nombre = nombre;
        this.objetivo = objetivo;
        this.responsable = responsable;
        this.resultadosClave = resultadosClave;
        this.fechaInicio = fechaInicio;
        this.fechaFinalizacion = fechaFinalizacion;
        this.avancePorcentual = avancePorcentual;
    }
}
