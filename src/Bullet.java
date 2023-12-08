import processing.core.PApplet;

public class Bullet {
    protected double x, y, xSpeed, ySpeed;
    protected static int width = 1000, height = 800;
    protected static double imageWidth = 10, imageHeight = 10;
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
  /* public void move(Boss boss ){
       double xDiff = (boss.getX() - x);
       double yDiff = (boss.getY() - y);
       xSpeed = x + xDiff / 10000;
       ySpeed = y + yDiff / 100000;
       x+=xSpeed;
       y+=ySpeed;
   }*/

    public boolean removeFromList(){
        if (x+imageWidth>width || x<0 || y+imageHeight>height || y<0) {
            return true;
        }
        return false;
    }

    public void drawBullet(PApplet game) {
        game.fill(0, 255, 0);
        game.rect((float)(x+5),(float)(y+50),(float)imageWidth, (float)imageHeight);
    }

    public double getX() {
        return this.x;
    }public double getY() {
        return this.y;
    }public double getimageWidth() {
        return this.imageWidth;
    }public double getimageHeight() {
        return this.imageHeight;
    }



}
