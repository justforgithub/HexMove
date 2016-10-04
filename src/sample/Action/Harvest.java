package sample.Action;

import sample.Building.AResourceField;
import sample.HexCell;
import sample.MyValues;
import sample.Resources.AResource;
import sample.Resources.Backpack;
import sample.Unit.AUnit;
import sample.Unit.Worker;

/**
 * Created by Deviltech on 18.09.2016.
 */
public class Harvest extends AAction {

    private AUnit unit;
    private HexCell hexcell;

    public Harvest(AUnit unit, HexCell hexCell) {
        this.unit = unit;
        this.hexcell = hexCell;
        this.actionStatus = actionStatus.READY;
    }

    public boolean isActionPossible() {
        return calculateChangeValue() > 0.0;
    }

    @Override
    public void execute() {
        double changeValue = calculateChangeValue();
        if(changeValue > 0.0) {
            AResource resource = ((AResourceField) hexcell.getField()).getResource();
            Backpack backpack = unit.getBackpack();

            unit.energy -= changeValue;
            // fill resource into backpack
            resource.addRemainingCapacity(-changeValue);
            resource.addResource(backpack, changeValue);
            hexcell.drawObject();
        }
    }

    /**
     * Calculate amount of possible transferable resource
     * @return
     */
    private double calculateChangeValue() {
        double changeValue = 0.0;
        // Check if unit is on field and field is resource
        if (unit.getClass() == Worker.class && unit.hexCell == hexcell && hexcell.getField() != null && hexcell.getField().getFieldType().equals(MyValues.FIELD_TYPE.RESOURCE)) {
            AResourceField resourceField = (AResourceField) hexcell.getField();
            AResource resource = resourceField.getResource();

            // Check if there is enough energy, resource or space in backpack for harvest
            Backpack backpack = unit.getBackpack();
            changeValue = Math.min(Math.min(unit.energy,
                    resource.getCurrentCapacity()),
                    backpack.getRemainingCapacity());
        }
        return changeValue;
    }
}
