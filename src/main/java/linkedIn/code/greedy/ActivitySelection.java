package linkedIn.code.greedy;

import java.util.*;

/**
 * Created by PDeb on 12/17/2017.
 */
public class ActivitySelection {

    class Activity{
        int start;
        int end;

        public Activity(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    class ActivityComparator implements Comparator<Activity>
    {
        @Override
        public int compare(Activity o1, Activity o2) {
            return (Integer.compare(o1.end, o2.end));
        }
    }

    public void selectActivity()
    {
        List<Activity> activities = new ArrayList<>();
        activities.add(new Activity(1,4));
        activities.add(new Activity(3,5));
        activities.add(new Activity(0,6));
        activities.add(new Activity(5,7));
        activities.add(new Activity(3,8));
        activities.add(new Activity(5,9));
        activities.add(new Activity(6,10));
        activities.add(new Activity(8,11));
        activities.add(new Activity(8,12));
        activities.add(new Activity(2, 13));
        activities.add(new Activity(12,14));

        Collections.sort(activities, new ActivityComparator());

        int k = 0;
        Set<Integer> selectedActivity = new HashSet<>();
        selectedActivity.add(0);
        for (int i = 1; i < activities.size() ; i++) {
            Activity act = activities.get(i);
            if(act.start>= activities.get(k).end)
            {
                selectedActivity.add(i);
                k=i;
            }
        }

        for(Integer i : selectedActivity)
        {
            System.out.println("(" + activities.get(i).start +" "+ activities.get(i).end+")");
        }
    }

    public static void main(String[] args) {
        new ActivitySelection().selectActivity();
    }
}
