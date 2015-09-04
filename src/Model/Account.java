package Model;

import DataProvider.CharacterDataProvider;
import Model.Exceptions.NoCharacterExistsException;
import Parsers.CharacterParser;
import org.json.JSONException;

import java.io.IOException;

/**
 * Created by Brandon on 2015-08-26.
 */
public class Account {

    private String charName;
    private String accountName;
    private boolean isOnline;

    public Account(String charName) throws NoCharacterExistsException {
        this.charName = charName;
        for (String league : App.LEAGUE_NAMES) {
            try {
                accountName = CharacterParser.getAccountNameFromCharacter(new CharacterDataProvider(charName, league).dataSourceToString());
            } catch (Exception e) {

            }
        }
        if (accountName == null) {
            throw new NoCharacterExistsException();
        }
    }

    public String getCharName() {
        return charName;
    }

    public String getAccountName() {
        return accountName;
    }
}
