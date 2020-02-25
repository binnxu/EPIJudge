package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
public class IsNumberPalindromic {
  @EpiTest(testDataFile = "is_number_palindromic.tsv")

  public static boolean isPalindromeNumber(int x) {
    // TODO - you fill in here.
    // if the number is negative, return false
    // brute force, convert digits into string,
    // and start from msb and lsb to the middle to compare the chars
    // space O(n)

    // for digits, lsb x%10 msb x/10^(n-1) and n=(int) (Math.log10(tempX) + 1)
    // space O(1) Time O(n)

    // we can also reverse the digits and check if original and reversed one are the same.
//    if(x<0){
//      return false;
//    }
//
//    if(x>=0 && x< 10){
//      return true;
//    }
//
//    int lsb =0, msb=0, tempX=0;
//    while(tempX != 0) {
//      lsb = tempX % 10;
//      msb = tempX / (10 ^ ((int) (Math.log10(tempX) + 1) - 1));
//      if (lsb != msb) {
//        return false;
//      }
//      tempX = (tempX - tempX % (10 ^ ((int) (Math.log10(x) + 1) - 1))) / 10;
//    }
//    return true;

    ////another try on 11/05/2019, not fully working.
    if(x<0)
    {
      return false;
    }

    int lsb = 0;
    int msb = 0;
    int numBits = 0;

    while(x != 0) {
      numBits = (int)(Math.floor(Math.log10((double)x)))+1;
      System.out.println();
      System.out.println("numBits is " + numBits);
      if(numBits == 1)
      {
        return true;
      }
      lsb = x%10;
      msb = x/(int)(Math.pow(10, numBits-1));
      System.out.println("lsb is " + lsb + " msb is " + msb);
      if(lsb != msb){
        return false;
      }
      x = x%(int)(Math.pow(10, numBits-1));
      System.out.println("after module " + x);
      x=x/10;
      System.out.println("after division " + x);




    }
    return true;

    // reverse the int x, and compare it with x
//    if(x<0){
//      return false;
//    }
//    long y = reverseDigits(x);
//    if((int)y == x){
//      return true;
//    }
//    return false;
//  }
//  private static long reverseDigits(int x){
//    long y = 0;
//
//    while(x != 0){
//      y = x%10 + y*10;
//      x = x/10;
//    }
//    //System.out.println("y is " + y);
//    return y;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "IsNumberPalindromic.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
