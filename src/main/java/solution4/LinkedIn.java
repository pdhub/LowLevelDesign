package solution4;


import java.util.ArrayList;
import java.util.List;

public class LinkedIn {
    public static void main(String[] args) {
        countDepth("{1,1,1}");
        countDepth("{1,{2},1}");
        countDepth("{{1,1},2,{1,1}}");
        countDepth("{1,{4,{6}}}");
    }

    public static void countDepth(String input){
        int depthCount = 0, total = 0;
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '{')
                depthCount++;
            else if(c == '}')
                depthCount--;
            else if(c!=',')
                total += (Integer.valueOf(c+""))*depthCount;
        }
        System.out.println(total);
    }

    interface NestedGroup
    {
        /** @return true if this NestedGroup holds a single integer, rather than a nested list */
        boolean isInteger();

        /** @return the single integer that this NestedGroup holds, if it holds a single integer
         * Return null if this NestedGroup holds a nested list */
        Integer getInteger();

        /** @return the nested list that this NestedGroup holds, if it holds a nested list
         * Return null if this NestedGroup holds a single integer */
        List<NestedGroup> getList();
    }

    class Group<T> implements NestedGroup{
        List<NestedGroup> nestedGroup = new ArrayList<>();

        Group(){
        }



        @Override
        public boolean isInteger() {
            return nestedGroup.size()==1;
        }

        @Override
        public Integer getInteger() {
            return null;
        }

        @Override
        public List<NestedGroup> getList() {
            return this.nestedGroup;
        }
    }

    public int nestedMemberWeightedSum (List<NestedGroup> input) {
        if (input == null || input.isEmpty())
            return 0;
        return nestedMemberWeightedSum(input, 1);
    }

    private int nestedMemberWeightedSum(List<NestedGroup> input, int weight) {
        if (input == null || input.isEmpty())
            return 0;
        int total = 0;
        for (NestedGroup nestedGroup : input) {
            if (nestedGroup.isInteger())
                total += nestedGroup.getInteger()*weight;
            else
                total += nestedMemberWeightedSum(nestedGroup.getList(), weight+1);
        }
        return total;
    }


}
