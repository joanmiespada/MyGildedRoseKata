package com.gildedrose;

public class Item {

    public String name;

    public int sellIn;

    public int quality;

    public static final int UNIT  = 1;
    public static final int TWICE = 2;
    public static final int TOPQUALITY = 50;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

   @Override
   public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }

    public void ReduceQualityAndSellin() throws FactorWrongException
    {
        ChangeQuality( ChooseFactor() );
        ReduceSellIn();
    }

    protected void ReduceSellIn()
    {
        this.sellIn--;
    }

    protected void ChangeQuality(int factor) throws FactorWrongException
    {
        if(factor <0) { //we must protect under zero
            ProtectBelowZero(factor);
        }else { //we must protect over 50
            ProtectOverFifty(factor);
        }
    }

    protected void ProtectBelowZero(int factor) throws  FactorWrongException
    {
        //here the factor should be always negative
        if(factor>0) throw new FactorWrongException();

        if (this.quality > 0)
            this.quality += factor;
    }

    protected void ProtectOverFifty(int factor)
    {

        if (this.quality < TOPQUALITY )
            this.quality += factor ;
        else
            this.quality = TOPQUALITY ;
    }

    protected int ChooseFactor()
    {
        if( this.sellIn>0)
            return -UNIT;
        else
            return -TWICE;
    }

}
