package sample.RectangleButtons;

import javafx.scene.Group;
import sample.DoubleTuple;
import sample.MyMath;
import sample.MyValues;

/**
 * Created by Deviltech on 28.09.2016.
 */
public class RectangleMenu {

    private AButton[] buttonArray = new AButton[6];

    public void setButton(AButton button, int pos){
        buttonArray[pos%buttonArray.length] = button;
    }

    public Group drawObject(){
        double hor = MyValues.HEX_HORIZONTAL_VALUE * MyValues.HEX_SCALE + MyValues.HEX_STROKE_WIDTH * 0.4;
        double dia = MyValues.HEX_DIAGONAL_VALUE * MyValues.HEX_SCALE + MyValues.HEX_STROKE_WIDTH * 0.4;
        Group group = new Group();
        for(int i = 0; i < buttonArray.length; i++){
            if(buttonArray[i] != null){
                Group currentGroup = buttonArray[i].drawObject();
                DoubleTuple tup = MyMath.calculatePositionCoords(hor, dia, MyValues.HEX_POSITION.values()[i%MyValues.HEX_POSITION.values().length]);

                currentGroup.setTranslateX(currentGroup.getTranslateX() + tup.getX());
                currentGroup.setTranslateY(currentGroup.getTranslateY() + tup.getY());
                group.getChildren().addAll(currentGroup);
            }
        }
        return group;
    };
}
