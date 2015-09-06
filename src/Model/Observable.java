package Model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Brandon on 2015-09-04.
 */
public abstract class Observable {

    private List<Observer> observers;

    public Observable() {
        observers = new ArrayList<>();
    }

    public void addObserver(Observer o) {
        observers.add(o);
    }

    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    public void notifyObservers(String charName, boolean status) {
        for (Observer next : observers) {
            next.update(charName, status);
        }
    }
}
