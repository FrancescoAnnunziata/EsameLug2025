package model.ricompense;

import javafx.scene.paint.Color;
import model.enums.Ricompense;

public class RicElo extends AbstractRicompensa{
    public RicElo() {
        super(Ricompense.Elo);
        this.effect = mainModel -> {
            mainModel.addElo(this.getIncrement());
        };
    }

    @Override
    public Color getColor() {
        return Color.GRAY;
    }

    @Override
    public int getIncrement() {
        return 70;
    }
}
