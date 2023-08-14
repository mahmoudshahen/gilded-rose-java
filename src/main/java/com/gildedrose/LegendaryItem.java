package com.gildedrose;

public class LegendaryItem extends Item {

	public LegendaryItem(String name, int sellIn, int quality) {
		super(name, sellIn, quality);
	}

	@Override
	public void dayPass() {
		// nothing to do with sellIn and quality
	}
}
