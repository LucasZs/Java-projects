/*
 * In this kata you have to write a simple Morse code decoder. While the Morse code is now mostly superceded by voice
 * and digital data communication channels, it still has its use in some applications around the world.
 * The Morse code encodes every character as a sequence of "dots" and "dashes". For example, the letter A is coded as
 * ·−, letter Q is coded as −−·−, and digit 1 is coded as ·−−−. The Morse code is case-insensitive, traditionally
 * capital letters are used. When the message is written in Morse code, a single space is used to separate the character
 * codes and 3 spaces are used to separate words. For example, the message HEY JUDE in Morse code is ···· · −·−− ·−−−
 * ··− −·· ·.
 * 
 * NOTE: Extra spaces before or after the code have no meaning and should be ignored.
 * 
 * In addition to letters, digits and some punctuation, there are some special service codes, the most notorious of
 * those is the international distress signal SOS (that was first issued by Titanic), that is coded as ···−−−···. These
 * special codes are treated as single special characters, and usually are transmitted as separate words.
 * 
 * Your task is to implement a function decodeMorse(morseCode), that would take the morse code as input and return a
 * decoded human-readable string.
 * 
 * For example:
 * 
 * MorseCodeDecoder.decode(".... . -.--   .--- ..- -.. .")
 * //should return "HEY JUDE"
 * The Morse code table is preloaded for you as MORSE_CODE dictionary, feel free to use it. In Java, the table can be
 * accessed like this: MorseCode.get('.--'). In C#, the preloaded Dictionary can be accessed like this:
 * MorseCode.Get('.--');. In Haskell the codes are in a Map String String and can be accessed like this: morseCodes !
 * ".--".
 * 
 * All the test strings would contain valid Morse code, so you may skip checking for errors and exceptions.
 * In C#, tests will fail if the solution code throws an exception. Please keep that in mind. (This is mostly because
 * else the engine would simply ignore the tests, resulting in a "valid" solution.)
 * 
 * Good luck!
 */

import java.util.HashMap;
import java.util.Map;

public class MorseDecoder
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
        System.out.println(decode(".... . -.--   .--- ..- -.. .")); // HEY JUDE
    }
}