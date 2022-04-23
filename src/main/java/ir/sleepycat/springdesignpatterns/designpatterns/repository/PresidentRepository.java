package ir.sleepycat.springdesignpatterns.designpatterns.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PresidentRepository extends CrudRepository<PresidentEntity, Long> {
    PresidentRepository findPresidentEntityByEmailAddress(String emailAddress);
}
