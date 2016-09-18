package sample;

import javafx.scene.Group;
import javafx.scene.control.Tooltip;
import javafx.scene.input.MouseButton;
import javafx.scene.shape.Polygon;
import sample.Building.AField;
import sample.Terrain.ATerrain;
import sample.Unit.AUnit;



/**
 * Created by Deviltech on 11.08.2016.
 */
public class HexCell {

    /**
     * Generate drawGroup without positioning
     *
     * @return
     */

    public ATerrain terrain;
    public AField field;
    public AUnit unit;

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
        drawGroup.getChildren().addAll(new Group(polygon));


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
        polygon.getPoints().addAll(new Double[]{
                -(dia + 0.5 * hor), 0.0,
                -0.5 * hor, -hor,
                +0.5 * hor, -hor,
                +(dia + 0.5 * hor), 0.0,
                +0.5 * hor, hor,
                -0.5 * hor, hor,
        });
        polygon.setStroke(MyValues.HEX_STROKE);
        polygon.setStrokeWidth(MyValues.HEX_STROKE_WIDTH);
        polygon.setFill(MyValues.HEX_BACKGROUND);

        return polygon;
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

        double x = 0;
        double y = 0;
        switch (position) {
            case TOP:
                x = 0;
                y = -2 * hor;
                break;
            case TOP_LEFT:
                x = -(hor + dia);
                y = -hor;
                break;
            case TOP_RIGHT:
                x = +(hor + dia);
                y = -hor;
                break;
            case BOT:
                x = 0;
                y = +2 * hor;
                break;
            case BOT_LEFT:
                x = -(hor + dia);
                y = +hor;
                break;
            case BOT_RIGHT:
                x = +(hor + dia);
                y = +hor;
                break;
        }
        otherHexCell.drawGroup.setTranslateX(drawGroup.getTranslateX() + x);
        otherHexCell.drawGroup.setTranslateY(drawGroup.getTranslateY() + y);
    }


    /**
     * Prepare Mouse handlers
     */
    private void prepareEventListeners() {
        drawGroup.setOnMouseClicked(event -> {
            if (event.getButton().equals(MouseButton.PRIMARY)) {
                board.dummy1 = this;
            } else {
                if(event.getButton().equals(MouseButton.SECONDARY)){
                    board.dummy2 = this;
                }
            }
            if(board.dummy1 != null  && board.dummy2 != null){
                Path path = board.calculatePath(board.dummy1, board.dummy2);
                board.deselectAllCells();
                for(HexCell current: path.pathCells){
                    current.setSelected(true);
                }
            }

        });
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

    public void setSelected(boolean bool){
        if(bool){
            polygon.setStroke(MyValues.HEX_STROKE_SELECTED);
        } else {
            polygon.setStroke(MyValues.HEX_STROKE);
        }
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
        String s = " - Cell xy:" + Integer.toString(x) + " " + Integer.toString(y) + "\n";
        if(terrain != null){
            s += terrain.toString() + " \n";
        }
        if(field != null){
            s += field.toString() + " \n";
        }
        if(unit != null){
            s += unit.toString() + " ";
        }
        return s;
    }
}
