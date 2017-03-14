package com.gildedrose;

import static org.junit.Assert.*;

import org.junit.Test;

public class GildedRoseTest {

    public static final int Days5 = 5;

    @Test
    public void NormalWay_DecreaseQuality_1day() {
        Item[] items = new Item[] { new Item("apple", 10, 8) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        //System.out.println(app.items[0]);
        assertEquals(7, app.items[0].quality);
        assertEquals(9, app.items[0].sellIn);
        for (int i = 0; i < Days5 ; i++) {
            app.updateQuality();
        }
        //System.out.println(app.items[0]);
        assertEquals(4, app.items[0].quality);
        assertEquals(2, app.items[0].sellIn);
    }

}
