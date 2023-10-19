import processing.core.PApplet;

public class Bullet {
    private double x, y, xSpeed, ySpeed;
    public Bullet (double x, double y, double xSpeed, double ySpeed){
        this.x = x;
        this.y = y;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;

    }
    public void move(){
        x+=xSpeed;
        y+=ySpeed;
    }
    public void reset(){

    }

    public void drawBullet(PApplet game) {
        game.rect((float)x,(float)y,10, 100);
        game.rotate((float)(0.1));
    }
}

