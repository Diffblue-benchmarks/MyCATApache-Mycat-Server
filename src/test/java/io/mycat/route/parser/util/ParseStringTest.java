package io.mycat.route.parser.util;

import io.mycat.route.parser.util.ParseString;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.rules.Timeout;

import java.lang.reflect.Array;
import java.lang.reflect.Method;

public class ParseStringTest {

  @Rule public final ExpectedException thrown = ExpectedException.none();

  @Rule public final Timeout globalTimeout = new Timeout(10000);

  /* testedClasses: ParseString */
  // Test written by Diffblue Cover.
  @Test
  public void hexString2BytesInput0NegativeNegativeOutput0() {

    // Arrange
    final char[] hexString = {};
    final int offset = -801_618_944;
    final int length = -1;

    // Act
    final byte[] actual = ParseString.hexString2Bytes(hexString, offset, length);

    // Assert result
    Assert.assertArrayEquals(new byte[] {}, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void hexString2BytesInput2PositiveZeroOutput0() {

    // Arrange
    final char[] hexString = {'F', '\u2042'};
    final int offset = 674_505_271;
    final int length = 0;

    // Act
    final byte[] actual = ParseString.hexString2Bytes(hexString, offset, length);

    // Assert result
    Assert.assertArrayEquals(new byte[] {}, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void hexString2BytesInput7PositivePositiveOutputStringIndexOutOfBoundsException() {

    // Arrange
    final char[] hexString = {'\u0006', '\u2002', '9', '\u0423', '\u0423', '\u0423', '\u0822'};
    final int offset = 2;
    final int length = 65_536;

    // Act
    thrown.expect(StringIndexOutOfBoundsException.class);
    ParseString.hexString2Bytes(hexString, offset, length);

    // Method is not expected to return due to exception thrown
  }

  // Test written by Diffblue Cover.
  @Test
  public void hexString2BytesInput7PositivePositiveOutputStringIndexOutOfBoundsException2() {

    // Arrange
    final char[] hexString = {'\u0006', '\u2002', '4', '\u0423', '\u0423', '\u0423', '\u0822'};
    final int offset = 2;
    final int length = 65_536;

    // Act
    thrown.expect(StringIndexOutOfBoundsException.class);
    ParseString.hexString2Bytes(hexString, offset, length);

    // Method is not expected to return due to exception thrown
  }

  // Test written by Diffblue Cover.
  @Test
  public void hexString2BytesInput7PositivePositiveOutputStringIndexOutOfBoundsException3() {

    // Arrange
    final char[] hexString = {'\u0006', '\u2002', '5', '\u0423', '\u0423', '\u0423', '\u0822'};
    final int offset = 2;
    final int length = 65_536;

    // Act
    thrown.expect(StringIndexOutOfBoundsException.class);
    ParseString.hexString2Bytes(hexString, offset, length);

    // Method is not expected to return due to exception thrown
  }

  // Test written by Diffblue Cover.
  @Test
  public void hexString2BytesInput7PositivePositiveOutputStringIndexOutOfBoundsException4() {

    // Arrange
    final char[] hexString = {'\u0006', '\u2002', '6', '\u0423', '\u0423', '\u0423', '\u0820'};
    final int offset = 2;
    final int length = 65_536;

    // Act
    thrown.expect(StringIndexOutOfBoundsException.class);
    ParseString.hexString2Bytes(hexString, offset, length);

    // Method is not expected to return due to exception thrown
  }

  // Test written by Diffblue Cover.
  @Test
  public void hexString2BytesInput7PositivePositiveOutputStringIndexOutOfBoundsException5() {

    // Arrange
    final char[] hexString = {'\u0006', '\u2002', '1', '\u0423', '\u0423', '\u0423', '\u0822'};
    final int offset = 2;
    final int length = 65_536;

    // Act
    thrown.expect(StringIndexOutOfBoundsException.class);
    ParseString.hexString2Bytes(hexString, offset, length);

    // Method is not expected to return due to exception thrown
  }

  // Test written by Diffblue Cover.
  @Test
  public void hexString2BytesInput7PositivePositiveOutputStringIndexOutOfBoundsException6() {

    // Arrange
    final char[] hexString = {'\u0006', '\u2002', '8', '\u0423', '\u0423', '\u0423', '\u0822'};
    final int offset = 2;
    final int length = 65_536;

    // Act
    thrown.expect(StringIndexOutOfBoundsException.class);
    ParseString.hexString2Bytes(hexString, offset, length);

    // Method is not expected to return due to exception thrown
  }

  // Test written by Diffblue Cover.
  @Test
  public void hexString2BytesInput7PositivePositiveOutputStringIndexOutOfBoundsException7() {

    // Arrange
    final char[] hexString = {'\u241c', '\u0418', '2', '\u2039', '\u2039', '\u2039', '\u2828'};
    final int offset = 2;
    final int length = 65_536;

    // Act
    thrown.expect(StringIndexOutOfBoundsException.class);
    ParseString.hexString2Bytes(hexString, offset, length);

    // Method is not expected to return due to exception thrown
  }

  // Test written by Diffblue Cover.
  @Test
  public void hexString2BytesInput7PositivePositiveOutputStringIndexOutOfBoundsException8() {

    // Arrange
    final char[] hexString = {'\u241c', '\u0419', '7', '\u2039', '\u2039', '\u2038', '\u2828'};
    final int offset = 2;
    final int length = 65_536;

    // Act
    thrown.expect(StringIndexOutOfBoundsException.class);
    ParseString.hexString2Bytes(hexString, offset, length);

    // Method is not expected to return due to exception thrown
  }

  // Test written by Diffblue Cover.
  @Test
  public void hexString2BytesInput9PositivePositiveOutputStringIndexOutOfBoundsException() {

    // Arrange
    final char[] hexString = {'c', '\u0262', 'f', 'R', 'R', 'A', 'c', '\u0232', '@'};
    final int offset = 8;
    final int length = 131_067;

    // Act
    thrown.expect(StringIndexOutOfBoundsException.class);
    ParseString.hexString2Bytes(hexString, offset, length);

    // Method is not expected to return due to exception thrown
  }

  // Test written by Diffblue Cover.
  @Test
  public void hexString2BytesInput10PositivePositiveOutputIllegalArgumentException() {

    // Arrange
    final char[] hexString = {'\u8043', '\u8242', '\u8046', '\u8072', '\u8063',
                              '\u8042', '\u8043', '\u8212', '\u8063', '\u8042'};
    final int offset = 4;
    final int length = 3;

    // Act
    thrown.expect(IllegalArgumentException.class);
    ParseString.hexString2Bytes(hexString, offset, length);

    // Method is not expected to return due to exception thrown
  }

  // Test written by Diffblue Cover.
  @Test
  public void hexString2BytesInput10PositivePositiveOutputIllegalArgumentException2() {

    // Arrange
    final char[] hexString = {'\u0842', '\u0a43', '\u0847', 's', '0',
                              '\u0843', 'B',      '\u0a13', '0', '\u0843'};
    final int offset = 4;
    final int length = 4;

    // Act
    thrown.expect(IllegalArgumentException.class);
    ParseString.hexString2Bytes(hexString, offset, length);

    // Method is not expected to return due to exception thrown
  }

  // Test written by Diffblue Cover.
  @Test
  public void hexString2BytesInput10PositivePositiveOutputIllegalArgumentException3() {

    // Arrange
    final char[] hexString = {'c', '\u4042', 'd',      '\u0814', '\u4042',
                              'd', '\u4860', '\u4258', '\u1813', 'd'};
    final int offset = 1;
    final int length = 8;

    // Act
    thrown.expect(IllegalArgumentException.class);
    ParseString.hexString2Bytes(hexString, offset, length);

    // Method is not expected to return due to exception thrown
  }

  // Test written by Diffblue Cover.
  @Test
  public void hexString2BytesInput10PositivePositiveOutputStringIndexOutOfBoundsException() {

    // Arrange
    final char[] hexString = {'\u0842', '\u0a43', '\u1847', 's',      '\u1030',
                              '\u0843', 'B',      '\u0a13', '\u1030', '\u0843'};
    final int offset = 4;
    final int length = 36;

    // Act
    thrown.expect(StringIndexOutOfBoundsException.class);
    ParseString.hexString2Bytes(hexString, offset, length);

    // Method is not expected to return due to exception thrown
  }

  // Test written by Diffblue Cover.
  @Test
  public void hexString2BytesInput10PositivePositiveOutputStringIndexOutOfBoundsException2() {

    // Arrange
    final char[] hexString = {'(', '\u0229', '\u102d', '\u0819', '3',
                              ')', '\u0828', '\u0279', '\u185a', ')'};
    final int offset = 4;
    final int length = 36;

    // Act
    thrown.expect(StringIndexOutOfBoundsException.class);
    ParseString.hexString2Bytes(hexString, offset, length);

    // Method is not expected to return due to exception thrown
  }

  // Test written by Diffblue Cover.
  @Test
  public void hexString2BytesInput10PositivePositiveOutputStringIndexOutOfBoundsException3() {

    // Arrange
    final char[] hexString = {'(', '\u0269', '\u102d', '\u0819', 'c',
                              ')', '\u0828', '\u0279', '\u185a', ')'};
    final int offset = 4;
    final int length = 36;

    // Act
    thrown.expect(StringIndexOutOfBoundsException.class);
    ParseString.hexString2Bytes(hexString, offset, length);

    // Method is not expected to return due to exception thrown
  }

  // Test written by Diffblue Cover.
  @Test
  public void hexString2BytesInput10PositivePositiveOutputStringIndexOutOfBoundsException4() {

    // Arrange
    final char[] hexString = {'+', '\u0269', '\u102d', '\u0819', 'B',
                              ')', '\u0828', '\u0259', '\u185a', ')'};
    final int offset = 4;
    final int length = 36;

    // Act
    thrown.expect(StringIndexOutOfBoundsException.class);
    ParseString.hexString2Bytes(hexString, offset, length);

    // Method is not expected to return due to exception thrown
  }

  // Test written by Diffblue Cover.
  @Test
  public void hexString2BytesInput10PositivePositiveOutputStringIndexOutOfBoundsException5() {

    // Arrange
    final char[] hexString = {'D',      '\u2040', '\u2040', 'D',      '\u2040',
                              '\u2040', '\u0860', '\u025c', '\u1837', '\u2040'};
    final int offset = 3;
    final int length = 8;

    // Act
    thrown.expect(StringIndexOutOfBoundsException.class);
    ParseString.hexString2Bytes(hexString, offset, length);

    // Method is not expected to return due to exception thrown
  }

  // Test written by Diffblue Cover.
  @Test
  public void hexString2BytesInput10PositivePositiveOutputStringIndexOutOfBoundsException6() {

    // Arrange
    final char[] hexString = {'E',      '\u2041', '\u2040', 'E',      '\u2040',
                              '\u2040', '\u0861', '\u025c', '\u1837', '\u2040'};
    final int offset = 3;
    final int length = 8;

    // Act
    thrown.expect(StringIndexOutOfBoundsException.class);
    ParseString.hexString2Bytes(hexString, offset, length);

    // Method is not expected to return due to exception thrown
  }

  // Test written by Diffblue Cover.
  @Test
  public void hexString2BytesInput10PositivePositiveOutputStringIndexOutOfBoundsException7() {

    // Arrange
    final char[] hexString = {'A',      '\u2045', '\u0463', 'A',      '\u0463',
                              '\u0463', '\u0863', '\u065b', '\u1c10', '\u0463'};
    final int offset = 3;
    final int length = 8;

    // Act
    thrown.expect(StringIndexOutOfBoundsException.class);
    ParseString.hexString2Bytes(hexString, offset, length);

    // Method is not expected to return due to exception thrown
  }

  // Test written by Diffblue Cover.
  @Test
  public void hexString2BytesInput10PositivePositiveOutputStringIndexOutOfBoundsException8() {

    // Arrange
    final char[] hexString = {'F',      '\u2042', '\u0463', 'F',      '\u0463',
                              '\u0463', '\u0862', '\u065f', '\u1c14', '\u0463'};
    final int offset = 3;
    final int length = 8;

    // Act
    thrown.expect(StringIndexOutOfBoundsException.class);
    ParseString.hexString2Bytes(hexString, offset, length);

    // Method is not expected to return due to exception thrown
  }

  // Test written by Diffblue Cover.
  @Test
  public void hexString2BytesInput10PositivePositiveOutputStringIndexOutOfBoundsException9() {

    // Arrange
    final char[] hexString = {'\u0444', '\u0444', '\u0444', 'B',      '\u0445',
                              '@',      '\u0430', '\u0444', '\u0444', '\u0444'};
    final int offset = 3;
    final int length = 9;

    // Act
    thrown.expect(StringIndexOutOfBoundsException.class);
    ParseString.hexString2Bytes(hexString, offset, length);

    // Method is not expected to return due to exception thrown
  }

  // Test written by Diffblue Cover.
  @Test
  public void hexString2BytesInput10PositivePositiveOutputStringIndexOutOfBoundsException10() {

    // Arrange
    final char[] hexString = {'\u0444', '\u0444', '\u0444', 'A',      '\u0445',
                              '@',      '\u0430', '\u0444', '\u0444', '\u0444'};
    final int offset = 3;
    final int length = 9;

    // Act
    thrown.expect(StringIndexOutOfBoundsException.class);
    ParseString.hexString2Bytes(hexString, offset, length);

    // Method is not expected to return due to exception thrown
  }

  // Test written by Diffblue Cover.
  @Test
  public void hexString2BytesInput10PositivePositiveOutputStringIndexOutOfBoundsException11() {

    // Arrange
    final char[] hexString = {'\u0440', '\u0444', '\u0444', 'F',      '\u0445',
                              '@',      '\u0431', '\u0444', '\u0444', '\u0444'};
    final int offset = 3;
    final int length = 9;

    // Act
    thrown.expect(StringIndexOutOfBoundsException.class);
    ParseString.hexString2Bytes(hexString, offset, length);

    // Method is not expected to return due to exception thrown
  }

  // Test written by Diffblue Cover.
  @Test
  public void hexString2BytesInput10PositivePositiveOutputStringIndexOutOfBoundsException12() {

    // Arrange
    final char[] hexString = {'\u0440', '\u0465', '\u0444', 'e',      '\u0445',
                              '@',      '\u0430', '\u0444', '\u0444', '\u0464'};
    final int offset = 3;
    final int length = 9;

    // Act
    thrown.expect(StringIndexOutOfBoundsException.class);
    ParseString.hexString2Bytes(hexString, offset, length);

    // Method is not expected to return due to exception thrown
  }

  // Test written by Diffblue Cover.
  @Test
  public void hexString2BytesInput10PositivePositiveOutputStringIndexOutOfBoundsException13() {

    // Arrange
    final char[] hexString = {'\u0444', '\u0441', '\u0444', 'C',      '\u0445',
                              '@',      '\u0430', '\u0440', '\u0444', '\u0440'};
    final int offset = 3;
    final int length = 9;

    // Act
    thrown.expect(StringIndexOutOfBoundsException.class);
    ParseString.hexString2Bytes(hexString, offset, length);

    // Method is not expected to return due to exception thrown
  }

  // Test written by Diffblue Cover.
  @Test
  public void hexString2BytesInput10PositivePositiveOutputStringIndexOutOfBoundsException14() {

    // Arrange
    final char[] hexString = {'\u0440', '\u0464', '\u0444', 'd',      '\u0445',
                              '@',      '\u0431', '\u0444', '\u0464', '\u0464'};
    final int offset = 3;
    final int length = 9;

    // Act
    thrown.expect(StringIndexOutOfBoundsException.class);
    ParseString.hexString2Bytes(hexString, offset, length);

    // Method is not expected to return due to exception thrown
  }

  // Test written by Diffblue Cover.
  @Test
  public void hexString2BytesInput10PositivePositiveOutputStringIndexOutOfBoundsException15() {

    // Arrange
    final char[] hexString = {'0',      '4',      '\u0414', '6',      '5',
                              '\u0436', '\u0461', '\u0434', '\u0434', '\u0434'};
    final int offset = 3;
    final int length = 9;

    // Act
    thrown.expect(StringIndexOutOfBoundsException.class);
    ParseString.hexString2Bytes(hexString, offset, length);

    // Method is not expected to return due to exception thrown
  }

  // Test written by Diffblue Cover.
  @Test
  public void hexString2BytesInput10PositivePositiveOutputStringIndexOutOfBoundsException16() {

    // Arrange
    final char[] hexString = {'\u0434', '\u0430', '\u0414', '0',      '\u0435',
                              '1',      '\u0461', '\u0430', '\u0434', '\u0430'};
    final int offset = 3;
    final int length = 9;

    // Act
    thrown.expect(StringIndexOutOfBoundsException.class);
    ParseString.hexString2Bytes(hexString, offset, length);

    // Method is not expected to return due to exception thrown
  }

  // Test written by Diffblue Cover.
  @Test
  public void hexString2BytesInput10PositivePositiveOutputStringIndexOutOfBoundsException17() {

    // Arrange
    final char[] hexString = {'\u0434', '\u0430', '\u0414', '8',      '\u0435',
                              '1',      '\u0469', '\u0430', '\u0434', '\u0430'};
    final int offset = 3;
    final int length = 9;

    // Act
    thrown.expect(StringIndexOutOfBoundsException.class);
    ParseString.hexString2Bytes(hexString, offset, length);

    // Method is not expected to return due to exception thrown
  }

  // Test written by Diffblue Cover.
  @Test
  public void hexString2BytesInput10PositivePositiveOutputStringIndexOutOfBoundsException18() {

    // Arrange
    final char[] hexString = {'4', '0', '\u0014', '1', '5', '\u0438', 'i', '0', '4', '0'};
    final int offset = 3;
    final int length = 9;

    // Act
    thrown.expect(StringIndexOutOfBoundsException.class);
    ParseString.hexString2Bytes(hexString, offset, length);

    // Method is not expected to return due to exception thrown
  }

  // Test written by Diffblue Cover.
  @Test
  public void hexString2BytesInput10PositivePositiveOutputStringIndexOutOfBoundsException19() {

    // Arrange
    final char[] hexString = {'4', '0', '\u0014', '2', '5', '\u0432', 'i', '0', '4', '0'};
    final int offset = 3;
    final int length = 9;

    // Act
    thrown.expect(StringIndexOutOfBoundsException.class);
    ParseString.hexString2Bytes(hexString, offset, length);

    // Method is not expected to return due to exception thrown
  }

  // Test written by Diffblue Cover.
  @Test
  public void hexString2BytesInput10PositivePositiveOutputStringIndexOutOfBoundsException20() {

    // Arrange
    final char[] hexString = {'0', '1', '\u0014', '7', '5', '\u0432', 'm', '0', '4', '0'};
    final int offset = 3;
    final int length = 9;

    // Act
    thrown.expect(StringIndexOutOfBoundsException.class);
    ParseString.hexString2Bytes(hexString, offset, length);

    // Method is not expected to return due to exception thrown
  }

  // Test written by Diffblue Cover.
  @Test
  public void hexString2BytesInput10PositivePositiveOutputStringIndexOutOfBoundsException21() {

    // Arrange
    final char[] hexString = {'4', '1', '\u0014', '3', '5', '\u0437', 'i', '0', '4', '0'};
    final int offset = 3;
    final int length = 9;

    // Act
    thrown.expect(StringIndexOutOfBoundsException.class);
    ParseString.hexString2Bytes(hexString, offset, length);

    // Method is not expected to return due to exception thrown
  }

  // Test written by Diffblue Cover.
  @Test
  public void hexString2BytesInput10PositivePositiveOutputStringIndexOutOfBoundsException22() {

    // Arrange
    final char[] hexString = {'0', '1', '\u0016', '5', '5', '\u0437', 'm', '0', '4', '0'};
    final int offset = 3;
    final int length = 9;

    // Act
    thrown.expect(StringIndexOutOfBoundsException.class);
    ParseString.hexString2Bytes(hexString, offset, length);

    // Method is not expected to return due to exception thrown
  }

  // Test written by Diffblue Cover.
  @Test
  public void hexString2BytesInput10PositivePositiveOutputStringIndexOutOfBoundsException23() {

    // Arrange
    final char[] hexString = {'4', '1', '\u0016', '9', '5', '\u0437', 'i', '0', '4', '0'};
    final int offset = 3;
    final int length = 9;

    // Act
    thrown.expect(StringIndexOutOfBoundsException.class);
    ParseString.hexString2Bytes(hexString, offset, length);

    // Method is not expected to return due to exception thrown
  }

  // Test written by Diffblue Cover.
  @Test
  public void hexString2BytesInput10PositivePositiveOutputStringIndexOutOfBoundsException24() {

    // Arrange
    final char[] hexString = {'\u8034', '\u8031', '\u8016', '4',      '\u8035',
                              '\u8437', '\u8069', '\u8030', '\u8034', '\u8030'};
    final int offset = 3;
    final int length = 9;

    // Act
    thrown.expect(StringIndexOutOfBoundsException.class);
    ParseString.hexString2Bytes(hexString, offset, length);

    // Method is not expected to return due to exception thrown
  }

  // Test written by Diffblue Cover.
  @Test
  public void hexString2BytesInputNullPositivePositiveOutputNull() {

    // Arrange
    final char[] hexString = null;
    final int offset = 1_807_719_903;
    final int length = 62_831_008;

    // Act
    final byte[] actual = ParseString.hexString2Bytes(hexString, offset, length);

    // Assert result
    Assert.assertNull(actual);
  }
}
