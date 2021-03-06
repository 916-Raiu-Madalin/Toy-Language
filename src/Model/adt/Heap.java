package Model.adt;

import Model.Exceptions.DictionaryException;
import Model.value.IValue;

import java.util.ArrayList;
import java.util.HashMap;

public class Heap extends Dict<Integer,IValue>{
    Integer first_free = 1;
    ArrayList<Boolean> all_free;


    public Integer getFree() {
        setFree();
        for (int i = 1; i <= dictionary.size() + 1; i++) {
            if(all_free.get(i)) {
                first_free = i;
                return first_free;
            }
        }
        return first_free;
    }

    public void setFree() {
        all_free = new ArrayList<>();
        for (int i = 0; i <= dictionary.size() + 1; i++) {
            all_free.add(i, true);
        }
        all_free.set(0, false);
        for (Integer key : dictionary.keySet()) {
            all_free.set(key, false);
        }
    }
}




