package model.bros;

import model.exceptions.NotEnoughCreditiException;
import model.exceptions.NotEnoughToDecrementException;
import model.ricompense.RicCrediti;
import model.ricompense.withMax.RicMonete;
import model.ricompense.withMax.RicPowerup;

public class Bro implements BroIntf {
    private final String name;
    private final int requiredCredits;
    private int lvl;
    private int qtyTrofei;
    private boolean sbloccato;

    public Bro(String n, int rc){
        this.name = n;
        this.requiredCredits = rc;
        this.lvl = 1;
        this.qtyTrofei = 0;
    }

    @Override
    public void addXTrofei(int amt){
        this.qtyTrofei+=amt;
    }

    @Override
    public void sblocca(RicCrediti rc) throws NotEnoughCreditiException {
        if (rc.getQty() < this.requiredCredits){
            throw new NotEnoughCreditiException();
        }
        this.sbloccato = true;
    }

    @Override
    public boolean isSbloccato() {
        return sbloccato;
    }
    @Override
    public String getName() {
        return name;
    }
    @Override
    public int getQtyTrofei() {
        return qtyTrofei;
    }
    @Override
    public int getLvl() {
        return lvl;
    }
    @Override
    public int getRequiredCredits() {
        return requiredCredits;
    }

    @Override
    public void levelupAndDecrement(RicPowerup p, RicMonete m) throws NotEnoughToDecrementException {
        NotEnoughToDecrementException nede = new NotEnoughToDecrementException();
        try {
            p.decrement();
        } catch (NotEnoughToDecrementException e) {
            nede.addRicompensa(p);
        }
        try {
            m.decrement();
        } catch (NotEnoughToDecrementException e) {
            nede.addRicompensa(m);
        }
        if (nede.isThrowable()){
            throw nede;
        }
        this.lvl++;
    }

    @Override
    public int compareTo(BroIntf o) {
        if (o == null){
            return 0;
        }
        return this.name.compareTo(o.getName());
    }
}
