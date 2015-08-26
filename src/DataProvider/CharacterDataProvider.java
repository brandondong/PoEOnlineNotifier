package DataProvider;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Brandon on 2015-08-26.
 */
public class CharacterDataProvider extends AbstractHttpDataProvider {

    private String charName;

    public CharacterDataProvider(String charName) {
        this.charName = charName;
    }

    @Override
    protected URL getURL() throws MalformedURLException {
        String request = "http://api.exiletools.com/ladder?charName=" + charName;
        return new URL(request);
    }
}
