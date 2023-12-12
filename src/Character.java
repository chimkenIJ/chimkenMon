import processing.core.PApplet;
import processing.core.PImage;

import java.util.ArrayList;

public class Character {
    protected double x, y, xSpeed, ySpeed;
    protected int upDown;
    protected int hp, maxHP;
    protected boolean alive;
    protected int special;
    protected static int frameRate = 60;
    protected int counter;


    public Character(double x, double y, double xSpeed, double ySpeed, int maxHP, int special) {
        this.x = x;
        this.y = y;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
        this.maxHP = maxHP;
        this.hp = maxHP;
        this.upDown = 500;
        this.special = special;
        counter++;
    }

    public void drawCharacter(PApplet game, PImage[] img, String name, boolean lBool) {
        if(lBool) {
            System.out.println(lBool);
        }
        if (name.equals("michael")) {
            if (lBool) {
                if (counter % 2 == 0) {
                    game.image(img[4], (float) x, (float) y);
                } else {
                    game.image(img[5], (float) x, (float) y);
                }
                counter++;
            } else {
                game.image(img[0], (float) x, (float) y);
            }
        } else if (name.equals("leo")) {
            if (lBool) {
                if (counter % 2 == 0) {
                    game.image(img[6], (float) x, (float) y);
                } else {
                    game.image(img[7], (float) x, (float) y);
                }
                counter++;
            } else {
                game.image(img[1], (float) x, (float) y);
            }
        } else {
            game.rect((float) x, (float) y, 47, 69);
        }
    }

    protected double getX(int time, int width) {

        x = ((double) width / 2) + upDown * Math.cos((double) time / (2 * Math.PI));
        return x;

    }

    protected double getY(int time, int height) {
        y = ((double) height / 2) - 200 + (upDown * Math.sin((double) time / (Math.PI * 2)));
        return y;

    }


    public void setX(double newX) {
        this.x = newX;
    }

    public void setY(double newY) {
        this.y = newY;
    }

    public void setSpecial(int newSpecial) {
        this.special = newSpecial;
    }

    public int getSpecial() {
        return this.special;
    }


    public boolean collide(Chicken bullet) {

        if ((bullet.getX() + bullet.getimageWidth() >= this.x) && (bullet.getX() <= this.x + 10)) {

            return (bullet.getY() + bullet.getimageHeight() >= this.y) && (bullet.getY() <= this.y + 100);
        }
        return false;
    }

    public boolean collide(Boss boss, int time, int width, int height) {
        double bossX = boss.getX();
        double charX = this.getX(time, width);
        double bossY = boss.getY();
        double charY = this.getY(time, height);
        if (bossX <= charX && bossX + 100 >= charX && bossY <= charY && bossY + 100 >= charY) {
            return true;
        }
        return false;
    }

    public Bullet ability1(int time, int width, int height, boolean keyPressed, int key) {
        return new Bullet(this.getX(time, width), this.getY(time, height), 10, 10);
    }

    public boolean ability2(String current, Boss boss, int time, int width, int height, int coolDown, boolean done) {
        if (current.equals("michael") || current.equals("leo")) {
            if (this.collide(boss, time, width, height)) {
                return true;
            }
        } else if (current.equals("finn")) {
            if (coolDown > (frameRate * 15)) {
                this.special = 1;
                return true;
            }
        } else if (current.equals("david")) {
            if (!done) {
                if (coolDown >= (frameRate * 15)) {
                    this.special = 1;
                    return true;
                }
            }
        }
        return false;
    }


    public void move(boolean keyPressed, int key) {
        if (keyPressed) {
            if (key == 'w') {
                x += xSpeed;
                y -= ySpeed;
            }
            if (key == 'a') {
                x -= xSpeed;
                y -= ySpeed;
            }
            if (key == 's') {
                x -= xSpeed;
                y += ySpeed;
            }
            if (key == 'd') {
                x += xSpeed;
                y += ySpeed;
            }

        }
    }


    public void loseHP(int hpLost) {
        hp -= hpLost;
    }

    public void gainHP(int hpGain) {
        if (!((hpGain + this.hp) > this.maxHP)) {
            this.hp += hpGain;
        }
    }

    public int getHP() {
        return hp;
    }


    public void setupDown(int incrDecr) {
        if (upDown + incrDecr > 0) {
            this.upDown += incrDecr;
        }
    }

    public int getupDown() {
        return this.upDown;
    }
}


