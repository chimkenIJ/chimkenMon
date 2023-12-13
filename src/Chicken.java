import processing.core.PApplet;
import processing.core.PImage;

public class Chicken {
    private double x, y, xSpeed, ySpeed;
    private static float imageWidth = 10;
    private static float imageHeight = 10;
    public Chicken(double x, double y, double xSpeed, double ySpeed){
        this.x = x;
        this.y = y;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }
    public void drawChicken(PApplet game, PImage img) {
        /*game.fill(0, 0, 255);
        game.rect((float)x,(float)y,(float)imageWidth, (float)imageHeight);*/
        game.image(img,(float)x,(float)y);

    }
    public void move(){
        x+=xSpeed;
        y+=ySpeed;
    }
    public void reset(){

    }
    public boolean removeFromList(){
        if (x+imageWidth>1000 || x<0 || y+imageHeight>800 || y<0) {
            return true;
        }
        return false;
    }

    public double getX() {
        return this.x;
    }public double getY() {
        return this.y;
    }public double getimageWidth() {
        return imageWidth;
    }public double getimageHeight() {
        return imageHeight;
    }


}
