package com.gildedrose;

public class ConjuredItem extends AffectedItem {

	public ConjuredItem(String name, int sellIn, int quality) {
		super(name, sellIn, quality);
	}
	@Override
	protected void updateQuality() {
		sellIn -= SELL_IN_BY_DATE;
    	if(sellIn < 0) {
    		quality = decreaseQualityBy(quality, 4);
    	} else {
    		quality = decreaseQualityBy(quality, 2);
    	}
	}

}
