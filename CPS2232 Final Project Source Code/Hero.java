package TestShootgameDemo;

import java.awt.image.BufferedImage;

public class Hero  extends FlyingObject{

    private static BufferedImage[] images;

    static {
        images=new BufferedImage[2];
        for (int i = 0; i < images.length; i++) {
            images[i]=loadImage("hero"+i+".png");
        }
    }

    /*Define Double Fire*/
    private int doubleFire;
    /*Define life value*/
    private int life;

    /*Construction method*/
    public Hero() {
        super(97, 124,150,400);
        life=3;	//Initial HP

        doubleFire=0;//Initially single fire
    }

    /*Hero moves with the mouse*/
    public void moveTo(int x,int y) {
        //Move the mouse to the middle of the hero aircraft
        this.x=x-this.width/2;
        this.y=y-this.height/2;
    }

    @Override
    public void step() {
        // TODO Auto-generated method stub

    }

    /*Get the picture of Hero*/
    int deadIndex=0;
    @Override
    public BufferedImage getImage() {
        // TODO Auto-generated method stub
        if(isLife()) {
            return images[deadIndex++%2];
        }
        return null;
    }

    @Override
    public boolean outOfBounds() {
        // TODO Auto-generated method stub
        return false;
    }
    /*The Core Algorithm of Hero Aircraft Launching Ammunition*/
    public Bullet[] shoot() {
        //Calculate 1/15 width of the hero machine
        int xStep=this.width/4;
        int yStep=20;//Distance between hero aircraft and bullets
        if(doubleFire>0) { //Double firepower
            //Define two banch of bullets
            Bullet[] bs= new Bullet[3];
            bs[0]=new Bullet(this.x+xStep,this.y-yStep);
            bs[1]=new Bullet(this.x+2*xStep, this.y-yStep);
            bs[2]=new Bullet(this.x+3*xStep,this.y-yStep);

            //After a certain number of double bullets are fired, they automatically become single
            doubleFire-=2;
            return bs;
        }else {
            Bullet[] bs= new Bullet[1];
            bs[0]=new Bullet(this.x+2*xStep, this.y-yStep);
            return bs;
        }
    }
    /*Customized method - Hero reduces life*/
    public void substractLife() {
        life--;
    }
    /*Use your own method - Hero increases life*/
    public void addLife() {
        life++;
    }
    /*Customized method - obtain the life of the hero*/
    public int getLife() {
        return life;
    }
    /*Custom method to increase fire value*/
    public void addDoubleFire() {
        doubleFire+=40;
    }
    /*Customized Method - Fire Clearing 0*/
    public void clearDoubleFire() {
        doubleFire=0;
    }
}