package TestShootgameDemo;

import java.util.*;

/**
 * Total category of flying objects - abstract category
 * Parent class of all concrete classes
 */
public abstract class FlyingObject {

    /**
     * Default constructor
     */
    public FlyingObject() {
    }

    /**
     * 定义飞行物的基本属性
     */
    public static final int LIFE = 0;

    /**
     * 
     */
    public static final int DEAD = 1;

    /**
     * 
     */
    public static final int REMOVE = 2;

    /**
     * 
     */
    public int state;

    /**
     * 定义飞行物的基本属性
     */
    protected int width;

    /**
     * 
     */
    protected int height;

    /**
     * 
     */
    protected int x;

    /**
     * 
     */
    protected int y;

    /**
     * 定义不同的构造方法
     * 两种
     * 1.英雄机、天空、子弹提供的
     * 2.大小敌机、蜜蜂提供的
     * @param width 
     * @param height 
     * @param x 
     * @param y
     */
    public void FlyingObject(int width, int height, int x, int y) {
        // TODO implement here
    }

    /**
     * @param width 
     * @param height
     */
    public void FlyingObject(int width, int height) {
        // TODO implement here
    }

    /**
     * 自定义方法-读取图片的方法
     * @param filename 
     * @return
     */
    public static BufferedImage loadImage(String filename) {
        // TODO implement here
        return null;
    }

    /**
     * 自定义方法 飞行物移动
     * @return
     */
    public abstract void step();

    /**
     * 自定义方法--获取图片
     * @return
     */
    public abstract BufferedImage getImage();

    /**
     * 判断是否活着
     * @return
     */
    public boolean isLife() {
        // TODO implement here
        return false;
    }

    /**
     * 判断是否删除
     * @return
     */
    public boolean isRemove() {
        // TODO implement here
        return false;
    }

    /**
     * 判断是否死了
     * @return
     */
    public boolean isDead() {
        // TODO implement here
        return false;
    }

    /**
     * 自定义方法--绘制图片
     * @param g 
     * @return
     */
    public void paintObject(Graphics g) {
        // TODO implement here
        return null;
    }

    /**
     * 检测飞行物是否越界
     * @return
     */
    public abstract boolean outOfBounds();

    /**
     * 碰撞算法：this-敌人 other:子弹或者英雄
     * @param other 
     * @return
     */
    public boolean hit(FlyingObject other) {
        // TODO implement here
        return false;
    }

    /**
     * 飞行物去死
     * @return
     */
    public void goDead() {
        // TODO implement here
        return null;
    }

}