package de.example.bootsverleih.service;

import de.example.bootsverleih.entities.Boot;
import de.example.bootsverleih.repository.BootRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Boatservices {

    BootRepository bootRepository;

    public Boatservices(BootRepository bootRepository) {
        this.bootRepository = bootRepository;
    }

    public void addBoat(Boot boot){
        bootRepository.addBoot(boot);
    }

    public ArrayList<Boot> showAllBoats(){
        return bootRepository.showAllBoats();
    }

    public Boot showOneBoat(long id){
        return bootRepository.showOneBoat(id);
    }

    public void updateBoat(long id, String name, String category, int capacity){
        bootRepository.updateBoat(id, name, category, capacity);
    }

    public void deleteBoat(long id){
        bootRepository.deleteBoat(id);
    }

    public List<Boot> searchBoat(String search){
        return bootRepository.searchBoat(search);
    }
}
