package sample;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Polygon;
import sample.Building.ABuilding;
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
    public ABuilding building;
    public AUnit unit;

    public Polygon polygon;

    public Group drawGroup;
    public int x;
    public int y;
    public Board board;

    HexCell(int x, int y, Board board, ATerrain terrain) {
        this.drawGroup = new Group();
        this.terrain = terrain;
        polygon = drawHexCell();
        drawObject();
        this.x = x;
        this.y = y;
        this.board = board;
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


        // building Check
        if (building != null) {
            drawGroup.getChildren().addAll(building.drawObject());
        }

        // Unit check
        if (unit != null) {
            drawGroup.getChildren().addAll(unit.drawObject());
        }

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
                System.out.println("LeftClicked");
                setSelected(true);
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
     * Sets the terrain, building and unit
     *
     * @param terrain
     * @param building
     * @param unit
     */
    public Group setTerraBuildUnitGetDraw(ATerrain terrain, ABuilding building, AUnit unit) {
        if(terrain != null){
            this.terrain = terrain;
        }
        if(building != null){
            this.building = building;
        }
        if(unit!= null){
            this.unit = unit;
        }

        return (drawObject());
    }

    public void setSelected(boolean bool){
        if(bool){
            polygon.setStroke(MyValues.HEX_STROKE_SELECTED);
        } else {
            polygon.setStroke(MyValues.HEX_STROKE);
        }
    }
}
