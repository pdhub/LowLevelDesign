package solution;

import java.util.Arrays;
import java.util.List;

public class MyWrapperTest
{
    public static void main( String[] args )
    {
      List<Integer> lst= Arrays.asList(2, 3, 5, 6, 5, 7, 3, 4, 5, 5, -1, 5, 10, 5, 5, 5, 8, 1, 1);
      MyWrapper myWrapper=new MyWrapper(lst.iterator());
      System.out.println(myWrapper.hasNext()); // true
      System.out.println(myWrapper.hasNext()); // true
      System.out.println(myWrapper.next()); // returns 2
      myWrapper.ignore(5);
      System.out.println(myWrapper.next()); // returns 3
      System.out.println(myWrapper.next()); // returns 6 because 5 should be skipped
      System.out.println(myWrapper.next()); // returns 5
      myWrapper.ignore(5);
      myWrapper.ignore(5);
      myWrapper.ignore(5);
      myWrapper.ignore(5);
      myWrapper.ignore(5);
      myWrapper.ignore(5);
      myWrapper.ignore(5);
      System.out.println(myWrapper.next()); // returns 7
      myWrapper.ignore(3);
      System.out.println(myWrapper.next()); // returns 4
      System.out.println(myWrapper.next()); // returns -1
      System.out.println(myWrapper.next()); // returns 10
      System.out.println(myWrapper.hasNext()); // true
      System.out.println(myWrapper.next()); // 8
      myWrapper.ignore(1);
      myWrapper.ignore(1);
      System.out.println(myWrapper.hasNext()); // false
      System.out.println(myWrapper.next()); // error

    }
}