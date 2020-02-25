package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
public class SwapBits {
  @EpiTest(testDataFile = "swap_bits.tsv")
  public static long swapBits(long x, int i, int j) {
    // brute force
    // extract bit i and bit j, save, swap and write back
    // consider special case with i equals j
    /*
    if (i == j)
    {
      return x;
    } else {
      long temp_i = (x >>> i) & 0x1;
      long temp_j = (x >>> j) & 0x1;

      System.out.println(" temp_i - " + temp_i + " temp_j -" + temp_j);

      return (x & (~(1L << i)) & (~(1L << j)) ^ (temp_i << j) ^ (temp_j << i));
    }
    */

    //brute force
    // if i equals j, no changes at all.
    /*
    if(i == j) {
      return x;
    } else {

      long bit1 = (x>>>i) & 1;
      long bit2 = (x>>>j) & 1;

      return (x & (~(1L<<i)) & (~(1L<<j)) ^ (bit2<<i) ^ (bit1<<j));
    }

     */


    // the possible values are 0 or 1, so flipping bit values are the same as swapping
    // when bit1 and bit2 are different. Use XOR to flip.
    // Time O(1)
//    long bit1 = (x>>>i) & 1;
//    long bit2 = (x>>>j) & 1;
//
//    if((i == j) || (bit1 == bit2)){
//      return x;
//    } else
//    {
//      return (x ^ (0x1L<<i) ^(0x1L<<j));
//    }

    long y = 0;
    long bit_1 = x>>>i & 0x01;
    long bit_2 = x>>>j & 0x01;

    if(bit_1 == bit_2)
    {
      y = x;
    } else
    {
      y = x ^ (1L<<i) ^ (1L<<j); // need to be long int
    }
    return y;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "SwapBits.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
