/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.commons.fileupload;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import java.util.Map;

/** Unit tests for {@link ParameterParser}. */
public class ParameterParserTest {

    

    

    

    

    /** Test for <a href="http://issues.apache.org/jira/browse/FILEUPLOAD-199">FILEUPLOAD-199</a> */

    @Test
    public void testParsing_test0_decomposed()  {
        String s = "test; test1 =  stuff   ; test2 =  \"stuff; stuff\"; test3=\"stuff";
        ParameterParser parser = new ParameterParser();
    }

    @Test
    public void testParsing_test1_decomposed()  {
        String s = "test; test1 =  stuff   ; test2 =  \"stuff; stuff\"; test3=\"stuff";
        ParameterParser parser = new ParameterParser();
        Map<String, String> params = parser.parse1(s, ';');
    }

    @Test
    public void testParsing_test2_decomposed()  {
        String s = "test; test1 =  stuff   ; test2 =  \"stuff; stuff\"; test3=\"stuff";
        ParameterParser parser = new ParameterParser();
        Map<String, String> params = parser.parse1(s, ';');
        assertEquals(null, params.get("test"));
        assertEquals("stuff", params.get("test1"));
        assertEquals("stuff; stuff", params.get("test2"));
        assertEquals("\"stuff", params.get("test3"));
    }

    @Test
    public void testParsing_test3_decomposed()  {
        String s = "test; test1 =  stuff   ; test2 =  \"stuff; stuff\"; test3=\"stuff";
        ParameterParser parser = new ParameterParser();
        Map<String, String> params = parser.parse1(s, ';');
        assertEquals(null, params.get("test"));
        assertEquals("stuff", params.get("test1"));
        assertEquals("stuff; stuff", params.get("test2"));
        assertEquals("\"stuff", params.get("test3"));
        params = parser.parse0(s, new char[] {',', ';'});
    }

    @Test
    public void testParsing_test4_decomposed()  {
        String s = "test; test1 =  stuff   ; test2 =  \"stuff; stuff\"; test3=\"stuff";
        ParameterParser parser = new ParameterParser();
        Map<String, String> params = parser.parse1(s, ';');
        assertEquals(null, params.get("test"));
        assertEquals("stuff", params.get("test1"));
        assertEquals("stuff; stuff", params.get("test2"));
        assertEquals("\"stuff", params.get("test3"));
        params = parser.parse0(s, new char[] {',', ';'});
        assertEquals(null, params.get("test"));
        assertEquals("stuff", params.get("test1"));
        assertEquals("stuff; stuff", params.get("test2"));
        assertEquals("\"stuff", params.get("test3"));
    }

    @Test
    public void testParsing_test5_decomposed()  {
        String s = "test; test1 =  stuff   ; test2 =  \"stuff; stuff\"; test3=\"stuff";
        ParameterParser parser = new ParameterParser();
        Map<String, String> params = parser.parse1(s, ';');
        assertEquals(null, params.get("test"));
        assertEquals("stuff", params.get("test1"));
        assertEquals("stuff; stuff", params.get("test2"));
        assertEquals("\"stuff", params.get("test3"));
        params = parser.parse0(s, new char[] {',', ';'});
        assertEquals(null, params.get("test"));
        assertEquals("stuff", params.get("test1"));
        assertEquals("stuff; stuff", params.get("test2"));
        assertEquals("\"stuff", params.get("test3"));
        s = "  test  , test1=stuff   ,  , test2=, test3, ";
        params = parser.parse1(s, ',');
    }

    @Test
    public void testParsing_test6_decomposed()  {
        String s = "test; test1 =  stuff   ; test2 =  \"stuff; stuff\"; test3=\"stuff";
        ParameterParser parser = new ParameterParser();
        Map<String, String> params = parser.parse1(s, ';');
        assertEquals(null, params.get("test"));
        assertEquals("stuff", params.get("test1"));
        assertEquals("stuff; stuff", params.get("test2"));
        assertEquals("\"stuff", params.get("test3"));
        params = parser.parse0(s, new char[] {',', ';'});
        assertEquals(null, params.get("test"));
        assertEquals("stuff", params.get("test1"));
        assertEquals("stuff; stuff", params.get("test2"));
        assertEquals("\"stuff", params.get("test3"));
        s = "  test  , test1=stuff   ,  , test2=, test3, ";
        params = parser.parse1(s, ',');
        assertEquals(null, params.get("test"));
        assertEquals("stuff", params.get("test1"));
        assertEquals(null, params.get("test2"));
        assertEquals(null, params.get("test3"));
    }

