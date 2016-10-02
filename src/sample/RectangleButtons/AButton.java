package sample.RectangleButtons;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextBoundsType;
import sample.ACellContent;
import sample.HexCell;
import sample.MyMath;
import sample.MyValues;
import sample.Unit.AUnit;

/**
 * Created by Deviltech on 28.09.2016.
 */
public abstract class AButton {

    ImagePattern texture_enabled;
    ImagePattern texture_disabled;
    String name;
    HexagonMenu hexagonMenu;
    Group drawGroup;
    SimpleBooleanProperty isEnabled;


    public AButton(HexagonMenu hexagonMenu){
        this.hexagonMenu = hexagonMenu;
        this.drawGroup = new Group();
        this.isEnabled = new SimpleBooleanProperty(); // Standard: false
        this.isEnabled.addListener((value)->{
            drawObject();
        });
    }

    public abstract void prepareEventListener(AUnit unit, HexCell targetCell);

    public Group drawObject(){

        double hor = MyValues.HEX_HORIZONTAL_VALUE * MyValues.HEX_SCALE;
        double dia = MyValues.HEX_DIAGONAL_VALUE * MyValues.HEX_SCALE;


        Polygon polygon = new Polygon();
        polygon.getPoints().addAll(MyMath.generateHexagonCoords(hor, dia));
        polygon.setStroke(MyValues.UI_BUTTON_STROKE_COLOR);
        polygon.setStrokeWidth(MyValues.HEX_STROKE_WIDTH * MyValues.UI_BUTTON_SCALE);
        polygon.setFill(getValidTexture());

        //Text text = new Text(this.name);
        //text.setFont(Font.font(null, FontWeight.EXTRA_BOLD, 20));
        //text.setFill(Color.ORANGERED);
        //text.setBoundsType(TextBoundsType.VISUAL);

        drawGroup.getChildren().clear();
        drawGroup.getChildren().addAll(polygon);
        return drawGroup;
    }

    /** //TODO: Fix double occurrence
     * generate general pattern
     * @param s
     * @return
     */
    public ImagePattern generatePattern(String s){
        return new ImagePattern(new Image(getClass().getClassLoader().getResource(MyValues.PATH_IMAGE  + MyValues.PATH_BUTTON + s).toExternalForm()), 0, 0, 1, 1, true);
    }

    /**
     * Returns enabled or disabled image pattern for texture
     * @return
     */
    ImagePattern getValidTexture(){
        if(isEnabled.getValue()){
            return texture_enabled;
        } else {
            return texture_disabled;
        }
    }

    public void setEnabled(boolean b){
        this.isEnabled.set(b);
    }


}
