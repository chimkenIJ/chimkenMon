import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import processing.core.PApplet;
import processing.core.PImage;

import java.util.ArrayList;


public class Game extends PApplet {
    // TODO: declare game variables
    final int Start1 = 0;
    final int Start2 = 3;
    final int Game = 1;
    final int End = 2;
    int mode = Start1;

    PImage bg, winBg, loseBg;
    PImage I_leo, I_leoPunch1, I_leoPunch2, I_leoRight, I_leoBack, I_dagger;
    PImage I_michael, I_michaelStick1, I_michaelStick2, I_michaelRight, I_michaelBack, I_bunny;
    PImage I_finn, I_finnHeal, I_finnRight, I_finnBack, I_water;
    PImage I_david, I_davidShield, I_davidRight, I_davidBack, I_coin;
    PImage I_boss;
    PImage I_chicken;

    PImage a0, a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17, a18, a19, a20, a21, a22, a23;
    PImage I_hM, I_hL, I_hF, I_hD;
    PImage I_hMD, I_hLD, I_hFD, I_hDD;

    PImage[] PI_bg = new PImage[24];
    PImage[] PI_char = new PImage[12];
    PImage[] PI_bullet = new PImage[4];
    PImage[] PI_extras = new PImage[15];
    PImage[] PI_boss = new PImage[3];
    PImage[] PI_head = new PImage[8];


    int width = 1000;
    int height = 800;

    double time = 8;
    int coolDown = 10 * 30;

    int char1 = 0;

    boolean pBoolean;
    boolean lBoolean;

    boolean done = true;
    boolean win = false;

    ArrayList<Bullet> bList = new ArrayList<>();
    ArrayList<Chicken> cList = new ArrayList<>();

    Character michael = new Michael((float) (width - 100), height - 100, 12, 9, 100, 0);
    Character leo = new Leo((float) width / 2, height, 12, 9, 100, 0);
    Character finn = new Finn((float) width / 2, height, 12, 92, 130, 0);
    Character david = new David((float) width / 2, height, 12, 9, 140, 0);


    Boss boss = new Boss(500, 350, 1, 0, 200);
    Character current = new Character((float) (width - 100), height - 100, 0, 0, 0, 0);


    int randAbility = 0;
    int counter = 0;
    boolean watched = false;
    double frame = 0;

    Minim loader;
    AudioPlayer song;


    public void settings() {
        size(width, height);   // set the window size
    }

    public void setup() {
        // TODO: initialize game variables
        bg = loadImage("bgg.png");
        bg.resize(width, height);
        winBg = loadImage("win.png");
        winBg.resize(width, height);
        loseBg = loadImage("end.png");
        loseBg.resize(width, height);
        loader = new Minim(this);
        song = loader.loadFile("y2mate.com - Dark Music  Lucifers Hymn  Choir.mp3");

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

        I_boss = loadImage("bodsssss-removebg-preview.png");

        I_chicken = loadImage("chickenbullet.png");

        I_hD = loadImage("headShotDavid.png");
        I_hM = loadImage("headShotMichael.png");
        I_hF = loadImage("headShotFinn.png");
        I_hL = loadImage("headShotLeo.png");

        I_hDD = loadImage("1headShotDavid.png");
        I_hMD = loadImage("1headShotMichael.png");
        I_hFD = loadImage("1headShotFinn.png");
        I_hLD = loadImage("1headShotLeo.png");


        PI_bg[0] = a0;
        PI_bg[1] = a1;
        PI_bg[2] = a2;
        PI_bg[3] = a3;
        PI_bg[4] = a4;
        PI_bg[5] = a5;
        PI_bg[6] = a6;
        PI_bg[7] = a7;
        PI_bg[8] = a8;
        PI_bg[9] = a9;
        PI_bg[10] = a10;
        PI_bg[11] = a11;
        PI_bg[12] = a12;
        PI_bg[13] = a13;
        PI_bg[14] = a14;
        PI_bg[15] = a15;
        PI_bg[16] = a16;
        PI_bg[17] = a17;
        PI_bg[18] = a18;
        PI_bg[19] = a19;
        PI_bg[20] = a20;
        PI_bg[21] = a21;
        PI_bg[22] = a22;
        PI_bg[23] = a23;
        for (int i = 0; i < 24; i++) {
            PI_bg[i] = loadImage("frame_" + i + "_delay-0.1s.gif");
            PI_bg[i].resize(1000, 800);
        }

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
        I_bunny.resize(25, 30);

        I_finn.resize((int) (72 * 1.5), (int) (69 * 1.5));
        I_finnBack.resize((int) (72 * 1.5), (int) (69 * 1.5));
        I_finnRight.resize((int) (72 * 1.5), (int) (69 * 1.5));
        I_finnHeal.resize((int) (72 * 1.5), (int) (69 * 1.5));
        I_water.resize(25, 30);

        I_david.resize((int) (72 * 1.5), (int) (69 * 1.5));
        I_davidBack.resize((int) (64 * 1.5), (int) (69 * 1.5));
        I_davidRight.resize((int) (72 * 1.5), (int) (69 * 1.5));
        I_davidShield.resize((int) (72 * 1.5), (int) (69 * 1.5));
        I_coin.resize(20, 20);

        I_boss.resize(170, 170);

        I_chicken.resize(30, 30);

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

        PI_head[0] = I_hM;
        PI_head[1] = I_hL;
        PI_head[2] = I_hF;
        PI_head[3] = I_hD;
        PI_head[4] = I_hMD;
        PI_head[5] = I_hLD;
        PI_head[6] = I_hFD;
        PI_head[7] = I_hDD;


        current = michael;

    }

