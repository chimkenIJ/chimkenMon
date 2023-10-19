import processing.core.PApplet;

public class Character {
    protected double x, y, xSpeed, ySpeed;
    protected int hp, maxHP;
    protected boolean alive;

    public Character(double x, double y, double xSpeed, double ySpeed, int maxHP) {
        this.x = x;
        this.y = y;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
        this.maxHP = maxHP;
    }

    public void drawCharacater(PApplet game) {
        game.rect((float) x, (float) y, 10, 100);

    }

    protected double getX() {
        return this.x;
    }protected double getY() {
        return this.y;
    }

    public boolean collide(chicken bullet) {
        //chicken wave
        return false;
    }

    public boolean collide(Boss chicken) {
        //punch
        return false;
    }

    public Bullet ability1(Character current) {
        return null;
    }

    public void ability2(Character current) {

    }

    public void boundary(double bossX, double bossY) {
        if (this.x >= bossX && x <= bossX + 100) {
        }
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
        //health--
    }

    public void gainHP(int hpGain) {
        //if max = health, don't gain
    }
}


