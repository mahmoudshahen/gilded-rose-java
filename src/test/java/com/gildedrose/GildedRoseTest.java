package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

	private final String sulfuras = "Sulfuras, Hand of Ragnaros";
	private final String aged = "Aged Brie";
	private final String backstage = "Backstage passes to a TAFKAL80ETC concert";
	private final String elixir = "Elixir of the Mongoose";

	@Test
    void testGlideRoseIfNameIsNotAgedOrBackstageOrSulfurasAndSellInMoreThanZero() {
    	Item[] items = new Item[] { new Item(elixir, 5, 40) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(39, app.items[0].quality);
        assertEquals(elixir, app.items[0].name);
        assertEquals(4, app.items[0].sellIn);
    }
	@Test
    void testGlideRoseIfNameIsNotAgedOrBackstageOrSulfurasAndSellInLessThanOne() {
    	Item[] items = new Item[] { new Item(elixir, 0, 40) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(38, app.items[0].quality);
        assertEquals(elixir, app.items[0].name);
        assertEquals(-1, app.items[0].sellIn);
    }
    @Test
    void testGlideRoseIfNameIsSulfuras() {
    	Item[] items = new Item[] { new Item(sulfuras, 5, 30) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(30, app.items[0].quality);
        assertEquals(sulfuras, app.items[0].name);
        assertEquals(5, app.items[0].sellIn);
    }
    @Test
    void testGlideRoseIfNameIsAgedAndQualityLessThan50AndSellInMoreThanZero() {
    	Item[] items = new Item[] { new Item(aged, 1, 30) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(31, app.items[0].quality);
        assertEquals(aged, app.items[0].name);
        assertEquals(0, app.items[0].sellIn);
    }
    @Test
    void testGlideRoseIfNameIsAgedAndQualityLessThan50AndSellInLessThanOne() {
    	Item[] items = new Item[] { new Item(aged, 0, 45) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(47, app.items[0].quality);
        assertEquals(aged, app.items[0].name);
        assertEquals(-1, app.items[0].sellIn);
    }
    // test the quantity is never more than 50
    @Test
    void testGlideRoseIfNameIsAgedAndQualityIs49AndSellInLessThanOne() {
    	Item[] items = new Item[] { new Item(aged, 0, 49) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
        assertEquals(aged, app.items[0].name);
        assertEquals(-1, app.items[0].sellIn);
    }
    @Test
    void testGlideRoseIfNameIsAgedAndQualityEquals50AndSellInMoreThanZero() {
    	Item[] items = new Item[] { new Item(aged, 1, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
        assertEquals(aged, app.items[0].name);
        assertEquals(0, app.items[0].sellIn);
    }
    @Test
    void testGlideRoseIfNameIsAgedAndQualityEquals50AndSellInLessThanOne() {
    	Item[] items = new Item[] { new Item(aged, 0, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
        assertEquals(aged, app.items[0].name);
        assertEquals(-1, app.items[0].sellIn);
    }

    @Test
    void testGlideRoseIfNameIsBackstageAndSellInMoreThan5AndLessThan11AndQualityLessThan50() {
    	Item[] items = new Item[] { new Item(backstage, 6, 30) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(32, app.items[0].quality);
        assertEquals(backstage, app.items[0].name);
        assertEquals(5, app.items[0].sellIn);
    }
    @Test
    void testGlideRoseIfNameIsBackstageAndSellInMoreThan0AndLessThan6AndQualityLessThan50() {
    	Item[] items = new Item[] { new Item(backstage, 4, 30) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(33, app.items[0].quality);
        assertEquals(backstage, app.items[0].name);
        assertEquals(3, app.items[0].sellIn);
    }
    @Test
    void testGlideRoseIfNameIsBackstageAndSellInLessThan1AndQualityLessThan50() {
    	Item[] items = new Item[] { new Item(backstage, 0, 30) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
        assertEquals(backstage, app.items[0].name);
        assertEquals(-1, app.items[0].sellIn);
    }    
}
