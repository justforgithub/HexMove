package sample.RectangleButtons;

import javafx.scene.input.MouseButton;
import sample.Action.Move;
import sample.HexCell;
import sample.MyValues;
import sample.Unit.AUnit;

/**
 * Created by Deviltech on 28.09.2016.
 */
public class MoveButton extends AButton {


    public MoveButton(HexagonMenu hexagonMenu) {
        super(hexagonMenu);
        this.name = MyValues.NAMES_BUTTON_MOVE;
        this.texture_enabled = generatePattern("button_move.png");
        this.texture_disabled = generatePattern("button_move_disabled.png");
    }

    @Override
    public void prepareEventListener(AUnit unit, HexCell targetCell) {
        drawGroup.setOnMouseClicked((event) -> {
            if (event.getButton().equals(MouseButton.PRIMARY)) {
                if (unit != null && targetCell.getUnit() == null) {
                    // No movement, when already attacked
                    if(!unit.isHasAttacked()) {
                        new Move(unit, targetCell.board.calculatePath(unit.hexCell, targetCell)).execute();
                        targetCell.board.deselectAllCells();
                        unit.isSelected.set(false);
                        targetCell.board.dummy1 = null;
                        targetCell.board.closeHexMenu();
                    }
                }

            }
        });
    }
}
