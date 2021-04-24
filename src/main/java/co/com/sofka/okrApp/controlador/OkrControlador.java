package co.com.sofka.okrApp.controlador;

import co.com.sofka.okrApp.modelo.Okr;
import co.com.sofka.okrApp.modelo.OkrList;
import co.com.sofka.okrApp.servicio.OkrServicio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Map;

@RestController
public class OkrControlador {
    private Logger logger =
            LoggerFactory.getLogger(OkrControlador.class);

    @Autowired
    private OkrServicio okrServicio;

    @GetMapping(value = "okr/list")
    public List<Okr> getAllMovies() {
        logger.info("Getting all movies.");
        return okrServicio.finAll();
    }

    @GetMapping(value = "okr/{responsable}")
    public List<OkrList> getByResponsable(@PathVariable("responsable")String responsable) {
        logger.info("Getting by responsable.");
        return okrServicio.findByResponsable(responsable);
    }

    @GetMapping(value = "okr/listGroup")
    public Map<String, List<OkrList>> findOkrGroupByResponsable(){
        return okrServicio.findOkrGroupByResponsable();
    }
}
