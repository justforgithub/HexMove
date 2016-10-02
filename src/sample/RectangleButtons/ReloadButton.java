package sample.RectangleButtons;

import javafx.scene.input.MouseButton;
import sample.HexCell;
import sample.MyValues;
import sample.Unit.AUnit;

/**
 * Created by Deviltech on 02.10.2016.
 */
public class ReloadButton extends AButton {

    public ReloadButton(HexagonMenu hexagonMenu) {
        super(hexagonMenu);
        this.name = MyValues.NAMES_BUTTON_RELOAD;
        this.texture_enabled =generatePattern("button_reload.png");
        this.texture_disabled =generatePattern("button_reload_disabled.png");
    }

    @Override
    public void prepareEventListener(AUnit unit, HexCell targetCell) {
        if(!unit.isLoaded() &&  unit.isEnoughEnergyForAttack()) {
            isEnabled.set(true);
            drawGroup.setOnMouseClicked((event) -> {
                if (event.getButton().equals(MouseButton.PRIMARY)) {
                    // reload
                    unit.reload();
                    unit.useAttackEnergy();
                    unit.completeDeselect();
                }
            });

        }

    }


}
