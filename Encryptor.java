import java.util.Scanner;

public class Encryptor {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your msg: ");
        String msg = scanner.nextLine();

        Rotor[] rotors = Enigma.rotors;
        Enigma.initializeRotors();

        System.out.println(encrypt(msg, rotors));
    }

    public static final int frontSalt = 3;
    public static final int backSalt = 3;

    public static String encrypt(String msg, Rotor[] rotors) {
        StringBuilder cipher = new StringBuilder(msg);

        // Rotor Mechanism
        for (Rotor currRot : rotors) {
            cipher = enc(cipher, currRot);
        }

        // Swapper
        cipher = new StringBuilder(Swapper.swap(cipher.toString()));

        // Salting
        StringBuilder tmp = new StringBuilder();
        // Front Salt
        for (int j = 0; j < frontSalt; j++) {
            char randChar = Map.defaultMap[(int)(Math.random() * Map.defaultMap.length)];
            tmp.append(randChar);
        }

        // Central copying
        for (int i = 0, p = cipher.toString().length(); i < p; i++) {
            tmp.append(cipher.charAt(i));
        }

        // Back Salt
        for (int j = 0; j < backSalt; j++) {
            char randChar = Map.defaultMap[(int)(Math.random() * Map.defaultMap.length)];
            tmp.append(randChar);
        }

        cipher = tmp;
        return cipher.toString();
    }

    public static StringBuilder enc(StringBuilder msg, Rotor currRot) {
        StringBuilder tmp = new StringBuilder();
        String msgStr = msg.toString();
        for (int i = 0, n = msg.length(); i < n; i++) {
            char currChar = msgStr.charAt(i);
            char charToReplace = currRot.getCharToReplace(currChar, i);
            tmp.append(charToReplace);
        }
        return tmp;
    }

}
