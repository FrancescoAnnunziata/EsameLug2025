package view.bropanes;

import model.bros.Bro;
import model.bros.BroIntf;

import java.util.ArrayList;

public class BroPaneFactory {

    public static BroPane createBroPane(BroIntf br){
        ArrayList<Integer> args = new ArrayList<>();
        if (br.isSbloccato()) {
            args.add(br.getLvl());
            args.add(br.getQtyTrofei());
            return new BroPaneAcquired(br.getName(), args);
        }else{
            args.add(br.getRequiredCredits());
            return new BroPaneNotAcquired(br.getName(),args);
        }
    }
}
