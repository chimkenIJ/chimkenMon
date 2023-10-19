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
        hp = maxHP;
    }

    public void drawCharacater(PApplet game) {
        game.rect((float) x, (float) y, 10, 100);

    }

    protected double getX() {
        return this.x;
    }protected double getY() {
        return this.y;
    }

    public boolean collide(Chicken bullet) {

        if ((bullet.getX() + bullet.getimageWidth() >= this.x) && (bullet.getX() <= this.x + 10)) {

            return (bullet.getY() + bullet.getimageHeight() >= this.y) && (bullet.getY() <= this.y + 100);
        }
        return false;
    }

    public boolean collide(Character boss) {
        //punch
        return false;
    }

    public Bullet ability1(Character current) {
        return new Bullet(current.getX(), current.getY(), 10, 10);
    }

    public void ability2(Character current) {

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
        //if max = health, don't gain
    }
    public int getHP() {
        return hp;
    }


}


