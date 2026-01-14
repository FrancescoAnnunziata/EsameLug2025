package view.bropanes;

import controller.BroController;
import javafx.geometry.Pos;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import java.util.ArrayList;

public abstract class BroPane extends StackPane {
    private static final int SIZE = 40;
    private Circle c;
    protected Text t_name;

    protected BroPane(String n, ArrayList<Integer> args){
        this.c = new Circle(SIZE);
        this.c.setFill(this.getColor());
        this.getChildren().add(c);

        this.t_name = new Text();
        this.t_name.setText(n);

        this.initialiseTexts(args);
        VBox v = this.initialiseData();
        v.setAlignment(Pos.CENTER);
        v.setSpacing(5);
        this.getChildren().add(v);
    }

    public void setController(BroController bc){
        this.setEventHandler(MouseEvent.MOUSE_CLICKED, bc);
    }

    protected abstract Color getColor();
    protected abstract VBox initialiseData();
    protected abstract void initialiseTexts(ArrayList<Integer> args);
}
