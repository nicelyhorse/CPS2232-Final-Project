package TestShootgameDemo;

import java.util.*;

/**
 * 天空类
 * 飞行物
 */
public class Sky extends FlyingObject {

    /**
     * Default constructor
     */
    public Sky() {
    }

    /**
     * 定义背景图片
     */
    public static BufferedImage image;

    /**
     * 静态代码块加载图片
     * 属性
     */
    private int speed;

    /**
     * 
     */
    private int y2;

    /**
     * 构造方法
     */
    public void Sky() {
        // TODO implement here
    }

    /**
     * 背景图片的移动
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
     * @param g 
     * @return
     */
    public void paintObject(Graphics g) {
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