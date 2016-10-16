import java.util.Arrays;

public class TriangleArray
{
    public static char[][] triangle(String str)
    {
        String reversed = reverse(str);
        char[][] result = new char[2 * str.length() - 1][];

        for (int i = 0; i < result.length / 2; i++)
        {
            String asd = reversed.substring(0, i + 1);
            char[] row = asd.toCharArray();
            result[i] = row;
            result[result.length - 1 - i] = row;
        }
        result[str.length() - 1] = reversed.toCharArray();
        return result;
    }

    // public static String reverse(String string)
    // {
    // String reversed = "";
    // // for (int i = 0; i < string.length(); i++)
    // // {
    // // char character = string.charAt(i);
    // // reversed =character + reversed;
    // // }
    //
    // // for (int i = string.length()-1; i >= 0; i--)
    // // {
    // // char character = string.charAt(i);
    // // reversed += character;
    // // }
    //
    // for (int i = 0; i < string.length(); i++)
    // {
    // char character = string.charAt(string.length() - i - 1);
    // reversed += character;
    // }
    //
    // return reversed;
    // }
    public static String reverse(String string)
    {
        StringBuilder reversed = new StringBuilder();
        for (int i = 0; i < string.length(); i++)
        {
            char character = string.charAt(i);
            reversed.insert(0, character);
        }

        return reversed.toString();
    }

    public static void main(String[] args)
    {
        char[][] result = triangle("Hello");
        for (char[] cs : result)
        {
            System.out.println(Arrays.toString(cs));
        }
    }
}