import java.util.*;
public class TerstHashMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<String,String>();
        map.put("1", "a");
        System.out.println(map.toString());
        map.put("2", "b");
        System.out.println(map.toString());
        map.put("3", "c");
        System.out.println(map.toString());
        System.out.println(map.get("1"));
        System.out.println(map.get("2"));
        System.out.println(map.get("3"));
        System.out.println(map.get("4"));
        System.out.println(map.getOrDefault("4", "N/A"));
        System.out.println(map.getOrDefault("3", "N/A"));

    }
}
