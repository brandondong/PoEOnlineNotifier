package DataProvider;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Brandon on 2015-08-26.
 */
public class AccountDataProvider extends AbstractHttpDataProvider {

    public AccountDataProvider(String accountName, String leagueName) {
        name = accountName;
        league = leagueName;
    }

    @Override
    protected URL getURL() throws MalformedURLException {
        String request = "http://api.exiletools.com/ladder?" + "league=" + league +
                "&accountName=" + name;
        return new URL(request);
    }
}
