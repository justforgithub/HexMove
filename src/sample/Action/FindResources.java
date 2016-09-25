package sample.Action;

import sample.Board;
import sample.Building.AField;
import sample.Building.AResourceField;
import sample.Path;
import sample.Resources.AResource;
import sample.Unit.Worker;

import java.util.ArrayList;

/**
 * Created by Deviltech on 19.09.2016.
 */
public class FindResources extends AStrategy {

    enum StrategyType {NEAREST, MOST, FASTEST}

    StrategyType currentType;
    boolean isStore;
    AField currentField;
    AResource currentResource;
    Worker currentUnit;
    double maxDistance;

    public FindResources(Worker unit, AField field , boolean isStore, AResource resource){
        this.isStore = isStore;
        this.actions = new ArrayList<>();
        this.currentField = field;
        this.currentUnit = unit;
        this.currentResource = resource;
        // Is the resource to be stored or harvested?


    }

    /**
     * Set strategy type to find nearest
     * @param distance
     */
    public void setFindNearest(double distance) {
        this.currentType = StrategyType.NEAREST;
        this.maxDistance = distance;
    }

    /**
     * Set strategy type to find resource with most capacity
     * @param distance
     */
    public void setFindMost(double distance) {
        this.currentType = StrategyType.MOST;
        this.maxDistance = distance;
    }

    /**
     * Set strategy type to find resource with best energy/resource ratio
     * @param distance
     */
    public void setFindFastest(double distance){
        this.currentType = StrategyType.FASTEST;
        this.maxDistance = distance;
    }

    /**
     * find path to resource which suits best for current strategy type
     */
    public void prepareActions(){
        Board board = currentUnit.hexCell.board;
        ArrayList<Path> paths = board.findACellContents(currentUnit.hexCell, currentField, maxDistance);
        // find nearest path
        if (!paths.isEmpty()) {
            Path bestPath = paths.get(0);
            double bestPathScore = Double.MIN_VALUE;
            for (Path p : paths) {
                double currentScore;
                if(isStore){
                    currentScore = calculateStoreScore(currentUnit, p);
                }else {
                    currentScore = calculateHarvestScore(currentUnit, p);
                }
                System.out.println("Score current: " + currentScore);
                if (currentScore >= bestPathScore) {
                    bestPath = p;
                    bestPathScore = currentScore;
                }
            }
            System.out.println(" Best score: " + bestPathScore);
            Move goToResource = new Move(currentUnit, bestPath);
            board.deselectAllCells();
            bestPath.setSelected(true);
            AAction storeOrHarvestAction;
            if(isStore){
                storeOrHarvestAction = new Store(currentUnit, bestPath.getEnd(), currentResource);
            } else {
                storeOrHarvestAction = new Harvest(currentUnit, bestPath.getEnd());
            }

            // set actions
            actions.clear();
            actions.add(goToResource);
            actions.add(storeOrHarvestAction);
        }

    }

    private double calculateHarvestScore(Worker w, Path p){
        switch (currentType){
            case NEAREST:
                return  - p.pathCost;
            case MOST:
                return ((AResourceField) p.getEnd().getField()).getResource().getCurrentCapacity();
            case FASTEST:
                return ((AResourceField) p.getEnd().getField()).getResource().getCurrentCapacity() / (p.pathCost + 0.1);
            default:
                return -1;
        }
    }

    private double calculateStoreScore(Worker w, Path p){
        switch (currentType){
            case NEAREST:
                return  - p.pathCost;
            case MOST:
                return p.getEnd().getField().getBackpack().getRemainingCapacity();
            case FASTEST:
                return Math.min(p.getEnd().getField().getBackpack().getRemainingCapacity(), w.getBackpack().getRemainingCapacity()) / (p.pathCost + 0.1);
            default:
                return -1;
        }
    }

    public void execute(){
        while(!actions.isEmpty() && currentUnit.energy > 0.0){
            // Execute ready action
            if(actions.get(0).isReady()){
                System.out.println("Action! :" + actions.get(0).toString());
                actions.get(0).execute();
                // if action is obsolete, remove it and use remaining energy for next action
                if(actions.get(0).isObsolete()) {
                    System.out.println("Action obsolete: " + actions.get(0));
                    actions.remove(0);
                }
                // if action asks to wait for new energy for completion, end current execute
                if(!actions.isEmpty() && actions.get(0).isWait()){
                    actions.get(0).setReady();
                    break;
                }

            }
        }
    }
}
