package view;

import controller.RicompensaController;
import javafx.geometry.Pos;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import model.enums.Ricompense;

/**
 * Pannello grafico che rappresenta una ricompensa nell'interfaccia utente.
 * Estende StackPane per sovrapporre gli elementi grafici (rettangoli e testo).
 */
public class RicompensaPane extends StackPane {
    // Dimensioni del pannello
    private static final int L = 100;  // Larghezza del pannello
    private static final int H = 30;   // Altezza del pannello
    private static final int BORDERSIZE = 5+5;  // Spessore del bordo (5 px per lato)

    // Elementi grafici del pannello
    private Rectangle bgr;    // Rettangolo di sfondo nero (bordo esterno)
    private Rectangle r;      // Rettangolo interno colorato
    private Text t_name;      // Testo che mostra il nome della ricompensa
    private Text t_q;         // Testo che mostra la quantità della ricompensa

    /**
     * Costruttore del pannello ricompensa.
     *
     * @param insidecol Colore di riempimento del rettangolo interno
     * @param r Tipo di ricompensa (enum Ricompense)
     * @param qty Quantità della ricompensa da visualizzare
     */
    public RicompensaPane(Color insidecol, Ricompense r, int qty){
        // Crea il rettangolo di sfondo nero (per creare l'effetto bordo)
        this.bgr = new Rectangle(L, H);
        this.bgr.setFill(Color.BLACK);

        // Crea il rettangolo interno colorato, più piccolo per far vedere il bordo nero
        this.r = new Rectangle(L-BORDERSIZE, H-BORDERSIZE);
        this.r.setFill(insidecol);

        // Crea e imposta il testo per il nome della ricompensa
        this.t_name = new Text();
        this.t_name.setText(r.toString()+": ");

        // Crea il testo per la quantità e lo imposta
        this.t_q = new Text();
        this.setQty(qty);

        // Crea un contenitore orizzontale (HBox) per i testi
        HBox hb  = new HBox();
        hb.getChildren().add(t_name);
        hb.getChildren().add(t_q);
        hb.setAlignment(Pos.CENTER);  // Centra i testi nel contenitore

        // Aggiunge gli elementi al pannello in ordine di sovrapposizione
        // (prima il bordo nero, poi il rettangolo colorato, infine il testo sopra)
        this.getChildren().add(this.bgr);
        this.getChildren().add(this.r);
        this.getChildren().add(hb);
    }

    /**
     * Associa un controller a questo pannello per gestire gli eventi del mouse.
     * Quando l'utente clicca sul pannello, il controller specificato gestirà l'evento.
     *
     * @param ric Il controller che gestirà gli eventi di click sul pannello
     */
    public void setController(RicompensaController ric){
        this.setEventHandler(MouseEvent.MOUSE_CLICKED, ric);
    }

    /**
     * Aggiorna la quantità visualizzata nel pannello.
     * Converte il numero intero in stringa e lo mostra nel testo della quantità.
     *
     * @param q La nuova quantità da visualizzare
     */
    public void setQty(int q){
        this.t_q.setText(q+"");
    }
}
