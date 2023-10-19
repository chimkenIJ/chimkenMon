import processing.core.PApplet;
import processing.core.PImage;


public class Game extends PApplet {
    // TODO: declare game variables
    PImage bg;
    int width = 1000;
    int height = 800;
    double currentX;
    double currentY;
    Character michael = new Michael(100, 200, 4, 3, 100);
    Character leo = new Leo(150, 200, 4, 4, 100);
    Character finn = new Finn(200, 200, 3, 2, 130);
    Character david = new David(250, 200, 4, 3, 140);
    Character current = new Character(0, 0, 0, 0, 0);

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
        drawKeys();
        decideCurrent(keyPressed, key);
        current.move(keyPressed, key);
        fill(255, 0, 0);
        current.drawCharacater(this);
        fill(255, 255, 0);
        boss.drawBoss(this);

        bullet = doAbility(current);

        fill(0, 255, 0);
        bullet.drawBullet(this);

    }

    private Bullet doAbility(Character current) {
        Bullet cBullet = new Bullet(0, 0, 0, 0);
        if (keyPressed) {
            if (key == 'p') {
                cBullet = current.ability1(current);
            }
        }
        return cBullet;
    }


    private void decideCurrent(boolean keyPressed, int key) {
        if (keyPressed) {
            if (key =='1') {
                current = michael;
            }if (key =='2') {
                current = leo;
            }if (key =='3') {
                current = finn;
            }if (key =='4') {
                current = david;
            }
            currentX = current.getX();
            currentY = current.getY();
        }
    }


    private void drawKeys () {
        fill(255, (float) 0.5);
        rect(0, height - 170, 170, 170);
        ellipse((float) 170 / 2, (float) (height - ((double) 170 / 2) - 12.5), 25, 25);
    }


    public static void main (String[]args){
        PApplet.main("Game");
    }
}

