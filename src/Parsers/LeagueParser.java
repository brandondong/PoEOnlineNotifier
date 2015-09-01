package Parsers;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Brandon on 2015-09-01.
 */
public class LeagueParser {

    public static List<String> parseLeagueData(String jsonResponse) throws JSONException {
        JSONArray leagues = new JSONArray(jsonResponse);
        List<String> listOfLeagues = new ArrayList<>();

        for (int i = 0; i < leagues.length(); i++) {
            JSONObject next = leagues.getJSONObject(i);
            listOfLeagues.add(next.getString("id"));
        }
        return listOfLeagues;
    }
}
