package DataProvider;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Brandon on 2015-08-26.
 */
public class CharacterDataProvider extends AbstractHttpDataProvider {

    public CharacterDataProvider(String charName, String leagueName) {
        name = charName;
        league = leagueName;
    }

    @Override
    protected URL getURL() throws MalformedURLException {
        String request = "http://api.exiletools.com/ladder?" + "league=" + league +
                "&charName=" + name;
        return new URL(request);
    }
}
