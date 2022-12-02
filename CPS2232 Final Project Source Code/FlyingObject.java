package TestShootgameDemo;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

/**
 * Total category of flying objects - abstract category
 * Parent class of all concrete classes
 */
public  abstract class FlyingObject {
    /*Define the basic attributes of flying objects*/
    public static final int LIFE=0;//Alive
    public static final int DEAD=1;//Dead
    public static final int REMOVE=2;//Delete
    //Define the initial state of the current flying object -- alive
    public int state=LIFE;
    /*Define the basic attributes of flying objects*/
    protected int width;
    protected int height;
    protected int x;//position x
    protected int y;//position y

    /*Define different construction methods*/
    /*
     *Two
     *1. Hero aircraft, sky and bullets
     *2. Provided by large and small enemy planes and bees
     */
    //Define the construction method provided by Hero, Sky and Bullet
    public FlyingObject(int width,int height,int x,int y) {
        this.width=width;
        this.height=height;
        this.x=x;
        this.y=y;
    }
    //Define the construction method provided by large and small enemy planes and bees
    public FlyingObject(int width,int height) {
        this.width=width;
        this.height=height;
        //Initialize the range of flying objects
        Random ran=new Random();
        x=ran.nextInt(ShootGame.jframeWidth-this.width);
        y=-this.height;
    }

    /*Custom Method read pictures*/
    public static BufferedImage loadImage(String filename){
        BufferedImage imgBufferedImage;
        try {
            imgBufferedImage = ImageIO.read(FlyingObject.class.getResource(filename));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            throw new RuntimeException();
        }
        return imgBufferedImage;
    }
    /*Custom Method Flyer Movement*/
    public abstract void step();
    /*Custom Method -- Get Picture*/
    public abstract BufferedImage getImage();
    /*Judge whether alive*/
    public boolean isLife() {
        return state==LIFE;
    }
    /*Judge whether to delete*/
    public boolean isRemove() {
        return state==REMOVE;
    }
    /*Judge whether dead*/
    public boolean isDead() {
        return state==DEAD;
    }
    /*Custom Method -- Draw Picture*/
    public void paintObject(Graphics g) {
        g.drawImage(getImage(), x, y, null);
    }
    /*Check whether the flying object is out of bounds*/
    public abstract boolean outOfBounds();
    /*Collision algorithm: this - enemy other: bullet or hero*/
    public boolean hit(FlyingObject other) {
        //Calculate the maximum and minimum boundary of X
        int x1=this.x-other.width;
        int x2=this.x+this.width;
        //Calculate the maximum and minimum boundary of y
        int y1=this.y-other.height;
        int y2=this.y+this.height;
        //Obtain the xy coordinate of the hero plane or bullet
        int x=other.x;
        int y=other.y;
        return x>=x1&&x<=x2&&y>=y1&&y<=y2;
    }
    /*Death of flying objects*/
    public void goDead() {
        state=DEAD;//Dead but not deleted
    }

}
