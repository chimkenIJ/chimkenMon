import processing.core.PApplet;

public class David extends Character {

    public David(double x, double y, double xSpeed, double ySpeed, int maxHP) {
        super(x, y, xSpeed, ySpeed, maxHP);
    }

    public Bullet ability1(Character current) {
        return new Bullet(current.getX(), current.getY(), 4, 3);
    }

    public void drawCharacater(PApplet game) {
        game.fill(255,0,0);
        //replace with image
        game.rect((float) x, (float) y, 10, 100);

    }
}
