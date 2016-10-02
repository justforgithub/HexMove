package sample.RectangleButtons;

import sample.MyValues;

/**
 * Created by Deviltech on 02.10.2016.
 */
public class ReloadButton extends AButton {

    public ReloadButton(RectangleMenu rectangleMenu) {
        super(rectangleMenu);
        this.name = MyValues.NAMES_BUTTON_RELOAD;
        this.texture =generatePattern("button_reload.png");
    }

    @Override
    public void execute() {

    }
}
