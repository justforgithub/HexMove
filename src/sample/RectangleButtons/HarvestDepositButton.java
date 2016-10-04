package sample.RectangleButtons;

import javafx.scene.image.Image;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.ImagePattern;
import sample.Action.Attack;
import sample.Action.Deposit;
import sample.Action.Harvest;
import sample.HexCell;
import sample.MyValues;
import sample.Resources.AResource;
import sample.Unit.AUnit;
import sample.Unit.Worker;

import java.util.ArrayList;

/**
 * Created by Deviltech on 04.10.2016.
 */
public class HarvestDepositButton extends AButton {

    private ImagePattern texture_all_enabled;
    private ImagePattern texture_all_disabled;
    private ImagePattern texture_harvest;
    private ImagePattern texture_deposit;

    public HarvestDepositButton(HexagonMenu hexagonMenu) {
        super(hexagonMenu);
        this.name = MyValues.NAMES_BUTTON_HARVEST_DEPOSIT;
        this.texture_all_enabled = generatePattern("button_resources.png");
        this.texture_all_disabled = generatePattern("button_resources_disabled.png");
        this.texture_harvest = generatePattern("button_harvest.png");
        this.texture_deposit = generatePattern("button_deposit.png");

        this.texture_enabled = texture_all_enabled;
        this.texture_disabled = texture_all_disabled;
    }

    @Override
    public void prepareEventListener(AUnit unit, HexCell targetCell) {
        if (unit != null && unit.getClass() == Worker.class) {
            Harvest harvestAction = new Harvest(unit, targetCell);
            // Backpack check: worker
            ArrayList<AResource> resources = unit.getBackpack().getAllResources();
            ArrayList<Deposit> depositActions = new ArrayList<>();
            // Find possible depositable resources
            for (AResource currentResource : resources) {
                depositActions.add(new Deposit(unit, targetCell, currentResource));
            }
            boolean harvestable = false;
            boolean depositable = false;
            harvestable = harvestAction.isActionPossible();
            for (Deposit currentDepositAction : depositActions) {
                if (currentDepositAction.isActionPossible()) {
                    depositable = true;
                    break;
                }
            }
            // HARVEST AND DEPOSIT
            if (harvestable && depositable) {
                this.texture_disabled = texture_all_enabled;
            }
            // HARVEST ONLY
            if (harvestable && !depositable) {
                this.texture_disabled = texture_harvest;
                drawGroup.setOnMouseClicked((event) -> {
                    if (event.getButton().equals(MouseButton.PRIMARY)) {
                        // TODO for multiple resources
                        harvestAction.execute();
                        unit.completeDeselect();
                    }
                });
            }
            // DEPOSIT ONLY
            if (!harvestable && depositable) {
                this.texture_disabled = texture_deposit;
                drawGroup.setOnMouseClicked((event) -> {
                    if (event.getButton().equals(MouseButton.PRIMARY)) {
                        for(Deposit currentDepositAction: depositActions){
                            // TODO choose resource
                            currentDepositAction.execute();
                        }
                        unit.completeDeselect();
                    }
                });
            }
            // NOTHING
            if (!harvestable && !depositable) {
                this.texture_disabled = texture_all_disabled;
            }
            drawObject();
        }
    }
}

