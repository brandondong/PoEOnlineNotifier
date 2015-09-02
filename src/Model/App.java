package Model;

import DataProvider.AccountDataProvider;
import DataProvider.CharacterDataProvider;
import DataProvider.LeagueDataProvider;
import Parsers.CharacterParser;
import Parsers.LeagueParser;
import org.json.JSONException;

import java.io.IOException;
import java.util.List;

/**
 * Created by Brandon on 2015-08-27.
 */
public class App {

    public static void main(String[] args) throws IOException, JSONException {
        CharacterDataProvider test = new CharacterDataProvider("WTBsurvivability", "hardcore");
        System.out.println(CharacterParser.getAccountNameFromCharacter(test.dataSourceToString()));
        LeagueDataProvider test2 = new LeagueDataProvider();
        for (String next : LeagueParser.parseLeagueData(test2.dataSourceToString())) {
            System.out.println(next);
        }
    }
}
