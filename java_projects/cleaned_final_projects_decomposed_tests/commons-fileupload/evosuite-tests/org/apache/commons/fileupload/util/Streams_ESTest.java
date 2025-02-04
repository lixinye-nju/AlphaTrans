/*
 * This file was automatically generated by EvoSuite
 * Sat Jun 22 14:32:02 GMT 2024
 */

package org.apache.commons.fileupload.util;

import org.junit.Test;
import static org.junit.Assert.*;
import org.apache.commons.fileupload.util.Streams;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true) 
public class Streams_ESTest extends Streams_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test0()  throws Throwable  {
      String string0 = Streams.checkFileName("org.apache.commons.fileupload.util.Streams");
      assertEquals("org.apache.commons.fileupload.util.Streams", string0);
  }

  @Test(timeout = 4000)
  public void test1()  throws Throwable  {
      String string0 = Streams.checkFileName("");
      assertEquals("", string0);
  }

  @Test(timeout = 4000)
  public void test2()  throws Throwable  {
      String string0 = Streams.checkFileName((String) null);
      assertNull(string0);
  }
}
