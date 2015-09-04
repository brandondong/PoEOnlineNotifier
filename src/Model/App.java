package Model;

import DataProvider.AccountDataProvider;
import DataProvider.CharacterDataProvider;
import DataProvider.LeagueDataProvider;
import Model.Exceptions.NoCharacterExistsException;
import Parsers.CharacterParser;
import Parsers.LeagueParser;
import org.json.JSONException;

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

    public static void main(String[] args) throws IOException {
        Account test = null;
        try {
            test = new Account("Exaltonasdfasdf");
            System.out.println(test.getAccountName());
        } catch (NoCharacterExistsException e) {
            System.out.println("No such character exists");
        }
    }
}
