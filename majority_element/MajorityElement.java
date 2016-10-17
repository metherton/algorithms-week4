import java.util.*;
import java.io.*;

public class MajorityElement {
    private static int getMajorityElement(int[] a, int left, int right) {

     //   System.out.println("left: " + left + " & right: " + right + "\n");

        if (left == right) {
       //     System.out.println("left  == right" + "\n");
            return -1;
        }
        if (left + 1 == right) {
         //   System.out.println("left +1 == right" + "\n");
            return a[left];
        }
 //       int majorityNumber = (int) Math.floor((a.length / 2));
        int majorityNumber = (int) Math.floor(((right - left) / 2));
     //   System.out.println("majority:" + majorityNumber  +"\n");


      //  int majorityNumber = (int) Math.floor((right - left / 2));
        //write your code here
        int mid = (int)Math.floor(left + ((right - left) / 2));

//        int mid = (int)Math.floor(left + ((right - left) / 2));
  //      System.out.println("mid: " + mid);
  //      System.out.println("getmajority first: left: " + left + " & right: " + mid + "\n");
        int leftSide = getMajorityElement(a, left, mid);
//        int leftSide = getMajorityElement(a, left, mid);
    //    System.out.println("getmajority second: left: " + (mid + 1) + " & right: " + right + "\n");
        int rightSide = getMajorityElement(a, mid, right);
    //    System.out.println("leftSide: " + leftSide + " " + "rightSide: " + rightSide + "\n");
//
//

        int leftCount = 0;
        int rightCount = 0;


      //  System.out.println("do the count: left: " + left + " " + " right: " + right + "\n");

        if (leftSide == -1 && rightSide != -1) {

            for (int i = left; i < right; i++) {

                if (a[i] == rightSide) {
                    rightCount++;
                }
            }

         //   unsigned int num = count(a, left, right, rightCount);
            if (rightCount > majorityNumber)
            {
                return rightSide;
            }
            else
            {
                return -1;
            }

        }
        else if (rightSide == -1 && leftSide != -1)
        {
            for (int i = left; i < right; i++) {

                if (a[i] == leftSide) {
                    leftCount++;
                }
            }

            //   unsigned int num = count(a, left, right, rightCount);
            if (leftCount > majorityNumber)
            {
                return leftSide;
            }
            else
            {
                return -1;
            }
        }
        else if (leftSide != -1 && rightSide != -1)
        {
            for (int i = left; i < right; i++) {

                if (a[i] == leftSide) {
                    leftCount++;
                }
            }

            for (int i = left; i < right; i++) {

                if (a[i] == rightSide) {
                    rightCount++;
                }
            }
//
//            unsigned int leftNum = count(a, left, right, leftCount);
//            unsigned int rightNum = count(a, left, right, rightCount);
            if (leftCount > majorityNumber)
            {
                return leftSide;
            }
            else if (rightCount > majorityNumber)
            {
                return rightSide;
            }
            else
            {
                return -1;
            }
        }
//        else
//        {
//            return -1;
//        }




//        if (leftSide == rightSide) {
//            return leftSide;
//        }


//        if ((leftSide == rightSide) && leftSide != -1 ) {
//            for (int i = 0; i < a.length; i++) {
//
//                if (a[i] == leftSide) {
//                    leftCount++;
//                }
//                if (a[i] == rightSide) {
//                    rightCount++;
//                }
//            }
//
//        }


   //     System.out.println("Beforeloop:   left:" + left + " right: " + right  +"\n");


   //     if (leftSide != -1) {
      //      System.out.println("do test leftSIde:" + leftSide  +"\n");
//            for (int i = left; i < right; i++) {
//
//                if (a[i] == leftSide) {
//                    leftCount++;
//                }
//            }
     //   }

    //    if (rightSide != -1) {
        //    System.out.println( " and rightside:" + rightSide +"\n");
//            for (int i = left; i < right; i++) {
//
//                if (a[i] == rightSide) {
//                    rightCount++;
//                }
//            }

   //     }


//        System.out.println("majaor: " + majorityNumber);
//        System.out.println("leftCount: " + leftCount);
//        System.out.println("rightCount: " + rightCount);

//        if (leftCount <= majorityNumber && rightCount <= majorityNumber) {
//            return -1;
//        } else {
//            if (leftCount > majorityNumber) {
//                return leftSide;
//            } else if (rightCount > majorityNumber) {
//                return rightSide;
//            }
//        }

//        if (leftCount > majorityNumber) {
//            return leftSide;
//        } else if (rightCount > majorityNumber) {
//            return rightSide;
//        }
        return -1;
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        if (getMajorityElement(a, 0, a.length) != -1) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}

