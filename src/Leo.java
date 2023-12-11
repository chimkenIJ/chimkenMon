import processing.core.PApplet;

public class Leo extends Character{

    public Leo(double x, double y, double xSpeed, double ySpeed, int maxHP, int special) {
        super(x, y, xSpeed, ySpeed, maxHP,0);
    }
    public void drawCharacter(PApplet game) {
        game.fill(255,0,255);
        //replace with image
        game.rect((float) x, (float) y, 10, 100);

    }
    public String toString() {
        return "leo";
    }
}
