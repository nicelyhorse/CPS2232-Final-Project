package TestShootgameDemo;

import java.util.*;

/**
 * 蜜蜂类
 * 飞行物 奖励
 */
public class Bee extends FlyingObject implements Award {

    /**
     * Default constructor
     */
    public Bee() {
    }

    /**
     * 定义图片集
     */
    private static Set<BufferedImage> images;

    /**
     * 静态代码块
     */
    private int xSpeed;

    /**
     * 
     */
    private int ySpeed;

    /**
     * 
     */
    private int awardType;

    /**
     * 
     */
    int deadIndex = 1;

    /**
     * 构造方法
     */
    public void Bee() {
        // TODO implement here
    }

    /**
     * 获取奖励
     * @return
     */
    public int getAward() {
        // TODO implement here
        return 0;
    }

    /**
     * 小蜜蜂的移动
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

    /**
     * 获取奖励类型的方法
     * @return
     */
    public int getAward() {
        // TODO implement here
        return 0;
    }

}