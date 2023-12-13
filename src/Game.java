import processing.core.PApplet;
import processing.core.PImage;

import java.util.ArrayList;


public class Game extends PApplet {
    // TODO: declare game variables
    final int Start = 0;
    final int Game = 1;
    final int End = 2;
    int mode = Game;

    PImage startbg, bg;
    PImage I_leo, I_leoPunch1, I_leoPunch2, I_leoRight, I_leoBack, I_dagger;
    PImage I_michael, I_michaelStick1, I_michaelStick2, I_michaelRight,I_michaelBack, I_bunny;
    PImage I_finn, I_finnHeal, I_finnRight, I_finnBack, I_water;
    PImage I_david, I_davidShield, I_davidRight, I_davidBack, I_coin;
    PImage I_boss;
    PImage I_chicken;

    PImage[] PI_char = new PImage[12];
    PImage[] PI_bullet = new PImage[4];
    PImage[] PI_extras = new PImage[15];
    PImage[] PI_boss = new PImage[3];

    int width = 1000;
    int height = 800;

    int time = 2;
    int coolDown = 15 * 30;

    int char1 = 0;

    boolean pBoolean;
    boolean lBoolean;

    boolean done = true;

    ArrayList<Bullet> bList = new ArrayList<>();
    ArrayList<Chicken> cList = new ArrayList<>();

    Character michael = new Michael((float) (width - 100), height - 100, 12, 9, 100, 0);
    Character leo = new Leo((float) width / 2, height, 12, 9, 100, 0);
    Character finn = new Finn((float) width / 2, height, 12, 92, 130, 0);
    Character david = new David((float) width / 2, height, 12, 9, 140, 0);


    Boss boss = new Boss(500, 350, 1, 0, 10000);
    Character current = new Character((float) (width - 100), height - 100, 0, 0, 0, 0);

    public void settings() {
        size(width, height);   // set the window size
    }

