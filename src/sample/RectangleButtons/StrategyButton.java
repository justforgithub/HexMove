package sample.RectangleButtons;

import sample.HexCell;
import sample.MyValues;
import sample.Unit.AUnit;

/**
 * Created by Deviltech on 01.10.2016.
 */
public class StrategyButton extends AButton {

    public StrategyButton(HexagonMenu hexagonMenu) {
        super(hexagonMenu);
        this.name = MyValues.NAMES_BUTTON_STRATEGY;
        this.texture_enabled =generatePattern("button_strategy.png");
        this.texture_disabled =generatePattern("button_strategy_disabled.png");
    }

    @Override
    public void prepareEventListener(AUnit unit, HexCell targetCell) {

    }


}
