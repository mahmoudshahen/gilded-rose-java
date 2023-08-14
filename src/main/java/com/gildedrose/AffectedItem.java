package com.gildedrose;

public abstract class AffectedItem extends Item {

	private final int MAX_QUALITY = 50;
    private final int MIN_QUALITY = 0;
    protected final int SELL_IN_BY_DATE = 1;
	public AffectedItem(String name, int sellIn, int quality) {
		super(name, sellIn, quality);
	}
    protected abstract void updateQuality();
    
    protected int increaseQualityBy(int quality, int value) {
    	return Math.min(quality + value, MAX_QUALITY);
    }
    protected int decreaseQualityBy(int quality, int value) {
    	return Math.max(quality - value, MIN_QUALITY);
    }
	@Override
	public void dayPass() {
		updateQuality();
	}
}
