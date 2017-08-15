package com.mtrading.animal;

/**
 * Created by aleksandr.neguritsa on 8/3/2017.
 */
public class Application {

    public static void main(String[] args) throws Exception {
        Cupboard cupboard = new Cupboard(21);
        Room room = new Room(cupboard);

        room.addCat(new Cat("Musja",15));
        room.addCat(new Cat("Barsik",5));
        room.addCat(new Cat("Vasja",20));

        room.switchHoover(true);

    }
}
