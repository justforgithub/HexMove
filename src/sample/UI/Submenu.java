package sample.UI;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.control.ListView;
import sample.ACellContent;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Deviltech on 04.10.2016.
 */
public class Submenu {

    public boolean isCloseOnClick;
    private List<String> names;
    private SimpleIntegerProperty integerProperty;
    private Group draw;
    private ListView<String> list;

    public Submenu(ACellContent[] cellContents, SimpleIntegerProperty integerProperty){
        this.names = new ArrayList<>();
        for(int i = 0; i <cellContents.length; i++){
            this.names.add(cellContents[i].name);
        }
        this.isCloseOnClick = true;
        this.integerProperty = integerProperty;
        this.draw = new Group();
        this.list = new ListView<String>();
        drawObject();

    }

    public Submenu(String[] names, SimpleIntegerProperty integerProperty){
        this.isCloseOnClick = true;
        this.names = new ArrayList<>();
        for (String s: names){
            this.names.add(s);
        }
        this.isCloseOnClick = true;
        this.integerProperty = integerProperty;
        this.draw = new Group();
        this.list = new ListView<String>();
        drawObject();
    }

    public void addItem(String s){
        names.add(s);
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

    /**
     * Set list size, catch nullpointer
     * @param height
     * @param width
     */
    public Submenu choosePrefSize(Double height, Double width){
        if(height != null){
            list.setPrefHeight(height);
        }
        if(width != null){
            list.setPrefWidth(width);
        }
        return this;
    }

    public Submenu chooseSelection(int i){
        if(list != null){
            list.getSelectionModel().select(i);
        }
        return this;
    }

    public SimpleIntegerProperty getIntegerProperty(){
        return integerProperty;
    }

    public void closeSubMenu(){
        this.list = null;
        this.draw.getChildren().clear();
    }

    /**
     * get size, catch nullpointer
     * @return
     */
    public int getSize(){
        if(list != null){
            return list.getItems().size();
        } else {
            return 0;
        }
    }


    public Group drawObject() {
        // Unit
        draw.getChildren().clear();
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
