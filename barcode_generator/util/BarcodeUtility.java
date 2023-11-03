package util;

import java.util.HashMap;
import java.util.Map;

public class BarcodeUtility {

    private static Map<Character, String> encoding;

    public static void init () {
        encoding = new HashMap<>();
        encoding.put('0', "ssswwswss");
        encoding.put('1', "wsswssssw");
        encoding.put('2', "sswwssssw");
        encoding.put('3', "wswwsssss");
        encoding.put('4', "ssswwsssw");
        encoding.put('5', "wsswwssss");
        encoding.put('6', "sswwwssss");
        encoding.put('7', "ssswsswsw");
        encoding.put('8', "wsswsswss");
        encoding.put('9', "sswwsswss");
        encoding.put('A', "wsssswssw");
        encoding.put('B', "sswsswssw");
        encoding.put('C', "wswsswsss");
        encoding.put('D', "sssswwssw");
        encoding.put('E', "wssswwsss");
        encoding.put('F', "sswswwsss");
        encoding.put('G', "ssssswwsw");
        encoding.put('H', "wsssswwss");
        encoding.put('I', "sswsswwss");
        encoding.put('J', "sssswwwss");
        encoding.put('K', "wssssssww");
        encoding.put('L', "sswssssww");
        encoding.put('M', "wswssssws");
        encoding.put('N', "sssswssww");
        encoding.put('O', "wssswssws");
        encoding.put('P', "sswswssws");
        encoding.put('Q', "sssssswww");
        encoding.put('R', "wssssswws");
        encoding.put('S', "sswssswws");
        encoding.put('T', "sssswswws");
        encoding.put('U', "wwssssssw");
        encoding.put('V', "swwsssssw");
        encoding.put('W', "wwwssssss");
        encoding.put('X', "swsswsssw");
        encoding.put('Y', "wwsswssss");
        encoding.put('Z', "swwswssss");
        encoding.put('-', "swsssswsw");
        encoding.put('.', "wwsssswss");
        encoding.put(' ', "swwssswss");
        encoding.put('*', "swsswswss");
        encoding.put('$', "swswswsss");
        encoding.put('/', "swswsssws");
        encoding.put('+', "swssswsws");
        encoding.put('%', "ssswswsws");
    }

    public static String constructBarcode (String message) {
        if (encoding == null) init();
        String result = "";
        String codeword = "*" + message.toUpperCase() + "*";

        for (int i = 0; i < codeword.length(); i++) {
            result += encoding.get(codeword.charAt(i));
            if (i != codeword.length() - 1) result += "s";
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(constructBarcode("jan hat waesche"));
    }
}
