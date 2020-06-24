package org.demo.places.model;

import com.google.common.base.Objects;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.LAZY;

@NoArgsConstructor
@Getter
@ToString
@Entity
@Table(name = "places")
public class Place {
    @Id @GeneratedValue private Long id;
    @Column(name = "google_place_id") private String googlePlaceId;
    @Column private String name;
    @Column private String icon;
    @ManyToOne @JoinColumn(name = "city_id") private City city;
    @OneToOne(mappedBy = "place", cascade = ALL, fetch = LAZY) private PlaceDetails placeDetails;

    public Place(String name, City city) {
        this.name = name;
        this.city = city;
    }

    public Place(String googlePlaceId, String name, String icon, City city) {
        this(name, city);
        this.googlePlaceId = googlePlaceId;
        this.icon = icon;
    }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Place place = (Place) o;
        return Objects.equal(id, place.id);
    }

    @Override public int hashCode() {
        return Objects.hashCode(id, name, city);
    }
}
