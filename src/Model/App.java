package Model;

import DataProvider.AccountDataProvider;
import DataProvider.CharacterDataProvider;
import Parsers.CharacterParser;
import org.json.JSONException;

import java.io.IOException;

/**
 * Created by Brandon on 2015-08-27.
 */
public class App {

    public static void main(String[] args) throws IOException, JSONException {
        CharacterDataProvider test = new CharacterDataProvider("WTBsurvivability", "hardcore");
        System.out.print(CharacterParser.getAccountNameFromCharacter(test.dataSourceToString()));
    }
}
