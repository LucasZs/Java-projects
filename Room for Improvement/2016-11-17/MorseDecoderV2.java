/*
 * In this kata you have to write a Morse code decoder for wired electrical telegraph.
 * Electric telegraph is operated on a 2-wire line with a key that, when pressed, connects the wires together, which can
 * be detected on a remote station. The Morse code encodes every character being transmitted as a sequence of "dots"
 * (short presses on the key) and "dashes" (long presses on the key).
 * 
 * When transmitting the Morse code, the international standard specifies that:
 * 
 * "Dot" – is 1 time unit long.
 * "Dash" – is 3 time units long.
 * Pause between dots and dashes in a character – is 1 time unit long.
 * Pause between characters inside a word – is 3 time units long.
 * Pause between words – is 7 time units long.
 * However, the standard does not specify how long that "time unit" is. And in fact different operators would transmit
 * at different speed. An amature person may need a few seconds to transmit a single character, a skilled professional
 * can transmit 60 words per minute, and robotic transmitters may go way faster.
 * 
 * For this kata we assume the message receiving is performed automatically by the hardware that checks the line
 * periodically, and if the line is connected (the key at the remote station is down), 1 is recorded, and if the line is
 * not connected (remote key is up), 0 is recorded. After the message is fully received, it gets to you for decoding as
 * a string containing only symbols 0 and 1.
 * 
 * For example, the message HEY JUDE, that is ···· · −·−− ·−−− ··− −·· · may be received as follows:
 * 
 * 1100110011001100000011000000111111001100111111001111110000000000000011001111110011111100111111000000110011001111110000001111110011001100000011
 * 
 * As you may see, this transmission is perfectly accurate according to the standard, and the hardware sampled the line
 * exactly two times per "dot".
 * 
 * That said, your task is to implement two functions:
 * 
 * Function decodeBits(bits), that should find out the transmission rate of the message, correctly decode the message to
 * dots ., dashes - and spaces (one between characters, three between words) and return those as a string. Note that
 * some extra 0's may naturally occur at the beginning and the end of a message, make sure to ignore them. Also if you
 * have trouble discerning if the particular sequence of 1's is a dot or a dash, assume it's a dot.
 * Function decodeMorse(morseCode), that would take the output of the previous function and return a human-readable
 * string.
 * The Morse code table is preloaded for you as MORSE_CODE dictionary (MorseCode class for Java), feel free to use it.
 * 
 * All the test strings would be valid to the point that they could be reliably decoded as described above, so you may
 * skip checking for errors and exceptions, just do your best in figuring out what the message is!
 * 
 * Good luck!
 * 
 * bit -> morse -> alphabet
 * 
 * HHHH E YYYY JJJJ UUU DDD E
 * ···· · −·−− ·−−− ··− −·· ·
 * 
 * H - 11001100110011
 * _ - 000000
 * E - 11
 * _ - 000000
 * Y - 11111100110011111100111111
 * _ - 00000000000000
 * J - 11001111110011111100111111
 * _ - 000000
 * U - 11001100111111
 * _ - 000000
 * D - 11111100110011
 * _ - 000000
 * E - 11
 */

