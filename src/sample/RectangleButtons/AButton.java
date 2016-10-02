package sample.RectangleButtons;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextBoundsType;
import sample.MyMath;
import sample.MyValues;

/**
 * Created by Deviltech on 28.09.2016.
 */
public abstract class AButton {

    ImagePattern texture;
    String name;
    HexagonMenu hexagonMenu;

    public AButton(HexagonMenu hexagonMenu){
        this.hexagonMenu = hexagonMenu;
    }

    public abstract void execute();

    public Group drawObject(){

        double hor = MyValues.HEX_HORIZONTAL_VALUE * MyValues.HEX_SCALE;
        double dia = MyValues.HEX_DIAGONAL_VALUE * MyValues.HEX_SCALE;


        Polygon polygon = new Polygon();
        polygon.getPoints().addAll(MyMath.generateHexagonCoords(hor, dia));
        polygon.setStroke(MyValues.UI_BUTTON_STROKE_COLOR);
        polygon.setStrokeWidth(MyValues.HEX_STROKE_WIDTH * MyValues.UI_BUTTON_SCALE);
        polygon.setFill(this.texture);

        Group group = new Group();
        //Text text = new Text(this.name);
        //text.setFont(Font.font(null, FontWeight.EXTRA_BOLD, 20));
        //text.setFill(Color.ORANGERED);
        //text.setBoundsType(TextBoundsType.VISUAL);

        group.getChildren().addAll(polygon);
        return group;
    }

    /** //TODO: Fix double occurrence
     * generate general pattern
     * @param s
     * @return
     */
    public ImagePattern generatePattern(String s){
        return new ImagePattern(new Image(getClass().getClassLoader().getResource(MyValues.PATH_IMAGE + s).toExternalForm()), 0, 0, 1, 1, true);
    }

}
