package com.gildedrose.items;

import com.gildedrose.Item;

/**
 * Created by joanmi on 14/3/17.
 */
public class Sulfuras extends Item {

    public Sulfuras(String name, int sellIn, int quality)
    {
        super(name, sellIn, quality);
    }

    public void ReduceQualityAndSellin()
    {
        ReduceSellIn();
    }

}
