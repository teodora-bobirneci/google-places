package org.demo.places.controller;

import org.demo.places.model.PlaceDetails;
import org.demo.places.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"/places"})
public class PlacesController {

    private LocationService locationService;

    @GetMapping("/{id}/details")
    public String showDetails(@PathVariable(name = "id") Long id, Model model) {
        PlaceDetails placeDetails = locationService.getPlaceDetails(id);
        model.addAttribute("details", placeDetails);
        return "place_details";
    }

    @Autowired public void setLocationService(LocationService locationService) {
        this.locationService = locationService;
    }
}
