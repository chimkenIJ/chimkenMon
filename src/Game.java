import processing.core.PApplet;
import processing.core.PImage;

import java.util.ArrayList;


public class Game extends PApplet {
    // TODO: declare game variables
    PImage bg;
    int width = 1000;
    int height = 800;
    double currentX;
    double currentY;
    ArrayList<Bullet> bList = new ArrayList<>();
    Character michael = new Michael(100, 200, 4, 3, 100);
    Character leo = new Leo(100, 200, 4, 4, 100);
    Character finn = new Finn(100, 200, 3, 2, 130);
    Character david = new David(100, 200, 4, 3, 140);
    Character current = new Character(100, 200, 0, 0, 0);

    Bullet bullet = new Bullet(0, 0, 3, 4);

    Boss boss = new Boss(400, 500, (int) (Math.random() * 11 - 5), (int) (Math.random() * 11 - 5), 10000);

    public void settings() {
        size(width, height);   // set the window size

    }

    public void setup() {
        // TODO: initialize game variables
        bg = loadImage("01-Isometric-Dungeon-Preview-05.jpg");
        bg.resize(width, height);


    }

    /***
     * Draws each frame to the screen.  Runs automatically in a loop at frameRate frames a second.
     * tick each object (have it update itself), and draw each object
     */
    public void draw() {
        background(bg);
        decideCurrent(keyPressed, key);
        current.move(keyPressed, key);
        fill(255, 0, 0);
        current.drawCharacater(this);
        fill(255, 255, 0);
        boss.drawBoss(this);

        if (keyPressed) {
            if (key == 'p' || key == 'o') {
                doAbility(current);
            }
        }

        fill(0, 255, 0);
        for (int i = 0; i < bList.size(); i++) {
            Bullet b = bList.get(i);
            if (b != null) {
                b.drawBullet(this);
                b.move(this);
                if (b.removeFromList()) {
                    bList.remove(b);
                    System.out.println("removed");
                    i--;
                }
            }

        }

    }

    private void doAbility(Character current) {
        Bullet cBullet;

        if (key == 'p') {
            cBullet = current.ability1(current);
            System.out.println(current.x);
            bList.add(cBullet);
            System.out.println("added!!");
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

