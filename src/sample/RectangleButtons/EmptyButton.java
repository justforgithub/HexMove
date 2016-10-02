package sample.RectangleButtons;

import sample.HexCell;
import sample.MyValues;
import sample.Unit.AUnit;

/**
 * Created by Deviltech on 02.10.2016.
 */
public class EmptyButton extends AButton{

    public EmptyButton(HexagonMenu hexagonMenu) {
        super(hexagonMenu);
        this.name = MyValues.NAMES_BUTTON_EMPTY;
        this.texture_enabled = generatePattern("button_empty.png");
        this.texture_disabled = generatePattern("button_empty.png");
    }

    @Override
    public void prepareEventListener(AUnit unit, HexCell targetCell) {

    }

}
