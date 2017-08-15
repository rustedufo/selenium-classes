package com.mtrading.animal;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by aleksandr.neguritsa on 8/3/2017.
 */
public class Room2 {
    private List<Cat> catSet = new ArrayList<>();
    private Wardrobe wardrobe;

    public Room2(Wardrobe wardrobe) {
        this.wardrobe = wardrobe;
    }
    public void addCat(Cat cat) {
        this.catSet.add(cat);
    }
    public void switchHoover(Boolean enabled) throws Exception {
        if (enabled) {
            for (Cat cat : this.catSet) {
                this.hideCat(cat, this.wardrobe);
            }
        }
    }

    private void hideCat(Cat cat, Wardrobe wardrobe) throws Exception {
        Thread.sleep(1000);
        if (cat.getAssSize() < wardrobe.getClearance()) {
            System.out.println(
                    String.format(
                            "%s может спрятатьчется под шкафом",
                            cat.getName()
                    )
            );
        } else {
            throw new Exception(
                    String.format(
                            "%s слишком жирный '%s' для этого шкафа '%s'",
                            cat.getName(),
                            cat.getAssSize(),
                            wardrobe.getClearance()
                    )
            );
        }
    }
}