    public void setup() {
        // TODO: initialize game variables
        bg = loadImage("bgg.png");
        bg.resize(width, height);
        startbg = loadImage("01-Isometric-Dungeon-Preview-05.jpg");
        startbg.resize(width, height);

        I_leo = loadImage("Untitled_Artwork.png");
        I_leoPunch1 = loadImage("Untitled_Artwork (1).png");
        I_leoPunch2 = loadImage("Untitled_Artwork (2).png");
        I_leoRight = loadImage("download (2).png");
        I_leoBack = loadImage("leoback.png");
        I_dagger = loadImage("download (4).png");

        I_michael = loadImage("REALmichael.png");
        I_michaelStick1 = loadImage("RESLREALSTICK1.png");
        I_michaelStick2 = loadImage("REAREALSTICK2.png");
        I_michaelRight = loadImage("download (3).png");
        I_michaelBack = loadImage("michaelback.png");
        I_bunny = loadImage("Screenshot_2023-12-13_2.15.09_AM-removebg-preview.png");

        I_finn = loadImage("FINNN-removebg-preview.png");
        I_finnHeal = loadImage("heal.png");
        I_finnRight = loadImage("download.png");
        I_finnBack = loadImage("finnback.png");
        I_water = loadImage("Screenshot_2023-12-13_2.19.34_AM-removebg-preview.png");

        I_david = loadImage("david.png");
        I_davidShield = loadImage("shield.png");
        I_davidRight = loadImage("download (1).png");
        I_davidBack = loadImage("davidback-removebg-preview.png");
        I_coin = loadImage("download-removebg-preview.png");

        I_boss = loadImage("boss.png");

        I_chicken = loadImage("chickenbullet.png");

        I_leo.resize((int) (47 * 1.5), (int) (69 * 1.5));
        I_leoRight.resize((int) (47 * 1.5), (int) (69 * 1.5));
        I_leoBack.resize((int) (72 * 1.5), (int) (69 * 1.5));
        I_leoPunch1.resize((int) (47 * 1.5), (int) (69 * 1.5));
        I_leoPunch2.resize((int) (47 * 1.5), (int) (69 * 1.5));
        I_dagger.resize(35, 40);

        I_michael.resize((int) (72 * 1.5), (int) (69 * 1.5));
        I_michaelBack.resize((int) (72 * 1.5), (int) (69 * 1.5));
        I_michaelRight.resize((int) (72 * 1.5), (int) (69 * 1.5));
        I_michaelStick1.resize((int) (72 * 1.5), (int) (69 * 1.5));
        I_michaelStick2.resize((int) (72 * 1.5), (int) (69 * 1.5));
        I_bunny.resize(25,30);

        I_finn.resize((int)(72*1.5), (int)(69*1.5));
        I_finnBack.resize((int)(72*1.5), (int)(69*1.5));
        I_finnRight.resize((int)(72*1.5), (int)(69*1.5));
        I_finnHeal.resize((int)(72*1.5), (int)(69*1.5));
        I_water.resize(25,30);

        I_david.resize((int)(72*1.5), (int)(69*1.5));
        I_davidBack.resize((int)(72*1.5), (int)(69*1.5));
        I_davidRight.resize((int)(72*1.5), (int)(69*1.5));
        I_davidShield.resize((int)(72*1.5), (int)(69*1.5));
        I_coin.resize(20,20);

        I_boss.resize(170, 170);

        I_chicken.resize(30,30);

        PI_char[0] = I_michael;
        PI_char[3] = I_leo;
        PI_char[6] = I_finn;
        PI_char[9] = I_david;
        PI_char[1] = I_michaelStick1;
        PI_char[2] = I_michaelStick2;
        PI_char[4] = I_leoPunch1;
        PI_char[5] = I_leoPunch2;
        PI_char[7] = I_finnHeal;
        PI_char[8] = I_finnHeal;
        PI_char[10] = I_davidShield;
        PI_char[11] = I_davidShield;

        PI_extras[3] = I_leo;
        PI_extras[4] = I_leoRight;
        PI_extras[5] = I_leoBack;
        PI_extras[0] = I_michael;
        PI_extras[1] = I_michaelRight;
        PI_extras[2] = I_michaelBack;
        PI_extras[6] = I_finn;
        PI_extras[7] = I_finnRight;
        PI_extras[8] = I_finnBack;
        PI_extras[9] = I_david;
        PI_extras[10] = I_davidRight;
        PI_extras[11] = I_davidBack;

        PI_bullet[1] = I_dagger;
        PI_bullet[0] = I_bunny;
        PI_bullet[3] = I_coin;
        PI_bullet[2] = I_water;

        PI_boss[0] = I_boss;

        current = michael;


    }

    /***
     * Draws each frame to the screen.  Runs automatically in a loop at frameRate frames a second.
     * tick each object (have it update itself), and draw each object
     */
    public void draw() {
        if (mode == Start) {
            background(startbg);
            if (keyPressed) {
                if (key == 's') {
                    mode = Game;
                }
            }
        }
        if (mode == Game) {
            String name1 = current.toString();
if(name1.equals("michael")) {
    char1 = 0;
}else if(name1.equals("leo")) {
    char1 = 3;
}else if(name1.equals("finn")) {
    char1 = 6;
}else if(name1.equals("david")) {
    char1 = 9;
}
            if(current.getX(time, width)<333) {
                PI_char[char1] = PI_extras[char1];
            }else if(current.getX(time,width)>=333 && current.getX(time,width)<666) {
                PI_char[char1] = PI_extras[char1+2];

            }else if(current.getX(time,width)>=666) {
                PI_char[char1] = PI_extras[char1+1];

            }
            //background, moving
            background(bg);
            ifKeyPressed(keyPressed, key);
            current.drawCharacter(this, PI_char, name1, lBoolean);
            boss.drawBoss(this, PI_boss);
            boss.move();

            //health
            text("Boss Health: " + boss.getHP(), 100, 100);
            text("Character Health: " + current.getHP(), 800, 100);

            //bullets (ability 1 character)
            for (int i = 0; i < bList.size(); i++) {
                Bullet b = bList.get(i);
                if (b != null) {
                    b.drawBullet(this, PI_bullet, name1);
                    b.move();
                    if (b.removeFromList()) {
                        bList.remove(b);
                        i--;
                    }
                    if (boss.collide(b)) {
                        bList.remove(b);
                        i--;
                        boss.loseHP(1);
                    }
                }
            }

            //chickens (boss) + david ability 1 implementation
            if (Math.random() <= 0.02) {
                createChickens();
            }
            for (int j = 0; j < cList.size(); j++) {
                Chicken c = cList.get(j);
                if (c != null) {
                    c.drawChicken(this, I_chicken);
                    c.move();

                    if (c.removeFromList()) {
                        cList.remove(c);

                        j--;

                    }
                    if (current.collide(c)) {
                        cList.remove(c);
                        j--;
                        if (current.equals(david)) {
                            if (david.getSpecial() == 1) {
                                david.setSpecial(0);
                                coolDown = 0;
                                done = true;
                            } else {
                                current.loseHP(1);
                            }

                        } else {
                            current.loseHP(1);
                        }
                    }
                }
            }

            //ability 2 coolDown
            coolDown++;

            if (current.getHP() <= 0) {
                current = michael;
                if (michael.getHP() <= 0) {
                    current = leo;
                    if (leo.getHP() <= 0) {
                        current = finn;
                        if (finn.getHP() <= 0) {
                            current = david;
                            if (david.getHP() <= 0) {
                                mode = End;
                            }
                        }
                    }
                }
            }
        }

        if (mode == End) {
            background(startbg);
        }
    }

