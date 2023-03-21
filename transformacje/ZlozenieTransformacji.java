package pl.edu.pg.eti.ksg.po.lab1.transformacje;

public class ZlozenieTransformacji implements Transformacja {
    private final Transformacja[] tab;


    public ZlozenieTransformacji(Transformacja[] tab) {
        this.tab = tab;
    }

    @Override
    public Punkt transformuj(Punkt p) {
        for (Transformacja tr : tab) {
            p = tr.transformuj(p);
        }
        return p;
    }

    @Override
    public Transformacja getTransformacjaOdwrotna() throws BrakTransformacjiOdwrotnejException {
        Transformacja[] odwrotnosci = new Transformacja[tab.length];
        for (int i = 0; i < tab.length; i++) {
            odwrotnosci[tab.length - 1 - i] = tab[i].getTransformacjaOdwrotna();
        }
        return new ZlozenieTransformacji(odwrotnosci);
    }

    @Override
    public String toString() {
        String out = "";
        for (Transformacja tr : tab) {
            out += (tr.toString() + ", ");
        }
        return out;
    }
}


