package sample.Action;

import com.sun.xml.internal.ws.api.pipe.FiberContextSwitchInterceptor;
import sample.Building.ABuildingField;
import sample.Building.ConstructionSite;
import sample.HexCell;
import sample.Unit.AUnit;
import sample.Unit.Worker;

/**
 * Created by Deviltech on 04.10.2016.
 */
public class Build extends AAction {

    private AUnit unit;
    private HexCell hexCell;
    private ABuildingField building;

    public Build(AUnit unit, HexCell hexCell, ABuildingField building){
        this.unit = unit;
        this.hexCell = hexCell;
        this.building = building;
    }

    @Override
    public void execute() {
        if(isActionPossible()){
            ABuildingField buildingCopy = (ABuildingField) building.generateCopy();
            buildingCopy.chooseFaction(unit.getFaction());
            buildingCopy.hexCell = unit.hexCell;
            hexCell.setField( new ConstructionSite(unit.faction, buildingCopy, hexCell));
        }

    }

    /**
     * Checks if in general, building is possible here
     * @return
     */
    public boolean isBuildingPossible(){
        boolean isPossible = false;
        if(unit != null && unit.getClass()== Worker.class && unit.hexCell == hexCell &&
                hexCell.getField() == null){
            //TODO: possible terrain check, current check: build where worker can walk
            isPossible = true;
        }
        return isPossible;

    }
    @Override
    public boolean isActionPossible() {
        return isBuildingPossible() && building != null;
    }

    public Build chooseBuilding(ABuildingField build) {
        this.building = build;
        return this;
    }
}
