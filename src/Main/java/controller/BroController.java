package controller;

import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;
import model.MainModel;
import model.bros.BroIntf;
import model.exceptions.NotEnoughToDecrementException;
import model.ricompense.RicompensaIntf;
import view.MainView;

public class BroController implements EventHandler<MouseEvent> {
    private BroIntf bro;
    private MainModel mm;
    private MainView mv;

    public BroController(BroIntf b, MainModel m, MainView v){
        this.bro = b;
        this.mm = m;
        this.mv = v;
    }

    @Override
    public void handle(MouseEvent mouseEvent) {
        if (!this.bro.isSbloccato()){
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("Bro non sbloccato");
            a.showAndWait();
        }else{
            try {
                this.bro.levelupAndDecrement(this.mm.getRp(), this.mm.getRm());
                this.mv.setBroslist(this.mm);
                this.mv.setRicompenselist(this.mm);
            } catch (NotEnoughToDecrementException e) {
                Alert a = new Alert(Alert.AlertType.ERROR);
                String s = "";
                for (RicompensaIntf ar: e.getSr()) {
                    int x = 10 - ar.getQty();
                    String y = ar.getR().toString();
                    s += "Mancano "+x+" ricompense di tipo "+y+" per livellare \n";
                }
                a.setContentText(s);
                a.showAndWait();
            }
        }
    }
}
