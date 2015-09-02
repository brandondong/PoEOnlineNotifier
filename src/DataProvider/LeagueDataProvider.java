package DataProvider;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Brandon on 2015-08-30.
 */
public class LeagueDataProvider extends AbstractHttpDataProvider {

    @Override
    protected URL getURL() throws MalformedURLException {
        return new URL("http://api.exiletools.com/ladder?activeleagues=1");
    }
}