    @Test
    public void testParsing_test7_decomposed()  {
        String s = "test; test1 =  stuff   ; test2 =  \"stuff; stuff\"; test3=\"stuff";
        ParameterParser parser = new ParameterParser();
        Map<String, String> params = parser.parse1(s, ';');
        assertEquals(null, params.get("test"));
        assertEquals("stuff", params.get("test1"));
        assertEquals("stuff; stuff", params.get("test2"));
        assertEquals("\"stuff", params.get("test3"));
        params = parser.parse0(s, new char[] {',', ';'});
        assertEquals(null, params.get("test"));
        assertEquals("stuff", params.get("test1"));
        assertEquals("stuff; stuff", params.get("test2"));
        assertEquals("\"stuff", params.get("test3"));
        s = "  test  , test1=stuff   ,  , test2=, test3, ";
        params = parser.parse1(s, ',');
        assertEquals(null, params.get("test"));
        assertEquals("stuff", params.get("test1"));
        assertEquals(null, params.get("test2"));
        assertEquals(null, params.get("test3"));
        s = "  test";
        params = parser.parse1(s, ';');
    }

    @Test
    public void testParsing_test8_decomposed()  {
        String s = "test; test1 =  stuff   ; test2 =  \"stuff; stuff\"; test3=\"stuff";
        ParameterParser parser = new ParameterParser();
        Map<String, String> params = parser.parse1(s, ';');
        assertEquals(null, params.get("test"));
        assertEquals("stuff", params.get("test1"));
        assertEquals("stuff; stuff", params.get("test2"));
        assertEquals("\"stuff", params.get("test3"));
        params = parser.parse0(s, new char[] {',', ';'});
        assertEquals(null, params.get("test"));
        assertEquals("stuff", params.get("test1"));
        assertEquals("stuff; stuff", params.get("test2"));
        assertEquals("\"stuff", params.get("test3"));
        s = "  test  , test1=stuff   ,  , test2=, test3, ";
        params = parser.parse1(s, ',');
        assertEquals(null, params.get("test"));
        assertEquals("stuff", params.get("test1"));
        assertEquals(null, params.get("test2"));
        assertEquals(null, params.get("test3"));
        s = "  test";
        params = parser.parse1(s, ';');
        assertEquals(null, params.get("test"));
    }

    @Test
    public void testParsing_test9_decomposed()  {
        String s = "test; test1 =  stuff   ; test2 =  \"stuff; stuff\"; test3=\"stuff";
        ParameterParser parser = new ParameterParser();
        Map<String, String> params = parser.parse1(s, ';');
        assertEquals(null, params.get("test"));
        assertEquals("stuff", params.get("test1"));
        assertEquals("stuff; stuff", params.get("test2"));
        assertEquals("\"stuff", params.get("test3"));
        params = parser.parse0(s, new char[] {',', ';'});
        assertEquals(null, params.get("test"));
        assertEquals("stuff", params.get("test1"));
        assertEquals("stuff; stuff", params.get("test2"));
        assertEquals("\"stuff", params.get("test3"));
        s = "  test  , test1=stuff   ,  , test2=, test3, ";
        params = parser.parse1(s, ',');
        assertEquals(null, params.get("test"));
        assertEquals("stuff", params.get("test1"));
        assertEquals(null, params.get("test2"));
        assertEquals(null, params.get("test3"));
        s = "  test";
        params = parser.parse1(s, ';');
        assertEquals(null, params.get("test"));
        s = "  ";
        params = parser.parse1(s, ';');
    }

    @Test
    public void testParsing_test10_decomposed()  {
        String s = "test; test1 =  stuff   ; test2 =  \"stuff; stuff\"; test3=\"stuff";
        ParameterParser parser = new ParameterParser();
        Map<String, String> params = parser.parse1(s, ';');
        assertEquals(null, params.get("test"));
        assertEquals("stuff", params.get("test1"));
        assertEquals("stuff; stuff", params.get("test2"));
        assertEquals("\"stuff", params.get("test3"));
        params = parser.parse0(s, new char[] {',', ';'});
        assertEquals(null, params.get("test"));
        assertEquals("stuff", params.get("test1"));
        assertEquals("stuff; stuff", params.get("test2"));
        assertEquals("\"stuff", params.get("test3"));
        s = "  test  , test1=stuff   ,  , test2=, test3, ";
        params = parser.parse1(s, ',');
        assertEquals(null, params.get("test"));
        assertEquals("stuff", params.get("test1"));
        assertEquals(null, params.get("test2"));
        assertEquals(null, params.get("test3"));
        s = "  test";
        params = parser.parse1(s, ';');
        assertEquals(null, params.get("test"));
        s = "  ";
        params = parser.parse1(s, ';');
        assertEquals(0, params.size());
        s = " = stuff ";
        params = parser.parse1(s, ';');
    }

