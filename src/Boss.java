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
    }

    public void drawBoss(PApplet game) {
        game.fill(255, 255, 0);
        game.rect((float)x,(float)y,100,100);
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
        return false;
    } public boolean collide(Character character) {
        return false;
    }

    public void move(int x, int y) {
        x+=xSpeed;
        y+=ySpeed;
    }

    public void loseHP (int hpLost) {

    }

    public void gainHP(int hpGain) {
        //if max = health, don't gain
    }
}

