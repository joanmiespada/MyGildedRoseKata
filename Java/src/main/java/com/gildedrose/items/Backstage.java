package com.gildedrose.items;

import com.gildedrose.Item;

/**
 * Created by joanmi on 14/3/17.
 */
public class Backstage extends Item {

    public static final int THIRD=3;

    public Backstage(String name, int sellIn, int quality)
    {
        super(name, sellIn, quality);
    }

    protected int ChooseFactor()
    {

        if( this.sellIn>10)
            return UNIT;
        else if( this.sellIn<=10 && this.sellIn>5)
            return TWICE;
        else
            return THIRD;
    }

    protected void ReduceQuality(int factor)
    {
        if(this.sellIn > 0)
            ProtectOverFifty(factor);
        else
            this.quality=0;
    }

}
