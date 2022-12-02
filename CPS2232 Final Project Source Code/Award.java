package TestShootgameDemo;
/**
 *Reward interface after hitting bees
 *Define the reward type of double firepower or HP as 0 or 1
 *- The purpose is to randomly generate the number 0 or 1 to determine the reward type
 */
public interface Award {
    //Define award types
    public int DOUBLE_FIRE=0;//Double firepower
    public int LIFE=1;//HP bonus

    /*How to get reward types*/
    public int getAward();
}
