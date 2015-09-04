package Model;

import DataProvider.LeagueDataProvider;
import Model.Exceptions.NoCharacterExistsException;
import Parsers.LeagueParser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Brandon on 2015-08-27.
 */
public class App {

    public static List<String> LEAGUE_NAMES;

    static {
        try {
            LEAGUE_NAMES = LeagueParser.parseLeagueData(new LeagueDataProvider().dataSourceToString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private List<Account> accounts;

    public App() {
        accounts = new ArrayList<>();
    }

    public void addAccount(String charName) throws NoCharacterExistsException {
        Account toAdd = new Account(charName);
        if (!accounts.contains(toAdd)) {
            accounts.add(toAdd);
        }
    }

    public static void main(String[] args) throws IOException {
        Account test = null;
        try {
            test = new Account("Havoc");
            System.out.println(test.getAccountName());
            System.out.println(test.isOnline());
        } catch (NoCharacterExistsException e) {
            System.out.println("No such character exists");
        }
    }
}
