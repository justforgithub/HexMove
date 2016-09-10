package sample;

import sample.Terrain.ATerrain;

import java.util.ArrayList;

/**
 * Created by Deviltech on 11.08.2016.
 */
public class Board {

    public HexCell[][] boardCells;
    private int x;
    private int y;

    Board(int x, int y, ATerrain terrain){
        this.x = x;
        this.y = y;
        boardCells = new HexCell[x][y];
        fillBoardWithCells(terrain);
    }

    /**
     * Fill the board with x*y level 0 cells
     */
    private void fillBoardWithCells(ATerrain terrain){
        double posx = MyValues.HEX_HORIZONTAL_VALUE*0.5*MyValues.HEX_SCALE + MyValues.HEX_DIAGONAL_VALUE*MyValues.HEX_SCALE + MyValues.HEX_STROKE_WIDTH;
        double posy = 2*MyValues.HEX_DIAGONAL_VALUE*MyValues.HEX_SCALE + MyValues.HEX_STROKE_WIDTH ;
        HexCell startCell = new HexCell(0,0, this, terrain);
        startCell.changePosition(posx, posy);
        boardCells[0][0] = startCell;
        for (int i = 0; i< x-1; i++) {
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
        for(int i = 0; i < x; i++){
            for(int j = 0; j < y-1; j++){
                HexCell currentCell = new HexCell(i, j+1, this, terrain);
                //System.out.println(Integer.toString(i) + Integer.toString(j));
                boardCells[i][j+1] = currentCell;
                boardCells[i][j].placeHexCell(currentCell, MyValues.HEX_POSITION.BOT);
            }
        }
    }

    /**
     * Return specific hexcell
     * @param x
     * @param y
     * @return
     */
    public HexCell getCell(int x, int y){
        //TODO Check bounds
        return boardCells[x][y];
    }

    /**
     * Gets the adjacent cell according to position
     * @param currentCell
     * @param position
     * @return
     */
    public HexCell getAdjacentCell(HexCell currentCell, MyValues.HEX_POSITION position){
        int cellX = currentCell.x;
        int cellY = currentCell.y;
        HexCell adjacentCell = null;
        switch (position){
            case TOP:
                if(isInBound(cellY-1, y)){
                    adjacentCell = getCell(cellX,
                            cellY-1);
                }
                break;
            case BOT:
                if(isInBound(cellY+1, y)){
                    adjacentCell = getCell(cellX, cellY+1);
                }
                break;
            case TOP_LEFT:
                if(isInBound(cellX -1, x)){
                    if(cellX % 2 ==0){
                        if(isInBound(cellY-1, y)){
                            adjacentCell = getCell(cellX-1, cellY-1);
                        }
                    } else{
                        adjacentCell = getCell(cellX-1, cellY);
                    }
                }
                break;
            case TOP_RIGHT:
                if(isInBound(cellX +1, x)){
                    if(cellX % 2 ==0){
                        if(isInBound(cellY-1, y)){
                            adjacentCell = getCell(cellX+1, cellY-1);
                        }
                    } else{
                        adjacentCell = getCell(cellX+1, cellY);
                    }
                }
                break;
            case BOT_LEFT:
                if(isInBound(cellX -1, x)){
                    if(cellX % 2 ==1){
                        if(isInBound(cellY+1, y)){
                            adjacentCell = getCell(cellX-1, cellY+1);
                        }
                    } else{
                        adjacentCell = getCell(cellX-1, cellY);
                    }
                }
                break;
            case BOT_RIGHT:
                if(isInBound(cellX +1, x)){
                    if(cellX % 2 ==1){
                        if(isInBound(cellY+1, y)){
                            adjacentCell = getCell(cellX+1, cellY+1);
                        }
                    } else{
                        adjacentCell = getCell(cellX+1, cellY);
                    }
                }
                break;
        }
        return adjacentCell;
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


}
