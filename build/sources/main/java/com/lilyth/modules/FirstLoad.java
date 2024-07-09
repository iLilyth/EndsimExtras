package com.lilyth.modules;

import com.google.gson.Gson;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class FirstLoad {
    public FirstLoad() {
        try {
            File theDir = new File("./config/EndsimExtras");
            if (!theDir.exists()) FileUtils.forceMkdir(theDir);
            File storage = new File("./config/EndsimExtras/dropstorage.json");
            if (storage.createNewFile()) {
                Gson gson = new Gson();
                Map<String, Integer> map = new HashMap<>();
                map.put("placed1", 0);
                map.put("placed2", 0);
                map.put("candy", 0);
                map.put("summoning", 0);
                map.put("ice", 0);
                map.put("cosmic", 0);
                map.put("radioactive", 0);
                map.put("flaming", 0);
                map.put("ameliorate", 0);
                map.put("divine", 0);
                map.put("shell", 0);
                map.put("yolk", 0);
                map.put("tear", 0);
                try (FileWriter writer = new FileWriter("./config/EndsimExtras/dropstorage.json")) {
                    gson.toJson(map, writer);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
