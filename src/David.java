import processing.core.PApplet;

public class David extends Character {

    public David(double x, double y, double xSpeed, double ySpeed, int maxHP, int special) {
        super(x, y, xSpeed, ySpeed, maxHP, 0);
    }

    public Bullet ability1(Character current, int time, int width, int height) {
        return new Bullet(current.getX(time, width), current.getY(time, height), 4, 3);
    }



    public void drawCharacter(PApplet game) {
        game.fill(255, 0, 0);
        //replace with image
        game.rect((float) x, (float) y, 10, 100);

    }
    public String toString() {
        return "david";
    }
}

