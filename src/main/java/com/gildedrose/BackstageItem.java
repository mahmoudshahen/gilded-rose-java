package com.gildedrose;

public class BackstageItem extends AffectedItem {

	public BackstageItem(String name, int sellIn, int quality) {
		super(name, sellIn, quality);
	}

	@Override
	protected void updateQuality() {
		if(sellIn < 6) {
    		quality = increaseQualityBy(quality, 3);
    	} else if(sellIn < 11) {
    		quality = increaseQualityBy(quality, 2);
    	} else {
    		quality = increaseQualityBy(quality, 1);
    	}
    	sellIn -= SELL_IN_BY_DATE;
    	if(sellIn < 0) {
    		quality = 0;
    	}
	}
}
