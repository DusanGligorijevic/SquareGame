package model.gameButtons;

public class ObojenoDugme extends Dugme{
    int brojac = 0;

    public ObojenoDugme(String name) {
        super(name);
    }

    public int getBrojac() {
        return this.brojac;
    }

    public void setBrojac(int brojac) {
        this.brojac = brojac;
    }
}
