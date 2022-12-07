package TestShootgameDemo;

import java.util.*;

/**
 * 小敌机类
 * 飞行物、得分
 * @author liujiacheng
 */
public class Airplane extends FlyingObject implements Enemy {

    /**
     * Default constructor
     */
    public Airplane() {
    }

    /**
     * 
     */
    public static Set<BufferedImage> images;

    /**
     * 使用静态代码块 加载小敌机图片
     */
    private int speed;

    /**
     * 
     */
    int deadIndex = 1;

    /**
     * 构造方法
     */
    public void Airplane() {
        // TODO implement here
    }

    /**
     * 打中得分
     * @return
     */
    public int getScore() {
        // TODO implement here
        return 0;
    }

    /**
     * 小敌机移动
     * @return
     */
    public void step() {
        // TODO implement here
        return null;
    }

    /**
     * 获得小敌机图片---爆炸效果
     * @return
     */
    public BufferedImage getImage() {
        // TODO implement here
        return null;
    }

    /**
     * 小敌机是否越界
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
     * 得分
     * @return
     */
    public int getScore() {
        // TODO implement here
        return 0;
    }

}