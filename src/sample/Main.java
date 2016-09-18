package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sample.Action.Harvest;
import sample.Action.Move;
import sample.Building.*;
import sample.Terrain.*;
import sample.Unit.Worker;

import java.util.ArrayList;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane pane = new Pane();
        VBox mainBox = new VBox();

        Board myBoard = new Board(8,8, new Grassland(null));

        myBoard.getCell(0, 0).setTerraBuildUnitGetDraw(new Forest(null), new Barracks(null), null);

        myBoard.getCell(1, 1).setTerraBuildUnitGetDraw(new HQBackground(null), new HeadQuarter(null), null);

        myBoard.getCell(0, 3).setTerraBuildUnitGetDraw(new Water(null), null, null);
        myBoard.getCell(0, 4).setTerraBuildUnitGetDraw(new Water(null), null, null);
        myBoard.getCell(1, 3).setTerraBuildUnitGetDraw(new Water(null), null, null);
        myBoard.getCell(2, 4).setTerraBuildUnitGetDraw(new Water(null), null, null);
        myBoard.getCell(2, 1).setTerraBuildUnitGetDraw(new Forest(null), new FoodBerries(null, 20), null);
        myBoard.getCell(2, 0).setTerraBuildUnitGetDraw(new Forest(null), new WoodPile(null, 30), null);
        myBoard.getCell(3, 0).setTerraBuildUnitGetDraw(new Hill(null), null, null);
        myBoard.getCell(1, 2).setTerraBuildUnitGetDraw(new Hill(null), null, null);
        myBoard.getCell(0, 2).setTerraBuildUnitGetDraw(null, new Hut(null), new Worker(null));
        myBoard.getCell(2, 2).setTerraBuildUnitGetDraw(new Grassland(null), new Barracks(null), new Worker(null));
        myBoard.getCell(4, 4).setTerraBuildUnitGetDraw(null, new FoodBerries(null, 54), null);
        myBoard.getCell(3, 2).setTerraBuildUnitGetDraw(new Hill(null), null, null);
        myBoard.getCell(3, 3).setTerraBuildUnitGetDraw(new Hill(null), new Barracks(null), null);
        myBoard.getCell(4, 2).setTerraBuildUnitGetDraw(null, new OreRocks(null, 12), null);
        myBoard.getCell(4, 3).setTerraBuildUnitGetDraw(new Hill(null), new OreRocks(null, 20), null);
        myBoard.getCell(0, 5).setTerraBuildUnitGetDraw(null, new FoodBerries(null, 33), null);
        myBoard.getCell(4, 0).setTerraBuildUnitGetDraw(new Hill(null), new Hut(null), new Worker(null));

        Worker worker = new Worker(null);
        myBoard.getCell(2, 3).setTerraBuildUnitGetDraw(null, new FoodBerries(null, 15), worker);

        worker.texture = MyValues.IMAGE_WORKER_ACTION;
        worker.drawObject();

        Worker hero = (Worker) myBoard.getCell(0,2).unit;

        for(int x = 0; x<myBoard.boardCells.length; x++){
            for (int y = 0; y < myBoard.boardCells[0].length; y++){
                //System.out.println(Integer.toString(x) + " " + Integer.toString(y) +" " + myBoard.boardCells[x][y]);
               pane.getChildren().add(myBoard.boardCells[x][y].drawGroup);
            }
        }


        ArrayList<Path> p = myBoard.findResources(hero.hexCell, new FoodBerries(null, 15), 30);
        //for(Path x:  p){
        //    x.setSelected(true);
        //}
        p.get(2).setSelected(true);

        Button b1 = new Button("Move");
        Button b2 = new Button("Reset Energy");
        Button b3 = new Button("harvest");

        b1.setOnAction((value)->{
            new Move(hero, p.get(2)).excute();
            myBoard.deselectAllCells();
            p.get(2).setSelected(true);
        });

        b2.setOnAction((value) -> {
            hero.energy = hero.getMaxEnergy();
            worker.energy = worker.getMaxEnergy();
            worker.hexCell.drawObject();
        });

        b3.setOnAction((value)->{
            new Harvest(hero, hero.hexCell).execute();
        });

        HBox hbox = new HBox();

        hbox.getChildren().addAll(b1, b2, b3);

        mainBox.getChildren().addAll(hbox, pane);

        primaryStage.setScene(new Scene(mainBox, 400, 400));

        primaryStage.show();
    }



    public static void main(String[] args) {
        launch(args);
    }
}
