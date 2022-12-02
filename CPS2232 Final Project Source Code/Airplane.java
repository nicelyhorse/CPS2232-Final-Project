package TestShootgameDemo;
/**
 *Small enemy aircraft
 *Flying objects, scores
 */

import java.awt.image.BufferedImage;

public class Airplane extends FlyingObject implements Enemy{
    //Define small enemy aircraft picture set
    public static BufferedImage[] images;

    /*Use static code block to load small enemy pictures*/
    static {
        images=new BufferedImage[5];
        //Cyclically load 5 pictures
        for (int i = 0; i < images.length; i++) {
            images[i]=loadImage("airplane"+i+".png");
        }
    }

    //Define the specific coordinates of the current small enemy aircraft
    private int speed;


    public Airplane() {
        super(49,36);//Call the constructor of the parent class to initialize parameters
        speed=2;
    }

    /*Hit the mark*/
    @Override
    public int getScore() {
        // TODO Auto-generated method stub
        return 10;
    }

    /*Small enemy aircraft movement*/
    @Override
    public void step() {
        // TODO Auto-generated method stub
        y+=speed;

    }
    //The subscript that defines the death of a small enemy aircraft
    int deadIndex=1;
    /*Get the picture of small enemy plane --- explosion effect*/
    @Override
    public BufferedImage getImage() {
        // TODO Auto-generated method stub
        //Judge whether the small enemy plane is alive
        if (isLife()) {
            return images[0];
        }else if (isDead()) {//Judge whether dead
            //Switch from the second picture
            BufferedImage img=images[deadIndex++];
            //Judge whether to switch to the last picture
            if (deadIndex==images.length) {
                //Remove flying objects
                state=REMOVE;
            }
            return img;
        }
        return null;
    }
    /*Whether the small enemy aircraft is out of bounds*/
    @Override
    public boolean outOfBounds() {
        // TODO Auto-generated method stub
        return this.y>=ShootGame.jframeHeight ;
    }
}