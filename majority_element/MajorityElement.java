import java.util.*;
import java.io.*;

public class MajorityElement {
    private static int getMajorityElement(int[] a, int left, int right) {
        if (left == right) {
            return -1;
        }
        if (left + 1 == right) {
            return a[left];
        }
      //  int majorityNumber = (int) Math.floor((a.length / 2));
        int majorityNumber = (int) Math.floor((right - left / 2));
        //write your code here
        int mid = (int)Math.floor(left + ((right - left) / 2));
        int leftSide = getMajorityElement(a, left, mid);
        int rightSide = getMajorityElement(a, mid + 1, right);
      //  System.out.println("leftSide: " + leftSide + " " + "rightSide: " + rightSide + "\n");


        System.out.println("do test leftSIde:" + leftSide  +"\n");
        System.out.println( " and rightside:" + rightSide +"\n");
        System.out.println( " and lef:" + left + " and right:" + right +"\n");

        if (leftSide == rightSide) {
            return leftSide;
        }
        int leftCount = 0;
        int rightCount = 0;

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



        if (leftSide != -1) {
      //      System.out.println("do test leftSIde:" + leftSide  +"\n");
            for (int i = 0; i < ; i++) {

                if (a[i] == leftSide) {
                    leftCount++;
                }
            }
        }

        if (rightSide != -1) {
        //    System.out.println( " and rightside:" + rightSide +"\n");
            for (int i = 0; i < right; i++) {

                if (a[i] == rightSide) {
                    rightCount++;
                }
            }

        }


//        System.out.println("majaor: " + majorityNumber);
//        System.out.println("leftCount: " + leftCount);
//        System.out.println("rightCount: " + rightCount);
        if (leftCount > majorityNumber) {
            return leftSide;
        } else if (rightCount > majorityNumber) {
            return rightSide;
        }
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

