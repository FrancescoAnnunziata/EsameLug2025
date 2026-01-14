package model.ricompense;

import javafx.scene.paint.Color;
import model.MainModel;
import model.enums.Ricompense;
import model.exceptions.MaxExceededException;

import java.util.function.Consumer;

public interface RicompensaIntf {
    Color getColor();

    int getIncrement();
    void increment() throws MaxExceededException;
    int getQty();
    Ricompense getR();
    Consumer<MainModel> getEffect();
}
