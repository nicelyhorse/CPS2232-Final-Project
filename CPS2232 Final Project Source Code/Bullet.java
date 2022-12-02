package TestShootgameDemo;
/**
 *Bullets
 *Flying object
 */
import java.awt.image.BufferedImage;
public class Bullet extends FlyingObject {

    public static BufferedImage image;
    static {
        image=loadImage("bullet.png");
    }
    /*Define coordinate increments*/
    /*The coordinate increment of the current bullet*/
    private int speed=50;

    /*Construction method*/
    public Bullet(int x,int y) {
        super(8,14,x,y);
    }
    /*Bullet movement*/
    @Override
    public void step() {
        // TODO Auto-generated method stub
        y-=speed;
    }

    @Override
    public BufferedImage getImage() {
        // TODO Auto-generated method stub
        if(isLife()) {
            return image;
        }else if (isDead()) {
            state=REMOVE;
        }
        return null;
    }
    @Override
    public boolean outOfBounds() {
        // TODO Auto-generated method stub
        return this.y<=-this.height;
    }
}