package Parsers;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Brandon on 2015-08-27.
 */
public class CharacterParser {

    public static String getAccountNameFromCharacter(String jsonResponse) throws JSONException {
        JSONObject charData = new JSONObject(jsonResponse);
        JSONArray names = charData.names();
        String key = names.getString(0);
        return key.substring(0, key.indexOf("."));
    }
}
