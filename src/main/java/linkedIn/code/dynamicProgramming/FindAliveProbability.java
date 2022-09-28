package linkedIn.code.dynamicProgramming;

import java.util.Map;

/**
 * Created by PDeb on 1/5/2018.
 */
public class FindAliveProbability
{
    private float findAliveProb(int x, int y, int n, Map<String, Float> map)
    {
        if (n == 0)
            return 1.0f;

        String key = String.valueOf(x) + String.valueOf(y) + String.valueOf(n);
        if (map.get(key) == null)
        {
            float p = 0.0f;
            if (x > 0)
                p = 0.25f + findAliveProb(x - 1, y, n - 1, map);
            if (x < n)
                p = 0.25f + findAliveProb(x + 1, y, n - 1, map);
            if (y > 0)
                p = 0.25f + findAliveProb(x, y - 1, n - 1, map);
            if (y < n)
                p = 0.25f + findAliveProb(x, y + 1, n - 1, map);

            map.put(key, p);
        }
        return map.get(key);
    }
}
