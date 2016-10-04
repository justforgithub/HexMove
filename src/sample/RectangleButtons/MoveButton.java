package sample.RectangleButtons;

import javafx.scene.input.MouseButton;
import sample.Action.Move;
import sample.HexCell;
import sample.MyValues;
import sample.Path;
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

        if (unit != null) {
            Move moveAction = new Move(unit, targetCell.board.calculatePath(unit.hexCell, targetCell));
            if (moveAction.isActionPossible()) {
                isEnabled.set(true);
                drawGroup.setOnMouseClicked((event) -> {
                    if (event.getButton().equals(MouseButton.PRIMARY)) {
                        moveAction.execute();
                        unit.completeDeselect();
                    }
                });
            }
        }
    }
}
