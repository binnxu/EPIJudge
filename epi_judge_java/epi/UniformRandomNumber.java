package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
import epi.test_framework.RandomSequenceChecker;
import epi.test_framework.TestFailure;
import epi.test_framework.TimedExecutor;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
public class UniformRandomNumber {
  private static int zeroOneRandom() {
    Random gen = new Random();
    return gen.nextInt(2);
  }

  public static int uniformRandom(int lowerBound, int upperBound) {
    // TODO - you fill in here.
    // brute force. use 0/1 bit to generate the range 0~2^n-1, => [lowerBound, 2^n-1+lowerBound]
    // covering the [lowerBound, upperBound]
    // if the generated number is out of bound, re-generate it.
//
//    int bitUpperBound = upperBound-lowerBound+1;
//    int ret = 0;
//    do{
//        ret = 0;
//        //for(int i=0; i<Math.floor(Math.log(bitUpperBound))+1;i++){
//        for(int i=0; (1<<i)<bitUpperBound; i++){
//        ret = (ret<<1) | zeroOneRandom();
//        }
//    }while(ret>=bitUpperBound);
//
//    ret = ret + lowerBound;
//
//    return ret;

    //11052019 not correct
//  int ret = 0;
//  int x = upperBound - lowerBound +1;
//  int numBits = (int)Math.log(x) +1;
//  int i = 0;
//  do {
//    for (i = 0; i < numBits; i++) {
//      ret = zeroOneRandom() + ret << 1;
//    }
//  } while(ret>x);
//  System.out.println("lower bound " + lowerBound + " higher bound " + upperBound + " ret " + ret + " x " + x);
//  return ret+lowerBound;
    return -1;
  }
  private static boolean uniformRandomRunner(TimedExecutor executor,
                                             int lowerBound, int upperBound)
      throws Exception {
    List<Integer> results = new ArrayList<>();

    executor.run(() -> {
      for (int i = 0; i < 100000; ++i) {
        results.add(uniformRandom(lowerBound, upperBound));
      }
    });

    List<Integer> sequence = new ArrayList<>();
    for (Integer result : results) {
      sequence.add(result - lowerBound);
    }
    return RandomSequenceChecker.checkSequenceIsUniformlyRandom(
        sequence, upperBound - lowerBound + 1, 0.01);
  }

  @EpiTest(testDataFile = "uniform_random_number.tsv")
  public static void uniformRandomWrapper(TimedExecutor executor,
                                          int lowerBound, int upperBound)
      throws Exception {
    RandomSequenceChecker.runFuncWithRetries(
        () -> uniformRandomRunner(executor, lowerBound, upperBound));
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "UniformRandomNumber.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
