package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
public class PrimitiveMultiply {
  @EpiTest(testDataFile = "primitive_multiply.tsv")
  //O(n^2)
  public static long multiply(long x, long y) {
    // TODO - you fill in here.
    //The idea is to use adding instead of multiply
    //
    //compute the sum bit-by-bit, and "rippling" the carry along.
    //Each addition is itself performed bit-by-bit.
//    long ret = 0;
//
//    while(x != 0){
//      if((x&0x01) == 0x01){
//        ret = bitsum(ret, y);
//      }
//      y=y<<1;
//      x = x>>>1;
//    }
    long ret = 0;
    long tempx = x;
    long tempy = y;
    long tempsum = 0;

    while(tempx != 0){
      if((tempx&0x1) != 0){
        ret = bitsum(tempy, ret);
      }
      tempx = tempx >>> 1;
      ret = ret<<1 + tempsum;
    }
    return ret;
  }

      //implement the bit add sum with carryin.
    //use bit addition for each bit by moving bit mask k.
  //O(n)
  private static long bitsum(long a, long b)
    {
//      long sum=0, carryIn=0, carryOut=0, tempA=0, tempB=0,k=1,ak=0,bk=0;
//      tempA=a;
//      tempB=b;
//
//      //tempA and tempB are used as index to loop through.
//      //use k as shift window as bit mask
//      while(tempA !=0 || tempB!=0){
//
//        ak=a&k;
//        bk=b&k;
//
//        carryOut = (ak&bk) | (ak&carryIn) | (bk&carryIn); //two bits are 1, then carry out.
//        sum = sum | (ak^bk^carryIn);
//
//        //now bit shift left
//        carryIn = carryOut << 1;
//        k = k<<1;
//        tempA = tempA>>>1;
//        tempB = tempB>>>1;
//
//      }
//
//      //corner case for last bit
//      sum = sum | carryIn;
//      return sum;

      long ret = 0;
      long carryin = 0;
      long carryout = 0;
      long bita = 0;
      long bitb = 0;
      long sum = 0;
      long bitmask = 0x1;

      if (((a&0x1) == 0x1) && ((b&0x1) == 0x1)) {
        carryout = 0x1;
      }

      while((a != 0) || (b != 0)) {

        bita = a & 0x1;
        bitb = b & 0x1;

        sum = bita ^ bitb ^ carryin;
        carryin = (bita&carryout) | (bitb&carryout) | (bita&bitb);
        a = a >>>1;
        b = b >>>1;
        ret = ret + (sum<<1);
      }
      return (ret|carryin);
    }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "PrimitiveMultiply.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
