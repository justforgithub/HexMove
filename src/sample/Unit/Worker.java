package sample.Unit;

import javafx.scene.Group;
import javafx.scene.text.Text;
import sample.MyValues;

/**
 * Created by Deviltech on 07.09.2016.
 */
public class Worker extends AUnit {

    public Worker() {
        this.name = MyValues.NAMES_WORKER;
        this.texture = MyValues.IMAGE_WORKER;
        this.draw = new Group();

        this.energy = 10;
    }

    @Override
    public Group drawObject() {
        draw.getChildren().clear();
        draw.getChildren().addAll(generateRectangle());
        return draw;
    }
}
