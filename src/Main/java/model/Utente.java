package model;

public class Utente {
    private int eloLvl;
    private int qtyTrofei;

    public Utente(){
        this.eloLvl = 0;
        this.qtyTrofei = 0;
    }

    public void addElo(int amt){
        this.eloLvl+=amt;
    }
    public void addTrofei(int amt){
        this.qtyTrofei+=amt;
    }

    public int getEloLvl() {
        return eloLvl;
    }
    public int getQtyTrofei() {
        return qtyTrofei;
    }
}
