package TestShootgameDemo;

import java.util.*;

/**
 * 
 */
public class Hero extends FlyingObject {

    /**
     * Default constructor
     */
    public Hero() {
    }

    /**
     * 定义图片集
     */
    private static Set<BufferedImage> images;

    /**
     * 静态代码块加载图片
     * 定义双倍火力
     */
    private int doubleFire;

    /**
     * 定义生命值
     */
    private int life;

    /**
     * 获取英雄机图片
     */
    int deadIndex = 0;

    /**
     * 构造方法
     */
    public void Hero() {
        // TODO implement here
    }

    /**
     * 英雄机随鼠标移动
     * @param x 
     * @param y 
     * @return
     */
    public void moveTo(int x, int y) {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public void step() {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public BufferedImage getImage() {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public boolean outOfBounds() {
        // TODO implement here
        return false;
    }

    /**
     * 英雄机发射子弹的核心算法
     * @return
     */
    public Set<Bullet> shoot() {
        // TODO implement here
        return null;
    }

    /**
     * 自定义方法--英雄机减少性命
     * @return
     */
    public void substractLife() {
        // TODO implement here
        return null;
    }

    /**
     * 自定以方法-英雄机增加性命
     * @return
     */
    public void addLife() {
        // TODO implement here
        return null;
    }

    /**
     * 自定义方法-获取英雄机的命
     * @return
     */
    public int getLife() {
        // TODO implement here
        return 0;
    }

    /**
     * 自定义方法增加火力值
     * @return
     */
    public void addDoubleFire() {
        // TODO implement here
        return null;
    }

    /**
     * 自定义方法-火力清0
     * @return
     */
    public void clearDoubleFire() {
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
     * 检测飞行物是否越界
     * @return
     */
    public abstract boolean outOfBounds();

}