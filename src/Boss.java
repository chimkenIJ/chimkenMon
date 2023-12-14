import processing.core.PApplet;
import processing.core.PImage;

public class Boss {
    private double x, y, xSpeed, ySpeed;
    private int hp, maxHP;

    public Boss(double x, double y, double xSpeed, double ySpeed, int maxHP) {
        this.x = x;
        this.y = y;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
        this.maxHP = maxHP;
        hp = maxHP;
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public void drawBoss(PApplet game, PImage[] img) {
        game.image(img[0], (float) x, (float) y);
    }



    public void ability2() {
        if (this.hp + 10 <= this.maxHP) {
            this.hp += 10;
        }
    }

    public void hpBar(PApplet game) {
        game.stroke(235, 116, 108);
        game.strokeWeight(0);
        game.fill(235, 116, 108);
        game.rect(100, 50,(float)(this.hp*4), 25);
        game.stroke(22);
        game.strokeWeight(3);
        game.fill(0, 0);
        game.rect(100, 50, 800, 25);
        game.strokeWeight(0);


    }

    public boolean collide(Bullet bullet) {

        if ((bullet.getX() + bullet.getImageWidth() >= this.x) && (bullet.getX() <= this.x + 100)) {

            return (bullet.getY() + bullet.getImageHeight() >= this.y) && (bullet.getY() <= this.y + 100);
        }
        return false;
    }

    public boolean collide(Character character) {
        return false;
    }

    public void move() {
        if (x >= 550 || x <= 450) {
            xSpeed *= -1;
        }
        x += xSpeed;
    }

    public void loseHP(int hpLost) {
        hp -= hpLost;
    }


    public int getHP() {
        return hp;
    }

    public void setHP(int newHP) {
        this.hp = newHP;
    }
}

