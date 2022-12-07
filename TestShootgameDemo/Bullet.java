package TestShootgameDemo;

import java.util.*;

/**
 * 子弹类
 * 飞行物
 */
public class Bullet extends FlyingObject {

    /**
     * Default constructor
     */
    public Bullet() {
    }

    /**
     * 定义图片
     */
    public static BufferedImage image;

    /**
     * 静态代码块
     * 定义坐标增量
     * 当前子弹的坐标增量
     */
    private int speed = 50;

    /**
     * 构造方法
     * @param x 
     * @param y
     */
    public void Bullet(int x, int y) {
        // TODO implement here
    }

    /**
     * 子弹移动
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
     * 判断子弹是否越界
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

}