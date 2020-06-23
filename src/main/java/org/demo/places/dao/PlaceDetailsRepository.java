package org.demo.places.dao;

import org.demo.places.model.Place;
import org.demo.places.model.PlaceDetails;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlaceDetailsRepository extends CrudRepository<PlaceDetails, Long> {
    @Query("SELECT pd FROM PlaceDetails pd WHERE pd.place = ?1")
    Optional<PlaceDetails> findDetailsFor(Place place);
}
