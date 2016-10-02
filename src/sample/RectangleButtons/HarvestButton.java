package sample.RectangleButtons;

import sample.MyValues;

/**
 * Created by Deviltech on 01.10.2016.
 */
public class HarvestButton extends AButton {

    public HarvestButton(RectangleMenu rectangleMenu) {
        super(rectangleMenu);
        this.name = MyValues.NAMES_BUTTON_HARVEST;
        this.texture =generatePattern("button_harvest.png");
    }

    @Override
    public void execute() {

    }
}
