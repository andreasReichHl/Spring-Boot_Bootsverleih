package de.example.bootsverleih.controller;

import de.example.bootsverleih.entities.Boot;
import de.example.bootsverleih.service.Boatservices;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1/boats")
public class BoatController {

    Boatservices boatservices;

    public BoatController(Boatservices boatservices) {
        this.boatservices = boatservices;
    }

    @GetMapping
    public ArrayList<Boot> showAllBoats() {
        return boatservices.showAllBoats();
    }

    @GetMapping("/{id}")
    public Boot showOneBoat(@PathVariable long id) {
        return boatservices.showOneBoat(id);
    }

    @GetMapping("search")
    public List<Boot> searchBoat(@RequestParam String filter){
        return boatservices.searchBoat(filter);
    }

    @PostMapping
    public void addBoat(@RequestBody Boot boat) {
        boatservices.addBoat(boat);
    }

    @PutMapping
    public void updateBoat(@RequestParam("id") Long id, @RequestParam(defaultValue = "") String name,
                           @RequestParam(defaultValue = "") String category,
                           @RequestParam(defaultValue = "0") Integer capacity) {
        boatservices.updateBoat(id, name, category, capacity);
    }

    @DeleteMapping
    public void deleteBoat(@RequestParam(required = false) Long deleteId){
        if(deleteId != null) boatservices.deleteBoat(deleteId);
    }

}
