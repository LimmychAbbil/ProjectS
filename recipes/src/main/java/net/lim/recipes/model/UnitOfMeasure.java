package net.lim.recipes.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UnitOfMeasure {

    @Id
    private String uom;

    public UnitOfMeasure(String uom) {
        this.uom = uom;
    }

    public String getUom() {
        return uom;
    }

    public void setUom(String uom) {
        this.uom = uom;
    }
}