    public void createChickens() {
        int xSpeed, ySpeed, xDirection, yDirection;
        int swarmCount = (int) (Math.random() * 5) + 10;
        for (int i = 0; i < swarmCount; i++) {
            xDirection = (int) (Math.random() * 2);
            yDirection = (int) (Math.random() * 2);
            if (xDirection == 0) {
                xSpeed = -2;
            } else xSpeed = 2;
            if (yDirection == 0) {
                ySpeed = -2;
            } else ySpeed = 2;

            Chicken newC = new Chicken(boss.getX(), boss.getY() + 50, xSpeed, ySpeed);
            cList.add(newC);
        }
    }

    public void doAbility(Character current) {
        Bullet cBullet;
        //ability 1
        if (pBoolean) {
            cBullet = current.ability1(time, width, height, keyPressed, key);
            bList.add(cBullet);
            pBoolean = false;
        }
        //ability 2
        if (lBoolean) {
            String name = current.toString();
            if (current.ability2(name, boss, time, width, height, coolDown, done)) {
                if (current.equals(michael) || current.equals(leo)) {
                    boss.loseHP(2);
                }
                if (current.equals(finn)) {
                    michael.gainHP(5);
                    leo.gainHP(5);
                    david.gainHP(5);
                }
            }
            lBoolean = false;
        }
    }

    public void keyReleased() {
        //ability 1
        if (key == 'p') {
            pBoolean = true;
            doAbility(current);
        }
        //ability 2
        if (key == 'l') {
            lBoolean = true;
            done = false;
            doAbility(current);
        }
    }

    public void ifKeyPressed(boolean keyPressed, int key) {
        if (keyPressed) {
            //1 through 4 --> switching character
            if (key == '1') {
                current = michael;
            }
            if (key == '2') {
                current = leo;
            }
            if (key == '3') {
                current = finn;
            }
            if (key == '4') {
                current = david;
            }
            //left
            if (key == 'a') {
                if (!(current.getX(time, width) < 50) && (current.getY(time, height) > 300)) {
                    time++;
                }
            }
            //right
            if (key == 'd') {
                if ((!(current.getX(time, width) > width - 50)) && (current.getY(time, height) > 300)) {
                    time--;
                }
            }
            //up
            if (key == 'w') {
                if (current.getupDown() >= 300) {
                    current.setupDown(-10);
                }
            }
            //down
            if (key == 's') {
                if (current.getupDown() <= 700) {
                    current.setupDown(10);
                }
            }
        }
    }


    public static void main(String[] args) {
        PApplet.main("Game");
    }
}
