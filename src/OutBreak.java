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

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Random;

/**************************************************
 * This class extends JPanel and Implements       *
 * Shared, MouseMotionListener, and MouseListener.*
 * I created an interface that is implemented.    *
 **************************************************/
public class OutBreak extends JPanel implements Shared, MouseMotionListener, MouseListener{
    /**************************************
     * These private attributes are       *
     * examples of encapsulation          *
     * along with the getters and setters *
     **************************************/
    private Paddle paddle;
    private Brick[] bricks;
    public Ball ball;
    private int turn = 1;
    private int counter = 0;
    private boolean started = false;
    private boolean gameover = false;
    private int score = 0;

    /*******************
     * Constructor     *
     *******************/
    public OutBreak(){
        super();
        this.ball = new Ball(Shared.BALL_START_X, Shared.BALL_START_Y);
        this.paddle = new Paddle(Shared.PADDLE_START_X, Shared.PADDLE_START_Y);
        buildBricks();
    }
    /*******************
     * Main method     *
     *******************/
    public static void main(String[] args) throws InterruptedException{
        JFrame f = new JFrame("OutBreak");
        OutBreak o = new OutBreak();
        f.add(o);
        f.setSize(APPLICATION_WIDTH, APPLICATION_HEIGHT);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        o.setBackground(Color.BLACK);
        o.addMouseMotionListener(o);
        o.addMouseListener(o);

        /*******************
         * While Statement *
         *******************/
        while(true) {
            /*******************
             * If Statement     *
             *******************/
            if (!o.isGameover()) {
                Thread.sleep(TIME_DELAY);
                o.repaint();
            }else{
                /******************************
                 * Puts option pane on JFrame *
                 ******************************/
                Object[] options = {"Replay", "Exit",};
                int n = JOptionPane.showOptionDialog(o, "What would you like to do?",
                        "Game Over",
                        JOptionPane.YES_NO_CANCEL_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        options,
                        options[1]);
                if(n == 0){
                    o.resetGame();
                }else if(n == 1){
                    o.gameExit();
                }
            }
        }

    }
    /***********************************
     * Method to resetGame to starting *
     ***********************************/
    public void resetGame(){
        gameover = false;
        started = false;
        counter = 0;
        turn = 0;
        score = 0;
        buildBricks();
    }
    /*******************
     * Method to exit  *
     *******************/
    public void gameExit(){
        System.exit(1);
    }
    /***************************
     * Method to paint objects *
     * to screen. Polymorphism *
     * from JFame.             *
     ***************************/
    public void paint(Graphics g){
        super.paint(g);
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        this.ball.paint(g2d);
        this.paddle.paint(g2d);
        for(int i = 0; i < this.bricks.length; i++) {
            if (!bricks[i].isHit()) {
                counter++;
                this.bricks[i].paint(g2d);
            }
        }
        if(isStarted()){
            this.ball.moveBall();
        }
        checkWalls();
        checkCollisions();
        g.setColor(Color.WHITE);
        g2d.drawString( Integer.valueOf(score).toString(), APPLICATION_WIDTH - 50, 25);
        g.setColor(Color.BLACK);
    }
    /**************************
     * Method to build bricks *
     * and shows encapsulation*
     **************************/
    private void buildBricks(){
        Random r = new Random();
        this.bricks = new Brick[TOTAL_BRICKS];
        int counter = 0;
        for(int row = 0; row < NBRICKS_ROW; ++row) {
            for(int col = 0; col < NBRICKS_PER_ROW; ++col) {
                Brick b = new Brick((double)((BRICK_WIDTH + BRICK_SEP) * col + 1), (double) 70 + (( BRICK_HEIGHT +BRICK_Y_OFFSET) * row));
                b.setId(counter+1);
                this.bricks[counter] = b;
                counter++;
                b.setFill(true);
                b.setLabel(labels[r.nextInt(labels.length)]);
                /*******************
                 * Switch          *
                 *******************/
                switch(row) {
                    case 0:
                        b.setColor(Color.RED);
                        b.setValue(100);
                        break;
                    case 1:
                        b.setColor(Color.RED);
                        b.setValue(100);
                        break;
                    case 2:
                        b.setColor(Color.ORANGE);
                        b.setValue(50);
                        break;
                    case 3:
                        b.setColor(Color.ORANGE);
                        b.setValue(50);
                        break;
                    case 4:
                        b.setColor(Color.YELLOW);
                        b.setValue(35);
                        break;
                    case 5:
                        b.setColor(Color.YELLOW);
                        b.setValue(35);
                        break;
                    case 6:
                        b.setColor(Color.GREEN);
                        b.setValue(20);
                        break;
                    case 7:
                        b.setColor(Color.GREEN);
                        b.setValue(20);
                        break;
                    case 8:
                        b.setColor(Color.BLUE);
                        b.setValue(10);
                        break;
                    case 9:
                        b.setColor(Color.BLUE);
                        b.setValue(10);
                }
            }
        }

    }
    /*******************
     * Method to check *
     * If wall are hit *
     *******************/
    private void checkWalls() {
        if(this.ball.getX() <= 0.0D) {
            this.ball.setVX(-this.ball.getVX());
        } else if(this.ball.getX() + 20D >= (double)this.getWidth()) {
            this.ball.setVX(-this.ball.getVX());
        } else if(this.ball.getY() <= 0.0D) {
            this.ball.setVY(-this.ball.getVY());
        } else if(this.ball.getY()  >= (double)this.getHeight()) {
            this.removeBall();
        }

    }
    /**************************
     * Method to remove ball  *
     *************************/
    private void removeBall(){
        if(checkTurns()) {
            this.ball = new Ball(Shared.BALL_START_X, Shared.BALL_START_Y);
            turn++;
            setStarted(false);
        }
    }
    /*******************
     * Boolean Method  *
     * to check turns  *
     *******************/
    private boolean checkTurns(){
        if(turn == NTURNS){
            gameover = true;
            return false;
        }else{
            return true;
        }
    }
    /*****************************
     * Method to checkCollisions *
     * Using inheritance         *
     *****************************/
    private void checkCollisions(){
        if(this.paddle.getCollidingObject(this.ball)) {
            System.out.println("Paddle hit");
        }
        for(int i = 0; i < this.bricks.length; i++){
            boolean hit = this.bricks[i].isHit();
              if(!hit) {
                  if (this.bricks[i].getCollidingObject(this.ball)) {
                      this.score += this.bricks[i].getValue();
                      System.out.println("Score " + this.score);
                      System.out.println("Brick hit");
                  }
              }
        }
    }

    /************************
     * Methods to use Mouse *
     * in game              *
     ***********************/
    public void mousePressed(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        if(!isStarted()){
            setStarted(true);
        }
    }
    public void mouseDragged(MouseEvent e){
        if(e.getX() >= 0 && e.getX() < this.getWidth() - 60) {
            this.paddle.setLocation((double) (e.getX()), (double) (Shared.PADDLE_START_Y));
        }else if(e.getX() >= this.getWidth() - 60){
            this.paddle.setLocation((double)(this.getWidth() - 65), (double)(Shared.PADDLE_START_Y));
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        //mouseDragged(e);
    }
    public void mouseReleased(MouseEvent e){

    }
    public void mouseExited(MouseEvent e){

    }
    public void mouseClicked(MouseEvent e){

    }
    public void mouseEntered(MouseEvent e){

    }
    /***********************
     * Getters and Setters *
     ***********************/
    public boolean isGameover() {
        return gameover;
    }

    public void setGameover(boolean gameover) {
        this.gameover = gameover;
    }
    public boolean isStarted() {
        return started;
    }

    public void setStarted(boolean started) {
        this.started = started;
    }
}

