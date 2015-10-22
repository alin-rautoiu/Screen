/**
 * Created by Alin on 21/10/2015.
 */
public class Main {
    public static void main(String[] args){
        Screen screen = new Screen(5000,300);
        RectangleBuilder rectangleBuilder = new RectangleBuilder();
        screen.addRectangle(rectangleBuilder
                .height(180)
                .width(90)
                .color("red")
                .coord(90,80)
                .buildRectangle());
        screen.addRectangle(rectangleBuilder
                .height(170)
                .width(50)
                .color("yellow")
                .coord(140,150)
                .buildRectangle());
        screen.addRectangle(rectangleBuilder
                .height(80)
                .width(45)
                .color("blue")
                .coord(300,30)
                .buildRectangle());

        screen.dumpScreen();
        screen.detectIntersection(0,1);
        screen.detectIntersection(1,2);
        screen.clearScreen();
        screen.dumpScreen();
        moveRectangleAcrossScreen(4);

    }

    //Am considerat ca la prin pas se refera la incrementul cu care se deplaseaza dreptunghiul la fiecare unitate de timp
    public static void moveRectangleAcrossScreen(int pace){
        Screen screen = new Screen(100, 100);
        Rectangle rect = new RectangleBuilder()
                .height(10)
                .width(5)
                .buildRectangle();
        screen.addRectangle(rect);

        while(rect.getBottomRightCorner().getX() + pace <= screen.getWidth() ||
                rect.getBottomRightCorner().getY() + pace <= screen.getHeight()){
            if(rect.getBottomRightCorner().getX() + pace > screen.getWidth()){
                rect.updatePos(0, pace);
            } else if (rect.getBottomRightCorner().getY() + pace > screen.getHeight()){
                rect.updatePos(pace, 0);
            } else {
                rect.updatePos(pace, pace);
            }
            System.out.print("(" + rect.getTopLeftCorner().getX() + ", " + rect.getTopLeftCorner().getY() + ") - ");
            System.out.println("(" + rect.getBottomRightCorner().getX() + ", " + rect.getBottomRightCorner().getY() + ")");
        }
    }
}
