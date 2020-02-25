package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
public class ReverseDigits {
  @EpiTest(testDataFile = "reverse_digits.tsv")
  public static long reverse(int x) {
    // TODO - you fill in here.
    // brute force - start from the most right to get each digit, then reverse it.
    //Time O(n)

    //int sign = 1;
    //int y = 0; // the return type is long
//    long sign =1;
//    long y=0;
//
//    if(x==0){
//      return 0;
//    }
//
//    if(x<0){
//      x=-x;
//      sign = -1;
//    }
//
//    //while(x%10 != 0){
//    while(x != 0){
//    //  y=(x%10)*10+y;
//      y=y*10+x%10;
//      x=x/10;
//    }
//    return y*sign;

    long sign = 1;
    long ret = 0;

    if(x<0)
    {
      sign = -1;
      x = -x;
    }

    while(x != 0){
      ret=(x%10)+ret*10;
      x = x/10;
    }
    return ret*sign;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "ReverseDigits.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
