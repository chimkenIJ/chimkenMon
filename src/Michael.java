import processing.core.PApplet;

public class Michael extends Character{

    public Michael(double x, double y, double xSpeed, double ySpeed, int maxHP) {
        super(x, y, xSpeed, ySpeed, maxHP);
    }
    public void drawCharacater(PApplet game) {
        game.fill(0,0,0);
        //replace with image
        game.rect((float) x, (float) y, 10, 100);

    }
}



