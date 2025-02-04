/*
 * This file was automatically generated by EvoSuite
 * Sat Jun 22 14:30:53 GMT 2024
 */

package org.apache.commons.fileupload.util.mime;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.runtime.EvoAssertions.*;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.apache.commons.fileupload.util.mime.Base64Decoder;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true) 
public class Base64Decoder_ESTest extends Base64Decoder_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test0()  throws Throwable  {
      ByteArrayOutputStream byteArrayOutputStream0 = new ByteArrayOutputStream();
      byte[] byteArray0 = new byte[5];
      byteArray0[0] = (byte)103;
      byteArray0[1] = (byte)115;
      byteArray0[2] = (byte)61;
      byteArray0[4] = (byte)61;
      int int0 = Base64Decoder.decode(byteArray0, byteArrayOutputStream0);
      assertEquals("\uFFFD", byteArrayOutputStream0.toString());
      assertEquals(1, int0);
  }

  @Test(timeout = 4000)
  public void test1()  throws Throwable  {
      // Undeclared exception!
      try { 
        Base64Decoder.decode((byte[]) null, (OutputStream) null);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("org.apache.commons.fileupload.util.mime.Base64Decoder", e);
      }
  }

  @Test(timeout = 4000)
  public void test2()  throws Throwable  {
      ByteArrayOutputStream byteArrayOutputStream0 = new ByteArrayOutputStream();
      byte[] byteArray0 = new byte[4];
      byteArray0[0] = (byte)104;
      byteArray0[1] = (byte)104;
      byteArray0[2] = (byte)61;
      byteArray0[3] = (byte)104;
      try { 
        Base64Decoder.decode(byteArray0, byteArrayOutputStream0);
        fail("Expecting exception: IOException");
      
      } catch(IOException e) {
         //
         // Invalid Base64 input: incorrect padding, 4th byte must be padding if 3rd byte is
         //
         verifyException("org.apache.commons.fileupload.util.mime.Base64Decoder", e);
      }
  }

  @Test(timeout = 4000)
  public void test3()  throws Throwable  {
      ByteArrayOutputStream byteArrayOutputStream0 = new ByteArrayOutputStream();
      byte[] byteArray0 = new byte[5];
      byteArray0[0] = (byte)65;
      byteArray0[1] = (byte)65;
      byteArray0[2] = (byte)65;
      byteArray0[3] = (byte)65;
      int int0 = Base64Decoder.decode(byteArray0, byteArrayOutputStream0);
      assertEquals(3, byteArrayOutputStream0.size());
      assertEquals(3, int0);
  }

  @Test(timeout = 4000)
  public void test4()  throws Throwable  {
      ByteArrayOutputStream byteArrayOutputStream0 = new ByteArrayOutputStream();
      byte[] byteArray0 = new byte[4];
      byteArray0[0] = (byte)103;
      byteArray0[1] = (byte)61;
      byteArray0[2] = (byte)103;
      byteArray0[3] = (byte)103;
      try { 
        Base64Decoder.decode(byteArray0, byteArrayOutputStream0);
        fail("Expecting exception: IOException");
      
      } catch(IOException e) {
         //
         // Invalid Base64 input: incorrect padding, first two bytes cannot be padding
         //
         verifyException("org.apache.commons.fileupload.util.mime.Base64Decoder", e);
      }
  }

  @Test(timeout = 4000)
  public void test5()  throws Throwable  {
      ByteArrayOutputStream byteArrayOutputStream0 = new ByteArrayOutputStream();
      byte[] byteArray0 = new byte[4];
      byteArray0[0] = (byte)61;
      byteArray0[1] = (byte)61;
      byteArray0[2] = (byte)61;
      byteArray0[3] = (byte)61;
      try { 
        Base64Decoder.decode(byteArray0, byteArrayOutputStream0);
        fail("Expecting exception: IOException");
      
      } catch(IOException e) {
         //
         // Invalid Base64 input: incorrect padding, first two bytes cannot be padding
         //
         verifyException("org.apache.commons.fileupload.util.mime.Base64Decoder", e);
      }
  }

  @Test(timeout = 4000)
  public void test6()  throws Throwable  {
      ByteArrayOutputStream byteArrayOutputStream0 = new ByteArrayOutputStream();
      byte[] byteArray0 = new byte[4];
      byteArray0[0] = (byte)103;
      byteArray0[1] = (byte)103;
      byteArray0[2] = (byte)103;
      byteArray0[3] = (byte)61;
      int int0 = Base64Decoder.decode(byteArray0, byteArrayOutputStream0);
      assertEquals("\uFFFD\b", byteArrayOutputStream0.toString());
      assertEquals(2, int0);
  }

  @Test(timeout = 4000)
  public void test7()  throws Throwable  {
      ByteArrayOutputStream byteArrayOutputStream0 = new ByteArrayOutputStream();
      byte[] byteArray0 = new byte[4];
      byteArray0[0] = (byte)103;
      try { 
        Base64Decoder.decode(byteArray0, byteArrayOutputStream0);
        fail("Expecting exception: IOException");
      
      } catch(IOException e) {
         //
         // Invalid Base64 input: truncated
         //
         verifyException("org.apache.commons.fileupload.util.mime.Base64Decoder", e);
      }
  }

  @Test(timeout = 4000)
  public void test8()  throws Throwable  {
      ByteArrayOutputStream byteArrayOutputStream0 = new ByteArrayOutputStream();
      byte[] byteArray0 = new byte[4];
      int int0 = Base64Decoder.decode(byteArray0, byteArrayOutputStream0);
      assertEquals(0, int0);
  }
}
