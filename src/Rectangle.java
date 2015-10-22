import com.sun.javafx.binding.StringFormatter;
import org.w3c.dom.css.Rect;

import java.awt.*;
import java.util.Formatter;

/**
 * Created by Alin on 21/10/2015.
 */
class RectangleBuilder {
    private int _height = 25;
    private int _width = 25;
    private Point _coord = new Point();
    private String _color = "red";

    public RectangleBuilder() {}

    public Rectangle buildRectangle(){
        return new Rectangle(_height, _width, _coord, _color);
    }

    public RectangleBuilder height(int height){
        this._height = height;
        return this;
    }

    public RectangleBuilder width(int width){
        this._width = width;
        return this;
    }

    public RectangleBuilder coord(Point coord){
        this._coord = coord;
        return this;
    }

    public RectangleBuilder coord(int x, int y){
        this._coord = new Point(x, y);
        return this;
    }

    public RectangleBuilder color(String color){
        this._color = color;
        return this;
    }
}

public class Rectangle{
    private int _height;
    private int _width;
    private Point _coord;
    private String _color;

    public Rectangle(int _height, int _width, Point _coord, String color){
        this._height = _height;
        this._width = _width;
        this._coord = _coord;
        this._color = color;
    }

    public Point getTopLeftCorner(){
        return _coord;
    }

    public Point getBottomRightCorner(){
        return new Point(_coord.getX() + _width, _coord.getY() + _height);
    }

    public void updatePos(Point newPos){
        this._coord = newPos;
    }

    public void updatePos(int x, int y){
        updatePos(new Point(_coord.getX() + x, _coord.getY() + y));
    }

    //Nu-mi place asa mult ideea de functie care afiseaza in cadrul lui Rectangle.
    //Mai degraba as fi avut niste gettere care sa ii expuna proprietatile
    public void rectangleInfo(){
        StringBuilder output = new StringBuilder();
        Formatter formater = new Formatter(output);
        formater.format("%1$s, %2$d x %3$d, (%4$d, %5$d)", _color, _height, _width,
                _coord.getX(), _coord.getY());
        System.out.println(formater.toString());
    }

    public static boolean containsPoint(Rectangle rect, Point point){
        return rect._coord.getY() <= point.getY() && rect._coord.getY() + rect._height >= point.getY()
                && rect._coord.getX() <= point.getX() && rect._coord.getX() + rect._width >= point.getX();
    }

    public static boolean intersects(Rectangle rect1, Rectangle rect2){

        return Rectangle.containsPoint(rect1, rect2._coord)
                ||Rectangle.containsPoint(rect1, new Point(rect2._coord.getX() + rect2._width,
                rect2._coord.getY() + rect2._height))
                || Rectangle.containsPoint(rect1, new Point(rect2._coord.getX(), rect2._coord.getY() + rect2._height))
                || Rectangle.containsPoint(rect1, new Point(rect2._coord.getX() + rect2._width, rect2._coord.getY()));
    }

    public static boolean contains(Rectangle rect1, Rectangle rect2){

        return Rectangle.containsPoint(rect1, rect2._coord) && Rectangle.containsPoint(rect1,
                new Point(rect2._coord.getX() + rect2._width, rect2._coord.getY() + rect2._height)) ||
                Rectangle.containsPoint(rect2, rect1._coord) && Rectangle.containsPoint(rect2,
                        new Point(rect1._coord.getX() + rect1._width, rect1._coord.getY() + rect1._height));
    }

}
