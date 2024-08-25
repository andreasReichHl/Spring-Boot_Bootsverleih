package de.example.bootsverleih.entities;

import java.util.Objects;

public class Boot {
    private static long idCounter;
    private long id;
    private String name;
    private String category;
    private int capacity;

    public Boot(String name, String category, int capacity) {
        this.id = idCounter++;
        this.name = name;
        this.category = category;
        this.capacity = capacity;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Boot boot = (Boot) o;
        return getId() == boot.getId() && getCapacity() == boot.getCapacity() && Objects.equals(getName(), boot.getName()) && Objects.equals(getCategory(), boot.getCategory());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getCategory(), getCapacity());
    }

    @Override
    public String toString() {
        return "Boot{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", capacity=" + capacity +
                '}';
    }
}
