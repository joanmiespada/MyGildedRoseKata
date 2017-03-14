package com.gildedrose;

public class Item {

    public String name;

    public int sellIn;

    public int quality;

    private static final int UNIT  = 1;
    private static final int TWICE = 2;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

   @Override
   public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }

    public void ReduceQualityAndSellin()
    {
        ReduceQuality( ChooseFactor() );
        ReduceSellIn();
    }

    protected void ReduceSellIn()
    {
        this.sellIn--;
    }

    protected void ReduceQuality(int factor)
    {
        if(this.quality >0)
            this.quality+= factor;
    }

    protected int ChooseFactor()
    {
        if( this.sellIn>0)
            return -UNIT;
        else
            return -TWICE;
    }

}
