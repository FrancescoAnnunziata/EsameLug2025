package model.ricompense.withMax;

import javafx.scene.paint.Color;
import model.enums.Ricompense;

public class RicPowerup extends AbstractRicompensaConMax {

    public RicPowerup() {
        super(Ricompense.Powerup);
    }

    @Override
    public Color getColor() {
        return Color.PURPLE;
    }

    @Override
    public int getIncrement() {
        return 10;
    }

    @Override
    protected int getMax() {
        return 30;
    }
}
