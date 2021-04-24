package co.com.sofka.okrApp.modelo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document
public class HistoricoAvance {
    @Id
    private Long id;
    private Date fechaActualizacion;
    private float avance;

    public HistoricoAvance(Long id, float avance) {
        this.id = id;
        this.fechaActualizacion =  new Date();
        this.avance = avance;
    }
}
