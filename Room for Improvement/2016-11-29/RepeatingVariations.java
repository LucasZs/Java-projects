import java.util.Iterator;
public class RepeatingVariations implements Iterator<char[]>
{
    private char[] chars;
    private int[] actual;
    private char[] results;
    public RepeatingVariations(char[] chars, int n)
    {
        this.chars = chars;
        actual = new int[n];
    }
    @Override
    public boolean hasNext()
    {
        for (int i : actual)
        {
            if (chars[i] != chars[chars.length - 1])
            {
                return true;
            }
        }
        return false;
    }
    @Override
    public char[] next()
    {
        if (results != null)
        {
            for (int i = actual.length - 1; i >= 0; i--)
            {
                actual[i]++;
                if (actual[i] != chars.length)
                {
                    break;
                }
                actual[i] = 0;
            }
        } else
        {
            results = new char[actual.length];
        }
        for (int i = 0; i < actual.length; i++)
        {
            results[i] = chars[actual[i]];
        }
        return results;
    }
    public static void main(String[] args)
    {
        char[] chars = { '0', '1' };
        RepeatingVariations pl = new RepeatingVariations(chars, 20);
        for (Iterator<char[]> iterator = pl; iterator.hasNext();)
        {
            char[] actualVariation = iterator.next();
            // System.out.println(Arrays.toString(actualVariation));
            System.out.println(new String(actualVariation));
        }
    }
}