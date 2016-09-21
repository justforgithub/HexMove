package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sample.Action.FindResources;
import sample.Action.Harvest;
import sample.Action.Move;
import sample.Building.*;
import sample.Resources.Food;
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
        myBoard.getCell(0, 5).setTerraBuildUnitGetDraw(null, new FoodBerries(null, 60), null);
        myBoard.getCell(4, 0).setTerraBuildUnitGetDraw(new Hill(null), new Hut(null),null);

        Worker worker = new Worker(null);
        myBoard.getCell(2, 3).setTerraBuildUnitGetDraw(null, new FoodBerries(null, 15), worker);

        Worker hero = (Worker) myBoard.getCell(0,2).unit;

        for(int x = 0; x<myBoard.boardCells.length; x++){
            for (int y = 0; y < myBoard.boardCells[0].length; y++){
                //System.out.println(Integer.toString(x) + " " + Integer.toString(y) +" " + myBoard.boardCells[x][y]);
               pane.getChildren().add(myBoard.boardCells[x][y].drawGroup);
            }
        }



        Button b1 = new Button("Reset Energy");
        Button b2 = new Button("Go to Food");
        Button b3 = new Button("Find Food");
        Button b4 = new Button("Go to Storage");
        Button b5 = new Button("bring back Food");
        Button b6 = new Button("AttackRange");

        FindResources strategy = new FindResources(hero, new FoodBerries(null, 10), false, null);
        strategy.setFindMost(100);
        strategy.prepareActions();

        FindResources bringHomeStrategy = new FindResources(hero, new Hut(null), true, new Food(0));
        bringHomeStrategy.setFindFastest(100);
        bringHomeStrategy.prepareActions();

        b1.setOnAction((value) -> {
            hero.energy = hero.getMaxEnergy();
            worker.energy = worker.getMaxEnergy();
            worker.hexCell.drawObject();
            hero.hexCell.drawObject();
        });

        b2.setOnAction((value)->{
            strategy.execute();
        });

        b3.setOnAction((value)->{
            strategy.prepareActions();
        });

        b4.setOnAction((value)->{
            bringHomeStrategy.execute();
        });

        b5.setOnAction((value) -> {
            bringHomeStrategy.prepareActions();
        });

        b6.setOnAction((value)-> {
            ArrayList<HexCell> attcells = hero.getAttackCells();
            for(HexCell x: attcells){
                x.setSelected(3);
            }
        });

        //b4.setDisable(true);
        //b5.setDisable(true);







        HBox hbox = new HBox();

        hbox.getChildren().addAll(b1, b2, b3, b4, b5, b6);

        mainBox.getChildren().addAll(hbox, pane);

        primaryStage.setScene(new Scene(mainBox, 400, 400));

        primaryStage.show();
    }



    public static void main(String[] args) {
        launch(args);
    }
}
