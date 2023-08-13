package com.gildedrose;

class GildedRose {
    Item[] items;
    private final int MAX_QUALITY = 50;
    private final int MIN_QUALITY = 0;
    private final int SELL_IN_BY_DATE = 1;
    private final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    private final String AGED = "Aged Brie";
    private final String BACKSTAGE = "Backstage passes to a TAFKAL80ETC concert";
    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
        	if(items[i].name.equals(AGED)) {
        		updateAgedQuality(items[i]);
        	} else if(items[i].name.equals(BACKSTAGE)) {
        		updateBackstageQuality(items[i]);
        	} else if(items[i].name.equals(SULFURAS)){
        		// Do nothing as "Sulfuras", being a legendary item and no changes required
        	} else {
        		updateNormalItem(items[i]);
        	}
        }
    }
    
    private void updateAgedQuality(Item item) {
    	item.sellIn -= SELL_IN_BY_DATE;
    	if(item.sellIn < 0) {
    		item.quality = increaseQualityBy(item.quality, 2);
    	} else {
    		item.quality = increaseQualityBy(item.quality, 1);
    	}
    }
    private void updateBackstageQuality(Item item) {
    	if(item.sellIn < 6) {
    		item.quality = increaseQualityBy(item.quality, 3);
    	} else if(item.sellIn < 11) {
    		item.quality = increaseQualityBy(item.quality, 2);
    	} else {
    		item.quality = increaseQualityBy(item.quality, 1);
    	}
    	item.sellIn -= SELL_IN_BY_DATE;
    	if(item.sellIn < 0) {
    		item.quality = 0;
    	}
    }
    private void updateNormalItem(Item item) {
    	item.sellIn -= SELL_IN_BY_DATE;
    	if(item.sellIn < 0) {
    		item.quality = decreaseQualityBy(item.quality, 2);
    	} else {
    		item.quality = decreaseQualityBy(item.quality, 1);
    	}
    }
    private int increaseQualityBy(int quality, int value) {
    	return Math.min(quality + value, MAX_QUALITY);
    }
    private int decreaseQualityBy(int quality, int value) {
    	return Math.max(quality - value, MIN_QUALITY);
    }
    
}