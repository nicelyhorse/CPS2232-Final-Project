package TestShootgameDemo;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.Arrays;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class ShootGame extends JPanel{

    /*Define the basic properties of the form*/
    public static int width = Toolkit.getDefaultToolkit().getScreenSize().width;
    //Get the width of the screen
    public static int height = Toolkit.getDefaultToolkit().getScreenSize().height;
    //Get the height of the screen
    public static int jframeWidth = 400;// Width of the form
    public static int jframeHeight = 700;// Height of the form
    //Get the X coordinate of the screen center
    public static int jframeX=width/2-jframeWidth/2;
    //Get centered Y coordinate
    public static int jframeY=height/2-jframeHeight/2;
    /*
     *Set game status
     *Start, run, pause, end
     *The default state is startup
     */
    public static final int START = 0;//Start
    public static final int RUNNING = 1;//Run
    public static final int PAUSE = 2;//Pause
    public static final int GAME_OVER = 3;//End
    private int state = START;//The default state is start

    /*Define a picture set*/
    public static BufferedImage start;//picture for start game
    public static BufferedImage pause;//picture for pause game
    public static BufferedImage gameover;//picture for game over

    /*Load Picture*/
    static {
        start = FlyingObject.loadImage("start.png");//start picture
        pause = FlyingObject.loadImage("pause.png");//pause picture
        gameover = FlyingObject.loadImage("gameover.png");//game over picture
    }

    /*Define Concrete Class*/
    private Sky sky = new Sky();//Sky
    private Hero hero = new Hero();//Hero Aircraft
    private FlyingObject[] enemies = {};//Enemy (big and small enemy aircraft, bees) array
    private Bullet[] bullets = {};//Bullet array

    /*Core algorithm for generating enemies*/
    public FlyingObject nextOne() {
        /*Instantiate random number object -- type of randomly generated enemy (big, small enemy aircraft, bees)*/
        Random ran = new Random();
        /*Random numbers within 0-20 to generate objects*/
        int type = ran.nextInt(20);//0-19
        if(type < 4) {//0-3
            return new Bee();//Bee production
        } else if(type < 12) {//4-11
            return new Airplane();//Small enemy aircraft
        } else{//12-19
            return new BigAirplane();//Enemy aircraft
        }
    }

    /*Enemy entry counter*/
    int enterIndex = 0;

    /*Enemy entry*/
    public void enterAction() {
        enterIndex ++;//Timer counter, representing the number of objects generated per second
        if(enterIndex % 8 == 0) {//The timer goes once every 400ms -- an object is generated
            FlyingObject obj = nextOne();//Generate an enemy randomly
            enemies = Arrays.copyOf(enemies, enemies.length + 1);//Capacity expansion
            enemies[enemies.length - 1] = obj;//Put the enemy at the end of the array
        }
    }

    /*Bullet entry counter*/
    int shootIndex = 0;

    /*Bullet entry incident*/
    public void shootAction() {
        shootIndex ++;
        if(shootIndex % 10 == 0) {//Walk once every 300ms
            Bullet[] bs = hero.shoot();//Get bullet array
            bullets = Arrays.copyOf(bullets, bullets.length + bs.length);//Capacity expansion
            //Store the bullet array fired by the hero into the bullet array
            System.arraycopy(bs, 0,
                    bullets, bullets.length - bs.length, bs.length);
        }
    }

    /*Flying object movement event*/
    public void stepAction() {
        sky.step();//Sky movement
        hero.step();//Hero aircraft movement

        for (int i = 0; i < bullets.length; i++) {
            bullets[i].step();
        }
        //Enemy movement
        for (int i = 0; i < enemies.length; i++) {
            enemies[i].step();
        }
    }

    /*Delete out of bounds flying object event*/
    public void outOfBoundsAction() {
        //Define the subscript and number of the enemy array that does not exceed the boundary
        int index = 0;
        //Define an array of enemies that do not cross the boundary
        FlyingObject[] enemyLives = new FlyingObject[enemies.length];
        //遍历所有敌人
        for (int i = 0; i < enemies.length; i++) {
            //Get every enemy
            FlyingObject f = enemies[i];
            //Judge whether the enemy has crossed the border
            If (! F. outOfBounds()) {//Do not cross the boundary
                enemyLives[index] = f;// Store in a non out of bounds array
                index ++;// Count enemies who do not cross the border
            }
        }
        //Assign the non overrun enemy array to enemies -- convert to the original array
        enemies = Arrays.copyOf(enemyLives, index);
        index = 0;// Subscript and number of non overrun bullet array
        //Define non overrun bullet array
        Bullet[] bulletLives = new Bullet[bullets.length];
        //Go through all the bullets
        for (int i = 0; i < bullets.length; i++) {
            //Get each bullet
            Bullet b = bullets[i];
            //Judge whether the bullet does not cross the boundary
            If (! B. outOfBounds()) {//Do not cross the boundary
                bulletLives[index] = b;// Store the non overrunning bullets into the non overrunning array
                index ++;// Subscripts and number increase
            }
        }
        bullets = Arrays.copyOf(bulletLives, index);
    }
    /*Define player score*/
    int score = 0;

    /*Collision between enemy and bullet*/
    public void BulletBangAction() {
        //Go through all the bullets
        for (int i = 0; i < bullets.length; i++) {
            Bullet b = bullets[i];// Get each bullet
            //Traverse all enemies
            for (int j = 0; j < enemies.length; j++) {
                FlyingObject f = enemies[j];// Get every enemy
                //Judge whether there is collision
                if(f.hit(b) && f.isLife() && b.isLife()) {
                    f.goDead();// Death to the enemy
                    b.goDead();// Bullet to death
                    //Post collision processing logic
                    if(f instanceof Enemy) {
                        Enemy en = (Enemy)f;// Get the current collided enemy
                        score += en.getScore();// Cumulative score
                    }
                    if(f instanceof Award) {
                        Award aw = (Award)f;
                        //Reward type
                        int type = aw.getAward();
                        //Judge reward items according to reward type
                        switch (type) {
                            case Award.DOUBLE_ FIRE:
                                hero.addDoubleFire();// Double your firepower
                                break;
                            case Award.LIFE:
                                hero.addLife();// Increase HP
                                break;
                        }
                    }
                }
            }
        }
    }
    /*Heroes collide with enemies*/
    public void heroBangAction() {
        //Traverse all enemies
        for (int i = 0; i < enemies.length; i++) {
            FlyingObject f = enemies[i];// Get every enemy
            //Judge whether it is hit
            if(f.hit(hero) && f.isLife() && hero. isLife()) {
                f.goDead();// Death to the enemy
                hero.substractLife();// Life reduction
                hero.clearDoubleFire();// Fire clearing 0
            }
        }
    }
    /*Check whether the game is over*/
    public void checkGameOverAction() {
        if(hero.getLife() < 0) {
            state = GAME_OVER;//The game status changes to GameOver
        }
    }

    /*Execution of start-up procedure*/
    public void action() {
        MouseAdapter l = new MouseAdapter() {

            @Override
            Public void mouseMoved (MouseEvent e) {//Mouse movement event
                //Judge whether the current state is running
                if(state == RUNNING) {
                    int x = e.getX();// Get mouse x coordinate
                    int y = e.getY();// Get mouse y coordinate
                    hero. moveTo(x, y);// Hero machine movement
                }
            }

            @Override
            public void mouseClicked(MouseEvent e) {//Mouse click event
                //Make different results according to different states
                switch (state) {
                    case START:
                        state = RUNNING;//Start ->Run
                        break;
                    case GAME_OVER:
                        state = START;//End ->Start
                        //Initialization parameters
                        score = 0;
                        sky = new Sky();
                        hero = new Hero();
                        bullets = new Bullet[0];
                        enemies = new FlyingObject[0];
                        break;
                }
            }

            @Override
            Public void mouseExited (MouseEvent e) {//The mouse moves out of the event
                if(state == RUNNING) {
                    state = PAUSE;// Run ->Pause
                }
            }

            @Override
            Public void mouseEntered (MouseEvent e) {//The mouse moves into the event
                if(state == PAUSE) {
                    state = RUNNING;// Pause ->Run
                }
            }
        };

        //Add mouse listening event
        this.addMouseListener(l);
        //Add mouse slide event
        this.addMouseMotionListener(l);

        //Define Timer Object
        Timer timer = new Timer();
        int intervel = 10;//10ms
        timer.schedule(new TimerTask() {
            @Override
            public void run() {//Timer task
                //Define the task and walk every 10ms
                if(state == RUNNING) {
                    enterAction();// Big and small enemy bees enter the site
                    shootAction();// Bullet entry
                    stepAction();// Flying object movement
                    outOfBoundsAction();// Delete flying objects beyond the boundary
                    BulletBangAction();// The bullet collided with the enemy
                    heroBangAction();// Heroes collide with enemies
                    checkGameOverAction();// Check whether the game is over
                }
                repaint();// Repaint
            }

        }, intervel,intervel);
    }

    /*Draw Graph*/
    @Override
    public void paint(Graphics g) {
        sky.paintObject(g);// Draw the sky
        hero.paintObject(g);// Draw Hero
        For (int i=0; i<enemies. length; i++) {//Draw enemies
            enemies[i].paintObject(g);
        }
        for (int i = 0; i < bullets.length; i++) {
            bullets[i].paintObject(g);// Draw Bullet
        }
        /*Draw Score*/
        g.drawString("SCORE:" + score, 10, 25);
        /*Draw HP*/
        g.drawString("LIFE:" + hero.getLife(), 10, 45);
        /*Draw different pictures according to different states*/
        switch (state) {
            case START:
                g.drawImage(start, 0, 0, null);
                break;
            case PAUSE:
                g.drawImage(pause, 0, 0, null);
                break;
            case GAME_ OVER:
                g.drawImage(gameover, 0, 0, null);
                break;
        }
    }
    public static void main(String[] args) {
        JFrame jf = new JFrame();// Instantiate a form object
        jf.setTitle("Fighter Battle");// Set Title
        jf.setBounds(jframeX, jframeY, jframeWidth, jframeHeight);// Setting position and size
        ShootGame sg = new ShootGame();// Instantiate the current class object
        jf.add(sg);// Add the drawing board to the form container
        jf.setVisible(true);// Form Visible
        sg.action();// Program startup
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



    }
}
