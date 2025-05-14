import java.util.Scanner;

public class Enigma {

    public static Rotor[] rotors = new Rotor[5];

    public static void main(String[] arg) {

        initializeRotors();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your message: ");
        String msg = scanner.nextLine().toLowerCase();

        String cipher = encryptMsg(msg, rotors);
        System.out.println("Cipher is: " + cipher);

        String decipher = decryptMsg(cipher, rotors);
        System.out.println("Decipher is: " + decipher);

    }

    public static void initializeRotors() {
        rotors[0] = new Rotor(Map.map1, 5);
        rotors[1] = new Rotor(Map.map2, 3);
        rotors[2] = new Rotor(Map.map3, 2);
        rotors[3] = new Rotor(Map.map4, 6);
        rotors[4] = new Rotor(Map.map5, 4);
    }

    public static String encryptMsg( String msg , Rotor[] rotors ) {
        String cipher = msg;

        for (Rotor rotor : rotors)
            cipher = encrypt(cipher, rotor);

        cipher = Swapper.swap( cipher );

        for (int i = rotors.length - 1; i >= 0 ; i--)
            cipher = encrypt(cipher, rotors[i]);

        return cipher;
    }

    public static String encrypt( String msg , Rotor rotor ) {
        StringBuilder cipher = new StringBuilder();
        for (int i = 0, n = msg.length(); i < n; i++) {
            cipher.append(rotor.getCharToReplace(msg.charAt(i), i));
        }
        return cipher.toString();
    }

    private static String decryptMsg ( String cipher , Rotor[] rotors) {

        String decipher = cipher;

        for (Rotor rotor : rotors)
            decipher = decrypt(decipher, rotor);

        decipher = Swapper.swap(decipher);

        for (int i = rotors.length - 1; i >= 0; i--)
            decipher = decrypt(decipher, rotors[i]);

        return decipher;
    }

    private static String decrypt( String cipher , Rotor rotor ) {
        StringBuilder decipher = new StringBuilder();
        for (int i = 0, n = cipher.length(); i < n; i++) {
            char currChar = cipher.charAt(i);

            int numToSub = ( i % rotor.freq ) + 1;
            int charIdx = 0;
            for (int j = 0; j < rotor.map.length; j++) {
                if (currChar == rotor.map[j]) {
                    charIdx = j;
                    break;
                }
            }
            if (numToSub == 0)
                numToSub = rotor.freq;
            if ( (charIdx - numToSub) < 0 )
                decipher.append(rotor.map[charIdx - numToSub + rotor.map.length]);
            else
                decipher.append(rotor.map[charIdx - numToSub]);
        }
        return decipher.toString();
    }

}
