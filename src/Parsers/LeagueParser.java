package Parsers;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Brandon on 2015-09-01.
 */
public class LeagueParser {

    public static List<String> parseLeagueData(String jsonResponse) throws JSONException {
        List<String> leagues = new ArrayList<>();
        JSONObject leagueData = new JSONObject(jsonResponse);

        Iterator<String> keys = leagueData.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            leagues.add(leagueData.getString(next));
        }
        return leagues;
    }
}
