package com.gildedrose;

public class ItemFactory {
	
	private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    private static final String AGED = "Aged Brie";
    private static final String BACKSTAGE = "Backstage passes to a TAFKAL80ETC concert";
    private static final String CONJURED = "Conjured Mana Cake";
	public static Item getItem(String name, int sellIn, int quality) {
		if(name.equalsIgnoreCase(AGED)) {
			return new AgedItem(name, sellIn, quality);
		} else if(name.equalsIgnoreCase(BACKSTAGE)) {
			return new BackstageItem(name, sellIn, quality);
		} else if( name.equalsIgnoreCase(SULFURAS)) {
			return new LegendaryItem(name, sellIn, quality);
		} else if( name.equalsIgnoreCase(CONJURED)) {
			return new ConjuredItem(name, sellIn, quality);
		} else {
			return new NormalItem(name, sellIn, quality);
		}
	}
}
