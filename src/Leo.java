import processing.core.PApplet;

public class Leo extends Character{

    public Leo(double x, double y, double xSpeed, double ySpeed, int maxHP) {
        super(x, y, xSpeed, ySpeed, maxHP);
    }
    public void drawCharacater(PApplet game) {
        game.fill(255,0,255);
        //replace with image
        game.rect((float) x, (float) y, 10, 100);

    }
}
