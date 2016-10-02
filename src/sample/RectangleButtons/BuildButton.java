package sample.RectangleButtons;

import sample.MyValues;

/**
 * Created by Deviltech on 02.10.2016.
 */
public class BuildButton extends AButton {

    public BuildButton(HexagonMenu hexagonMenu) {
        super(hexagonMenu);
        this.name = MyValues.NAMES_BUTTON_BUILD;
        this.texture =generatePattern("button_build.png");
    }

    @Override
    public void execute() {

    }
}
