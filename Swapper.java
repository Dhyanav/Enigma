abstract public class Swapper {

    public static String swap(String msg) {

        if (msg == null)
            return null;

        StringBuilder cipher = new StringBuilder();

        for (int i = 0, n = msg.length(); i < n; i++) {
            char currChar = msg.charAt(i);
            switch (currChar) {
                case 'a' : cipher.append('z');
                    break;
                case 'b' : cipher.append('y');
                    break;
                case 'c' : cipher.append('x');
                    break;
                case 'd' : cipher.append('w');
                    break;
                case 'e' : cipher.append('v');
                    break;
                case 'f' : cipher.append('u');
                    break;
                case 'g' : cipher.append('t');
                    break;
                case 'h' : cipher.append('s');
                    break;
                case 'i' : cipher.append('r');
                    break;
                case 'j' : cipher.append('q');
                    break;
                case 'k' : cipher.append('p');
                    break;
                case 'l' : cipher.append('o');
                    break;
                case 'm' : cipher.append('n');
                    break;
                case 'n' : cipher.append('m');
                    break;
                case 'o' : cipher.append('l');
                    break;
                case 'p' : cipher.append('k');
                    break;
                case 'q' : cipher.append('j');
                    break;
                case 'r' : cipher.append('i');
                    break;
                case 's' : cipher.append('h');
                    break;
                case 't' : cipher.append('g');
                    break;
                case 'u' : cipher.append('f');
                    break;
                case 'v' : cipher.append('e');
                    break;
                case 'w' : cipher.append('d');
                    break;
                case 'x' : cipher.append('c');
                    break;
                case 'y' : cipher.append('b');
                    break;
                case 'z' : cipher.append('a');
                    break;
                default: cipher.append(currChar);
                break;
            }
        }
        return cipher.toString();
    }
}