/*
 * This file was automatically generated by EvoSuite
 * Sat Jun 22 14:49:14 GMT 2024
 */

package org.apache.commons.graph;

import org.junit.Test;
import static org.junit.Assert.*;
import org.apache.commons.graph.Graph;
import org.apache.commons.graph.SynchronizedUndirectedGraph;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true) 
public class SynchronizedUndirectedGraph_ESTest extends SynchronizedUndirectedGraph_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test0()  throws Throwable  {
      SynchronizedUndirectedGraph<Integer, Integer> synchronizedUndirectedGraph0 = new SynchronizedUndirectedGraph<Integer, Integer>((Graph<Integer, Integer>) null);
  }
}
