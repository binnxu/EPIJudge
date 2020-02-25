package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
public class ClosestIntSameWeight {
  @EpiTest(testDataFile = "closest_int_same_weight.tsv")
  public static long closestIntSameBitCount(long x) {
    // TODO - you fill in here.
    // assume x is not all 0's or 1's
    // min(2^x-2^y) x as small as possible, and y is close to x as possible
    // find the two right most consecutive bits that differ, then swap them.
    // O(n)
    /*
    for(int i=0; i<64; i++) {
      if(((x>>i)&0x1) != ((x>>(i+1))&0x1)) {
        //return x&(~(0x1L<<i))&(~(0x1L<<(i+1)))^((x>>i)&0x1)<<(i+1)^((x>>(i+1)&0x1)<<i);
        return x^(0x1L<<i)^(0x1L<<(i+1)); //since bit values only, 0^1=1 1^1=0
      }
    }
    return 0;
    */

    //O(1)
    //if ends with 1, find the least 0, then 01 -> 10
    //if ends with 0, find the least 1, then 10 -> 01
    // Use the x&(x-1) trick, O(1)
    // the right most 10 -> 01 01->10;

//    long y = ~x;
//
//    if((x&0x1) == 0x0){ //if ends with 0
//    //if((x&~(x-1)) != 1) {
//      x=((x&(x-1))|((x&~(x-1))>>1)); // use | instead of ^
//    } else{
//      x=~((y&(y-1))|(((y&~(y-1))>>1)));
//
//    }
//    return x;

    //swap the right most two bits which are differ


/*
    if((x&~(x-1)) != 1) {
      return ((x&(x-1)) | ((x&~(x-1))>>1));
    } else {
      return ~((y&(y-1)) | ((y&~(y-1))>>1));
    }
    */
  long y = 0;
  if((x&0x1) != 0x1)
  {
    y = x&~(x-1);
    y = x&(x-1) | (y>>>1);
  } else
  {
    y = ~x;
    y = ~(y&(y-1) | ((y&~(y-1))>>>1));
  }

  return y;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "ClosestIntSameWeight.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
