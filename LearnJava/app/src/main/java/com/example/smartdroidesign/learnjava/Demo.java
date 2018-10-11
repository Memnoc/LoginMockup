package com.example.smartdroidesign.learnjava;


public class Demo {

    public static void main(String[] args) {

//        VampireKing dracula = new VampireKing("Dracula");
//        dracula.showInfo();
//        dracula.setLives(0);
//
//        do {
//            if (dracula.dodges()) {
//                dracula.setLives(dracula.getLives() + 1);
//                continue;
//            }
//            if (dracula.runAway()) {
//                System.out.println("Dracula run away!");
//                break;
//            } else {
//                dracula.takeDamage(80);
//                dracula.showInfo();
//            }
//        } while (dracula.getLives() > 0);
//        System.out.println("========================================================");


        Player conan = new Player("Conan");
        conan.pickUpLoot(new Loot("Invisibility", LootType.POTION, 4));
        conan.pickUpLoot(new Loot("Mithril", LootType.ARMOR, 183));
        conan.pickUpLoot(new Loot("Ring of Speed", LootType.RING, 25));
        conan.pickUpLoot(new Loot("Red Potion", LootType.RING, 2));
        conan.pickUpLoot(new Loot("Cursed Shield", LootType.ARMOR, -8));
        conan.pickUpLoot(new Loot("Brass Ring", LootType.RING, 1));
        conan.pickUpLoot(new Loot("Chain Mail", LootType.ARMOR, 4));
        conan.pickUpLoot(new Loot("Gold Ring", LootType.RING, 12));
        conan.pickUpLoot(new Loot("Health Potion", LootType.POTION, 3));
        conan.pickUpLoot(new Loot("Silver Ring", LootType.RING, 6));
        conan.showInventory();

        System.out.println(conan.score());
        conan.dropLoot("Cursed Shield");
        conan.dropLoot("Gold Ring");
        conan.dropLoot("Ring of Speed");
        System.out.println(conan.score());

    }
}
