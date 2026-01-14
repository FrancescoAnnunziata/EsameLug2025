package model.exceptions;

import model.ricompense.RicompensaIntf;
import java.util.HashSet;

public class NotEnoughToDecrementException extends Exception {

    private HashSet<RicompensaIntf> sr = new HashSet<>();
    public void addRicompensa(RicompensaIntf r){
        this.sr.add(r);
    }
    public HashSet<RicompensaIntf> getSr() {
        return sr;
    }

    public boolean isThrowable(){
        return !this.sr.isEmpty();
    }
}
