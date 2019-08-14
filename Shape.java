/*********************************************************************************
 *                      The Breakout game that I call OutBreak                   *
 *                      Final Project                                            *
 *                      Programmed by Blake Lawall                               *
 *                      12-2-17                                                  *
 *                      Class CS200                                              *
 *                      Instructor Christopher Harris                            *
 *                                                                               *
 *                      This program was originally created in                   *
 *                      1976. It is a game where you try to get                  *
 *                      rid of all the bricks by hitting them with               *
 *                      a ball.                                                  *
 *********************************************************************************/
/*****************************************
 * Class that all my other classes       *
 * Inherit from. It is an Abstract class *
 *****************************************/

public abstract class Shape {
    /************************************
     * Shared Attributes                *
     ************************************/
    protected double x;
    protected double y;
    protected int width;
    protected int height;
    /************************************
     * Methed to set location           *
     ************************************/
    public void setLocation(double x, double y){
        setX(x);
        setY(y);
    }
    /************************************
     * Constructors                     *
     ************************************/
    public Shape(double x, double y){
        this.x = x;
        this.y = y;
    }
    /************************************
     * Getters and Setters              *
     ************************************/
    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
