package Model;

import DataProvider.LeagueDataProvider;
import Model.Exceptions.NoCharacterExistsException;
import Parsers.LeagueParser;
import UI.StatusBar;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Brandon on 2015-08-27.
 */
public class App extends Observable {

    public static List<String> LEAGUE_NAMES;

    private List<Account> accounts;

    public App() {
        accounts = new ArrayList<>();
    }

    // Modifies: this
    // Effects: adds and returns the specified account, throws NoCharacterExistsException if account is invalid
    public Account addAccount(String charName) throws NoCharacterExistsException {
        Account toAdd = new Account(charName);
        if (!accounts.contains(toAdd)) {
            accounts.add(toAdd);
        }
        return toAdd;
    }

    public void removeAccount(Account a) {
        accounts.remove(a);
    }

    // Modifies: this
    // Effects: updates each account, notifying observers if needed
    public void update() {
        for (Account next : accounts) {
            if (next.updateStatus()) {
                notifyObservers(next.getCharName(), next.isOnline());
            }
        }
    }

    public static List<String> getLeagues() {
        if (LEAGUE_NAMES == null) {
            try {
                LEAGUE_NAMES = LeagueParser.parseLeagueData(new LeagueDataProvider().dataSourceToString());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return LEAGUE_NAMES;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

}
