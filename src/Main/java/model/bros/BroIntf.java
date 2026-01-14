package model.bros;

import model.exceptions.NotEnoughCreditiException;
import model.exceptions.NotEnoughToDecrementException;
import model.ricompense.RicCrediti;
import model.ricompense.withMax.RicMonete;
import model.ricompense.withMax.RicPowerup;

public interface BroIntf extends Comparable<BroIntf> {
    void addXTrofei(int amt);

    void sblocca(RicCrediti rc) throws NotEnoughCreditiException;
    boolean isSbloccato();
    String getName();
    int getQtyTrofei();
    int getLvl();
    int getRequiredCredits();
    void levelupAndDecrement(RicPowerup p, RicMonete m) throws NotEnoughToDecrementException;
}
