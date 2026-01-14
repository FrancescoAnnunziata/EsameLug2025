package model.bros.comparators;

import model.bros.Bro;
import model.bros.BroIntf;

import java.util.Comparator;

public class BroTrofeiComparator implements Comparator<BroIntf> {
    @Override
    public int compare(BroIntf o1, BroIntf o2) {
        if (o1.getQtyTrofei() == o2.getQtyTrofei()){
            return o1.compareTo(o2);
        }
        return Integer.compare(o2.getQtyTrofei(),o1.getQtyTrofei());
    }
}
