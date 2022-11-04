package com.example.demo;

import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/get")
public class APIController {
    Map<String, String> userList = new HashMap<String, String>(){{
        put("abc@gmail.com", "Yongjun");
        put("ys@gmail.com", "sex");
    }};
    Map<String, String> tweetText = new HashMap<String, String>() {{
        put("123456", "yongjun sexsex");
        put("22222", "kimozzzi");
        put("333", "yongjun obba");
    }};
    @RequestMapping(value="/user/{usrId}", method= RequestMethod.GET)
    public String getUserName(@PathVariable(value="usrId") String userId) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("userName", userList.getOrDefault(userId, "N/A"));
        return jsonObject.toString();
    }

    @RequestMapping(value="/tweet/{tweetId}", method=RequestMethod.GET)
    public String getTweetTextBasedOnId(@PathVariable(value="tweetId") String tweetId) {
        JSONObject jsonObject1 = new JSONObject();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("tweetText", tweetText.getOrDefault(tweetId, "N/A"));
        jsonObject1.put("tweet", jsonObject);
        return jsonObject1.toString();
    }
}
