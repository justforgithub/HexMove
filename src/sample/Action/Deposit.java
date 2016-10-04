package sample.Action;

import sample.Building.ConstructionSite;
import sample.HexCell;
import sample.MyValues;
import sample.Resources.AResource;
import sample.Resources.Backpack;
import sample.Unit.AUnit;
import sample.Unit.Worker;

/**
 * Created by Deviltech on 19.09.2016.
 */
public class Deposit extends AAction {

    private AUnit unit;
    private HexCell hexcell;
    // Resource type
    private AResource resource;

    public Deposit(AUnit unit, HexCell hexcell, AResource resource){
        this.hexcell = hexcell;
        this.unit = unit;
        this.actionStatus = MyValues.ACTION_STATUS.READY;
        this.resource = resource;
    }

    @Override
    public boolean isActionPossible(){
        return calculateChangeValue() > 0.0;
    }

    @Override
    public void execute(){
        double changeValue = calculateChangeValue();
        if(changeValue > 0.0) {
            Backpack toStoreBackpack =  hexcell.getField().getBackpack();
            Backpack workerBackpack = unit.getBackpack();
                unit.energy -= changeValue;
                // remove resource from workerbackpack
                workerBackpack.addResource(-changeValue, resource);
                // store resource into toStoreBackpack
                toStoreBackpack.addResource( changeValue, resource);
                // Try to construct
                if(hexcell.getField().getClass().equals(ConstructionSite.class)){
                    ((ConstructionSite) hexcell.getField()).construct();
                }
            } else {
                actionStatus = MyValues.ACTION_STATUS.OBSOLETE;
            }
    }

    /**
     * Calculate amount of possible transferable resource
     * @return
     */
    private double calculateChangeValue(){
        double changeValue = 0.0;
        if(unit.getClass() == Worker.class && unit.hexCell == hexcell  && hexcell != null &&
                hexcell.getField() != null && hexcell.getField().getBackpack() != null) {
            Backpack toStoreBackpack = hexcell.getField().getBackpack();

            // Check if there is enough energy, store space or backpack resources to store
            Backpack workerBackpack = unit.getBackpack();
            changeValue = Math.min(Math.min(unit.energy,
                    toStoreBackpack.getRemainingCapacity()),
                    // amount of resource in workerbackpack
                    resource.findResource(workerBackpack).getCurrentCapacity());
        }
        return changeValue;
    }


}
