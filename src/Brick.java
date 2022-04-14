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
/************************************
 * Brick class to give an instance *
 * of a Brick                      *
 ************************************/

import java.awt.*;

public class Brick extends Shape implements Shared {
    /**************************************
     * These private attributes are       *
     * examples of encapsulation          *
     * along with the getters and setters *
     **************************************/
    private int w = BRICK_WIDTH;
    private int h = BRICK_HEIGHT;
    private Color color;
    private boolean fill = false;
    private boolean isHit = false;
    private int id = 0;
    private int value = 10;
    private String label = "";
    /************************************
     * Constructors                     *
     ************************************/
    public Brick(double x, double y) {
        super(x, y);
        this.color = Color.BLACK;
    }
    /************************************
     * Tells how to build a brick       *
     ************************************/
    public void paint(Graphics2D g){
        g.setColor(this.color);
        g.drawRect((int) x, (int) y, w, h);
        g.drawString( label, (int) (x + 2),  (int)( y + 15 ));
        g.setColor(Color.BLACK);
    }
    /************************************
     * Check to see if Ball collided    *
     * Brick.                           *
     ************************************/
    public boolean getCollidingObject(Ball ball) {
        if((getY() < ball.getY() + BALL_RADIUS && ball.getY() + BALL_RADIUS < (getY() + BRICK_HEIGHT)) &&
                ( getX() < ball.getX() + BALL_RADIUS && ball.getX() + BALL_RADIUS < getX() + BRICK_WIDTH)){
                    ball.setVY(-ball.getVY());
                    setHit(true);
                    return true;
        }
        return false;
    }
    /************************************
     * Setters and Getters              *
     ************************************/
    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
    public void setColor(Color c){
        this.color = c;
    }
    public void setFill(boolean fill){
        this.fill = fill;
    }

    public boolean isHit() {
        return isHit;
    }

    public void setHit(boolean hit) {
        isHit = hit;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
