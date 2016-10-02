package sample.RectangleButtons;

import sample.HexCell;
import sample.MyValues;
import sample.Unit.AUnit;

/**
 * Created by Deviltech on 01.10.2016.
 */
public class HarvestButton extends AButton {

    public HarvestButton(HexagonMenu hexagonMenu) {
        super(hexagonMenu);
        this.name = MyValues.NAMES_BUTTON_HARVEST;
        this.texture_enabled = generatePattern("button_harvest.png");
        this.texture_disabled = generatePattern("button_harvest_disabled.png");
    }

    @Override
    public void prepareEventListener(AUnit unit, HexCell targetCell) {

    }


}
