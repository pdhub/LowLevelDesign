package solution;

import java.util.*;

public class KeyReplace {

    Map<String, String> map = new HashMap<>();
    public static void main(String[] args) {
        KeyReplace keyReplace = new KeyReplace();
        keyReplace.assign("HOME", "/home/user/%USER%");
        keyReplace.assign("USER", "Alice");
        keyReplace.assign("SCHOOL", "%HOME%");
        String stringToReplace = "Where is %HOME% for %USER% and her %SCHOOL%";
        String res = keyReplace.substitute(stringToReplace, new ArrayList<>());
        System.out.println(res);

        int nums1[] = new int[]{1, 2, 3, 4, 5, 5, 6, 7, 8, 9};// -> true
        int nums2[] = new int[]{1, 2, 3, 4, 5, 6};// -> false
        int nums3[] = new int[]{1, 2, 2, 3, 3, 4, 4, 5, 5, 6};// -> true
        System.out.println(keyReplace.canbeSubset(nums1));
        System.out.println(keyReplace.canbeSubset(nums2));
        System.out.println(keyReplace.canbeSubset(nums3));

        List<List<Integer>> result = keyReplace.subsets(nums1);
    }

    public List<List<Integer>> subsets(int nums[]){
        List<List<Integer>> res = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        helper(0, new ArrayList<>(), res, nums, used);
        return res;
    }

    private void helper(int index, List<Integer> list, List<List<Integer>> res, int nums[], boolean used[]) {
        if (list.size() == 5){
            res.add(new ArrayList<>(list));
        }
        if (index == nums.length)
            return;
        for (int i = index; i < nums.length; i++) {
            if (index > 0 && (nums[i] == nums[i-1]) && used[i])
                continue;
            if (list.size() == 0 || list.get(list.size()-1) + 1 == nums[i] && !used[i]){
                list.add(nums[i]);
                used[i] = true;
                helper(index + 1, list, res, nums, used);
                list.remove(list.size()-1);
            }

            //used[i] = false;
        }
    }



    public boolean canbeSubset(int[] nums){
        Arrays.sort(nums);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }
        Queue<Count> pq = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            Count c = new Count(nums[i], map.get(nums[i]));
            pq.offer(c);
        }
        Count prev = null;
        int len = 0;
        int count = 0;
        while (!pq.isEmpty()){
            if (prev == null){
                prev = pq.poll();
                len++;
                if (prev.count > 1)
                    pq.offer(new Count(prev.number, prev.count-1));
            }else {
                Count next = pq.poll();
                if (next.number - 1 != prev.number)
                    return false;
                else {
                    prev = next;
                    if (next.count > 1)
                        pq.offer(new Count(next.number, next.count-1));
                    len++;
                }
                if (len%5== 0){
                    prev = pq.poll();
                    count++;
                }
            }
        }
        return len == nums.length;
    }

    class Count{
        int number;
        int count;

        public Count(int number, int count) {
            this.number = number;
            this.count = count;
        }
    }



    public void assign(String key, String value){
        map.put(key, value);
    }

    public String substitute(String key, List<String> existingKeys){
        if(key.indexOf('%')==-1)
            return key;
        int start = key.indexOf('%');
        int windowStart = start+1;
        while(key.charAt(windowStart)!='%')
            windowStart++;
        int windowEnd = windowStart;
        String stringToSubstitute = key.substring(start+1, windowEnd);
        existingKeys.add(key.substring(start, windowEnd+1));
        String value = map.get(stringToSubstitute);
        if (existingKeys.contains(value))
            return key.substring(0, start) + "BAD SUBSTITUTION";
        return key.substring(0, start)+
                substitute(value, existingKeys)+
                substitute(key.substring(windowEnd+1, key.length()), existingKeys);
    }

}
