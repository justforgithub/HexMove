package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import sample.Building.Hut;
import sample.Terrain.Forest;
import sample.Terrain.Grassland;
import sample.Terrain.Hill;
import sample.Terrain.Water;
import sample.Unit.Worker;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane pane = new Pane();

        Board myBoard = new Board(8,8, new Grassland());

        myBoard.getCell(0, 3).setTerraBuildUnitGetDraw(new Water(), null, null);
        myBoard.getCell(2, 1).setTerraBuildUnitGetDraw(new Forest(), null, null);
        myBoard.getCell(2, 0).setTerraBuildUnitGetDraw(new Forest(), null, null);
        myBoard.getCell(1, 2).setTerraBuildUnitGetDraw(new Grassland(), new Hut(), null);
        myBoard.getCell(0, 1).setTerraBuildUnitGetDraw(new Grassland(), null, new Worker());
        myBoard.getCell(3, 3).setTerraBuildUnitGetDraw(new Hill(), null, null);

        for(int x = 0; x<myBoard.boardCells.length; x++){
            for (int y = 0; y < myBoard.boardCells[0].length; y++){
                //System.out.println(Integer.toString(x) + " " + Integer.toString(y) +" " + myBoard.boardCells[x][y]);
               pane.getChildren().add(myBoard.boardCells[x][y].drawGroup);
            }
        }

        primaryStage.setScene(new Scene(pane, 400, 400));

        primaryStage.show();
    }



    public static void main(String[] args) {
        launch(args);
    }
}
