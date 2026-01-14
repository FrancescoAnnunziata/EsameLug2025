package view;

import controller.BroController;
import controller.RicompensaController;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.MainModel;
import model.bros.BroIntf;
import model.bros.comparators.BroLvlComparator;
import model.bros.comparators.BroTrofeiComparator;
import model.ricompense.RicompensaIntf;
import view.bropanes.BroPane;
import view.bropanes.BroPaneFactory;

public class MainView extends VBox {

    private UserPane up;
    private HBox broslist;
    private HBox ricompenselist;

    public MainView(){
        this.up = new UserPane(0,0);
        this.broslist = new HBox();
        this.broslist.setAlignment(Pos.CENTER);
        this.ricompenselist = new HBox();
        this.ricompenselist.setAlignment(Pos.CENTER);
        this.initialise();
        this.setSpacing(10);
        this.setAlignment(Pos.CENTER);
    }

    public void setUp(MainModel mm) {
        this.up = new UserPane(mm.getU().getEloLvl(), mm.getU().getQtyTrofei());
        this.initialise();
    }
    public void setBroslist(MainModel mm){
        this.broslist.getChildren().removeAll(this.broslist.getChildren());

        VBox hb = new VBox();
        hb.setSpacing(10);
        hb.setAlignment(Pos.CENTER);
        Button sortLv = new Button("Ordina (Lvl)");
        sortLv.setOnAction(e->{
            BroLvlComparator blc = new BroLvlComparator();
            mm.getAb_si().sort(blc);
            this.setBroslist(mm);
        });
        hb.getChildren().add(sortLv);
        Button sortT = new Button("Ordina (Trofei)");
        sortT.setOnAction(e->{
            BroTrofeiComparator blt = new BroTrofeiComparator();
            mm.getAb_si().sort(blt);
            this.setBroslist(mm);
        });
        hb.getChildren().add(sortT);
        this.broslist.getChildren().add(hb);

        for (BroIntf b: mm.getAllBros()) {
            BroPane bp = BroPaneFactory.createBroPane(b);
            BroController bc = new BroController(b,mm,this);
            bp.setController(bc);
            this.broslist.getChildren().add(bp);
        }
        this.initialise();
    }
    public void setRicompenselist(MainModel mm){
        this.ricompenselist.getChildren().removeAll(this.ricompenselist.getChildren());
        for (RicompensaIntf a : mm.getAr()){
            RicompensaPane rp = new RicompensaPane(a.getColor(),a.getR(),a.getQty());
            this.ricompenselist.getChildren().add(rp);

            RicompensaController ric = new RicompensaController(a,rp,mm,this);
            rp.setController(ric);
        }
        this.initialise();
    }

    private void initialise(){
        this.getChildren().removeAll(this.getChildren());
        this.getChildren().add(up);
        this.getChildren().add(broslist);
        this.getChildren().add(ricompenselist);
    }

}
