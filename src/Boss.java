import processing.core.PApplet;

public class Boss {
    private double x, y, xSpeed, ySpeed;
    private int hp, maxHP;
    private boolean alive;

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
    }public double getY() {
        return this.y;
    }

    public void drawBoss(PApplet game) {
        game.fill(255, 255, 0);
        game.rect((float) x, (float) y, 100, 100);
    }

    public void ability1() {
        //chicken wave
    }

    public void ability2() {
        //punch
    }

    public void ability3() {
        //heals
    }

    public boolean collide(Bullet bullet) {

        if ((bullet.getX() + bullet.getimageWidth() >= this.x) && (bullet.getX() <= this.x + 100)) {

            return (bullet.getY() + bullet.getimageHeight() >= this.y) && (bullet.getY() <= this.y + 100);
        }
        return false;
    }

    public boolean collide(Character character) {
        return false;
    }

    public void move() {
        if (x >= 550 || x<=450) {
            xSpeed *= -1;
        }
        x+=xSpeed;
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

