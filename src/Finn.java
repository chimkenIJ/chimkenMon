import processing.core.PApplet;

public class Finn extends Character {
    public Finn(double x, double y, double xSpeed, double ySpeed, int maxHP, int special) {
        super(x, y, xSpeed, ySpeed, maxHP,0);
    }
    public void drawCharacter(PApplet game) {
        game.fill(0,0,255);
        //replace with image
        game.rect((float) x, (float) y, 10, 100);

    }
   /*public boolean ability2(int coolDown) {

   }*/
}
