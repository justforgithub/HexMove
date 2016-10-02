package sample;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sample.Building.*;
import sample.RectangleButtons.*;
import sample.Terrain.*;
import sample.Unit.*;

import java.util.ArrayList;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane pane = new Pane();
        VBox mainBox = new VBox();


        Board myBoard = new Board(15, 12, new Grassland(null));

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

        myBoard.fillAreaWithcCellContents(new Tuple(10, 0), new Tuple(14, 6), new Swamp(null), null, null);
        myBoard.getCell(11, 0).setTerraBuildUnitGetDraw(new Swamp(null).chooseVariant(1), null, null);
        myBoard.getCell(13, 1).setTerraBuildUnitGetDraw(new Swamp(null).chooseVariant(2), null, null);
        myBoard.getCell(12, 4).setTerraBuildUnitGetDraw(new Swamp(null).chooseVariant(3), null, null);


        for (int x = 0; x < myBoard.boardCells.length; x++) {
            for (int y = 0; y < myBoard.boardCells[0].length; y++) {
                //System.out.println(Integer.toString(x) + " " + Integer.toString(y) +" " + myBoard.boardCells[x][y]);
                pane.getChildren().add(myBoard.boardCells[x][y].drawGroup);
            }
        }

        Button b8 = new Button("Reset energy");
        Button b9 = new Button("Heal attacker");
        Button b10 = new Button("New Turn");

        b9.setOnAction((value) -> {
            hero.energy = hero.getMaxEnergy();
            worker.energy = worker.getMaxEnergy();
            if(myBoard.dummy1 != null){
                myBoard.dummy1.resetEnergy();
                myBoard.dummy1.hexCell.drawObject();
            }
            worker.hexCell.drawObject();
            hero.hexCell.drawObject();
        });


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



        pane.getChildren().add(myBoard.hexMenuGroup);

        HBox hbox = new HBox();

        hbox.getChildren().addAll(b8, b9, b10);


        mainBox.getChildren().addAll(hbox, pane);

        primaryStage.setScene(new Scene(mainBox, 1000, 700));

        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
