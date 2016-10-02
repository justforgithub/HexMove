package sample.RectangleButtons;

import sample.MyValues;

/**
 * Created by Deviltech on 01.10.2016.
 */
public class DepositButton extends AButton {

    public DepositButton(HexagonMenu hexagonMenu) {
        super(hexagonMenu);
        this.name = MyValues.NAMES_BUTTON_DEPOSIT;
        this.texture =generatePattern("button_deposit.png");
    }

    @Override
    public void execute() {

    }
}
