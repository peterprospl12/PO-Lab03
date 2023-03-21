package pl.edu.pg.eti.ksg.po.lab1.transformacje;
import java.lang.Math;
public class Obrot implements Transformacja {

    private final double angle;

    public Obrot(double angle){
        this.angle = angle;
    }

    @Override
    public Transformacja getTransformacjaOdwrotna() {
        return new Obrot(-angle);
    }

    @Override
    public Punkt transformuj(Punkt p) {
        double x = p.getX();
        double y = p.getY();

        x = x * Math.cos(angle) - y * Math.sin(angle);
        y= x * Math.sin(angle) + y * Math.cos(angle);
        return new Punkt(x,y);
    }

    public double getAngle(){
        return angle;
    }

    @Override
    public String toString(){
        return "Obrót o kąt "+angle+" stopni";
    }

}
