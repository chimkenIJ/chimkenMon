public class David extends Character {

    public David(double x, double y, double xSpeed, double ySpeed, int maxHP) {
        super(x, y, xSpeed, ySpeed, maxHP);
    }

    public Bullet ability1(Character current) {
        Bullet shield = new Bullet(current.getX(), current.getY(), 10, 10) ;
        return shield;
    }
}
