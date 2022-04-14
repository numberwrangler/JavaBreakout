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
 * Paddle class to give an instance *
 * of a paddle                      *
 ************************************/

import java.awt.*;
/*****************************
 * This class extends Shapes *
 * and implements Shared     *
 *****************************/
public class Paddle extends Shape implements Shared {
    /*******************
     * constructor     *
     *******************/
    public Paddle(double x, double y) {
        super(x, y);
        this.width = PADDLE_WIDTH;
        this.height = PADDLE_HEIGHT;
    }
    /*******************
     * Method to paint *
     *******************/
    public void paint(Graphics2D g){
        g.setColor(Color.WHITE);
        g.drawRect((int)x, (int)y, width, height);

    }
    /*******************************
     * Method to check if ball has *
     * collided with paddle        *
     *******************************/
    public boolean getCollidingObject(Ball ball) {
        if( (getY() <= (ball.getY() + BALL_RADIUS) && (ball.getY() + BALL_RADIUS) <= (getY() + PADDLE_HEIGHT)) &&
                ( getX() <= ball.getX() + BALL_RADIUS && ball.getX() + BALL_RADIUS <= getX() + PADDLE_WIDTH)){
            ball.setVY(-ball.getVY());
            return true;
        }
        return false;
    }

//        if((ball.getY() + BALL_RADIUS * 2) > getY()){
//            if(ball.getX() >= getX() && ball.getX() <= getX() + PADDLE_WIDTH){
//                ball.setVY(-ball.getVY());
//                return true;
//            }else if(ball.getX() + BALL_RADIUS > getY() + PADDLE_HEIGHT){
//                return false;
//            }
//        }
//            return false;
//    }
}
