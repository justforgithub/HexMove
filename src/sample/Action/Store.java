package sample.Action;

import sample.HexCell;
import sample.MyValues;
import sample.Resources.AResource;
import sample.Resources.Backpack;
import sample.Unit.Worker;

/**
 * Created by Deviltech on 19.09.2016.
 */
public class Store extends AAction{

    private Worker worker;
    private HexCell hexcell;
    // Resource type
    private AResource resource;

    public Store(Worker worker, HexCell hexcell, AResource resource){
        this.hexcell = hexcell;
        this.worker = worker;
        this.actionStatus = MyValues.ACTION_STATUS.READY;
        this.resource = resource;

    }

    @Override
    public void execute(){
        if(hexcell != null && hexcell.getField() != null && hexcell.getField().getBackpack() != null) {
            Backpack toStoreBackpack =  hexcell.getField().getBackpack();

            // Check if there is enough energy, store space or backpack resources to store
            Backpack workerBackpack = worker.getBackpack();
            double changeValue = Math.min(Math.min(worker.energy,
                    toStoreBackpack.getRemainingCapacity()),
                    // amount of resource in workerbackpack
                    resource.findResource(workerBackpack).capacity);
            System.out.println(worker.energy +  " stored: " + changeValue);
            if(changeValue > 0.0) {
                worker.energy -= changeValue;
                // remove resource from workerbackpack
                workerBackpack.addResource(-changeValue, resource);
                // store resource into toStoreBackpack
                toStoreBackpack.addResource( changeValue, resource);
                hexcell.drawObject();
            } else {
                actionStatus = MyValues.ACTION_STATUS.OBSOLETE;
            }
        } else {
            System.out.println("Store not possible here " +
                    hexcell.getField() +" " + " " + hexcell.x + " " + hexcell.y);
            actionStatus = MyValues.ACTION_STATUS.OBSOLETE;
        }
    }
}