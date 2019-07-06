package net.lim.recipes.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CategoryTest {

    Category category;

    @Before
    public void setUp() {
        category = new Category();
    }

    @Test
    public void getId() {
        Long expectedId = 1L;
        category.setId(expectedId);

        Assert.assertEquals(expectedId, category.getId());
    }
}