package model.bros.comparators;

import model.bros.Bro;
import model.bros.BroIntf;

import java.util.Comparator;

public class BroLvlComparator implements Comparator<BroIntf> {
    @Override
    public int compare(BroIntf o1, BroIntf o2) {
        if (o1.getLvl() == o2.getLvl()){
            return o1.compareTo(o2);
        }
        return Integer.compare(o2.getLvl(), o1.getLvl());
    }
}
