package sample.RectangleButtons;

import javafx.scene.input.MouseButton;
import sample.Action.Attack;
import sample.HexCell;
import sample.MyValues;
import sample.Unit.AUnit;

import java.util.ArrayList;

/**
 * Created by Deviltech on 01.10.2016.
 */
public class AttackButton extends AButton {

    public AttackButton(HexagonMenu hexagonMenu) {
        super(hexagonMenu);
        this.name = MyValues.NAMES_BUTTON_ATTACK;
        this.texture_enabled = generatePattern("button_attack.png");
        this.texture_disabled = generatePattern("button_attack_disabled.png");
    }

    @Override
    public void prepareEventListener(AUnit unit, HexCell targetCell) {
        if (unit != null && targetCell.getUnit() != null){
            Attack attackAction = new Attack(unit, targetCell.getUnit());
            if (attackAction.isActionPossible()){
                this.isEnabled.set(true);
                //Add listener
                drawGroup.setOnMouseClicked((event) -> {
                    if (event.getButton().equals(MouseButton.PRIMARY)) {

                        targetCell.board.deselectAllCells();
                        targetCell.board.closeHexMenu();

                        new Attack(unit, targetCell.getUnit()).execute();
                        unit.isSelected.set(false);
                        targetCell.drawObject();
                        this.drawObject();

                        //TODO: perform normal attack instead
                        ArrayList<HexCell> attkCells = unit.getAttackCells();
                        if (attkCells.contains(targetCell)) {
                            targetCell.setSelected(2);
                            unit.hexCell.setSelected(2);
                        }
                        targetCell.board.dummy1 = null;
                    }
                });
            }
        }
    }
}
