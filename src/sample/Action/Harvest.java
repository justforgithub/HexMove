package sample.Action;

import sample.Building.AResourceField;
import sample.HexCell;
import sample.MyValues;
import sample.Resources.AResource;
import sample.Resources.Backpack;
import sample.Unit.Worker;

/**
 * Created by Deviltech on 18.09.2016.
 */
public class Harvest extends AAction {

    private Worker worker;
    private HexCell hexcell;

    public Harvest(Worker worker, HexCell hexcell){
        this.hexcell = hexcell;
        this.worker = worker;
        this.actionStatus = actionStatus.READY;

    }

    @Override
    public void execute(){
        if(hexcell.getField() != null && hexcell.getField().getFieldType().equals(MyValues.FIELD_TYPE.RESOURCE)) {
            AResourceField resourceField = (AResourceField) hexcell.getField();
            AResource resource = resourceField.getResource();

            // Check if there is enough energy, resource or space in backpack for harvest
            Backpack backpack = worker.getBackpack();
            double changeValue = Math.min(Math.min(worker.energy,
                    resource.getCurrentCapacity()),
                    backpack.getRemainingCapacity());
            System.out.println(worker.energy + " " + resource.getCurrentCapacity() + " " + backpack.getRemainingCapacity() + " harvested: " + changeValue);
            if(changeValue > 0.0) {
                worker.energy -= changeValue;
                // fill resource into backpack
                resource.addRemainingCapacity(- changeValue);
                resource.addResource(backpack, changeValue);
                hexcell.drawObject();
            } else {
                actionStatus = MyValues.ACTION_STATUS.OBSOLETE;
            }
        } else {
            System.out.println("Harvest not possible here " +
                    hexcell.getField() +" " + " " + hexcell.x + " " + hexcell.y);
            actionStatus = MyValues.ACTION_STATUS.OBSOLETE;
        }
    }
}
