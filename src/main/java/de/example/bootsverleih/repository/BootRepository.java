package de.example.bootsverleih.repository;

import de.example.bootsverleih.entities.Boot;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class BootRepository {

    private ArrayList<Boot> bootDb;

    public BootRepository() {
        bootDb = new ArrayList<>();
    }

    // create
    public void addBoot(Boot boot) {
        this.bootDb.add(boot);
    }

    // read
    public ArrayList<Boot> showAllBoats() {
        return this.bootDb;
    }

    //
    public Boot showOneBoat(long id) {
        return bootDb.stream()
                .filter(boot -> Objects.equals(boot.getId(), id))
                .findFirst()
                .orElseThrow();
    }

    // update
    public void updateBoat(long id, String name, String category, int capacity) {
        bootDb.stream()
                .filter(boot -> Objects.equals(boot.getId(), id))
                .findFirst()
                .ifPresent(boot -> {
                    if (!Objects.equals(name, "")) boot.setName(name);
                    if (!Objects.equals(category, "")) boot.setCategory(category);
                    if (capacity != 0 && capacity < 25) boot.setCapacity(capacity);
                });
    }

    // delete
    public void deleteBoat(long id) {
        bootDb.removeIf(boot -> Objects.equals(boot.getId(), id));
    }

    public List<Boot> searchBoat(String search){
        return bootDb.stream()
                .filter(boot -> boot.getName().toLowerCase().contains(search.toLowerCase()))
                .toList();
    }
}
