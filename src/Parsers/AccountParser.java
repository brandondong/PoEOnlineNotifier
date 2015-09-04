package Parsers;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Iterator;

/**
 * Created by Brandon on 2015-09-04.
 */
public class AccountParser {

    public static boolean isAccountOnline(String jsonResponse) throws JSONException {
        JSONObject response = new JSONObject(jsonResponse);
        Iterator<String> keys = response.keys();
        while (keys.hasNext()) {
            String key = keys.next();
            JSONObject next = response.getJSONObject(key);
            if (isCharacterOnline(next)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isCharacterOnline(JSONObject character) throws JSONException {
        String online = character.getString("online");
        return online.equals("1");
    }
}
