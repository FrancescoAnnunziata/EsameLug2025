package model.ricompense.withMax;

import model.enums.Ricompense;
import model.exceptions.MaxExceededException;
import model.exceptions.NotEnoughToDecrementException;
import model.ricompense.AbstractRicompensa;

public abstract class AbstractRicompensaConMax extends AbstractRicompensa {

    protected AbstractRicompensaConMax(Ricompense r) {
        super(r);
    }
    private static final int DECRAMT = 10;

    protected abstract int getMax();

    public void increment() throws MaxExceededException {
        int tmp = this.qty+this.getIncrement();
        if (tmp > this.getMax()){
            throw new MaxExceededException();
        }
        super.increment();
    }

    public void decrement() throws NotEnoughToDecrementException {
        if (this.qty < DECRAMT){
            throw new NotEnoughToDecrementException();
        }
        this.qty -= DECRAMT;
    }

}
