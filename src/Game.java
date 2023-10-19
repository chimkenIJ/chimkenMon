import processing.core.PApplet;
import processing.core.PImage;

import java.util.ArrayList;


public class Game extends PApplet {
    // TODO: declare game variables
    PImage bg;
    int width = 1000;
    boolean pBoolean;
    int height = 800;
    double currentX;
    double currentY;
    int numChickens;
    ArrayList<Bullet> bList = new ArrayList<>();
    ArrayList<Chicken> cList = new ArrayList<>();
    Character michael = new Michael(100, 200, 4, 3, 100);
    Character leo = new Leo(100, 200, 4, 4, 100);
    Character finn = new Finn(100, 200, 3, 2, 130);
    Character david = new David(100, 200, 4, 3, 140);
    Character current = new Character(100, 200, 0, 0, 0);


    //Boss boss = new Boss(400, 500, (int) (Math.random() * 11 - 5), (int) (Math.random() * 11 - 5), 10000);
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
        decideCurrent(keyPressed, key);
        current.move(keyPressed, key);
        current.drawCharacater(this);
        boss.drawBoss(this);
        boss.move();
        text("Boss Health: " + boss.getHP(), 100,100);
        text("Character Health: " + current.getHP(), 800,100);

        if (keyPressed) {
            if (key == 'p') {
                pBoolean = true;
                doAbility(current);
            }
        }
        for (int i = 0; i < bList.size(); i++) {
            Bullet b = bList.get(i);
            if (b != null) {
                b.drawBullet(this);
                b.move(this);
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


        if (Math.random()<=0.02) {
            createChickens();}
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
                                current.loseHP(1);
                            }
                        }
                    }
                }




    private void createChickens() {
        int swarmCount = (int)(Math.random()*5)+10;
        for (int i = 0; i < swarmCount; i++) {
            Chicken newC = new Chicken(boss.getX(), boss.getY()+50,-2,-2);
            cList.add(newC);
        }
    }

    private void doAbility(Character current) {
        Bullet cBullet;
        /*while (pBoolean) {
            if (!pBoolean) {
                System.out.println("in");
                cBullet = current.ability1(current);

                bList.add(cBullet);
            }
            System.out.println("0");
        }*/
        if (key == 'p') {

            cBullet = current.ability1(current);
            bList.add(cBullet);
        }
    }

    public void keyReleased() {
        if (key == 'p') {
            pBoolean = false;
        }
    }


    private void decideCurrent(boolean keyPressed, int key) {
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
            currentX = current.getX();
            currentY = current.getY();
        }
    }


    public static void main(String[] args) {
        PApplet.main("Game");
    }
}

