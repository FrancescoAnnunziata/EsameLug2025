package view.bropanes;

import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import java.util.ArrayList;

public class BroPaneNotAcquired extends BroPane {
    private Text t_q;

    public BroPaneNotAcquired(String n, ArrayList<Integer> args){
        super(n, args);
    }
    @Override
    protected Color getColor() {
        return Color.OLIVE;
    }

    @Override
    protected VBox initialiseData() {
        VBox info = new VBox();
        info.getChildren().add(this.t_name);
        info.getChildren().add(this.t_q);
        return info;
    }

    @Override
    protected void initialiseTexts(ArrayList<Integer> args) {
        int q = args.get(0);
        this.t_q = new Text();
        this.t_q.setText("Crediti: "+q);
    }
}
