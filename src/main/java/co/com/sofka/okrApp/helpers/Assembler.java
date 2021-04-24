package co.com.sofka.okrApp.helpers;

import co.com.sofka.okrApp.modelo.Okr;
import co.com.sofka.okrApp.modelo.OkrList;

import java.util.ArrayList;
import java.util.List;

public class Assembler {

    public static List<OkrList> okrListGenerator(List<Okr> okrs){
        List<OkrList> okrList = new ArrayList<>();
        okrs.forEach(okr -> {
            okrList.add(new OkrList(okr.getId(), okr.getNombre(), okr.getAvancePorcentual()));
        });
        return okrList;
    }
}
