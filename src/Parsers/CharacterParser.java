package Parsers;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Iterator;

/**
 * Created by Brandon on 2015-08-27.
 */
public class CharacterParser {

    public static String getAccountNameFromCharacter(String jsonResponse) throws JSONException {
        JSONObject charData = new JSONObject(jsonResponse);
        Iterator<String> keys = charData.keys();
        String key = keys.next();
        return key.substring(0, key.indexOf("."));
    }
}
