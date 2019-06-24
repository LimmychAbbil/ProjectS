package net.lim.recipes.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class UnitOfMeasure {

    @Id
    private String uom;
}
