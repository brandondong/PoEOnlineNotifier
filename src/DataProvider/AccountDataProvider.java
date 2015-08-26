package DataProvider;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Brandon on 2015-08-26.
 */
public class AccountDataProvider extends AbstractHttpDataProvider {

    private String accountName;

    public AccountDataProvider(String accountName) {
        this.accountName = accountName;
    }

    @Override
    protected URL getURL() throws MalformedURLException {
        String request = "http://api.exiletools.com/ladder?accountName=" + accountName;
        return new URL(request);
    }
}
