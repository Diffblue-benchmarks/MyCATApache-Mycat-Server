package io.mycat.route.parser.util;

import static org.mockito.Matchers.anyChar;
import static org.powermock.api.mockito.PowerMockito.mockStatic;

import com.diffblue.deeptestutils.mock.DTUMemberMatcher;
import io.mycat.route.parser.util.CharTypes;
import io.mycat.route.parser.util.ParseUtil;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.rules.Timeout;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.api.mockito.expectation.PowerMockitoStubber;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.lang.reflect.Method;

@RunWith(PowerMockRunner.class)
public class ParseUtilTest {

  @Rule public final ExpectedException thrown = ExpectedException.none();

  @Rule public final Timeout globalTimeout = new Timeout(10000);

  /* testedClasses: ParseUtil */
  // Test written by Diffblue Cover.
  @Test
  public void commentInputNotNullNegativeOutputStringIndexOutOfBoundsException() {

    // Arrange
    final String stmt = "/";
    final int offset = -98_234;

    // Act
    thrown.expect(StringIndexOutOfBoundsException.class);
    ParseUtil.comment(stmt, offset);

    // Method is not expected to return due to exception thrown
  }

  // Test written by Diffblue Cover.
  @Test
  public void commentInputNotNullPositiveOutputPositive() {

    // Arrange
    final String stmt = "a/b/c";
    final int offset = 1;

    // Act
    final int actual = ParseUtil.comment(stmt, offset);

    // Assert result
    Assert.assertEquals(1, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void commentInputNotNullPositiveOutputPositive2() {

    // Arrange
    final String stmt = "######";
    final int offset = 5;

    // Act
    final int actual = ParseUtil.comment(stmt, offset);

    // Assert result
    Assert.assertEquals(5, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void commentInputNotNullPositiveOutputPositive3() {

    // Arrange
    final String stmt = "//////*";
    final int offset = 5;

    // Act
    final int actual = ParseUtil.comment(stmt, offset);

    // Assert result
    Assert.assertEquals(5, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void commentInputNotNullPositiveOutputPositive4() {

    // Arrange
    final String stmt = "######*";
    final int offset = 5;

    // Act
    final int actual = ParseUtil.comment(stmt, offset);

    // Assert result
    Assert.assertEquals(5, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void commentInputNotNullPositiveOutputPositive5() {

    // Arrange
    final String stmt = "######\n";
    final int offset = 5;

    // Act
    final int actual = ParseUtil.comment(stmt, offset);

    // Assert result
    Assert.assertEquals(6, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void commentInputNotNullPositiveOutputPositive6() {

    // Arrange
    final String stmt = "/////////**/\u000b+?";
    final int offset = 8;

    // Act
    final int actual = ParseUtil.comment(stmt, offset);

    // Assert result
    Assert.assertEquals(11, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void commentInputNotNullPositiveOutputPositive7() {

    // Arrange
    final String stmt = "/////////**\u802f*/?";
    final int offset = 8;

    // Act
    final int actual = ParseUtil.comment(stmt, offset);

    // Assert result
    Assert.assertEquals(13, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void commentInputNotNullPositiveOutputPositive8() {

    // Arrange
    final String stmt = "///////////////////***";
    final int offset = 18;

    // Act
    final int actual = ParseUtil.comment(stmt, offset);

    // Assert result
    Assert.assertEquals(18, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void commentInputNotNullZeroOutputZero() {

    // Arrange
    final String stmt = "foo";
    final int offset = 0;

    // Act
    final int actual = ParseUtil.comment(stmt, offset);

    // Assert result
    Assert.assertEquals(0, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void commentInputNotNullZeroOutputZero2() {

    // Arrange
    final String stmt = "/";
    final int offset = 0;

    // Act
    final int actual = ParseUtil.comment(stmt, offset);

    // Assert result
    Assert.assertEquals(0, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void compareInputNotNullNegative2OutputStringIndexOutOfBoundsException() {

    // Arrange
    final String s = "a\'b\'c";
    final int offset = -2_147_483_648;
    final char[] keyword = {'\u0000', '\u0000'};

    // Act
    thrown.expect(StringIndexOutOfBoundsException.class);
    ParseUtil.compare(s, offset, keyword);

    // Method is not expected to return due to exception thrown
  }

  // Test written by Diffblue Cover.
  @Test
  public void compareInputNotNullPositive1OutputFalse() {

    // Arrange
    final String s = "foo";
    final int offset = 10;
    final char[] keyword = {'\u0000'};

    // Act
    final boolean actual = ParseUtil.compare(s, offset, keyword);

    // Assert result
    Assert.assertFalse(actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void compareInputNotNullPositive2OutputFalse() {

    // Arrange
    final String s = "a\'b\'c";
    final int offset = 1;
    final char[] keyword = {'\u0000', '\u0000'};

    // Act
    final boolean actual = ParseUtil.compare(s, offset, keyword);

    // Assert result
    Assert.assertFalse(actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void compareInputNotNullZero0OutputTrue() {

    // Arrange
    final String s = "a\'b\'c";
    final int offset = 0;
    final char[] keyword = {};

    // Act
    final boolean actual = ParseUtil.compare(s, offset, keyword);

    // Assert result
    Assert.assertTrue(actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void compareInputNotNullZero1OutputTrue() {

    // Arrange
    final String s = "a/b/c";
    final int offset = 0;
    final char[] keyword = {'A'};

    // Act
    final boolean actual = ParseUtil.compare(s, offset, keyword);

    // Assert result
    Assert.assertTrue(actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void currentCharIsSepInputNotNullPositiveOutputFalse() {

    // Arrange
    final String stmt = "a\'b\'c";
    final int offset = 1;

    // Act
    final boolean actual = ParseUtil.currentCharIsSep(stmt, offset);

    // Assert result
    Assert.assertFalse(actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void currentCharIsSepInputNotNullPositiveOutputTrue() {

    // Arrange
    final String stmt = "foo";
    final int offset = 256;

    // Act
    final boolean actual = ParseUtil.currentCharIsSep(stmt, offset);

    // Assert result
    Assert.assertTrue(actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void currentCharIsSepInputNotNullPositiveOutputTrue2() {

    // Arrange
    final String stmt = "1a 2b 3c";
    final int offset = 2;

    // Act
    final boolean actual = ParseUtil.currentCharIsSep(stmt, offset);

    // Assert result
    Assert.assertTrue(actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void getSQLIdInputNotNullOutputPositive() {

    // Arrange
    final String stmt = "\u0430\u0430\u0430\u0430\u0430\u0430\u0430= 1      ";

    // Act
    final long actual = ParseUtil.getSQLId(stmt);

    // Assert result
    Assert.assertEquals(1L, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void getSQLIdInputNotNullOutputZero() {

    // Arrange
    final String stmt = "2";

    // Act
    final long actual = ParseUtil.getSQLId(stmt);

    // Assert result
    Assert.assertEquals(0L, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void isEOFInputNotNullOutputFalse() {

    // Arrange
    final char c = '\u0000';

    // Act
    final boolean actual = ParseUtil.isEOF(c);

    // Assert result
    Assert.assertFalse(actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void isEOFInputNotNullOutputTrue() {

    // Arrange
    final char c = '\t';

    // Act
    final boolean actual = ParseUtil.isEOF(c);

    // Assert result
    Assert.assertTrue(actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void moveInputNotNullNegativeZeroOutputStringIndexOutOfBoundsException() {

    // Arrange
    final String stmt = "1";
    final int offset = -2_147_483_606;
    final int length = 0;

    // Act
    thrown.expect(StringIndexOutOfBoundsException.class);
    ParseUtil.move(stmt, offset, length);

    // Method is not expected to return due to exception thrown
  }

  // Test written by Diffblue Cover.
  @Test
  public void moveInputNotNullPositivePositiveOutputPositive() {

    // Arrange
    final String stmt = "1a 2b 3c";
    final int offset = 2;
    final int length = 7046;

    // Act
    final int actual = ParseUtil.move(stmt, offset, length);

    // Assert result
    Assert.assertEquals(7049, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void moveInputNotNullPositivePositiveOutputPositive2() {

    // Arrange
    final String stmt = "a/b/c";
    final int offset = 3;
    final int length = 7044;

    // Act
    final int actual = ParseUtil.move(stmt, offset, length);

    // Assert result
    Assert.assertEquals(7048, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void moveInputNotNullPositiveZeroOutputPositive() {

    // Arrange
    final String stmt = "foo";
    final int offset = 42;
    final int length = 0;

    // Act
    final int actual = ParseUtil.move(stmt, offset, length);

    // Assert result
    Assert.assertEquals(42, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void moveInputNotNullZeroNegativeOutputNegative() {

    // Arrange
    final String stmt = "1";
    final int offset = 0;
    final int length = -2_147_483_605;

    // Act
    final int actual = ParseUtil.move(stmt, offset, length);

    // Assert result
    Assert.assertEquals(-2_147_483_605, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void nextCharIsSepInputNotNullNegativeOutputStringIndexOutOfBoundsException() {

    // Arrange
    final String stmt = "/";
    final int offset = -8449;

    // Act
    thrown.expect(StringIndexOutOfBoundsException.class);
    ParseUtil.nextCharIsSep(stmt, offset);

    // Method is not expected to return due to exception thrown
  }

  // Test written by Diffblue Cover.
  @Test
  public void nextCharIsSepInputNotNullPositiveOutputTrue() {

    // Arrange
    final String stmt = "foo";
    final int offset = 3;

    // Act
    final boolean actual = ParseUtil.nextCharIsSep(stmt, offset);

    // Assert result
    Assert.assertTrue(actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void nextCharIsSepInputNotNullPositiveOutputTrue2() {

    // Arrange
    final String stmt = "1a 2b 3c";
    final int offset = 4;

    // Act
    final boolean actual = ParseUtil.nextCharIsSep(stmt, offset);

    // Assert result
    Assert.assertTrue(actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void nextCharIsSepInputNotNullZeroOutputFalse() {

    // Arrange
    final String stmt = "foo";
    final int offset = 0;

    // Act
    final boolean actual = ParseUtil.nextCharIsSep(stmt, offset);

    // Assert result
    Assert.assertFalse(actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void
  nextStringIsExpectedWithIgnoreSepCharInputNotNullNegativeNotNullFalseOutputStringIndexOutOfBoundsException() {

    // Arrange
    final String stmt = "3";
    final int offset = -1;
    final String nextExpectedString = "\'";
    final boolean checkSepChar = false;

    // Act
    thrown.expect(StringIndexOutOfBoundsException.class);
    ParseUtil.nextStringIsExpectedWithIgnoreSepChar(stmt, offset, nextExpectedString, checkSepChar);

    // Method is not expected to return due to exception thrown
  }

  // Test written by Diffblue Cover.

  @Test
  public void
  nextStringIsExpectedWithIgnoreSepCharInputNotNullPositiveNotNullFalseOutputPositive() {

    // Arrange
    final String stmt = "/";
    final int offset = 458_753;
    final String nextExpectedString = "Bar";
    final boolean checkSepChar = false;

    // Act
    final int actual = ParseUtil.nextStringIsExpectedWithIgnoreSepChar(
        stmt, offset, nextExpectedString, checkSepChar);

    // Assert result
    Assert.assertEquals(458_753, actual);
  }

  // Test written by Diffblue Cover.

  @Test
  public void
  nextStringIsExpectedWithIgnoreSepCharInputNotNullPositiveNotNullFalseOutputPositive2() {

    // Arrange
    final String stmt = "a\'b\'c";
    final int offset = 3;
    final String nextExpectedString = "\'";
    final boolean checkSepChar = false;

    // Act
    final int actual = ParseUtil.nextStringIsExpectedWithIgnoreSepChar(
        stmt, offset, nextExpectedString, checkSepChar);

    // Assert result
    Assert.assertEquals(4, actual);
  }

  // Test written by Diffblue Cover.

  @Test
  public void nextStringIsExpectedWithIgnoreSepCharInputNotNullPositiveNotNullTrueOutputPositive() {

    // Arrange
    final String stmt = "a\'b\'c";
    final int offset = 3;
    final String nextExpectedString = "\'";
    final boolean checkSepChar = true;

    // Act
    final int actual = ParseUtil.nextStringIsExpectedWithIgnoreSepChar(
        stmt, offset, nextExpectedString, checkSepChar);

    // Assert result
    Assert.assertEquals(4, actual);
  }

  // Test written by Diffblue Cover.

  @Test
  public void
  nextStringIsExpectedWithIgnoreSepCharInputNotNullPositiveNotNullTrueOutputPositive2() {

    // Arrange
    final String stmt = "1a 2b 3c";
    final int offset = 2;
    final String nextExpectedString = "A1B2C3";
    final boolean checkSepChar = true;

    // Act
    final int actual = ParseUtil.nextStringIsExpectedWithIgnoreSepChar(
        stmt, offset, nextExpectedString, checkSepChar);

    // Assert result
    Assert.assertEquals(2, actual);
  }

  // Test written by Diffblue Cover.

  @Test
  public void nextStringIsExpectedWithIgnoreSepCharInputNotNullZeroNotNullFalseOutputZero() {

    // Arrange
    final String stmt = "/";
    final int offset = 0;
    final String nextExpectedString = "2";
    final boolean checkSepChar = false;

    // Act
    final int actual = ParseUtil.nextStringIsExpectedWithIgnoreSepChar(
        stmt, offset, nextExpectedString, checkSepChar);

    // Assert result
    Assert.assertEquals(0, actual);
  }

  // Test written by Diffblue Cover.

  @Test
  public void nextStringIsExpectedWithIgnoreSepCharInputNotNullZeroNotNullFalseOutputZero2() {

    // Arrange
    final String stmt = "a\'b\'c";
    final int offset = 0;
    final String nextExpectedString = "a,b,c";
    final boolean checkSepChar = false;

    // Act
    final int actual = ParseUtil.nextStringIsExpectedWithIgnoreSepChar(
        stmt, offset, nextExpectedString, checkSepChar);

    // Assert result
    Assert.assertEquals(0, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void nextStringIsExpectedWithIgnoreSepCharInputNullNegativeNullFalseOutputNegative() {

    // Arrange
    final String stmt = null;
    final int offset = -3_397_561;
    final String nextExpectedString = null;
    final boolean checkSepChar = false;

    // Act
    final int actual = ParseUtil.nextStringIsExpectedWithIgnoreSepChar(
        stmt, offset, nextExpectedString, checkSepChar);

    // Assert result
    Assert.assertEquals(-3_397_561, actual);
  }

  // Test written by Diffblue Cover.

  @Test
  public void nextStringIsJsonEqInputNotNullNegativeOutputNegative() {

    // Arrange
    final String stmt = ",";
    final int offset = -1;

    // Act
    final int actual = ParseUtil.nextStringIsJsonEq(stmt, offset);

    // Assert result
    Assert.assertEquals(-1, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void nextStringIsJsonEqInputNotNullNegativeOutputStringIndexOutOfBoundsException() {

    // Arrange
    final String stmt = "1234";
    final int offset = -1_946_157_056;

    // Act
    thrown.expect(StringIndexOutOfBoundsException.class);
    ParseUtil.nextStringIsJsonEq(stmt, offset);

    // Method is not expected to return due to exception thrown
  }

  // Test written by Diffblue Cover.
  @Test
  public void nextStringIsJsonEqInputNotNullPositiveOutputPositive() {

    // Arrange
    final String stmt = "1234";
    final int offset = 201_326_592;

    // Act
    final int actual = ParseUtil.nextStringIsJsonEq(stmt, offset);

    // Assert result
    Assert.assertEquals(201_326_592, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void parseAliasInputNotNullNegativeOutputNull() {

    // Arrange
    final String stmt = "foo";
    final int aliasIndex = -860_421_152;

    // Act
    final String actual = ParseUtil.parseAlias(stmt, aliasIndex);

    // Assert result
    Assert.assertNull(actual);
  }

  // Test written by Diffblue Cover.
  @PrepareForTest(CharTypes.class)
  @Test
  public void parseAliasInputNotNullPositiveOutputNotNull() throws Exception {

    // Setup mocks
    PowerMockito.mockStatic(CharTypes.class);

    // Arrange
    final String stmt = "a/b/c";
    final int aliasIndex = 3;
    final Method isIdentifierCharMethod =
        DTUMemberMatcher.method(CharTypes.class, "isIdentifierChar", char.class);
    ((PowerMockitoStubber)PowerMockito.doReturn(true).doReturn(false))
        .when(CharTypes.class, isIdentifierCharMethod)
        .withArguments(anyChar());

    // Act
    final String actual = ParseUtil.parseAlias(stmt, aliasIndex);

    // Assert result
    Assert.assertEquals("/", actual);
  }

  // Test written by Diffblue Cover.
  @PrepareForTest(CharTypes.class)
  @Test
  public void parseAliasInputNotNullPositiveOutputNotNull2() throws Exception {

    // Setup mocks
    PowerMockito.mockStatic(CharTypes.class);

    // Arrange
    final String stmt = "a/b/c";
    final int aliasIndex = 4;
    final Method isIdentifierCharMethod =
        DTUMemberMatcher.method(CharTypes.class, "isIdentifierChar", char.class);
    PowerMockito.doReturn(true)
        .when(CharTypes.class, isIdentifierCharMethod)
        .withArguments(anyChar());

    // Act
    final String actual = ParseUtil.parseAlias(stmt, aliasIndex);

    // Assert result
    Assert.assertEquals("c", actual);
  }

  // Test written by Diffblue Cover.

  @Test
  public void parseAliasInputNotNullPositiveOutputNotNull3() {

    // Arrange
    final String stmt = "a\'b\'c";
    final int aliasIndex = 3;

    // Act
    final String actual = ParseUtil.parseAlias(stmt, aliasIndex);

    // Assert result
    Assert.assertEquals("c", actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void parseAliasInputNotNullPositiveOutputNotNull4() {

    // Arrange
    final String stmt = "```````````\\";
    final int aliasIndex = 10;

    // Act
    final String actual = ParseUtil.parseAlias(stmt, aliasIndex);

    // Assert result
    Assert.assertEquals("\\", actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void parseAliasInputNotNullPositiveOutputNotNull5() {

    // Arrange
    final String stmt = "````````````";
    final int aliasIndex = 10;

    // Act
    final String actual = ParseUtil.parseAlias(stmt, aliasIndex);

    // Assert result
    Assert.assertEquals("", actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void parseAliasInputNotNullPositiveOutputNotNull6() {

    // Arrange
    final String stmt = "\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"|%";
    final int aliasIndex = 21;

    // Act
    final String actual = ParseUtil.parseAlias(stmt, aliasIndex);

    // Assert result
    Assert.assertEquals("|%", actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void parseAliasInputNotNullPositiveOutputNotNull7() {

    // Arrange
    final String stmt = "\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"%";
    final int aliasIndex = 21;

    // Act
    final String actual = ParseUtil.parseAlias(stmt, aliasIndex);

    // Assert result
    Assert.assertEquals("", actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void parseAliasInputNotNullPositiveOutputNotNull8() {

    // Arrange
    final String stmt = "\'\'\'\'\'\'\'\'\\n";
    final int aliasIndex = 7;

    // Act
    final String actual = ParseUtil.parseAlias(stmt, aliasIndex);

    // Assert result
    Assert.assertEquals("\n", actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void parseAliasInputNotNullPositiveOutputNotNull9() {

    // Arrange
    final String stmt = "\"\"\"\"\"\"\"\"\\n";
    final int aliasIndex = 7;

    // Act
    final String actual = ParseUtil.parseAlias(stmt, aliasIndex);

    // Assert result
    Assert.assertEquals("\n", actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void parseAliasInputNotNullPositiveOutputNotNull10() {

    // Arrange
    final String stmt = "\"\"\"\"\"\"\"\\n\\\u2030";
    final int aliasIndex = 6;

    // Act
    final String actual = ParseUtil.parseAlias(stmt, aliasIndex);

    // Assert result
    Assert.assertEquals("\n\u2030", actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void parseAliasInputNotNullPositiveOutputNotNull11() {

    // Arrange
    final String stmt = "\"\"\"\"\"\"\"\\0\\\u2030";
    final int aliasIndex = 6;

    // Act
    final String actual = ParseUtil.parseAlias(stmt, aliasIndex);

    // Assert result
    Assert.assertEquals("\u0000\u2030", actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void parseAliasInputNotNullPositiveOutputNotNull12() {

    // Arrange
    final String stmt = "\'\'\"\\r\'t";
    final int aliasIndex = 1;

    // Act
    final String actual = ParseUtil.parseAlias(stmt, aliasIndex);

    // Assert result
    Assert.assertEquals("\"\r", actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void parseAliasInputNotNullPositiveOutputNotNull13() {

    // Arrange
    final String stmt = "\'\'\u805c\'\'\'t????";
    final int aliasIndex = 1;

    // Act
    final String actual = ParseUtil.parseAlias(stmt, aliasIndex);

    // Assert result
    Assert.assertEquals("\u805c\'", actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void parseAliasInputNotNullPositiveOutputNotNull14() {

    // Arrange
    final String stmt = "\'\'X\\t\'t????";
    final int aliasIndex = 1;

    // Act
    final String actual = ParseUtil.parseAlias(stmt, aliasIndex);

    // Assert result
    Assert.assertEquals("X\t", actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void parseAliasInputNotNullPositiveOutputNotNull15() {

    // Arrange
    final String stmt = "\'\'\'\'\\0\'^???????";
    final int aliasIndex = 1;

    // Act
    final String actual = ParseUtil.parseAlias(stmt, aliasIndex);

    // Assert result
    Assert.assertEquals("\'\u0000", actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void parseAliasInputNotNullPositiveOutputNotNull16() {

    // Arrange
    final String stmt = "````\\0\\Z???????";
    final int aliasIndex = 2;

    // Act
    final String actual = ParseUtil.parseAlias(stmt, aliasIndex);

    // Assert result
    Assert.assertEquals("", actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void parseAliasInputNotNullPositiveOutputNotNull17() {

    // Arrange
    final String stmt = "````````````````\u8027```b";
    final int aliasIndex = 15;

    // Act
    final String actual = ParseUtil.parseAlias(stmt, aliasIndex);

    // Assert result
    Assert.assertEquals("\u8027`", actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void parseAliasInputNotNullPositiveOutputStringIndexOutOfBoundsException() {

    // Arrange
    final String stmt = "\'\'\'\'\'\'\'\'\'\'\'\\";
    final int aliasIndex = 10;

    // Act
    thrown.expect(StringIndexOutOfBoundsException.class);
    ParseUtil.parseAlias(stmt, aliasIndex);

    // Method is not expected to return due to exception thrown
  }

  // Test written by Diffblue Cover.
  @Test
  public void parseAliasInputNotNullPositiveOutputStringIndexOutOfBoundsException2() {

    // Arrange
    final String stmt = "\"\"\"\"\"\"\"\"\"\"\"\\";
    final int aliasIndex = 10;

    // Act
    thrown.expect(StringIndexOutOfBoundsException.class);
    ParseUtil.parseAlias(stmt, aliasIndex);

    // Method is not expected to return due to exception thrown
  }

  // Test written by Diffblue Cover.
  @Test
  public void parseAliasInputNotNullPositiveOutputStringIndexOutOfBoundsException3() {

    // Arrange
    final String stmt = "\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"|\\";
    final int aliasIndex = 21;

    // Act
    thrown.expect(StringIndexOutOfBoundsException.class);
    ParseUtil.parseAlias(stmt, aliasIndex);

    // Method is not expected to return due to exception thrown
  }

  // Test written by Diffblue Cover.
  @Test
  public void parseAliasInputNotNullPositiveOutputStringIndexOutOfBoundsException4() {

    // Arrange
    final String stmt = "\"\"\"\"\"\"\"\\b\\0\\";
    final int aliasIndex = 6;

    // Act
    thrown.expect(StringIndexOutOfBoundsException.class);
    ParseUtil.parseAlias(stmt, aliasIndex);

    // Method is not expected to return due to exception thrown
  }

  // Test written by Diffblue Cover.
  @Test
  public void parseAliasInputNotNullPositiveOutputStringIndexOutOfBoundsException5() {

    // Arrange
    final String stmt = "\"\"\"\"\"\"\"\\0\\r\\";
    final int aliasIndex = 6;

    // Act
    thrown.expect(StringIndexOutOfBoundsException.class);
    ParseUtil.parseAlias(stmt, aliasIndex);

    // Method is not expected to return due to exception thrown
  }

  // Test written by Diffblue Cover.
  @Test
  public void parseAliasInputNotNullPositiveOutputStringIndexOutOfBoundsException6() {

    // Arrange
    final String stmt = "\"\"\"\"\"\"\"\\t\\r\\";
    final int aliasIndex = 6;

    // Act
    thrown.expect(StringIndexOutOfBoundsException.class);
    ParseUtil.parseAlias(stmt, aliasIndex);

    // Method is not expected to return due to exception thrown
  }

  // Test written by Diffblue Cover.
  @Test
  public void parseAliasInputNotNullPositiveOutputStringIndexOutOfBoundsException7() {

    // Arrange
    final String stmt = "\"\"\"\"\"\"\"\\Z\\r\\";
    final int aliasIndex = 6;

    // Act
    thrown.expect(StringIndexOutOfBoundsException.class);
    ParseUtil.parseAlias(stmt, aliasIndex);

    // Method is not expected to return due to exception thrown
  }

  // Test written by Diffblue Cover.
  @Test
  public void parseAliasInputNotNullPositiveOutputStringIndexOutOfBoundsException8() {

    // Arrange
    final String stmt = "\'\'\'\'\'\'\'\'\'\'\'\'\'\'\'\'\u8027\\`\\";
    final int aliasIndex = 15;

    // Act
    thrown.expect(StringIndexOutOfBoundsException.class);
    ParseUtil.parseAlias(stmt, aliasIndex);

    // Method is not expected to return due to exception thrown
  }

  // Test written by Diffblue Cover.
  @Test
  public void parseAliasInputNotNullPositiveOutputStringIndexOutOfBoundsException9() {

    // Arrange
    final String stmt = "\'\'\'\'\'\'\'\'\'\'\'\'\'\'\'\'\u8027\\b\\";
    final int aliasIndex = 15;

    // Act
    thrown.expect(StringIndexOutOfBoundsException.class);
    ParseUtil.parseAlias(stmt, aliasIndex);

    // Method is not expected to return due to exception thrown
  }

  // Test written by Diffblue Cover.
  @Test
  public void parseAliasInputNotNullPositiveOutputStringIndexOutOfBoundsException10() {

    // Arrange
    final String stmt = "\'\'\'\'\'\'\'\'\'\'\'\'\'\'\'\'\u8027\\Z\\";
    final int aliasIndex = 15;

    // Act
    thrown.expect(StringIndexOutOfBoundsException.class);
    ParseUtil.parseAlias(stmt, aliasIndex);

    // Method is not expected to return due to exception thrown
  }

  // Test written by Diffblue Cover.
  @PrepareForTest(CharTypes.class)
  @Test
  public void parseAliasInputNotNullZeroOutputNotNull() throws Exception {

    // Setup mocks
    PowerMockito.mockStatic(CharTypes.class);

    // Arrange
    final String stmt = "1";
    final int aliasIndex = 0;
    final Method isIdentifierCharMethod =
        DTUMemberMatcher.method(CharTypes.class, "isIdentifierChar", char.class);
    PowerMockito.doReturn(false)
        .when(CharTypes.class, isIdentifierCharMethod)
        .withArguments(anyChar());

    // Act
    final String actual = ParseUtil.parseAlias(stmt, aliasIndex);

    // Assert result
    Assert.assertEquals("", actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void parseAliasInputNotNullZeroOutputNotNull2() {

    // Arrange
    final String stmt = "\'";
    final int aliasIndex = 0;

    // Act
    final String actual = ParseUtil.parseAlias(stmt, aliasIndex);

    // Assert result
    Assert.assertEquals("", actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void parseAliasInputNotNullZeroOutputNotNull3() {

    // Arrange
    final String stmt = "\'\\Z";
    final int aliasIndex = 0;

    // Act
    final String actual = ParseUtil.parseAlias(stmt, aliasIndex);

    // Assert result
    Assert.assertEquals("\u001a", actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void parseAliasInputNotNullZeroOutputStringIndexOutOfBoundsException() {

    // Arrange
    final String stmt = "\"\"\"\\r\\";
    final int aliasIndex = 0;

    // Act
    thrown.expect(StringIndexOutOfBoundsException.class);
    ParseUtil.parseAlias(stmt, aliasIndex);

    // Method is not expected to return due to exception thrown
  }

  // Test written by Diffblue Cover.
  @Test
  public void parseStringInputNotNullOutputNotNull() {

    // Arrange
    final String stmt =
        "=\ua3fe\u23fe\u23fe\u23fe\u23fe\u23fe\u23fe\u23fe\u23fe\u23fe\u23fe\u23fe\u23fe\u23fe\u23fe\u23fe\u23fe\u23fe\u23fe\u23fe\u23fe\u23fe\u23fe\u23fe\u23fe\u23fe\u23fe\u23fe\u23fe";

    // Act
    final String actual = ParseUtil.parseString(stmt);

    // Assert result
    Assert.assertEquals(
        "\ua3fe\u23fe\u23fe\u23fe\u23fe\u23fe\u23fe\u23fe\u23fe\u23fe\u23fe\u23fe\u23fe\u23fe\u23fe\u23fe\u23fe\u23fe\u23fe\u23fe\u23fe\u23fe\u23fe\u23fe\u23fe\u23fe\u23fe\u23fe\u23fe",
        actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void parseStringInputNotNullOutputNull() {

    // Arrange
    final String stmt = "A1B2C3";

    // Act
    final String actual = ParseUtil.parseString(stmt);

    // Assert result
    Assert.assertNull(actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void parseStringInputNotNullOutputNull2() {

    // Arrange
    final String stmt = "<<<<<<<<<<<<<<<<<<<<<<<<<<<=";

    // Act
    final String actual = ParseUtil.parseString(stmt);

    // Assert result
    Assert.assertNull(actual);
  }
}
