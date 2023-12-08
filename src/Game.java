import processing.core.PApplet;
import processing.core.PImage;

import java.util.ArrayList;


public class Game extends PApplet {
    // TODO: declare game variables
    PImage bg;
    int width = 1000;
    boolean pBoolean;
    boolean lBoolean;
    int height = 800;
    int time = 0;
    ArrayList<Bullet> bList = new ArrayList<>();
    ArrayList<Chicken> cList = new ArrayList<>();
    Character michael = new Michael((float) width / 2, height, 12, 9, 100, 0);
    Character leo = new Leo((float) width / 2, height, 12, 9, 100, 0);
    Character finn = new Finn((float) width / 2, height, 12, 92, 130, 0);
    Character david = new David((float) width / 2, height, 12, 9, 140, 0);
    Character current = new Character((float) width / 2, height-100, 0, 0, 0, 0);

    Boss boss = new Boss(400, 500, 3, 1, 10000);

    public void settings() {
        size(width, height);   // set the window size

    }

    public void setup() {
        // TODO: initialize game variables
        bg = loadImage("01-Isometric-Dungeon-Preview-05.jpg");
        bg.resize(width, height);
        current = michael;
    }

    /***
     * Draws each frame to the screen.  Runs automatically in a loop at frameRate frames a second.
     * tick each object (have it update itself), and draw each object
     */
    public void draw() {

        background(bg);
        ifKeyPressed(keyPressed, key);
        // current.move(keyPressed, key);
        current.drawCharacter(this);
        boss.drawBoss(this);
        boss.move();
        text("Boss Health: " + boss.getHP(), 100, 100);
        text("Character Health: " + current.getHP(), 800, 100);

        for (int i = 0; i < bList.size(); i++) {
            Bullet b = bList.get(i);
            if (b != null) {
                b.drawBullet(this);
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
        if (Math.random() <= 0.02) {
            createChickens();
        }
        for (int j = 0; j < cList.size(); j++) {
            Chicken c = cList.get(j);
            if (c != null) {
                c.drawChicken(this);
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
                        }

                    } else {
                        current.loseHP(1);
                    }
                }
            }
        }

        System.out.println(height - current.getY(time, height));
    }


    private void createChickens() {
        int swarmCount = (int) (Math.random() * 5) + 10;
        for (int i = 0; i < swarmCount; i++) {
            int xSpeed;
            int ySpeed;
            int xDirection = (int) (Math.random() * 2);
            int yDirection = (int) (Math.random() * 2);
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


    private void doAbility(Character current) {
        Bullet cBullet;
        if (pBoolean) {
            cBullet = current.ability1(current, time, width, height, keyPressed, key);
            bList.add(cBullet);
            pBoolean = false;
        }
        if (lBoolean) {
            if (current.ability2(current, boss, time, width, height)) {
                lBoolean = false;
                boss.loseHP(2);
            }
        }
    }

    public void keyReleased() {
        if (key == 'p') {
            pBoolean = true;
            doAbility(current);
        }
        if (key == 'l') {
            lBoolean = true;
            doAbility(current);
        }
    }


    private void ifKeyPressed(boolean keyPressed, int key) {
        if (keyPressed) {
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
            if (key == 'a') {
                if (!(current.getX(time, width) < 50)) {
                    time++;
                }
            }
            if (key == 'd') {
                if (!(current.getX(time, width) > width - 50)) {
                    time--;
                }
            }
            if (key == 'w') {
                if (current.getupDown() <=700 && current.getupDown()>300) {
                    // if (current.getY(time, height) < height - 500 && current.getY(time, height) > height - 100) {
                    current.setupDown(-10);
                    // }
                }
            }
            if (key == 's') {
                if (current.getupDown() >300 && current.getupDown()<=700) {
                    //if (current.getY(time, height) < height - 500 && current.getY(time, height) > height - 100) {
                    current.setupDown(10);
                    // }
                }
            }
        }
    }


    public static void main(String[] args) {
        PApplet.main("Game");
    }
}