    @Test
    public void testParsing_test11_decomposed()  {
        String s = "test; test1 =  stuff   ; test2 =  \"stuff; stuff\"; test3=\"stuff";
        ParameterParser parser = new ParameterParser();
        Map<String, String> params = parser.parse1(s, ';');
        assertEquals(null, params.get("test"));
        assertEquals("stuff", params.get("test1"));
        assertEquals("stuff; stuff", params.get("test2"));
        assertEquals("\"stuff", params.get("test3"));
        params = parser.parse0(s, new char[] {',', ';'});
        assertEquals(null, params.get("test"));
        assertEquals("stuff", params.get("test1"));
        assertEquals("stuff; stuff", params.get("test2"));
        assertEquals("\"stuff", params.get("test3"));
        s = "  test  , test1=stuff   ,  , test2=, test3, ";
        params = parser.parse1(s, ',');
        assertEquals(null, params.get("test"));
        assertEquals("stuff", params.get("test1"));
        assertEquals(null, params.get("test2"));
        assertEquals(null, params.get("test3"));
        s = "  test";
        params = parser.parse1(s, ';');
        assertEquals(null, params.get("test"));
        s = "  ";
        params = parser.parse1(s, ';');
        assertEquals(0, params.size());
        s = " = stuff ";
        params = parser.parse1(s, ';');
        assertEquals(0, params.size());
    }

    @Test
    public void testContentTypeParsing_test0_decomposed()  {
        String s = "text/plain; Charset=UTF-8";
        ParameterParser parser = new ParameterParser();
    }

    @Test
    public void testContentTypeParsing_test1_decomposed()  {
        String s = "text/plain; Charset=UTF-8";
        ParameterParser parser = new ParameterParser();
        parser.setLowerCaseNames(true);
    }

    @Test
    public void testContentTypeParsing_test2_decomposed()  {
        String s = "text/plain; Charset=UTF-8";
        ParameterParser parser = new ParameterParser();
        parser.setLowerCaseNames(true);
        Map<String, String> params = parser.parse1(s, ';');
    }

    @Test
    public void testContentTypeParsing_test3_decomposed()  {
        String s = "text/plain; Charset=UTF-8";
        ParameterParser parser = new ParameterParser();
        parser.setLowerCaseNames(true);
        Map<String, String> params = parser.parse1(s, ';');
        assertEquals("UTF-8", params.get("charset"));
    }

    @Test
    public void testParsingEscapedChars_test0_decomposed()  {
        String s = "param = \"stuff\\\"; more stuff\"";
        ParameterParser parser = new ParameterParser();
    }

    @Test
    public void testParsingEscapedChars_test1_decomposed()  {
        String s = "param = \"stuff\\\"; more stuff\"";
        ParameterParser parser = new ParameterParser();
        Map<String, String> params = parser.parse1(s, ';');
    }

    @Test
    public void testParsingEscapedChars_test2_decomposed()  {
        String s = "param = \"stuff\\\"; more stuff\"";
        ParameterParser parser = new ParameterParser();
        Map<String, String> params = parser.parse1(s, ';');
        assertEquals(1, params.size());
        assertEquals("stuff\\\"; more stuff", params.get("param"));
    }

    @Test
    public void testParsingEscapedChars_test3_decomposed()  {
        String s = "param = \"stuff\\\"; more stuff\"";
        ParameterParser parser = new ParameterParser();
        Map<String, String> params = parser.parse1(s, ';');
        assertEquals(1, params.size());
        assertEquals("stuff\\\"; more stuff", params.get("param"));
        s = "param = \"stuff\\\\\"; anotherparam";
        params = parser.parse1(s, ';');
    }

    @Test
    public void testParsingEscapedChars_test4_decomposed()  {
        String s = "param = \"stuff\\\"; more stuff\"";
        ParameterParser parser = new ParameterParser();
        Map<String, String> params = parser.parse1(s, ';');
        assertEquals(1, params.size());
        assertEquals("stuff\\\"; more stuff", params.get("param"));
        s = "param = \"stuff\\\\\"; anotherparam";
        params = parser.parse1(s, ';');
        assertEquals(2, params.size());
        assertEquals("stuff\\\\", params.get("param"));
    }

    @Test
    public void testParsingEscapedChars_test5_decomposed()  {
        String s = "param = \"stuff\\\"; more stuff\"";
        ParameterParser parser = new ParameterParser();
        Map<String, String> params = parser.parse1(s, ';');
        assertEquals(1, params.size());
        assertEquals("stuff\\\"; more stuff", params.get("param"));
        s = "param = \"stuff\\\\\"; anotherparam";
        params = parser.parse1(s, ';');
        assertEquals(2, params.size());
        assertEquals("stuff\\\\", params.get("param"));
        assertNull(params.get("anotherparam"));
    }

