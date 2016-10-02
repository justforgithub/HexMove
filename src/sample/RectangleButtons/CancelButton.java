package sample.RectangleButtons;

import sample.MyValues;

/**
 * Created by Deviltech on 01.10.2016.
 */
public class CancelButton extends AButton {

    public CancelButton(HexagonMenu hexagonMenu) {
        super(hexagonMenu);
        this.name = MyValues.NAMES_BUTTON_CANCEL;
        this.texture =generatePattern("button_cancel.png");
    }

    @Override
    public void execute() {

    }
}
