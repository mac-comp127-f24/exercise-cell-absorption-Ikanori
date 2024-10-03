package cellabsorption;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.Ellipse;
import edu.macalester.graphics.Point;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@SuppressWarnings("SameParameterValue")
public class CellSimulation {
    private CanvasWindow canvas;
    private List<Cell> cells;
    private Random rand = new Random();



    public static void main(String[] args) {
        new CellSimulation();
    }

    public CellSimulation() {
        canvas = new CanvasWindow("Cell Absorption", 800, 800);
        populateCells();

        //noinspection InfiniteLoopStatement
        while (true) {
            for(Cell i: cells){
            Point canvasCenter = new Point(canvas.getWidth() / 2.0, canvas.getHeight() / 2.0);
            i.moveAround(canvasCenter);
            i.grow(0.02);
            }

            canvas.draw();
            canvas.pause(10);
        }
    }

    private void populateCells() {
        double size = rand.nextInt(5) + 2;
        cells = new ArrayList<Cell>();
        for(int i = 0; i <200; i++){
        cells.add(new Cell( rand.nextDouble() * (canvas.getWidth() - size),
            rand.nextDouble() * (canvas.getWidth() - size),
            size,
            Color.getHSBColor(rand.nextFloat(), rand.nextFloat() * 0.5f + 0.1f, 1)));
        canvas.add(cells.get(i).getShape());
        }
    }

}
