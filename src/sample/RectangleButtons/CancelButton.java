package sample.RectangleButtons;

import javafx.scene.input.MouseButton;
import sample.HexCell;
import sample.MyValues;
import sample.Unit.AUnit;

/**
 * Created by Deviltech on 01.10.2016.
 */
public class CancelButton extends AButton {

    public CancelButton(HexagonMenu hexagonMenu) {
        super(hexagonMenu);
        this.name = MyValues.NAMES_BUTTON_CANCEL;
        this.texture_enabled =generatePattern("button_cancel.png");
        this.texture_disabled =generatePattern("button_cancel_disabled.png");
    }

    @Override
    public void prepareEventListener(AUnit unit, HexCell targetCell) {
        drawGroup.setOnMouseClicked((event) -> {
            if (event.getButton().equals(MouseButton.PRIMARY)) {
                unit.completeDeselect();
            }
        });
    }


}
