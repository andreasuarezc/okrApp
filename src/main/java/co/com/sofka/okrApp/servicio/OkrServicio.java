package co.com.sofka.okrApp.servicio;

import co.com.sofka.okrApp.helpers.Assembler;
import co.com.sofka.okrApp.modelo.Okr;
import co.com.sofka.okrApp.modelo.OkrList;
import co.com.sofka.okrApp.repositorio.OkrRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.group;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.newAggregation;

@Service
public class OkrServicio {
    public static final String NO_FAULT_ID = "No existe el id de la lista";
    @Autowired
    private OkrRepository okrRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    public List<Okr> finAll() {
        return okrRepository.findAll();

    }

    public List<OkrList> findByResponsable(String responsable) {
        Query query = new Query();
        query.addCriteria(Criteria.where("responsable").is(responsable));
        List<Okr> okrs = mongoTemplate.find(query, Okr.class);
        return Assembler.okrListGenerator(okrs);
    }

    public Map<String, List<OkrList>> findOkrGroupByResponsable(){
        //return okrRepository.groupByResponsable();
        /*GroupOperation groupByResponsable = group("nombre");
        Aggregation aggregation = newAggregation(
                groupByResponsable);
        AggregationResults<Okr> result = mongoTemplate.aggregate(
                aggregation, "okr", Okr.class);

        return result;

         */
        List<String> responsables = new ArrayList<>();
        okrRepository.findAll().forEach(okr -> responsables.add(okr.getResponsable()));
        List<String> responsablesU =responsables.stream().distinct().collect(Collectors.toList());
        Map<String, List<OkrList>> okrsByResponsable = new HashMap<>();
        responsablesU.forEach(responsable -> okrsByResponsable.put(responsable, findByResponsable(responsable)));
        return okrsByResponsable;
    }

}
