package model.ricompense.withMax;

import javafx.scene.paint.Color;
import model.enums.Ricompense;
import model.ricompense.withMax.AbstractRicompensaConMax;

public class RicMonete extends AbstractRicompensaConMax {

    public RicMonete() {
        super(Ricompense.Monete);
    }

    @Override
    public Color getColor() {
        return Color.GOLD;
    }

    @Override
    public int getIncrement() {
        return 100;
    }

    @Override
    protected int getMax() {
        return 200;
    }
}
