package linkedIn.code.amazon;

import java.util.stream.Stream;

public class WildCardPattenMatching {
    public static void main(String[] args) {
        char[] pattern = "x***x?".toCharArray();
        char[] str = "xyxzzxy".toCharArray();
        boolean lookUp[][] = new boolean[pattern.length + 1][str.length + 1];
        System.out.println(isMatching(pattern, str, pattern.length-1, str.length-1, lookUp));
    }

    private static boolean isMatching(char[] pattern, char[] str, int m, int n, boolean[][] lookUp) {
        if (m < 0 && n < 0)
            return true;
        else if ( m < 0 )
            return false;
        else if (n < 0){
            for (int i = 0; i <= m; i++) {
                if (pattern[i] != '*')
                    return false;
            }
            return true;
        }
        if (!lookUp[m][n]){
            if (pattern[m] == '*'){
                lookUp[m][n] = isMatching(pattern, str, n-1, m, lookUp) ||
                        isMatching(pattern, str, n, m-1, lookUp);
            }else {
                if (pattern[m] !='?' && pattern[m]!= str[n])
                    lookUp[m][n] = false;
                else
                    lookUp[m][n] = isMatching(pattern, str, n-1, m-1, lookUp);
            }
        }
        return lookUp[m][n];
    }
}
