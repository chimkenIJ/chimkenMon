import processing.core.PApplet;

public class Bullet {
    private double x, y, xSpeed, ySpeed;
    private static int width = 1000, height = 800;
    private static float imageWidth = 10, imageHeight = 10;
    public Bullet (double x, double y, double xSpeed, double ySpeed){
        this.x = x;
        this.y = y;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;

    }
    public void move(PApplet game){
        x+=xSpeed;
        y+=ySpeed;
    }
    public boolean removeFromList(){
        if (x+imageWidth>width || x<0 || y+imageHeight>height || y<0) {
            return true;
        }
        return false;
    }

    public void drawBullet(PApplet game) {
        game.fill(0, 255, 0);
        game.rect((float)(x+5),(float)(y+50),imageWidth, imageHeight);
    }
}

