package co.com.sofka.okrApp.repositorio;

import co.com.sofka.okrApp.modelo.Okr;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.Meta;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OkrRepository extends MongoRepository<Okr, Long> {
    @Meta(allowDiskUse = true)
    @Aggregation("{ $group: { _id : $responsable} }")
    List<Okr> groupByResponsable();
}
