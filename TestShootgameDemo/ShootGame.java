package TestShootgameDemo;

import java.util.*;

/**
 * 
 */
public class ShootGame extends JPanel {

    /**
     * Default constructor
     */
    public ShootGame() {
    }

    /**
     * 定义窗体的基本属性
     */
    public static int width;

    /**
     * 
     */
    public static int height;

    /**
     * 
     */
    public static int jframeWidth = 400;

    /**
     * 
     */
    public static int jframeHeight = 700;

    /**
     * 
     */
    public static int jframeX;

    /**
     * 
     */
    public static int jframeY;

    /**
     * 设置游戏状态
     * 启动、运行、暂停、结束
     * 默认状态为启动
     */
    public static final int START = 0;

    /**
     * 
     */
    public static final int RUNNING = 1;

    /**
     * 
     */
    public static final int PAUSE = 2;

    /**
     * 
     */
    public static final int GAME_OVER = 3;

    /**
     * 
     */
    private int state;

    /**
     * 定义图片集
     */
    public static BufferedImage start;

    /**
     * 
     */
    public static BufferedImage pause;

    /**
     * 
     */
    public static BufferedImage gameover;

    /**
     * 实例化随机数对象--随机产生敌人的类型(大、小敌机、蜜蜂)
     * 0-20内的随机数来生成对象
     * 敌人入场计数器
     */
    int enterIndex = 0;

    /**
     * 子弹入场计数器
     */
    int shootIndex = 0;

    /**
     * 定义玩家得分
     */
    int score = 0;

    /**
     * 生成敌人的核心算法
     * @return
     */
    public FlyingObject nextOne() {
        // TODO implement here
        return null;
    }

    /**
     * 敌人入场事件
     * @return
     */
    public void enterAction() {
        // TODO implement here
        return null;
    }

    /**
     * 子弹入场事件
     * @return
     */
    public void shootAction() {
        // TODO implement here
        return null;
    }

    /**
     * 飞行物移动事件
     * @return
     */
    public void stepAction() {
        // TODO implement here
        return null;
    }

    /**
     * 删除越界的飞行物事件
     * @return
     */
    public void outOfBoundsAction() {
        // TODO implement here
        return null;
    }

    /**
     * 敌人与子弹碰撞事件
     * @return
     */
    public void BulletBangAction() {
        // TODO implement here
        return null;
    }

    /**
     * 英雄机和敌人碰撞事件
     * @return
     */
    public void heroBangAction() {
        // TODO implement here
        return null;
    }

    /**
     * 检测是否游戏结束
     * @return
     */
    public void checkGameOverAction() {
        // TODO implement here
        return null;
    }

    /**
     * 启动程序的执行
     * @return
     */
    public void action() {
        // TODO implement here
        return null;
    }

    /**
     * 绘制图形
     * @param g 
     * @return
     */
    public void paint(Graphics g) {
        // TODO implement here
        return null;
    }

    /**
     * 绘制得分
     * 绘制生命值
     * 根据不同状态绘制不同图片
     * @param args 
     * @return
     */
    public static void main(Set<String> args) {
        // TODO implement here
        return null;
    }

}