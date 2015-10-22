import org.w3c.dom.css.Rect;

import java.util.LinkedList;

/**
 * Created by Alin on 21/10/2015.
 */
public class Screen {
    private int _width;
    private int _height;
    private LinkedList<Rectangle> rectangles;

    public Screen(int _width, int _height){
        this._height = _height;
        this._width = _width;
        rectangles = new LinkedList<>();
    }

    public int getWidth(){
        return _width;
    }

    public int getHeight(){
        return _height;
    }

    public void addRectangle(Rectangle rectangle){
        rectangles.add(rectangle);
    }

    public void removeRectangle(Rectangle rectangle){
        rectangles.remove(rectangle);
    }

    public void clearScreen(){
        rectangles = new LinkedList<>();
    }

    public void dumpScreen(){
        if(rectangles.isEmpty()){
            System.out.println("Screen is empty.");
            return;
        }
        for (Rectangle rect : rectangles){
            rect.rectangleInfo();
        }
    }

    public void detectIntersection(int rect1, int rect2){
        if(Rectangle.intersects(rectangles.get(rect1),rectangles.get(rect2))){
            System.out.println("The 2 rectangles intersect.");
        } else {
            System.out.println("The 2 rectangles don't intersect.");
        }
    }

    public void moveRectangle(int rectIndex, int x, int y){
        Rectangle rect = rectangles.get(rectIndex);
        rect.updatePos(new Point(rect.getTopLeftCorner().getX() + x, rect.getTopLeftCorner().getY() + y));
    }
}
