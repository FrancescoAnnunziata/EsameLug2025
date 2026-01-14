import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.MainModel;
import view.MainView;

/**
 * Classe principale dell'applicazione JavaFX.
 * Estende Application per creare e gestire l'interfaccia grafica.
 */
public class Main extends Application {

    /**
     * Metodo start - punto di ingresso dell'applicazione JavaFX.
     * Viene chiamato automaticamente dopo il lancio dell'applicazione.
     *
     * @param stage La finestra principale dell'applicazione
     */
    @Override
    public void start(Stage stage) {
        // Crea il modello principale che contiene la logica e i dati dell'applicazione
        MainModel mm = new MainModel();

        // Crea la vista principale che gestisce l'interfaccia utente
        MainView mv = new MainView();

        // Collega il modello alla vista per visualizzare i dati
        mv.setUp(mm);
        mv.setBroslist(mm);
        mv.setRicompenselist(mm);

        // Crea la scena con la vista principale, dimensioni 800x600
        Scene scene = new Scene(mv, 800, 600);

        // Configura la finestra principale
        stage.setTitle("Bling - Brawl Stars Game");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Metodo main - punto di ingresso del programma Java.
     * Avvia l'applicazione JavaFX.
     *
     * @param args Argomenti da riga di comando
     */
    public static void main(String[] args) {
        // Lancia l'applicazione JavaFX
        launch(args);
    }
}

