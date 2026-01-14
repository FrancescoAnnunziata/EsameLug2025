package view.bropanes;

import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import java.util.ArrayList;

public class BroPaneAcquired extends BroPane{
    private Text t_lv;
    private Text t_tr;

    public BroPaneAcquired(String n, ArrayList<Integer> args){
        super(n, args);
    }

    @Override
    protected Color getColor() {
        return Color.GREEN;
    }

    @Override
    protected VBox initialiseData() {
        VBox info = new VBox();
        info.getChildren().add(this.t_name);
        info.getChildren().add(this.t_lv);
        info.getChildren().add(this.t_tr);
        return info;
    }

    @Override
    protected void initialiseTexts(ArrayList<Integer> args) {
        int lv = args.get(0);
        int tr = args.get(1);

        this.t_lv = new Text();
        this.setLvl(lv);
        this.t_tr = new Text();
        this.setTrofei(tr);
    }

    public void setLvl(int q){
        this.t_lv.setText("Lv: "+q);
    }
    public void setTrofei(int q){
        this.t_tr.setText("Trofei: "+q);
    }
}
