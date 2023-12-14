import processing.core.PApplet;
import processing.core.PImage;

public class Character {
    protected double x, y, xSpeed, ySpeed;
    protected int upDown;
    protected int hp, maxHP;
    protected int special;
    protected static int frameRate = 60;
    protected int counter;
    protected int lPose;


    public Character(double x, double y, double xSpeed, double ySpeed, int maxHP, int special) {
        this.x = x;
        this.y = y;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
        this.maxHP = maxHP;
        this.hp = maxHP;
        this.upDown = 500;
        this.special = special;
        counter = 0;
        lPose = 0;
    }

    public void drawCharacter(PApplet game, PImage[] img, String name) {

        if (lPose > 0) {
            counter++;
        }
        if (counter > 30 * 0.5) {
            counter = 0;
            lPose = 0;
        }
        if (counter > 0) {
            if (counter % 4 == 0 || counter%4 == 1  ) {
                lPose = 2;
            } else {
                lPose = 1;
            }
        }
        switch (name) {
            case "michael":
                game.image(img[lPose], (float) x, (float) y);
                break;
            case "leo":
                game.image(img[3 + lPose], (float) x, (float) y);
                break;
            case "finn":
                game.image(img[6 + lPose], (float) x, (float) y);
                break;
            case "david":
                game.image(img[9 + lPose], (float) x, (float) y);
                break;
            default:
                System.out.println("??");
                break;
        }
    }


    protected double getX(double time, int width) {

        x = ((double) width / 2) + upDown * Math.cos(time / (2 * Math.PI));
        return x;

    }

    protected double getY(double time, int height) {
        y = ((double) height / 2) - 200 + (upDown * Math.sin(time / (Math.PI * 2)));
        return y;

    }


    public void setX(double newX) {
        this.x = newX;
    }

    public void setY(double newY) {
        this.y = newY;
    }

    public void setSpecial(int newSpecial) {
        this.special = newSpecial;
    }

    public int getSpecial() {
        return this.special;
    }


    public boolean collide(Chicken bullet) {

        if ((bullet.getX() + bullet.getimageWidth() >= this.x) && (bullet.getX() <= this.x + 10)) {

            return (bullet.getY() + bullet.getimageHeight() >= this.y) && (bullet.getY() <= this.y + 100);
        }
        return false;
    }

    public boolean collide(Boss boss, double time, int width, int height) {
        double bossX = boss.getX();
        double charX = this.getX(time, width);
        double bossY = boss.getY();
        double charY = this.getY(time, height);
        return bossX <= this.getX(time, width) && (bossX + 170 >= charX) && (bossY <= charY && bossY + 170 >= charY);
    }

    public Bullet ability1(double time, int width, int height, boolean keyPressed, int key) {
        int go;
        if(this.getX(time,width)>500) {
            go = -10;
        }
        else {
            go = 10;
        }
        return new Bullet(this.getX(time, width), this.getY(time, height), go, -10);
    }

    public boolean ability2(String current, Boss boss, double time, int width, int height, int coolDown, boolean done) {
        switch (current) {
            case "michael":
            case "leo":
                if (this.collide(boss, time, width, height)) {
                    this.lPose = 1;
                    return true;
                }
                break;
            case "finn":
                if (coolDown > (frameRate * 10)) {
                    this.special = 1;
                    this.lPose = 1;

                    return true;
                }
                break;
            case "david":
                if (!done) {
                    if (coolDown >= (frameRate * 10)) {
                        this.special = 1;
                        this.lPose = 1;

                        return true;
                    }
                }
                break;
        }
        return false;
    }


    public void loseHP(int hpLost) {
        hp -= hpLost;
    }

    public void gainHP(int hpGain) {
        if (!((hpGain + this.hp) > this.maxHP)) {
            if(this.hp>0){
            this.hp += hpGain;}
        }
    }

    public int getHP() {
        return hp;
    }


    public void setupDown(int incrDecr) {
        if (upDown + incrDecr > 0) {
            this.upDown += incrDecr;
            this.y+=incrDecr;
        }
    }
    public void setHP(int newHP) {
        this.hp = newHP;
    }

    public int getupDown() {
        return this.upDown;
    }

    public void hpCharBar(PApplet game, Character current) {
        game.stroke(235, 116, 108);
        game.strokeWeight(0);
        game.fill(135, 232, 102);
        game.rect(400, 730,(float)(current.hp*200/current.maxHP), 25);
        game.stroke(22);
        game.strokeWeight(3);
        game.fill(0, 0);
        game.rect(400, 730, 200, 25);
        game.strokeWeight(0);
    }
}


