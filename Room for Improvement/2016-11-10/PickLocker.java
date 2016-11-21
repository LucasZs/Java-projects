public class PickLocker
{
    static char[] KEYS = new char[] { 'a', 'b', 'c' };

    // 0000, 0001, 0002, 0003, 0010, 0011....3333

    public static String[] crack(int num)
    {
        String[] result = new String[(int) Math.pow(KEYS.length, num)];
        int[] actual = new int[num];
        // while (!isLast(actual))
        for (int j = 0; j < result.length; j++)

        {
            StringBuilder sb = new StringBuilder();
            for (int i : actual)
            {
                sb.append(KEYS[i]);
            }
            result[j] = sb.toString();

            for (int i = actual.length - 1; i >= 0; i--)
            {
                actual[i]++;
                if (actual[i] != KEYS.length)
                {
                    break;
                }
                actual[i] = 0;
            }

        }
        return result;

    }

    public static boolean isLast(int[] actual)
    {
        for (int i : actual)
        {
            if (KEYS[i] != KEYS[KEYS.length - 1])
            {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args)
    {
        String[] result = crack(4);
        for (String string : result)
        {
            System.out.println(string);
        }
    }
}