package co.com.sofka.okrApp.modelo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.ArrayList;
import java.util.Date;

@Data
@Document
public class Kr {
    @Id
    private Long id;
    private String descripcion;
    private String responsable;
    private float ponderacion;
    private ArrayList<HistoricoAvance> historicoAvance;
    private Date fechaFinalizacion;
    private float avance;
}
