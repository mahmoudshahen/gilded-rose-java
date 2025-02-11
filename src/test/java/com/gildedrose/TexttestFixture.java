package com.gildedrose;

public class TexttestFixture {
    public static void main(String[] args) {
        System.out.println("OMGHAI!");

        Item[] items = new Item[] {
        		ItemFactory.getItem("+5 Dexterity Vest", 10, 20), //
        		ItemFactory.getItem("Aged Brie", 2, 0), //
        		ItemFactory.getItem("Elixir of the Mongoose", 5, 7), //
        		ItemFactory.getItem("Sulfuras, Hand of Ragnaros", 0, 80), //
        		ItemFactory.getItem("Sulfuras, Hand of Ragnaros", -1, 80),
        		ItemFactory.getItem("Backstage passes to a TAFKAL80ETC concert", 15, 20),
        		ItemFactory.getItem("Backstage passes to a TAFKAL80ETC concert", 10, 49),
        		ItemFactory.getItem("Backstage passes to a TAFKAL80ETC concert", 5, 49),
                // this conjured item does not work properly yet
        		ItemFactory.getItem("Conjured Mana Cake", 3, 6) };

        GildedRose app = new GildedRose(items);

        int days = 2;
        if (args.length > 0) {
            days = Integer.parseInt(args[0]) + 1;
        }

        for (int i = 0; i < days; i++) {
            System.out.println("-------- day " + i + " --------");
            System.out.println("name, sellIn, quality");
            for (Item item : items) {
                System.out.println(item);
            }
            System.out.println();
            app.updateQuality();
        }
    }

}
