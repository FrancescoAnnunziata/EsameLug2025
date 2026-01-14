package view;

import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public class UserPane extends HBox {
    private Text elotext;
    private Text trofeitext;

    public UserPane(int elo, int trofei){
        this.elotext = new Text();
        this.trofeitext = new Text();

        this.setElotext(elo);
        this.setTrofeitext(trofei);

        this.getChildren().add(this.elotext);
        this.getChildren().add(this.trofeitext);
        this.setAlignment(Pos.TOP_CENTER);
        this.setSpacing(10);
    }

    public void setElotext(int elotext) {
        this.elotext.setText("Elo: "+elotext);
    }
    public void setTrofeitext(int ttext) {
        this.trofeitext.setText("Trofei: "+ttext);
    }
}
