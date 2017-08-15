package com.mtrading.animal;

/**
 * Created by aleksandr.neguritsa on 8/3/2017.
 */
public class Application {

    public static void main(String[] args) throws Exception {
        Cupboard cupboard = new Cupboard(21);
        Wardrobe wardrobe = new Wardrobe(26);
        Room room = new Room(cupboard);
        Room2 room2 = new Room2(wardrobe);

        room.addCat(new Cat("Musja",15));
        room.addCat(new Cat("Barsik",5));
        room.addCat(new Cat("Vasja",20));

        room2.addCat(new Cat("Musja",15));
        room2.addCat(new Cat("Barsik",5));
        room2.addCat(new Cat("Vasja",20));

        room.switchHoover(true);
        room2.switchHoover(true);
    }
}
