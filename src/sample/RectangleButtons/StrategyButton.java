package sample.RectangleButtons;

import sample.MyValues;

/**
 * Created by Deviltech on 01.10.2016.
 */
public class StrategyButton extends AButton {

    public StrategyButton(HexagonMenu hexagonMenu) {
        super(hexagonMenu);
        this.name = MyValues.NAMES_BUTTON_STRATEGY;
        this.texture =generatePattern("button_strategy.png");
    }

    @Override
    public void execute() {

    }
}
