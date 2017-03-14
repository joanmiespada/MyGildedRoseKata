package com.gildedrose;

import static org.junit.Assert.*;

import org.junit.Test;

public class GildedRoseTest {

    public static final int Days10 = 10;
    public static final int Days5 = 5;
    public static final int Days2 = 2;

    @Test
    public void NormalWay_DecreaseQuality_Bydays() {
        Item[] items = new Item[] { new Item("apple", 10, 8) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(7, app.items[0].quality);
        assertEquals(9, app.items[0].sellIn);
        for (int i = 0; i < Days5 ; i++)  app.updateQuality();
        assertEquals(2, app.items[0].quality);
        assertEquals(4, app.items[0].sellIn);
        for (int i = 0; i < Days2 ; i++)  app.updateQuality();
        assertEquals(0, app.items[0].quality);
        assertEquals(2, app.items[0].sellIn);
    }

    @Test
    public void DegradeProductsWay_twice() {
        Item[] items = new Item[] { new Item("apple", 10, 20) };
        GildedRose app = new GildedRose(items);
        for (int i = 0; i < Days10 ; i++)  app.updateQuality();
        assertEquals(10, app.items[0].quality);
        assertEquals(0, app.items[0].sellIn);
        for (int i = 0; i < Days2 ; i++)  app.updateQuality();
        assertEquals(6, app.items[0].quality);
        assertEquals(-2, app.items[0].sellIn);
        for (int i = 0; i < Days2 ; i++)  app.updateQuality();
        assertEquals(2, app.items[0].quality);
        assertEquals(-4, app.items[0].sellIn);
    }

    @Test
    public void QualityIsNeverNegative() {
        Item[] items = new Item[] { new Item("apple", 5, 2) };
        GildedRose app = new GildedRose(items);
        for (int i = 0; i < Days10 ; i++)  app.updateQuality();
        assertEquals(0, app.items[0].quality);
        assertEquals(-5, app.items[0].sellIn);
    }

    @Test
    public void AgedBrieQualityIncreases() {
        Item[] items = new Item[] { new Item("Aged Brie", 10, 2) };
        GildedRose app = new GildedRose(items);
        for (int i = 0; i < Days10 ; i++)  app.updateQuality();
        assertEquals(12, app.items[0].quality);
        assertEquals(0, app.items[0].sellIn);
    }

    @Test
    public void AgedBrieQualityIncreasesTOP50() {
        Item[] items = new Item[] { new Item("Aged Brie", 10, 46) };
        GildedRose app = new GildedRose(items);
        for (int i = 0; i < Days10 ; i++)  app.updateQuality();
        assertEquals(50, app.items[0].quality);
    }

    @Test
    public void SulfurasNoDecrease() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 1000, 500) };
        GildedRose app = new GildedRose(items);
        for (int i = 0; i < Days10 ; i++)  app.updateQuality();
        assertEquals(500, app.items[0].quality);
    }

    @Test
    public void BackstagePasses() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 20, 5) };
        GildedRose app = new GildedRose(items);
        for (int i = 0; i < Days2 ; i++)  app.updateQuality();
        assertEquals(7, app.items[0].quality);
        assertEquals(18, app.items[0].sellIn);
        for (int i = 0; i < Days10 ; i++)  app.updateQuality();
        assertEquals(19, app.items[0].quality);
        assertEquals(8, app.items[0].sellIn);
        for (int i = 0; i < Days5 ; i++)  app.updateQuality();
        assertEquals(31, app.items[0].quality);
        assertEquals(3, app.items[0].sellIn);
        for (int i = 0; i < Days5 ; i++)  app.updateQuality();
        assertEquals(0, app.items[0].quality);
        assertEquals(-2, app.items[0].sellIn);
    }

}
