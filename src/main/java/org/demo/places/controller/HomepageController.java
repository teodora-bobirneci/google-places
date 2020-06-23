package org.demo.places.controller;

import org.demo.places.model.City;
import org.demo.places.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping({"/", "/google-places"})
public class HomepageController {

    private LocationService locationService;

    @ModelAttribute("cities")
    public List<City> populateTypes() {
        return locationService.getCities();
    }

    @GetMapping
    public String homePage(Model model) {
        model.addAttribute("city", new City());
        return "home";
    }

    @PostMapping
    public String nearbyPlaces(Model model, @RequestParam Map<String, String> form) {
        City city = locationService.getCity(Long.valueOf(form.get("id")));
        model.addAttribute("city", city);
        model.addAttribute("places", locationService.getPlaces(city));
        return "places";
    }

    @Autowired
    public void setLocationService(LocationService locationService) {
        this.locationService = locationService;
    }

}