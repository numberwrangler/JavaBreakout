/**********************************
 * Ball class that extends Shapes *
 * and implements Shared. Allows  *
 * the ball to be built and move. *
 **********************************/
import java.awt.*;
import java.util.Random;

public class Ball extends Shape implements Shared {
    /**************************************
     * These private attributes are       *
     * examples of encapsulation          *
     * along with the getters and setters *
     **************************************/
    private int r = BALL_RADIUS;
    private Random rgen;
    private double vx;
    private double vy;
    private int MIN = -3;
    private int MAX = 3;
    /*******************
     * Constructor     *
     *******************/
    public Ball(double x, double y) {
        super(x, y);
        this.rgen = new Random();
        //this.vx = rgen.nextInt(5);
        //this.vy = rgen.nextInt(5);
        //if(vy == 0){
        //this.vy = 1;
    //}
        this.randomV();
    }
    /*******************
     * Method on how   *
     * to paint Ball   *
     *******************/
    public void paint(Graphics2D g){
        g.setColor(Color.WHITE);
        g.fillOval((int) x,(int) y,r,r);
        g.setColor(Color.BLACK);
    }
    /************************
     * Method to Randomize  *
     * the velocity of Ball *
     ************************/
    public void randomV() {
        double d = rgen.nextDouble();
        double r = MIN + (MAX - MIN) * rgen.nextDouble();
        System.out.println(r +" "+ d);
        setVX(r);
        setVY(r);
    }
    /***********************
     * Method to move ball *
     ***********************/
    public void moveBall(double x, double y){
        this.x += x;
        this.y += y;
    }
    /*******************
     * Overload method *
     *******************/
    public void moveBall(){
        this.moveBall(this.vx, this.vy);
    }
    /***********************
     * Getters and Setters *
     ***********************/
    public double getVX() {
        return vx;
    }

    public void setVX(double vx) {
        this.vx = vx;
    }

    public double getVY() {
        return vy;
    }

    public void setVY(double vy) {
        this.vy = vy;
    }
}
