package org.demo.places.model;

import com.google.common.base.Objects;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@ToString
@Entity
@Table(name = "places")
public class Place {
    @Id @GeneratedValue private Long id;
    @Column private String name;
    @ManyToOne @JoinColumn(name = "city_id") private City city;

    public Place(String name, City city) {
        this.name = name;
        this.city = city;
    }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Place place = (Place) o;
        return Objects.equal(id, place.id) && Objects.equal(name, place.name) && Objects.equal(city, place.city);
    }

    @Override public int hashCode() {
        return Objects.hashCode(id, name, city);
    }
}
