package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
public class PowerXY {
  @EpiTest(testDataFile = "power_x_y.tsv")
  public static double power(double x, int y) {
    // TODO - you fill in here.
    //ignore overflow or underflow
    //brute force - power_x_y = x*x*x*...*x
    //O(2^n)

    //improvement - try to use fewer multiplications
    // - use binary representation of y
    // - use exponentiation properties
    // - lsb of y is 0 => x^y = (x^(y/2))^2
    // - lsb of y is 1 => x^y = x*(x^(y/2))^2
    // TIME O(n)

    double ret = 1.0;
    long power = y;

    //assume y is positive
    if(y<0){
      power = -power;
      x=1.0/x;
    }

    while(power != 0 ){
      if((power&1) != 0){ //lsb of y is 1, need to multiply x
        ret = ret*x;
      }
      x=x*x; //lsb of y is 0, just use x*x
      power= power>>>1;
    }

    return ret;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "PowerXY.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
