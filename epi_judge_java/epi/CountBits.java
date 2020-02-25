package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
public class CountBits {
  @EpiTest(testDataFile = "count_bits.tsv")

  public static short countBits(int x) {
//    // BX July 29, 2019
//    short num_bits = 0;
//  //  Character[] C = new char[]{'a', 'b'};
//    // Error: java: incompatible types: char[] cannot be converted to java.lang.Character[]
//    while(x != 0){
//      num_bits += x&1;
//      x = x >>> 1;
//    }
//    return num_bits;

    // time O(n) space O(1)
    short num_bits = 0;
    while(x !=0 ) {
      num_bits += x&1;
      //x >>= 1; // for java we need >>> to exclude the sign.
      x >>>= 1;
    }
    return num_bits;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "CountBits.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
