package org.demo.places.model;

import com.google.common.base.Objects;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.LAZY;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "cities")
public class City {
    @Id @GeneratedValue() private Long id;
    @Column private String name;
    @Column private Double latitude;
    @Column private Double longitude;
    @OneToMany(cascade = ALL, orphanRemoval = true, fetch = LAZY) @JoinColumn(name = "city_id") private List<Place> places;

    public City(String name) {
        this.name = name;
    }

    public City(String name, Double latitude, Double longitude) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return Objects.equal(id, city.id) && Objects.equal(name, city.name);
    }

    @Override public int hashCode() {
        return Objects.hashCode(id, name);
    }
}
