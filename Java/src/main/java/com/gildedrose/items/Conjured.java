package com.gildedrose.items;

import com.gildedrose.Item;

/**
 * Created by joanmi on 14/3/17.
 */
public class Conjured extends Item {

    public Conjured(String name, int sellIn, int quality)
    {
        super(name, sellIn, quality);
    }

    protected int ChooseFactor()
    {
        return -TWICE;
    }
}
