package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
public class ReverseBits {
  @EpiTest(testDataFile = "reverse_bits.tsv")
  public static long reverseBits(long x) {
    // TODO - you fill in here.
    // Use swapBits method to loop through bits and swap bits if different
    for(int i=0; i<32; i++){
      int j = 63-i;
      if(((x>>>i)&0x1) != ((x>>>j)&0x1)){
        x = x^(0x1L<<i)^(0x1L<<j);
      }
    }
    return x;

    // improved method - build an array based
    //lookup-table A such that for every 16-bit number y, A[y] holds the bit-reversal
    //of y.
    /*
    BIT_MASK = 0xFF;

    return ( PRECOMPUTED_REVERSE[x>>BIT_MASK]<< 3*
     */
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "ReverseBits.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
