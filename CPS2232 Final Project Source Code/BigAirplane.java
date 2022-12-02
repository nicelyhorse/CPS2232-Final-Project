package TestShootgameDemo;
/**
 *Small enemy aircraft
 *Flying objects, scores
 */

import java.awt.image.BufferedImage;

public class BigAirplane extends FlyingObject implements Enemy{
    //Define small enemy aircraft picture set
    public static BufferedImage[] images;

    static {
        images=new BufferedImage[5];
        for (int i = 0; i < images.length; i++) {
            images[i]=loadImage("bigplane"+i+".png");
        }
    }

    //Define the specific coordinates of the current small enemy aircraft
    private int speed;

    public BigAirplane() {
        super(69,99);//Call the constructor of the parent class to initialize parameters
        speed=3;
    }

    @Override
    public int getScore() {
        // TODO Auto-generated method stub
        return 10;
    }

    @Override
    public void step() {
        // TODO Auto-generated method stub
        y+=speed;

    }
    int deadIndex=1;
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
 
    @Override
    public boolean outOfBounds() {
        // TODO Auto-generated method stub
        return this.y>=ShootGame.jframeHeight ;
    }
}
