package sample;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import sample.Action.Attack;
import sample.Action.FindResources;
import sample.Building.*;
import sample.RectangleButtons.*;
import sample.Resources.Food;
import sample.Resources.Wood;
import sample.Terrain.*;
import sample.Unit.*;

import java.util.ArrayList;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane pane = new Pane();
        VBox mainBox = new VBox();


        Board myBoard = new Board(12, 12, new Grassland(null));

        Faction whiteFaction = new Faction(0);
        Faction redFaction = new Faction(1);
        Faction greenFaction = new Faction(2);
        Faction blueFaction = new Faction(1);
        Faction bunnyFaction = new Faction(2);

        myBoard.getCell(0, 0).setTerraBuildUnitGetDraw(new Forest(null), new Barracks(blueFaction, null), null);

        myBoard.getCell(1, 1).setTerraBuildUnitGetDraw(new HQBackground(null), new HeadQuarter(blueFaction, null), new Worker(blueFaction, null));

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
        myBoard.getCell(7, 0).setTerraBuildUnitGetDraw(new Forest(null), null, new Catapult(bunnyFaction, null));
        myBoard.getCell(6, 1).setTerraBuildUnitGetDraw(new Forest(null), null, null);
        myBoard.getCell(5, 0).setTerraBuildUnitGetDraw(new Forest(null), null, null);
        myBoard.getCell(7, 1).setTerraBuildUnitGetDraw(new Forest(null), new WoodPile(null, 31), null);
        myBoard.getCell(7, 4).setTerraBuildUnitGetDraw(new Forest(null), new WoodPile(null, 29), null);
        myBoard.getCell(7, 3).setTerraBuildUnitGetDraw(new Hill(null), new Quarry(blueFaction, null), null);
        myBoard.getCell(3, 0).setTerraBuildUnitGetDraw(new Hill(null), null, null);
        myBoard.getCell(1, 2).setTerraBuildUnitGetDraw(new Hill(null), null, null);
        myBoard.getCell(6, 2).setTerraBuildUnitGetDraw(new Forest(null), new Lumberjack(blueFaction, null), null);

        Catapult catapult = new Catapult(redFaction, null);
        myBoard.getCell(5, 5).setTerraBuildUnitGetDraw(null, null, catapult);

        Scout scout = new Scout(blueFaction, null);
        myBoard.getCell(5, 4).setTerraBuildUnitGetDraw(null, null, new Scout(blueFaction, null));

        Swordsman sword2 = new Swordsman(redFaction, null);
        myBoard.getCell(6, 4).setTerraBuildUnitGetDraw(null, null, sword2);

        Archer archer2 = new Archer(redFaction, null);
        myBoard.getCell(6, 5).setTerraBuildUnitGetDraw(null, null, archer2);

        Worker worker2 = new Worker(blueFaction, null);
        myBoard.getCell(5, 3).setTerraBuildUnitGetDraw(null, null, worker2);


        Archer archer = new Archer(blueFaction, null);
        Swordsman sword = new Swordsman(blueFaction, null);

        myBoard.getCell(4, 1).setTerraBuildUnitGetDraw(null, new Barracks(blueFaction, null), sword);
        myBoard.getCell(5, 0).setTerraBuildUnitGetDraw(null, null, archer);


        Worker hero = new Worker(blueFaction, null);
        myBoard.getCell(0, 2).setTerraBuildUnitGetDraw(null, new Hut(blueFaction, null), hero);
        myBoard.getCell(2, 2).setTerraBuildUnitGetDraw(new Grassland(null), null, null);
        myBoard.getCell(4, 4).setTerraBuildUnitGetDraw(null, new FoodBerries(null, 54), null);
        myBoard.getCell(3, 2).setTerraBuildUnitGetDraw(new Hill(null), null, null);
        myBoard.getCell(3, 3).setTerraBuildUnitGetDraw(new Hill(null), null, null);
        myBoard.getCell(4, 2).setTerraBuildUnitGetDraw(null, new OreRocks(null, 12), null);
        myBoard.getCell(4, 3).setTerraBuildUnitGetDraw(new Hill(null), new OreRocks(null, 20), null);
        myBoard.getCell(1, 6).setTerraBuildUnitGetDraw(null, new FoodBerries(null, 60), null);
        myBoard.getCell(4, 0).setTerraBuildUnitGetDraw(new Hill(null), null, null);

        myBoard.getCell(8, 0).setTerraBuildUnitGetDraw(null, new Barracks(bunnyFaction, null), new Swordsman(bunnyFaction, null));
        myBoard.getCell(9, 1).setTerraBuildUnitGetDraw(new HQBackground(null), new HeadQuarter(bunnyFaction, null), new Archer(bunnyFaction, null));
        myBoard.getCell(9, 2).setTerraBuildUnitGetDraw(null, new Hut(bunnyFaction, null), new Worker(bunnyFaction, null));
        myBoard.getCell(9, 3).setTerraBuildUnitGetDraw(null, new FoodBerries(null, 10), new Worker(bunnyFaction, null));
        myBoard.getCell(8, 2).setTerraBuildUnitGetDraw(new Hill(null), null, new Scout(bunnyFaction, null));
        myBoard.getCell(0, 6).setTerraBuildUnitGetDraw(null, new Farm(blueFaction, null), null);

        ConstructionSite construct = new ConstructionSite(blueFaction, new Hut(blueFaction, null), null);
        myBoard.getCell(3, 5).setTerraBuildUnitGetDraw(null, construct, null);

        Worker worker = new Worker(blueFaction, null);
        myBoard.getCell(2, 3).setTerraBuildUnitGetDraw(null, new FoodBerries(null, 15), worker);


        for (int x = 0; x < myBoard.boardCells.length; x++) {
            for (int y = 0; y < myBoard.boardCells[0].length; y++) {
                //System.out.println(Integer.toString(x) + " " + Integer.toString(y) +" " + myBoard.boardCells[x][y]);
                pane.getChildren().add(myBoard.boardCells[x][y].drawGroup);
            }
        }


        Button b1 = new Button("Reset Energy");
        Button b2 = new Button("Go to Wood");
        Button b3 = new Button("Find Wood");
        Button b4 = new Button("bring back Wood");
        Button b5 = new Button("find Storage");
        Button b6 = new Button("Attk Range");
        Button b7 = new Button("UI button");
        Button b8 = new Button("Attack!");
        Button b9 = new Button("Heal attacker");
        Button b10 = new Button("New Turn");
        Button b11 = new Button("Brightness");

        /*
        FindResources strategy = new FindResources(hero, new WoodPile(null, 10), false, null);
        strategy.setFindMost(100);
        strategy.prepareActions();

        FindResources bringHomeStrategy = new FindResources(hero, new ConstructionSite(blueFaction, new Barracks(null, null), null), true, new Wood(0));
        bringHomeStrategy.setFindNearest(100);
        bringHomeStrategy.prepareActions();
        */

        b1.setOnAction((value) -> {
            hero.energy = hero.getMaxEnergy();
            worker.energy = worker.getMaxEnergy();
            if(myBoard.dummy1 != null){
                myBoard.dummy1.resetEnergy();
                myBoard.dummy1.hexCell.drawObject();
            }
            worker.hexCell.drawObject();
            hero.hexCell.drawObject();
        });

        /*
        b2.setOnAction((value) -> {
            strategy.execute();
        });

        b3.setOnAction((value) -> {
            strategy.prepareActions();
        });

        b4.setOnAction((value) -> {
            bringHomeStrategy.execute();
        });

        b5.setOnAction((value) -> {
            bringHomeStrategy.prepareActions();
        });
        */

        b2.setDisable(true);
        b3.setDisable(true);
        b4.setDisable(true);
        b5.setDisable(true);

        b6.setOnAction((value) -> {
            if (myBoard.dummy1 != null && myBoard.dummy1 != null) {
                ArrayList<HexCell> attcells = myBoard.dummy1.getAttackCells();
                myBoard.deselectAllCells();
                for (HexCell x : attcells) {
                    x.setSelected(1);
                }
            }
        });

        b7.setOnAction((value) -> {
            if(myBoard.dummy1 != null) {
                Group g = myBoard.dummy1.hexCell.drawGroup;
                HexagonMenu men = myBoard.dummy1.generateHexagonMenu();

                Group g2 = men.drawObject();
                g2.setTranslateX(g.getTranslateX());
                g2.setTranslateY(g.getTranslateY());
                pane.getChildren().add(g2);
            }
        });

        /*
        b8.setOnAction((value) -> {
            if (myBoard.dummy1 != null && myBoard.dummy2 != null) {
                System.out.println("try to attack");
                new Attack(myBoard.dummy1, myBoard.dummy2.getUnit()).execute();
                myBoard.dummy1.drawObject();
                myBoard.dummy2.drawObject();
            }
        });
         */

        b8.setDisable(true);

        b9.setOnAction((value) -> {
            if (myBoard.dummy1 != null) {
                myBoard.dummy1.resetHealth();
                myBoard.dummy1.hexCell.drawObject();
            }
        });

        b10.setOnAction((value) -> {
            for (int x = 0; x < myBoard.boardCells.length; x++) {
                for (int y = 0; y < myBoard.boardCells[0].length; y++) {
                    myBoard.boardCells[x][y].executeNewTurn();
                }
                myBoard.deselectAllCells();
                if(myBoard.dummy1 != null) {
                    myBoard.dummy1.isSelected.set(false);
                    myBoard.dummy1 = null;
                }
            }
        });

        b11.setOnAction((value) -> {
            hero.isSelected.set(!hero.isSelected.get());
            double hor = 30;
            double dia = 35;
            ArrayList<HexCell> cells = myBoard.findAllCellsInRange(myBoard.getCell(0, 2), 8);
            myBoard.deselectAllCells();
            for(HexCell c: cells){
                c.setSelected(true);
            }
            }
        );


        pane.getChildren().add(myBoard.hexMenuGroup);

        HBox hbox = new HBox();

        hbox.getChildren().addAll(b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11);

        HBox textHBox = new HBox();
        textHBox.getChildren().addAll(myBoard.attText, myBoard.defText);


        mainBox.getChildren().addAll(hbox, textHBox, pane);

        primaryStage.setScene(new Scene(mainBox, 800, 600));

        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
