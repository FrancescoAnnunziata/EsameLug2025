package controller;

import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;
import model.MainModel;
import model.exceptions.MaxExceededException;
import model.ricompense.RicompensaIntf;
import view.MainView;
import view.RicompensaPane;

public class RicompensaController implements EventHandler<MouseEvent> {
    protected RicompensaIntf ar;
    protected RicompensaPane rp;
    private MainModel mm;
    private MainView mv;

    public RicompensaController(RicompensaIntf a, RicompensaPane p, MainModel m, MainView v){
        this.ar = a;
        this.rp = p;
        this.mm = m;
        this.mv = v;
    }

    private void increment(){
        try {
            this.ar.increment();
            this.rp.setQty(this.ar.getQty());
            this.ar.getEffect().accept(this.mm);
            this.mv.setUp(this.mm);
            this.mv.setBroslist(this.mm);
        } catch (MaxExceededException e) {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("Massimo raggiunto");
            a.showAndWait();
        }
    }

    @Override
    public void handle(MouseEvent mouseEvent) {
        this.increment();
    }
}
