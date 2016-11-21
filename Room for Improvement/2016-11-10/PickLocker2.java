public class PickLocker2
{
    static char[] KEYS = new char[] { 'a', 'b', 'c' };
    // 0000, 0001, 0002, 0003, 0010, 0011....3333
    public static void crack(int num)
    {
        int[] actual = new int[num];
        while (!isLast(actual))
        {
            for (int i = actual.length - 1; i >= 0; i--)
            {
                actual[i]++;
                if (actual[i] != KEYS.length)
                {
                    break;
                } 
                actual[i] = 0;
            }
            for (int i : actual)
            {
                System.out.print(KEYS[i]);
            }
            System.out.println();
        }
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
        crack(4);
    }
}