package org.demo.places.dao;

import org.demo.places.model.City;
import org.demo.places.model.Place;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface PlaceRepository extends CrudRepository<Place, Long> {
    @Query("SELECT p FROM Place p WHERE p.city = ?1")
    Collection<Place> findPlacesIn(City city);
}
