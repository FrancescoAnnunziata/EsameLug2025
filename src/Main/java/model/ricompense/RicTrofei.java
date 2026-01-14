package model.ricompense;

import javafx.scene.paint.Color;
import model.enums.Ricompense;

public class RicTrofei extends AbstractRicompensa{
    public RicTrofei() {
        super(Ricompense.Trofei);
        this.effect = mainModel -> {
            mainModel.addTrofei(this.getIncrement());
        };
    }

    @Override
    public Color getColor() {
        return Color.MAROON;
    }

    @Override
    public int getIncrement() {
        return 8;
    }
}
