package sample;

import javafx.scene.Group;
import javafx.scene.control.Tooltip;
import javafx.scene.input.MouseButton;
import javafx.scene.shape.Polygon;
import sample.Action.Attack;
import sample.Action.Move;
import sample.Building.AField;
import sample.RectangleButtons.HexagonMenu;
import sample.Terrain.ATerrain;
import sample.Unit.AUnit;

import java.util.ArrayList;


/**
 * Created by Deviltech on 11.08.2016.
 */
public class HexCell {

    /**
     * Generate drawGroup without positioning
     *
     * @return
     */

    private ATerrain terrain;
    private AField field;
    private  AUnit unit;

    public Polygon polygon;

    public Group drawGroup;
    public int x;
    public int y;
    public Board board;

    // For path finding
    public double distance;
    public HexCell precursor;

    HexCell(int x, int y, Board board, ATerrain terrain) {
        this.drawGroup = new Group();
        this.terrain = terrain;
        polygon = drawHexCell();
        this.x = x;
        this.y = y;
        this.board = board;
        this.distance = 0;
        this.precursor = null;
        drawObject();
        prepareEventListeners();
    }

    /**
     * Draws the current HexCell without resetting its translation
     */
    public Group drawObject() {

        drawGroup.getChildren().clear();

        // Terrain check
        if (terrain != null) {
            polygon.setFill(terrain.texture);
        }
        drawGroup.getChildren().addAll(polygon);


        // field Check
        if (field != null) {
            drawGroup.getChildren().addAll(field.drawObject());
        }

        // Unit check
        if (unit != null) {
            drawGroup.getChildren().addAll(unit.drawObject());
        }

        Tooltip.install(drawGroup, new Tooltip(toString()));

        return drawGroup;

    }

    /**
     * Draws Hexagon only
     *
     * @return
     */
    private Polygon drawHexCell() {

        double hor = MyValues.HEX_HORIZONTAL_VALUE * MyValues.HEX_SCALE;
        double dia = MyValues.HEX_DIAGONAL_VALUE * MyValues.HEX_SCALE;

        Polygon polygon = new Polygon();
        polygon.getPoints().addAll(MyMath.generateHexagonCoords(hor, dia));
        polygon.setStroke(MyValues.HEX_STROKE_SELECTION[0]);
        polygon.setStrokeWidth(MyValues.HEX_STROKE_WIDTH);
        polygon.setFill(MyValues.HEX_BACKGROUND);

        return polygon;
    }

    /**
     * executes the new turn in every cellcontent
     */
    public void executeNewTurn(){
        if(terrain != null){
            terrain.executeNewTurn();
        }
        if(field != null){
            field.executeNewTurn();
        }
        if(unit != null){
            unit.executeNewTurn();
        }
        drawObject();
    }

    /**
     * Adjacent HexCell positioning based on given position of other Hexagon
     *
     * @param otherHexCell
     * @param position
     */
    public void placeHexCell(HexCell otherHexCell, MyValues.HEX_POSITION position) {

        double hor = MyValues.HEX_HORIZONTAL_VALUE * MyValues.HEX_SCALE + MyValues.HEX_STROKE_WIDTH * 0.4;
        double dia = MyValues.HEX_DIAGONAL_VALUE * MyValues.HEX_SCALE + MyValues.HEX_STROKE_WIDTH *0.4;


        // Calculate x, y fur adjacent cell
        DoubleTuple coordsTuple = MyMath.calculatePositionCoords(hor, dia, position);

        otherHexCell.drawGroup.setTranslateX(drawGroup.getTranslateX() + coordsTuple.getX());
        otherHexCell.drawGroup.setTranslateY(drawGroup.getTranslateY() + coordsTuple.getY());
    }


