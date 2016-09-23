package sample;

import javafx.scene.text.Text;
import sample.Terrain.ATerrain;

import java.util.ArrayList;

/**
 * Created by Deviltech on 11.08.2016.
 */
public class Board {

    public HexCell[][] boardCells;
    private int sizeX;
    private int sizeY;

    // TEST STUFF TODO remove
    public HexCell dummy1;
    public HexCell dummy2;
    public Text attText = new Text("Attacker: - ; ");
    public Text defText = new Text("Defender: -");

    Board(int sizeX, int sizeY, ATerrain terrain){
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        boardCells = new HexCell[sizeX][sizeY];
        fillBoardWithCells(terrain);
    }

    /**
     * Fill the board with sizeX*sizeY level 0 cells
     */
    private void fillBoardWithCells(ATerrain terrain){
        double posx = MyValues.HEX_HORIZONTAL_VALUE*0.5*MyValues.HEX_SCALE + MyValues.HEX_DIAGONAL_VALUE*MyValues.HEX_SCALE + MyValues.HEX_STROKE_WIDTH;
        double posy = 2*MyValues.HEX_DIAGONAL_VALUE*MyValues.HEX_SCALE + MyValues.HEX_STROKE_WIDTH ;
        HexCell startCell = new HexCell(0,0, this, terrain);
        startCell.changePosition(posx, posy);
        boardCells[0][0] = startCell;
        for (int i = 0; i< sizeX -1; i++) {
            HexCell currentCell = new HexCell(i+1, 0, this, terrain);
            boardCells[i+1][0] = currentCell;
            //i mod 2 = 0: Bottom
            if (i % 2 == 0) {
                boardCells[i][0].placeHexCell(currentCell, MyValues.HEX_POSITION.BOT_RIGHT );
            } else {
                //i mod 2 =1: Top
                boardCells[i][0].placeHexCell(currentCell, MyValues.HEX_POSITION.TOP_RIGHT );
            }
        }
        for(int i = 0; i < sizeX; i++){
            for(int j = 0; j < sizeY -1; j++){
                HexCell currentCell = new HexCell(i, j+1, this, terrain);
                //System.out.println(Integer.toString(i) + Integer.toString(j));
                boardCells[i][j+1] = currentCell;
                boardCells[i][j].placeHexCell(currentCell, MyValues.HEX_POSITION.BOT);
            }
        }
    }

    /**
     * tuple wrapper for return of specific cell
     * @param tuple
     * @return
     */
    public HexCell getCell(Tuple tuple){
        if(tuple != null) {
            return getCell(tuple.getX(), tuple.getY());
        } else {
            return null;
        }
    }

    /**
     * Return specific hexcell, if possible
     * @param x
     * @param y
     * @return
     */
    public HexCell getCell(int x, int y){
        if(MyMath.isInBounds(0, sizeX-1, x) && MyMath.isInBounds(0, sizeY-1, y)){
            return boardCells[x][y];
        } else {
            return null;
        }
    }

    /**
     * HexCell-wrapper for adjacent coords
     * @param currentCell
     * @param position
     * @return
     */
    public Tuple getAdjacentCoords(HexCell currentCell, MyValues.HEX_POSITION position, boolean isIgnoreBound){
        return getAdjacentCoords(currentCell.getCoords(), position, isIgnoreBound);
    }


    /**
     * X Y-wrapper for adjacent coords
     * @param x
     * @param y
     * @param position
     * @return
     */
    public Tuple getAdjacentCoords(int x, int y, MyValues.HEX_POSITION position, boolean isIgnoreBound){
        return getAdjacentCoords(new Tuple(x,y), position, isIgnoreBound);
    }


    /**
     * Gets the adjacent coordinate tuple  according to position
     * @param currentTuple
     * @param position
     * @return
     */
    public Tuple getAdjacentCoords(Tuple currentTuple, MyValues.HEX_POSITION position, boolean isIgnoreBound){


        int cellX = currentTuple.getX();
        int cellY = currentTuple.getY();
        Tuple adjacentTuple = null;
        switch (position){
            case TOP:
                if(isInBound(cellY-1, sizeY)  || isIgnoreBound){
                    adjacentTuple = new Tuple(cellX,
                            cellY-1);
                }
                break;
            case BOT:
                if(isInBound(cellY+1, sizeY)  || isIgnoreBound){
                    adjacentTuple = new Tuple(cellX, cellY+1);
                }
                break;
            case TOP_LEFT:
                if(isInBound(cellX -1, sizeX)  || isIgnoreBound){
                    if(cellX % 2 ==0){
                        if(isInBound(cellY-1, sizeY)  || isIgnoreBound){
                            adjacentTuple = new Tuple(cellX-1, cellY-1);
                        }
                    } else{
                        adjacentTuple = new Tuple(cellX-1, cellY);
                    }
                }
                break;
            case TOP_RIGHT:
                if(isInBound(cellX +1, sizeX)  || isIgnoreBound){
                    if(cellX % 2 ==0){
                        if(isInBound(cellY-1, sizeY)  || isIgnoreBound){
                            adjacentTuple = new Tuple(cellX+1, cellY-1);
                        }
                    } else{
                        adjacentTuple = new Tuple(cellX+1, cellY);
                    }
                }
                break;
            case BOT_LEFT:
                if(isInBound(cellX -1, sizeX)  || isIgnoreBound){
                    if(cellX % 2 ==1){
                        if(isInBound(cellY+1, sizeY)  || isIgnoreBound){
                            adjacentTuple = new Tuple(cellX-1, cellY+1);
                        }
                    } else{
                        adjacentTuple = new Tuple(cellX-1, cellY);
                    }
                }
                break;
            case BOT_RIGHT:
                if(isInBound(cellX +1, sizeX)  || isIgnoreBound){
                    if(cellX % 2 ==1){
                        if(isInBound(cellY+1, sizeY)  || isIgnoreBound){
                            adjacentTuple = new Tuple(cellX+1, cellY+1);
                        }
                    } else{
                        adjacentTuple = new Tuple(cellX+1, cellY);
                    }
                }
                break;
        }
        return adjacentTuple;
    }

