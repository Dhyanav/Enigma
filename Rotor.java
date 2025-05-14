import java.util.Objects;

public class Rotor {
    int freq;
    char[] map;

    Rotor(char[] map, int freq) {
        this.freq = freq;
        this.map = Objects.requireNonNullElse(map, Map.defaultMap);
    }


    public char getCharToReplace(char currChar, int msgIdx) {

        if (map == null)
            return currChar;

        int numToAdd = (msgIdx % this.freq) + 1;

        int charIdx = 0;
        for (int i = 0; i < map.length; i++) {
            if (currChar == map[i]) {
                charIdx = i;
                break;
            }
        }

        if (numToAdd == 0)
            numToAdd = freq;
        if (charIdx + numToAdd >= map.length)
            return map[charIdx + numToAdd - map.length];
        else
            return map[charIdx + numToAdd];
    }
}
