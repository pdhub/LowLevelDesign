package solution;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MyWrapper {
    public Iterator<Integer> iterator;
    public Map<Integer, Integer> ignoreCount;
    MyWrapper(){}
    MyWrapper(Iterator<Integer> iterator){
        this.iterator = iterator;
        ignoreCount = new HashMap<>();
    }

    private Integer nextVal;
    public boolean hasNext(){
        if (nextVal!=null)
            return true;
        Integer x = iterator.hasNext()?iterator.next():null;
        while (ignoreCount.containsKey(x) && ignoreCount.get(x)!=0)
        {
            ignoreCount.put(x, ignoreCount.get(x)-1);
            if(iterator.hasNext())
                x = iterator.next();
            else
                x = null;
        }
        nextVal = x;
        return nextVal!=null;
    }

    public Integer next(){
        if (nextVal==null)
            hasNext();
        Integer nextValTemp = nextVal;
        nextVal = null;
        return nextValTemp;
    }

    public void ignore(Integer x){
        ignoreCount.put(x, ignoreCount.getOrDefault(x, 0)+1);
    }
}