    public HexCell getAdjacentCell(HexCell currentCell, MyValues.HEX_POSITION position, boolean isIgnoreBound){
        Tuple coords = getAdjacentCoords(currentCell, position, isIgnoreBound);
        if(coords != null){
            return getCell(coords.getX(), coords.getY());
        } else {
            return null;
        }
    }


    /**
     * Get adjacent cells of given cell without already visited
     * @param myCell
     * @param usedCells
     * @param todoCells
     * @return
     */
    private ArrayList<HexCell> getAllAdjacentCells(HexCell myCell, ArrayList<HexCell> usedCells, ArrayList<HexCell> todoCells ){

        for(MyValues.HEX_POSITION pos: MyValues.HEX_POSITION.values() ){
            HexCell current = getAdjacentCell(myCell, pos, false);
            // if adjacent Cell is valid and not already used, add it
            if(todoCells.contains(current) && current != null ){
                if(current.distance > myCell.distance + calculatePathCost(myCell, current)) {
                    current.precursor = myCell;
                    //  Caution: Error when HexCell empty
                    current.distance = myCell.distance + calculatePathCost(myCell, current);
                }
            }
        }
        return todoCells;
    }


    /**
     * Checks current >= 0 && current < bound
     * @param current
     * @param bound
     * @return
     */
    private boolean isInBound(int current, int bound){
        return (current >= 0 && current < bound);
    }

    /**
     * sets distance of all Hexcells to max value
     */
    private ArrayList<HexCell> resetHexCellDistances(){
        ArrayList<HexCell> todoCells = new ArrayList<>();
        for(int i = 0; i < boardCells.length; i++){
            for(int j = 0; j < boardCells[0].length; j++){
                HexCell current = boardCells[i][j];
                current.distance = Double.MAX_VALUE;
                current.precursor = null;
                todoCells.add(current);
            }
        }
        return todoCells;
    }

    /**
     * Calculate the path cost between 2 valid cell terrains
     * @param cell1
     * @param cell2
     * @return
     */
    private double calculatePathCost(HexCell cell1, HexCell cell2){
        // Check, if both cells are valid
        if(cell1.getTerrain() != null && cell2.getTerrain() != null){
            return cell1.getAllCosts(false) + cell2.getAllCosts(true);
        } else {
            return  -1;
        }
    }

    /**
     * Returns the Hexcell with the lowest distance
     * @param cells
     * @return
     */
    private HexCell getLowestDistanceCell(ArrayList<HexCell> cells){
        HexCell bestCell = null;

        if(!cells.isEmpty()) {
            bestCell = cells.get(0);
            for (HexCell current : cells) {
                if(current.distance < bestCell.distance){
                    bestCell = current;
                }
            }
        }
        return  bestCell;
    }

    private ArrayList<HexCell> backtrack(HexCell endCell){
        HexCell current = endCell;
        ArrayList<HexCell> pathCells = new ArrayList<>();
        pathCells.add(current);
        while(current.precursor != null){
            pathCells.add(current.precursor);
            current = current.precursor;
        }
        return pathCells;
    }

    /**
     * Calculate path between 2 cells
     * @param startCell
     * @param endCell
     * @return
     */
    public Path calculatePath(HexCell startCell, HexCell endCell){

        // initialize startcell pathfinding
        ArrayList<HexCell> todoCells = resetHexCellDistances();
        ArrayList<HexCell> usedCells = new ArrayList<>();
        startCell.distance = 0;
        boolean pathFound = false;
        HexCell currentCell = startCell;


        while(! pathFound){
           getAllAdjacentCells(currentCell, usedCells, todoCells);
            todoCells.remove(currentCell);
            usedCells.add(currentCell);
            if(currentCell == endCell){
                System.out.println("Path found! " + Double.toString(currentCell.distance));
                pathFound = true;
            } else {
                currentCell = getLowestDistanceCell(todoCells);
                todoCells.remove(currentCell);
            }
        }

        return new Path(backtrack(endCell), endCell.distance);
    }

    /**
     * Find given cell contents in range
     * @param startCell
     * @param content
     * @param maxDistance
     * @return
     */
    public ArrayList<Path> findACellContents(HexCell startCell, ACellContent content, double maxDistance){
        ArrayList<Path> paths = new ArrayList<>();
        // initialize startcell pathfinding
        ArrayList<HexCell> todoCells = resetHexCellDistances();
        ArrayList<HexCell> usedCells = new ArrayList<>();
        startCell.distance = 0;
        HexCell currentCell = startCell;

        while(currentCell.distance < maxDistance && !todoCells.isEmpty()){
            getAllAdjacentCells(currentCell, usedCells, todoCells);
            todoCells.remove(currentCell);
            usedCells.add(currentCell);
            if(content.isSameContent(currentCell)){
                paths.add(new Path(backtrack(currentCell), currentCell.distance));
                System.out.printf("Resource found! Distance: %f \n", currentCell.distance);
            }
            currentCell = getLowestDistanceCell(todoCells);
            todoCells.remove(currentCell);
        }
        return paths;
    }

    /**
     * Deselect all Hexcells
     */
    public void deselectAllCells(){
            for(int i = 0; i < boardCells.length; i++) {
                for (int j = 0; j < boardCells[0].length; j++) {
                    boardCells[i][j].setSelected(false);
                }
            }
    }



}
