package model;

import model.bros.Bro;
import model.bros.BroIntf;
import model.exceptions.NotEnoughCreditiException;
import model.ricompense.*;
import model.ricompense.withMax.RicMonete;
import model.ricompense.withMax.RicPowerup;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;


public class MainModel {

    private Utente u;
    private ArrayList<BroIntf> ab_no;
    private ArrayList<BroIntf> ab_si;
    private HashSet<RicompensaIntf> ar;
    private RicPowerup rp;
    private RicMonete rm;

    public MainModel(){
        this.u = new Utente();

        this.ab_no = new ArrayList<>();
        this.ab_si = new ArrayList<>();

        ab_no.add(new Bro("Colt", 10));
        ab_no.add(new Bro("Emz", 40));
        ab_no.add(new Bro("Draco", 100));
        ab_no.add(new Bro("Moe", 150));
        ab_no.add(new Bro("Chuck", 200));

        this.ar = new HashSet<>();
        ar.add(new RicCrediti());
        ar.add(new RicElo());
        rm = new RicMonete();
        ar.add(rm);
        rp = new RicPowerup();
        ar.add(rp);
        ar.add(new RicTrofei());
    }

    public ArrayList<BroIntf> getAb_si() {
        return this.ab_si;
    }
    public ArrayList<BroIntf> getAllBros() {
        ArrayList<BroIntf> ret = new ArrayList<>();
        ret.addAll(this.ab_si);
        ret.addAll(this.ab_no);
        return ret;
    }
    public HashSet<RicompensaIntf> getAr() {
        return ar;
    }
    public Utente getU() {
        return u;
    }
    public RicMonete getRm() {
        return rm;
    }
    public RicPowerup getRp() {
        return rp;
    }

    public void addElo(int qty){
        this.u.addElo(qty);
    }
    public void addTrofei(int qty) {
        this.u.addTrofei(qty);
        if (!this.ab_si.isEmpty()){
            this.ab_si.get(0).addXTrofei(qty);
        }
    }
    public void unlockBros(RicCrediti rc) {
        for (int i = 0 ; i < this.ab_no.size(); i++){
            BroIntf b = this.ab_no.get(i);
            try {
                b.sblocca(rc);
                if (b.isSbloccato()){
                    this.ab_no.remove(b);
                    this.ab_si.add(b);
                    Collections.sort(this.ab_si);
                }
            } catch (NotEnoughCreditiException e) {
                // qui bisognerebbe far qualcosa
            }
        }
    }
}
