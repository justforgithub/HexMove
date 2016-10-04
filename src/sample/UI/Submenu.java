package sample.UI;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.control.ListView;
import sample.ACellContent;


/**
 * Created by Deviltech on 04.10.2016.
 */
public class Submenu {

    public boolean isCloseOnClick;
    private String[] names;
    private SimpleIntegerProperty integerProperty;
    private Group draw;
    private ListView<String> list;

    public Submenu(ACellContent[] cellContents, SimpleIntegerProperty integerProperty){
        this.names = new String[cellContents.length];
        for(int i = 0; i <this.names.length; i++){
            this.names[i] = cellContents[i].name;
        }
        this.isCloseOnClick = true;
        this.integerProperty = integerProperty;
        this.draw = new Group();
        drawObject();

    }

    public Submenu(String[] names, SimpleIntegerProperty integerProperty){
        this.isCloseOnClick = true;
        this.names = names;
        this.integerProperty = integerProperty;
        this.draw = new Group();
        drawObject();
    }

    public Submenu chooseCloseOnClick(boolean b){
        this.isCloseOnClick = b;
        return this;
    }

    public int getSelectedIndex(){
        if(list != null){
            return list.getSelectionModel().getSelectedIndex();
        } else
            return -1;
    }

    public Group getDraw(){
        return draw;
    }

    public SimpleIntegerProperty getIntegerProperty(){
        return integerProperty;
    }

    public void closeSubMenu(){
        this.list = null;
        this.draw.getChildren().clear();
    }


    public Group drawObject() {
        // Unit
        draw.getChildren().clear();
        list = new ListView<String>();
        ObservableList<String> items = FXCollections.observableArrayList();
        for (String s : names) {
            items.add(s);
        }
        list.setItems(items);
        list.getSelectionModel().selectedItemProperty().addListener(
                ((observable, oldValue, newValue) -> {
                    // if property is empty, create new one
                    if(integerProperty == null) {
                        integerProperty = new SimpleIntegerProperty();
                    }
                    integerProperty.set(getSelectedIndex());
                    if(isCloseOnClick){
                        closeSubMenu();
                    }
                }));
        draw.getChildren().addAll(list);
        return draw;
    }
}
