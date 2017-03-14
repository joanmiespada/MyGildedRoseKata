package com.gildedrose;

class GildedRose {
    Item[] items;

    private static final String AgedBrie= "Aged Brie";
    private static final String Backstage= "Backstage passes to a TAFKAL80ETC concert";
    private static final String Sulfuras= "Sulfuras, Hand of Ragnaros";

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality()
    {
        //check all items
        for (Item item: this.items ) {

            ReduceQualityAndSellin(item);

        }
        
    }

    /*
    *  Comment: Reduce the quality of products and SellIn by one, the normal way
    * */
    private void ReduceQualityAndSellin(Item item)
    {
        item.sellIn--;
        item.quality--;
    }
    
    
    
    public void updateQuality2() {
        for (int i = 0; i < items.length; i++)
        { 
            if (!items[i].name.equals(AgedBrie) && !items[i].name.equals(Backstage)) {
                if (items[i].quality > 0) {
                    if (!items[i].name.equals(Sulfuras)) {
                        items[i].quality = items[i].quality - 1;
                    }
                }
            } else {
                if (items[i].quality < 50) {
                    items[i].quality = items[i].quality + 1;

                    if (items[i].name.equals(Backstage)) {
                        if (items[i].sellIn < 11) {
                            if (items[i].quality < 50) {
                                items[i].quality = items[i].quality + 1;
                            }
                        }

                        if (items[i].sellIn < 6) {
                            if (items[i].quality < 50) {
                                items[i].quality = items[i].quality + 1;
                            }
                        }
                    }
                }
            }

            if (!items[i].name.equals(Sulfuras)) {
                items[i].sellIn = items[i].sellIn - 1;
            }

            if (items[i].sellIn < 0) {
                if (!items[i].name.equals(AgedBrie)) {
                    if (!items[i].name.equals(Backstage)) {
                        if (items[i].quality > 0) {
                            if (!items[i].name.equals(Sulfuras)) {
                                items[i].quality = items[i].quality - 1;
                            }
                        }
                    } else {
                        items[i].quality = items[i].quality - items[i].quality;
                    }
                } else {
                    if (items[i].quality < 50) {
                        items[i].quality = items[i].quality + 1;
                    }
                }
            }
        }
    }
}