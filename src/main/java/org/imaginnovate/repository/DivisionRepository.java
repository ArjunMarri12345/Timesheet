package org.imaginnovate.repository;

import org.imaginnovate.model.Division;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class DivisionRepository implements PanacheRepository<Division> {

    public Division findById(int id) {
        return find("id", id).firstResult();
    }

    public int deleteById(int id) {
        return (int) delete("id", id);

    }

}
