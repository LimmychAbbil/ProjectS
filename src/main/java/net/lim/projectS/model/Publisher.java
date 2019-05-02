package net.lim.projectS.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Publisher {

    @Id
    private String name;

    private String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Publisher() {
    }

    public Publisher(String name, String address) {
        this.name = name;
        this.address = address;
    }
}
