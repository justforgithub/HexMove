package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import sample.Action.Attack;
import sample.Action.FindResources;
import sample.Building.*;
import sample.Resources.Food;
import sample.Terrain.*;
import sample.Unit.*;

import java.util.ArrayList;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane pane = new Pane();
        VBox mainBox = new VBox();


        Board myBoard = new Board(12,12, new Grassland(null));

        myBoard.getCell(0, 0).setTerraBuildUnitGetDraw(new Forest(null), new Barracks(null), null);

        myBoard.getCell(1, 1).setTerraBuildUnitGetDraw(new HQBackground(null), new HeadQuarter(null), null);

        myBoard.getCell(0, 3).setTerraBuildUnitGetDraw(new Water(null), null, null);
        myBoard.getCell(0, 4).setTerraBuildUnitGetDraw(new DeepWater(null), null, null);
        myBoard.getCell(1, 4).setTerraBuildUnitGetDraw(new Water(null), null, null);
        myBoard.getCell(0, 5).setTerraBuildUnitGetDraw(new Water(null), new FoodBerries(null, 12), null);
        myBoard.getCell(1, 5).setTerraBuildUnitGetDraw(new Water(null), null, null);
        myBoard.getCell(1, 3).setTerraBuildUnitGetDraw(new Water(null), null, null);
        myBoard.getCell(2, 4).setTerraBuildUnitGetDraw(new Water(null), null, null);
        myBoard.getCell(3, 4).setTerraBuildUnitGetDraw(new Water(null), null, null);
        myBoard.getCell(2, 1).setTerraBuildUnitGetDraw(new Forest(null), new FoodBerries(null, 20), null);
        myBoard.getCell(2, 0).setTerraBuildUnitGetDraw(new Forest(null), new WoodPile(null, 30), null);
        myBoard.getCell(6, 0).setTerraBuildUnitGetDraw(new Forest(null), new WoodPile(null, 28), null);
        myBoard.getCell(7, 0).setTerraBuildUnitGetDraw(new Forest(null), null, null);
        myBoard.getCell(6, 1).setTerraBuildUnitGetDraw(new Forest(null), null, null);
        myBoard.getCell(5, 0).setTerraBuildUnitGetDraw(new Forest(null), null, null);
        myBoard.getCell(7, 1).setTerraBuildUnitGetDraw(new Forest(null), new WoodPile(null, 31), null);
        myBoard.getCell(7, 4).setTerraBuildUnitGetDraw(new Forest(null), new WoodPile(null, 29), null);
        myBoard.getCell(7, 3).setTerraBuildUnitGetDraw(new Hill(null), null, null);
        myBoard.getCell(3, 0).setTerraBuildUnitGetDraw(new Hill(null), null, null);
        myBoard.getCell(1, 2).setTerraBuildUnitGetDraw(new Hill(null), null, null);

        Catapult catapult = new Catapult(null);
        myBoard.getCell(5, 5).setTerraBuildUnitGetDraw(null, null, catapult);

        Scout scout = new Scout(null);
        myBoard.getCell(5, 4).setTerraBuildUnitGetDraw(null, null, new Scout(null));

        Swordsman sword2 = new Swordsman(null);
        myBoard.getCell(6, 4).setTerraBuildUnitGetDraw(null, null, sword2);

        Archer archer2 = new Archer(null);
        myBoard.getCell(6, 5).setTerraBuildUnitGetDraw(null, null, archer2);

        Worker worker2 = new Worker(null);
        myBoard.getCell(5, 3).setTerraBuildUnitGetDraw(null, null, worker2);


        Archer archer = new Archer(null);
        Swordsman sword = new Swordsman(null);

        myBoard.getCell(4, 1).setTerraBuildUnitGetDraw(null, new Barracks(null), sword);
        myBoard.getCell(5, 0).setTerraBuildUnitGetDraw(null, null, archer);


        Worker hero =  new Worker(null);
        myBoard.getCell(0, 2).setTerraBuildUnitGetDraw(null, new Hut(null), hero);
        myBoard.getCell(2, 2).setTerraBuildUnitGetDraw(new Grassland(null),null, new Worker(null));
        myBoard.getCell(4, 4).setTerraBuildUnitGetDraw(null, new FoodBerries(null, 54), null);
        myBoard.getCell(3, 2).setTerraBuildUnitGetDraw(new Hill(null), null, null);
        myBoard.getCell(3, 3).setTerraBuildUnitGetDraw(new Hill(null), null, null);
        myBoard.getCell(4, 2).setTerraBuildUnitGetDraw(null, new OreRocks(null, 12), null);
        myBoard.getCell(4, 3).setTerraBuildUnitGetDraw(new Hill(null), new OreRocks(null, 20), null);
        myBoard.getCell(1, 6).setTerraBuildUnitGetDraw(null, new FoodBerries(null, 60), null);
        myBoard.getCell(4, 0).setTerraBuildUnitGetDraw(new Hill(null), null,null);

        Worker worker = new Worker(null);
        myBoard.getCell(2, 3).setTerraBuildUnitGetDraw(null, new FoodBerries(null, 15), worker);


        for(int x = 0; x<myBoard.boardCells.length; x++){
            for (int y = 0; y < myBoard.boardCells[0].length; y++){
                //System.out.println(Integer.toString(x) + " " + Integer.toString(y) +" " + myBoard.boardCells[x][y]);
               pane.getChildren().add(myBoard.boardCells[x][y].drawGroup);
            }
        }



        Button b1 = new Button("Reset Energy");
        Button b2 = new Button("Go to Food");
        Button b3 = new Button("Find Food");
        Button b4 = new Button("bring back food");
        Button b5 = new Button("find Storage");
        Button b6 = new Button("Attk Range");
        Button b7 = new Button("Def Range");
        Button b8 = new Button("Attack!");
        Button b9 = new Button("Heal attacker");

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
            if(myBoard.dummy1 != null && myBoard.dummy1.getUnit() != null){
                ArrayList<HexCell> attcells = myBoard.dummy1.getUnit().getAttackCells();
                myBoard.deselectAllCells();
                for(HexCell x: attcells){
                    x.setSelected(3);
                }
            }
        });

        b7.setOnAction((value)-> {
            if(myBoard.dummy2 != null && myBoard.dummy2.getUnit() != null){
                ArrayList<HexCell> attcells = myBoard.dummy2.getUnit().getAttackCells();
                myBoard.deselectAllCells();
                for(HexCell x: attcells){
                    x.setSelected(3);
                }
            }
        });

        b8.setOnAction((value)-> {
            if(myBoard.dummy1 != null && myBoard.dummy2 != null) {
                System.out.println("try to attack");
                new Attack(myBoard.dummy1.getUnit(), myBoard.dummy2.getUnit()).execute();
                myBoard.dummy1.drawObject();
                myBoard.dummy2.drawObject();
            }
        });

        b9.setOnAction((value)->{
            if(myBoard.dummy1.getUnit() != null){
                myBoard.dummy1.getUnit().resetHealth();
                myBoard.dummy1.drawObject();
            }
        });



        HBox hbox = new HBox();

        hbox.getChildren().addAll(b1, b2, b3, b4, b5, b6, b7, b8, b9);

        HBox textHBox = new HBox();
        textHBox.getChildren().addAll(myBoard.attText, myBoard.defText);


        mainBox.getChildren().addAll(hbox, textHBox, pane);

        primaryStage.setScene(new Scene(mainBox, 600, 600));

        primaryStage.show();
    }



    public static void main(String[] args) {
        launch(args);
    }
}
