package model.ricompense;

import model.MainModel;
import model.enums.Ricompense;
import model.exceptions.MaxExceededException;
import java.util.function.Consumer;

/**
 * Classe astratta che rappresenta una ricompensa generica nel gioco.
 * Fornisce l'implementazione base comune a tutte le ricompense.
 */
public abstract class AbstractRicompensa implements RicompensaIntf {
    // Tipo di ricompensa (enum che identifica il tipo specifico)
    private Ricompense r;

    // Quantità attuale della ricompensa posseduta
    protected int qty;

    // Effetto che questa ricompensa ha sul modello principale quando viene applicata
    // Utilizza un Consumer per incapsulare l'azione da eseguire
    public Consumer<MainModel> effect;

    /**
     * Costruttore della ricompensa astratta.
     * Inizializza la ricompensa con quantità 0 e nessun effetto.
     *
     * @param r Il tipo di ricompensa (enum Ricompense)
     */
    protected AbstractRicompensa(Ricompense r){
        this.r = r;
        this.qty = 0; // All'inizio la quantità è sempre 0
        this.effect = mainModel -> {}; // Effetto vuoto di default (no-op)
    }

    /**
     * Incrementa la quantità della ricompensa.
     * La quantità aumenta in base al valore restituito da getIncrement().
     *
     * @throws MaxExceededException Se viene superato il massimo consentito
     */
    @Override
    public void increment() throws MaxExceededException {
        this.qty+=this.getIncrement();
    }

    /**
     * Restituisce la quantità attuale della ricompensa.
     *
     * @return La quantità posseduta di questa ricompensa
     */
    @Override
    public int getQty() {
        return qty;
    }

    /**
     * Restituisce il tipo di ricompensa.
     *
     * @return L'enum Ricompense che identifica il tipo
     */
    @Override
    public Ricompense getR() {
        return r;
    }

    /**
     * Restituisce l'effetto associato a questa ricompensa.
     * L'effetto è una funzione che modifica il MainModel quando viene applicata.
     *
     * @return Un Consumer che rappresenta l'effetto sul modello principale
     */
    @Override
    public Consumer<MainModel> getEffect() {
        return effect;
    }
}
