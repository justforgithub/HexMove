package sample.RectangleButtons;

import sample.HexCell;
import sample.MyValues;
import sample.Unit.AUnit;

/**
 * Created by Deviltech on 01.10.2016.
 */
public class DepositButton extends AButton {

    public DepositButton(HexagonMenu hexagonMenu) {
        super(hexagonMenu);
        this.name = MyValues.NAMES_BUTTON_DEPOSIT;
        this.texture_enabled =generatePattern("button_deposit.png");
        this.texture_disabled =generatePattern("button_deposit_disabled.png");
    }

    @Override
    public void prepareEventListener(AUnit unit, HexCell targetCell) {

    }

}