import java.util.HashMap;
import java.util.Map;
public class MorseDecoderV2
{
    private static Map<String, String> morseAlphabet;
    static
    {
        morseAlphabet = new HashMap<>();
        morseAlphabet.put(".-", "A");
        morseAlphabet.put("-...", "B");
        morseAlphabet.put("-.-.", "C");
        morseAlphabet.put("-..", "D");
        morseAlphabet.put(".", "E");
        morseAlphabet.put("..-.", "F");
        morseAlphabet.put("--.", "G");
        morseAlphabet.put("....", "H");
        morseAlphabet.put("..", "I");
        morseAlphabet.put(".---", "J");
        morseAlphabet.put("-.-", "K");
        morseAlphabet.put(".-..", "L");
        morseAlphabet.put("--", "M");
        morseAlphabet.put("-.", "N");
        morseAlphabet.put("---", "O");
        morseAlphabet.put(".--.", "P");
        morseAlphabet.put("--.-", "Q");
        morseAlphabet.put(".-.", "R");
        morseAlphabet.put("...", "S");
        morseAlphabet.put("-", "T");
        morseAlphabet.put("..-", "U");
        morseAlphabet.put("...-", "V");
        morseAlphabet.put(".--", "W");
        morseAlphabet.put("-..-", "X");
        morseAlphabet.put("-.--", "Y");
        morseAlphabet.put("--..", "Z");
        morseAlphabet.put("-----", "0");
        morseAlphabet.put(".----", "1");
        morseAlphabet.put("..---", "2");
        morseAlphabet.put("...--", "3");
        morseAlphabet.put("....-", "4");
        morseAlphabet.put(".....", "5");
        morseAlphabet.put("-....", "6");
        morseAlphabet.put("--...", "7");
        morseAlphabet.put("---..", "8");
        morseAlphabet.put("----.", "9");
        morseAlphabet.put(".-.-.-", ".");
        morseAlphabet.put("--..--", ");");
        morseAlphabet.put("..--..", "?");
        morseAlphabet.put(".----.", "`");
        morseAlphabet.put("-.-.--", "!");
        morseAlphabet.put("-..-.", "/");
        morseAlphabet.put("-.--.", "(");
        morseAlphabet.put("-.--.-", ")");
        morseAlphabet.put(".-...", "&");
        morseAlphabet.put("---...", ":");
        morseAlphabet.put("-.-.-.", ";");
        morseAlphabet.put("-...-", "=");
        morseAlphabet.put(".-.-.", "+");
        morseAlphabet.put("-....-", "-");
        morseAlphabet.put("..--.-", "_");
        morseAlphabet.put(".-..-.", "\"");
        morseAlphabet.put("...-..-", "$");
        morseAlphabet.put(".--.-.", "@");
        morseAlphabet.put("...-.-", "End of work");
        morseAlphabet.put("........", "Error");
        morseAlphabet.put("-.-.-", "Starting Signal");
        morseAlphabet.put("...-.", "Understood");
        morseAlphabet.put("...---...", "SOS");
        morseAlphabet.put("", " ");
    }
    public static String decodeBits(String bits)
    {
        String trimmed = trimZeros(bits);
        int unitLength = trimmed.indexOf('0');
        if (!trimmed.contains(concat('1', unitLength + 1)))
        {
            unitLength /= 3;
        }
        trimmed = trimmed.replace(concat('1', unitLength * 3), "-");
        trimmed = trimmed.replace(concat('1', unitLength), ".");
        trimmed = trimmed.replace(concat('0', unitLength * 7), "   ");
        trimmed = trimmed.replace(concat('0', unitLength * 3), " ");
        trimmed = trimmed.replace(concat('0', unitLength), "");
        return trimmed;
    }
    
    public static String concat(char character, int n)
    {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < n; i++)
        {
            stringBuilder.append(character);
        }
        return stringBuilder.toString();
    }
    public static String trimZeros(String bits)
    {
        int firstOne = bits.indexOf('1');
        if (firstOne > -1)
        {
            int lastOne = bits.lastIndexOf('1');
            return bits.substring(firstOne, lastOne + 1);
        }
        return "";
    }
    public static String decode(String morseCode)
    {
        StringBuilder stringBuilder = new StringBuilder();
        String tripleSpaceToDoubleSpace = morseCode.replace("   ", "  ");
        String[] splitted = tripleSpaceToDoubleSpace.split(" ");
        for (String string : splitted)
        {
            stringBuilder.append(morseAlphabet.get(string));
        }
        return stringBuilder.toString();
    }
    public static void main(String[] args)
    {
        System.out.println(decode(decodeBits(
                "1100110011001100000011000000111111001100111111001111110000000000000011001111110011111100111111000000110011001111110000001111110011001100000011"))); // HEY JUDE
    }
}