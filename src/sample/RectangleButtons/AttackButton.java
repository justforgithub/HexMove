package sample.RectangleButtons;

import sample.MyValues;

/**
 * Created by Deviltech on 01.10.2016.
 */
public class AttackButton extends AButton {

    public AttackButton(HexagonMenu hexagonMenu) {
        super(hexagonMenu);
        this.name = MyValues.NAMES_BUTTON_ATTACK;
        this.texture =generatePattern("button_attack.png");
    }

    @Override
    public void execute() {

    }
}