    /**
     * Prepare Mouse handlers
     */
    private void prepareEventListeners() {
        drawGroup.setOnMouseClicked(event -> {
            // LEFT CLICK
            if (event.getButton().equals(MouseButton.PRIMARY)) {
                if(board.dummy1 == null && this.unit != null){
                    board.dummy1 = this.unit;
                    this.unit.isSelected.set(true);
                    board.deselectAllCells();

                    // No movement or attack, if moved
                    if(!board.dummy1.isHasAttacked()) {
                        ArrayList<HexCell> moveCells = board.findAllCellsInRange(this, unit.energy);
                        ArrayList<HexCell> attackCells = board.findAllEnemiesInRange(board.dummy1);
                        for (HexCell cell : moveCells) {
                            cell.setSelected(1);
                        }
                        for (HexCell cell : attackCells) {
                            cell.setSelected(2);
                        }
                    }
                } else {
                    // Catch nullpointer
                    if (board.dummy1 != null) {
                        HexagonMenu menu = board.dummy1.generateHexagonMenu();
                        menu.prepareEventListeners(board.dummy1, this);

                        Group menuGroup = menu.drawObject();

                        menuGroup.setTranslateX(drawGroup.getTranslateX());
                        menuGroup.setTranslateY(drawGroup.getTranslateY());
                        board.hexMenuGroup.getChildren().clear();
                        board.hexMenuGroup.getChildren().add(menuGroup);
                    }

                }
            } else { // RIGHT CLICK
                if(event.getButton().equals(MouseButton.SECONDARY)){
                    if(board.dummy1 != null) {
                        board.dummy1.isSelected.set(false);
                        board.dummy1 = null;
                        board.deselectAllCells();
                        board.hexMenuGroup.getChildren().clear();
                    }
                        if (this.unit != null) {
                            ArrayList<HexCell> attkCells = this.unit.getAttackCells();
                            board.deselectAllCells();
                            for (HexCell cell : attkCells) {
                                cell.setSelected(3);
                            }
                            ArrayList<HexCell> attackCells = board.findAllEnemiesInRange(this.unit);
                            for(HexCell cell: attackCells){
                                cell.setSelected(2);
                            }
                    } else {
                            board.deselectAllCells();
                            board.hexMenuGroup.getChildren().clear();
                        }
                }

            }

        });
    }

    /**
     * returns 2-tuple of coordinates
     * @return
     */
    public Tuple getCoords(){
        return new Tuple(x, y);
    }


    /**
     * Change Position of x and y
     *
     * @param x
     * @param y
     */
    public void changePosition(double x, double y) {
        drawGroup.setTranslateX(x);
        drawGroup.setTranslateY(y);
    }

    /**
     * Sets the terrain, field and unit
     *
     * @param terrain
     * @param field
     * @param unit
     */
    public Group setTerraBuildUnitGetDraw(ATerrain terrain, AField field, AUnit unit) {
        if(terrain != null){
            this.terrain = terrain;
            this.terrain.hexCell = this;
        }
        if(field != null){
            this.field = field;
            this.field.hexCell = this;

        }
        if(unit!= null){
            this.unit = unit;
            this.unit.hexCell = this;
        }

        return drawObject();
    }

    /**
     * Selection with standard select /deselect
     * @param bool
     */
    public void setSelected(boolean bool){
        if(bool){
            polygon.setStroke(MyValues.HEX_STROKE_SELECTION[2]);
        } else {
            polygon.setStroke(MyValues.HEX_STROKE_SELECTION[0]);
        }
    }

    /**
     * Selection specified with color code
     * @param i
     */
    public void setSelected(int i){
        polygon.setStroke(MyValues.HEX_STROKE_SELECTION[i%MyValues.HEX_STROKE_SELECTION.length]);
    }

    /**
     * sums up all path costs of terrain, field and unit
     * @return
     */
    public double getAllCosts(boolean countUnit){
        double cost = 0.0;
        if(terrain != null){
            cost += terrain.pathCost;
        }
        if(field != null){
            cost += field.pathCost;
        }
        if(countUnit && unit != null){
            cost += unit.pathCost;
        }
        return  cost;
    }

    public String toString(){
        String s = " - Cell xy:" + Integer.toString(x) + " " + Integer.toString(y) + " Cost: " + getAllCosts(false) + "\n";
        if(terrain != null){
            s += terrain.toString() + ", Cover: " + terrain.coverage + " \n";
        }
        if(field != null){
            s += field.toString() + " \n";
        }
        if(unit != null){
            s += unit.toString() + " ";
        }
        return s;
    }

    public AField getField() {
        return field;
    }

    public void setField(AField field) {
        this.field = field;
    }

    public AUnit getUnit() {
        return unit;
    }

    public void setUnit(AUnit unit) {
        this.unit = unit;
    }

    public ATerrain getTerrain() {

        return terrain;
    }

    public void setTerrain(ATerrain terrain) {
        this.terrain = terrain;
    }
}
