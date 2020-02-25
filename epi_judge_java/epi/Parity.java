package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
public class Parity {
  @EpiTest(testDataFile = "parity.tsv")
  public static short parity(long x) {
    // TODO - you fill in here.
    /*
    //brute force. O(n) n is the word size.
    short sum = 0;
    while(x != 0){
      sum ^= x&0x01;
      x = x>>>1;
    }
    return sum;*/

    //use x&~(x-1) to get the least bit with value 1
    //use x&(x-1) to remove the least bit with value 1
    //O(k) k is the number of 1 in the word
    /*
    short sum = 0;
    while (x != 0){
      x = x&(x-1);
      sum ^= 0x01;
    }
    return sum;
*/
    //use precomputed tables - Olog(n/L)
    /*
    final int WORD_SIZE = 16;
    final int BIT_MASK = 0xFFFF;
    return (short) (
            precomputedParity[(int)((x >>> (3*WORD_SIZE)) & BIT_MASK)]
            ^precomputedParity[(int)((x >>> (2*WORD_SIZE)) & BIT_MASK)]
            ^precomputedParity[(int)((x >>> WORD_SIZE)&BIT_MASK)]
            ^precomputedParity[(int)x&BIT_MASK]);
*/
     // use XOR associativity and commutative - Olog(n)
//      x ^= x>>>32;
//    x ^= x>>>16;
//    x ^= x>>>8;
//    x ^= x>>>4;
//    x ^= x>>>2;
//    x ^= x>>>1;
//    return (short)(x&0x01);

    //combine the lookup table and XOR - 1/2log(n/L)
    /*
    final int BIT_MASK = 0xFFFF;
    x ^= x>>>32;
    return (short)(precomputedParity((int)(x>>>16)*BIT_MASK)
            ^(precomputedParity((int)(x>>>16)*BIT_MASK)));
            */

    //time O(n) space O(1)
//    short ret = 0;
//    while(x != 0)
//    {
//      ret ^= x&1;
//      x >>>= 1;
//    }

    //time O(k) space O(1)
    short ret = 0;
    while(x != 0)
    {
      x = x&(x-1);
      ret = (short)(ret^0x1);
    }

    // use map table

    return ret;

  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "Parity.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
