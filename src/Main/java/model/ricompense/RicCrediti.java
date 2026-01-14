package model.ricompense;

import javafx.scene.paint.Color;
import model.enums.Ricompense;

public class RicCrediti extends AbstractRicompensa{

    public RicCrediti() {
        super(Ricompense.Crediti);
        this.effect = mainModel -> {
            mainModel.unlockBros(this);
        };
    }

    @Override
    public Color getColor() {
        return Color.CYAN;
    }

    @Override
    public int getIncrement() {
        return 30;
    }
}
