package com.gildedrose;

public class AgedItem extends AffectedItem {

	public AgedItem(String name, int sellIn, int quality) {
		super(name, sellIn, quality);
	}
	@Override
	protected void updateQuality() {
		sellIn -= SELL_IN_BY_DATE;
    	if(sellIn < 0) {
    		quality = increaseQualityBy(quality, 2);
    	} else {
    		quality = increaseQualityBy(quality, 1);
    	}
	}
}