    /***
     * Draws each frame to the screen.  Runs automatically in a loop at frameRate frames a second.
     * tick each object (have it update itself), and draw each object
     */
    public void draw() {
        if (mode == Start1) {
            background(0);
            fill(255);
            textSize(33);
            text("THIS GAME HAS VOLUME\nPress s after reading instructions. \nWASD to move (you will move in a arc shaped path) \nPress p to do ability 1 (shooting), and l to do ability 2. \nThe first 2 characters punch once \nclose enough to the chicken boss. \nThe 3rd character heals everyone but himself \n(with a cooldown of 10 seconds).\nThe 4th character equips a shield (blocks 1 shot), \nalso with a cooldown of 10 seconds.\nPress space in the next screen to start the game!", 85, 200);

            if (keyPressed) {
                if (key == 's') {
                    song.play();
                    mode = Start2;
                }
            }
        }

        if (mode == Start2) {
            if (!watched) {
                background(PI_bg[(int) frame]);
                if (frame >= 22.75) {
                    watched = true;
                } else {
                    frame = frame + 0.25;
                }
            } else {

                if (keyPressed) {
                    if (key == ' ') {

                        mode = Game;
                    }
                }
            }

        }
        if (mode == Game) {
            if (song.position() == song.length()) {
                song.rewind();
                song.play();
            }

            String name1 = current.toString();
            switch (name1) {
                case "michael":
                    char1 = 0;
                    break;
                case "leo":
                    char1 = 3;
                    break;
                case "finn":
                    char1 = 6;
                    break;
                case "david":
                    char1 = 9;
                    break;
            }
            if (current.getX(time, width) < 333) {
                PI_char[char1] = PI_extras[char1];
            } else if (current.getX(time, width) >= 333 && current.getX(time, width) < 666) {
                PI_char[char1] = PI_extras[char1 + 2];

            } else if (current.getX(time, width) >= 666) {
                PI_char[char1] = PI_extras[char1 + 1];

            }
            //background, moving
            background(bg);
            ifKeyPressed(keyPressed, key);
            current.drawCharacter(this, PI_char, name1);
            boss.drawBoss(this, PI_boss);
            boss.move();
            boss.hpBar(this);
            current.hpCharBar(this, current);
            fill(255, 255, 0);
            textSize(10);
            text("Press key to switch", 870, 290);
            textSize(10);
            text("[1] Michael", 870, 320);
            text("[2] Leo", 870, 370);
            text("[3] Finn", 870, 420);
            text("[4] David", 870, 470);
            image(PI_head[3], 920, 450);
            image(PI_head[1], 935, 350);
            image(PI_head[0], 920, 300);
            image(PI_head[2], 920, 400);
            text("Keys:\nA/D --> left/right in arc path\nW/S --> translate arc up/down\nP --> ability 1: shoot\nL --> ability 2: special\n    [1][2](Leo/Michael) --> punch\n    [3](Finn) --> heal\n    [4](David) --> shield", 820, 650);

            //health

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
            if (counter > 30) {
                randAbility = (int) (Math.random() * 30);
                counter = 0;
            }
            if (randAbility < 28) {
                if (Math.random() <= 0.02) {
                    createChickens();
                }}
         else if (randAbility < 30) {
                boss.ability2();
                counter = 30;
            }

            //chickens (boss) + david ability 1 implementation

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
            if (michael.getHP() <= 0) {
                PI_head[0] = PI_head[4];
            }
            if (leo.getHP() <= 0) {
                PI_head[1] = PI_head[5];
            }
            if (finn.getHP() <= 0) {
                PI_head[2] = PI_head[6];
            }
            if (david.getHP() <= 0) {
                PI_head[3] = PI_head[7];
            }

            if (current.getHP() <= 0) {
                current = michael;
                if (michael.getHP() <= 0) {
                    current = leo;
                    if (leo.getHP() <= 0) {
                        current = finn;
                        if (finn.getHP() <= 0) {
                            current = david;
                            if (david.getHP() <= 0) {
                                win = false;
                                mode = End;
                            }
                        }
                    }
                }
            }
            if (boss.getHP() <= 0) {
                win = true;
                mode = End;
            }
            if (current.equals(michael) && michael.getHP() <= 0) {
                text(current.toString(), 300, 400);
            }

            counter++;

        }

        if (mode == End) {
            if (win) {
                background(winBg);
            } else {
                background(loseBg);
            }
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
                    time += 0.25;
                }
            }
            //right
            if (key == 'd') {
                if ((!(current.getX(time, width) > width - 100)) && (current.getY(time, height) > 300)) {
                    time -= 0.25;
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
