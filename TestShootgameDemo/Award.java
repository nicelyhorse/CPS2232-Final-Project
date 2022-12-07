package TestShootgameDemo;

import java.util.*;

/**
 * 打中蜜蜂后的奖励接口
 * 定义双倍火力或者生命值的奖励类型为0或1
 * -目的是为了随机产生数字0或1来确定奖励类型
 */
public interface Award {

    /**
     * 
     */
    public int DOUBLE_FIRE = 0;

    /**
     * 
     */
    public int LIFE = 1;

    /**
     * 获取奖励类型的方法
     * @return
     */
    public int getAward();

}