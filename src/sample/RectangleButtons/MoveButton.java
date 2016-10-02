package sample.RectangleButtons;

import sample.MyValues;

/**
 * Created by Deviltech on 28.09.2016.
 */
public class MoveButton extends AButton{


    public MoveButton(RectangleMenu rectangleMenu) {
        super(rectangleMenu);
        this.name = MyValues.NAMES_BUTTON_MOVE;
        this.texture =generatePattern("button_move.png");
    }

    @Override
    public void execute() {

    }
}