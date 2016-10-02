package sample.RectangleButtons;

import sample.MyValues;

/**
 * Created by Deviltech on 02.10.2016.
 */
public class EmptyButton extends AButton{

    public EmptyButton(HexagonMenu hexagonMenu) {
        super(hexagonMenu);
        this.name = MyValues.NAMES_BUTTON_EMPTY;
        this.texture =generatePattern("button_empty.png");
    }

    @Override
    public void execute() {

    }
}