    @Test
    public void testFileUpload139_test0_decomposed()  {
        ParameterParser parser = new ParameterParser();
    }

    @Test
    public void testFileUpload139_test1_decomposed()  {
        ParameterParser parser = new ParameterParser();
        String s = "Content-type: multipart/form-data , boundary=AaB03x";
        Map<String, String> params = parser.parse0(s, new char[] {',', ';'});
    }

    @Test
    public void testFileUpload139_test2_decomposed()  {
        ParameterParser parser = new ParameterParser();
        String s = "Content-type: multipart/form-data , boundary=AaB03x";
        Map<String, String> params = parser.parse0(s, new char[] {',', ';'});
        assertEquals("AaB03x", params.get("boundary"));
    }

    @Test
    public void testFileUpload139_test3_decomposed()  {
        ParameterParser parser = new ParameterParser();
        String s = "Content-type: multipart/form-data , boundary=AaB03x";
        Map<String, String> params = parser.parse0(s, new char[] {',', ';'});
        assertEquals("AaB03x", params.get("boundary"));
        s = "Content-type: multipart/form-data, boundary=AaB03x";
        params = parser.parse0(s, new char[] {';', ','});
    }

    @Test
    public void testFileUpload139_test4_decomposed()  {
        ParameterParser parser = new ParameterParser();
        String s = "Content-type: multipart/form-data , boundary=AaB03x";
        Map<String, String> params = parser.parse0(s, new char[] {',', ';'});
        assertEquals("AaB03x", params.get("boundary"));
        s = "Content-type: multipart/form-data, boundary=AaB03x";
        params = parser.parse0(s, new char[] {';', ','});
        assertEquals("AaB03x", params.get("boundary"));
    }

    @Test
    public void testFileUpload139_test5_decomposed()  {
        ParameterParser parser = new ParameterParser();
        String s = "Content-type: multipart/form-data , boundary=AaB03x";
        Map<String, String> params = parser.parse0(s, new char[] {',', ';'});
        assertEquals("AaB03x", params.get("boundary"));
        s = "Content-type: multipart/form-data, boundary=AaB03x";
        params = parser.parse0(s, new char[] {';', ','});
        assertEquals("AaB03x", params.get("boundary"));
        s = "Content-type: multipart/mixed, boundary=BbC04y";
        params = parser.parse0(s, new char[] {',', ';'});
    }

    @Test
    public void testFileUpload139_test6_decomposed()  {
        ParameterParser parser = new ParameterParser();
        String s = "Content-type: multipart/form-data , boundary=AaB03x";
        Map<String, String> params = parser.parse0(s, new char[] {',', ';'});
        assertEquals("AaB03x", params.get("boundary"));
        s = "Content-type: multipart/form-data, boundary=AaB03x";
        params = parser.parse0(s, new char[] {';', ','});
        assertEquals("AaB03x", params.get("boundary"));
        s = "Content-type: multipart/mixed, boundary=BbC04y";
        params = parser.parse0(s, new char[] {',', ';'});
        assertEquals("BbC04y", params.get("boundary"));
    }

    @Test
    public void fileUpload199_test0_decomposed()  {
        ParameterParser parser = new ParameterParser();
    }

    @Test
    public void fileUpload199_test1_decomposed()  {
        ParameterParser parser = new ParameterParser();
        String s =
                "Content-Disposition: form-data; name=\"file\";"
                        + " filename=\"=?ISO-8859-1?B?SWYgeW91IGNhbiByZWFkIHRoaXMgeW8=?="
                        + " =?ISO-8859-2?B?dSB1bmRlcnN0YW5kIHRoZSBleGFtcGxlLg==?=\"\r\n";
        Map<String, String> params = parser.parse0(s, new char[] {',', ';'});
    }

    @Test
    public void fileUpload199_test2_decomposed()  {
        ParameterParser parser = new ParameterParser();
        String s =
                "Content-Disposition: form-data; name=\"file\";"
                        + " filename=\"=?ISO-8859-1?B?SWYgeW91IGNhbiByZWFkIHRoaXMgeW8=?="
                        + " =?ISO-8859-2?B?dSB1bmRlcnN0YW5kIHRoZSBleGFtcGxlLg==?=\"\r\n";
        Map<String, String> params = parser.parse0(s, new char[] {',', ';'});
        assertEquals("If you can read this you understand the example.", params.get("filename"));
    }
}