package factory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class ObjectFactory {
    private final static Map<String,Object> OBJECT_MAP = new HashMap<>();
    static {
        InputStream is = ObjectFactory.class.getClassLoader().getResourceAsStream("Object.txt");
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        String msg;
        try {
            while ((msg = br.readLine()) != null){
                String key = msg.split("=")[0];
                String value = msg.split("=")[1];
                OBJECT_MAP.put(key,Class.forName(value).newInstance());
            }
        } catch (IOException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static Object getObject(String key){
        return OBJECT_MAP.get(key);
    }
}
