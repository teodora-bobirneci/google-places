package org.demo.places.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter @Setter
@Entity
@Table public
class PhotoReference {
    @Id @GeneratedValue() private Long id;
    @ManyToOne @JoinColumn(name = "place_details_id") private PlaceDetails placeDetails;
    @Column(length = 1024) private String attributions;
    @Column private Integer width;
    @Column private Integer height;
    @Column private String reference;
}
