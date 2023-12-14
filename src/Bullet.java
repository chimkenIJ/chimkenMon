import processing.core.PApplet;
import processing.core.PImage;

public class Bullet {
    protected double x, y, xSpeed, ySpeed;
    protected static int width = 1000, height = 800;
    protected static double imageWidth = 50, imageHeight = 65;
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

    public boolean removeFromList(){
        return x + imageWidth > width || x < 0 || y + imageHeight > height || y < 0;
    }

    public void drawBullet(PApplet game, PImage[] img, String name) {
        switch (name) {
            case "leo":
                game.image(img[1], (float) (x + 50), (float) (y + 50));
                break;
            case "michael":
                game.image(img[0], (float) (x + 50), (float) (y + 50));
                break;
            case "david":
                game.image(img[3], (float) (x + 50), (float) (y + 50));
                break;
            case "finn":
                game.image(img[2], (float) (x + 50), (float) (y + 50));
                break;
            default:
                System.out.println("???");
                break;
        }
    }

    public double getX() {
        return this.x;
    }public double getY() {
        return this.y;
    }public double getImageWidth() {
        return imageWidth;
    }public double getImageHeight() {
        return imageHeight;
    }



}
