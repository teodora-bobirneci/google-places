package org.demo.places.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.LAZY;

@Getter
@Setter
@Entity
@Table(name = "place_details")
public class PlaceDetails {
    @Id @GeneratedValue private Long id;
    @Column private String name;
    @OneToOne @JoinColumn(name = "place_id") private Place place;
    @Column private String googleInternalId;
    @Column private String formattedAddress;
    @OneToMany(cascade = ALL, orphanRemoval = true, fetch = LAZY) @JoinColumn(name = "place_details_id") private List<PhotoReference> photoReferences;
    @Column private String reference;
    @Column(length = 1024) private String url;
    @Column private String vicinity;
    @Column private String website;
    @Column private boolean userUpdated;
}
