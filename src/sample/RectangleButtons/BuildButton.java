package sample.RectangleButtons;

import sample.HexCell;
import sample.MyValues;
import sample.Unit.AUnit;

/**
 * Created by Deviltech on 02.10.2016.
 */
public class BuildButton extends AButton {

    public BuildButton(HexagonMenu hexagonMenu) {
        super(hexagonMenu);
        this.name = MyValues.NAMES_BUTTON_BUILD;
        this.texture_enabled =generatePattern("button_build.png");
        this.texture_disabled =generatePattern("button_build_disabled.png");
    }

    @Override
    public void prepareEventListener(AUnit unit, HexCell targetCell) {

    }


}
