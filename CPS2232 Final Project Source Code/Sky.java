package TestShootgameDemo;
/**
 *Sky class
 *Flying object
 */
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Sky extends FlyingObject {

    public static BufferedImage image;

    static {
        image=loadImage("background.png");
    }

    /*Attributes*/
    private int speed;
    private int y2; //y coordinate of the second picture (the same picture)

    /*Construction method*/
    public Sky() {
        super(ShootGame.jframeWidth, ShootGame.jframeHeight, 0, 0);
        speed=1;
        y2=-this.height;//Initial position of the second picture
    }
    /*Moving background pictures*/
    @Override
    public void step() {
        y+=speed;
        y2+=speed;
        if(y>=ShootGame.jframeHeight) {
            y=-ShootGame.jframeHeight;
        }
        if (y2>=ShootGame.jframeHeight) {
            y2=-ShootGame.jframeHeight;
        }

    }

    @Override
    public BufferedImage getImage() {
        // TODO Auto-generated method stub
        return image;
    }

    @Override
    public boolean outOfBounds() {
        // TODO Auto-generated method stub
        return false;
    }
    @Override
    public void paintObject(Graphics g) {
        g.drawImage(getImage(), x, y, null);
        g.drawImage(getImage(), x, y2, null);
    }

}
