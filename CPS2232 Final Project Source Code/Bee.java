package TestShootgameDemo;
/**
 *Bees
 *Flying object reward
 */

import java.awt.image.BufferedImage;
import java.util.Random;

public class Bee extends FlyingObject implements Award {
    private static BufferedImage[] images;
    static {
        images = new BufferedImage[5];
        for (int i = 0; i < images.length; i++) {
            images[i]=loadImage("bee"+i+".png");
        }
    }
    private int xSpeed;//x coordinate increment
    private int ySpeed;////X coordinate increment
    private int awardType;//Award type (0/1)

    public Bee() {
        super(60,50);
        xSpeed=1;
        ySpeed=2;

        Random rand=new Random();
        awardType =rand.nextInt(2);//0/1
    }

    @Override
    public int getAward() {
        // TODO Auto-generated method stub
        return awardType;
    }

    /*The movement of the bee*/
    @Override
    public void step() {
        x+=xSpeed;
        y+=ySpeed;
        //Judge whether to collide with the left and right boundaries
        if(x<=0||x>=ShootGame.jframeWidth-this.width) {
            xSpeed*=-1;//Change direction
        }

    }
    //Define a dead subscript
    int deadIndex=1;
    //Get the current picture -- explosion
    @Override
    public BufferedImage getImage() {
        // TODO Auto-generated method stub
        if(isLife()) {
            return images[0];
        }else if (isDead()) {
            BufferedImage img=images[deadIndex++];
            if (deadIndex==images.length) {
                state=REMOVE;
            }
            return img;
        }
        return null;
    }

    @Override
    public boolean outOfBounds() {
        // TODO Auto-generated method stub
        return this.y>=ShootGame.jframeHeight;
    }
}
