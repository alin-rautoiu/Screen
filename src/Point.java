/**
 * Created by Alin on 21/10/2015.
 */
public class Point {
    private int _x;
    private int _y;
    public Point(int x, int y){
        this._x = x;
        this._y = y;
    }
    public Point(){
        this(0,0);
    }

    public int getX(){
        return _x;
    }

    public int getY(){
        return _y;
    }

    public void setX(int x){
        this._x = x;
    }
    public void setY(int y){
        this._y = y;
    }
}
