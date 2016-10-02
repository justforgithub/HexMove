package sample.RectangleButtons;

import sample.MyValues;

/**
 * Created by Deviltech on 01.10.2016.
 */
public class CancelButton extends AButton {

    public CancelButton(RectangleMenu rectangleMenu) {
        super(rectangleMenu);
        this.name = MyValues.NAMES_BUTTON_CANCEL;
        this.texture =generatePattern("button_cancel.png");
    }

    @Override
    public void execute() {

    }
}
