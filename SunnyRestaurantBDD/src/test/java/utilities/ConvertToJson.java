package utilities;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.json.JSONArray;
import org.json.JSONObject;
import vos.MenuItems;
import vos.RestaurantOrder;

public class ConvertToJson {

    public JSONObject convertMenuItemsJason(MenuItems menuItems) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString = objectMapper.writeValueAsString(menuItems);
        JSONObject jsonObject = new JSONObject(jsonString);
        return jsonObject;
    }

    public String convertStringArrayJason(String[] chefUpdate) throws JsonProcessingException {
        Gson gson = new Gson();
        String jsonString = gson.toJson(chefUpdate);
        return jsonString;
    }

    public JSONObject convertOrderJason(RestaurantOrder restaurantOrder) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString = objectMapper.writeValueAsString(restaurantOrder);
        JSONObject jsonObject = new JSONObject(jsonString);
        return jsonObject;
    }
}
