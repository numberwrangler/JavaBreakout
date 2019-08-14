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
 * My interface that my Objects use *
 ************************************/

public interface Shared {
    public static final int APPLICATION_WIDTH = 490;
    public static final int APPLICATION_HEIGHT = 600;
    public static final int WIDTH = 490;
    public static final int HEIGHT = 600;
    public static final int PADDLE_WIDTH = 60;
    public static final int PADDLE_HEIGHT = 10;
    public static final int PADDLE_OFFSET = 40;
    public static final int NBRICKS_PER_ROW = 10;
    public static final int NBRICKS_ROW = 10;
    public static final int TOTAL_BRICKS = NBRICKS_PER_ROW * NBRICKS_ROW;
    public static final int BRICK_SEP = 4;
    public static final int BRICK_WIDTH = 45;
    public static final int BRICK_HEIGHT = 18;
    public static final int BALL_RADIUS = 10;
    public static final int BRICK_Y_OFFSET = 6;
    public static final int NTURNS = 3;
    public static final int TIME_DELAY = 5;
    public static final int PADDLE_START_X = 200;
    public static final int PADDLE_START_Y = HEIGHT - PADDLE_OFFSET;
    public static final int BALL_START_X = 200;
    public static final int BALL_START_Y = 350;
    public static final String[] labels = { "Java","Ruby","Python","C++","C#","Go"};

}
