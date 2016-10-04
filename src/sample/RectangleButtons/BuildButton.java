package sample.RectangleButtons;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.input.MouseButton;
import sample.Action.Build;
import sample.Building.ABuildingField;
import sample.HexCell;
import sample.MyValues;
import sample.UI.Submenu;
import sample.Unit.AUnit;

/**
 * Created by Deviltech on 02.10.2016.
 */
public class BuildButton extends AButton {

    public BuildButton(HexagonMenu hexagonMenu) {
        super(hexagonMenu);
        this.name = MyValues.NAMES_BUTTON_BUILD;
        this.texture_enabled =generatePattern("button_build.png");
        this.texture_disabled =generatePattern("button_build_disabled.png");
    }

    @Override
    public void prepareEventListener(AUnit unit, HexCell targetCell) {
        if (unit != null){
            Build buildAction = new Build(unit, targetCell, null);
            if(buildAction.isBuildingPossible()){
                isEnabled.set(true);
                drawGroup.setOnMouseClicked((event) -> {
                    if (event.getButton().equals(MouseButton.PRIMARY)) {
                        ABuildingField[] possibleBuildings = MyValues.LIST_BUILDINGS;
                        SimpleIntegerProperty intProperty = new SimpleIntegerProperty(-1);
                        Submenu sub = new Submenu(possibleBuildings, intProperty);
                        drawGroup.getChildren().add(sub.getDraw());
                        intProperty.addListener((value) ->{
                            System.out.println("value:" + intProperty.getValue());
                            if(intProperty.getValue() != -1){
                                buildAction.chooseBuilding(possibleBuildings[intProperty.getValue()]);
                                buildAction.execute();
                                unit.completeDeselect();
                            }
                        });
                    }});

            }
        }

    }


}
