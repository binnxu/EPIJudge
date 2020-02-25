package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
public class PrimitiveDivide {
  @EpiTest(testDataFile = "primitive_divide.tsv")
  public static int divide(int x, int y) {
    // TODO - you fill in here.
    // brute force: use x-n*y to get n
    // improved: find the largest k such that (2^k)*y<=x
    // then continue with subsequent iterations to test 2^(k-1)*y 2^(k-2)*y with x
    //O(n)
    int ret = 0, power=32, yPower=y<<power;

    if(x<y){
      return 0;
    }

    while(x>=y){
      //find the largest k such that (2^k)*y<=x
      while(yPower>x){
        yPower = yPower >>> 1;
        power--;
      }
      //continue with subsequent iterations to test 2^(k-1)*y 2^(k-2)*y with x
      //every time ret will get 2^(k-m)
      ret = ret+1<<power;
      //then reduce x by 2^(k-m)
      x = x - yPower;
    }

    return ret;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "PrimitiveDivide.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
