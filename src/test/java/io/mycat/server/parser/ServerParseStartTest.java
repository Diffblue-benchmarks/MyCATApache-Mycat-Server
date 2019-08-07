package io.mycat.server.parser;

import io.mycat.server.parser.ServerParseStart;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.rules.Timeout;

import java.lang.reflect.Method;

public class ServerParseStartTest {

  @Rule public final ExpectedException thrown = ExpectedException.none();

  @Rule public final Timeout globalTimeout = new Timeout(10000);

  /* testedClasses: ServerParseStart */
  // Test written by Diffblue Cover.
  @Test
  public void parseInputNotNullNegativeOutputStringIndexOutOfBoundsException() {

    // Arrange
    final String stmt = ",";
    final int offset = -2_105_657_345;

    // Act
    thrown.expect(StringIndexOutOfBoundsException.class);
    ServerParseStart.parse(stmt, offset);

    // Method is not expected to return due to exception thrown
  }

  // Test written by Diffblue Cover.
  @Test
  public void parseInputNotNullPositiveOutputNegative() {

    // Arrange
    final String stmt = ",";
    final int offset = 41_826_303;

    // Act
    final int actual = ServerParseStart.parse(stmt, offset);

    // Assert result
    Assert.assertEquals(-1, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void parseInputNotNullPositiveOutputNegative2() {

    // Arrange
    final String stmt = "1a 2b 3c";
    final int offset = 5;

    // Act
    final int actual = ServerParseStart.parse(stmt, offset);

    // Assert result
    Assert.assertEquals(-1, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void parseInputNotNullPositiveOutputNegative3() {

    // Arrange
    final String stmt = "a/b/c";
    final int offset = 3;

    // Act
    final int actual = ServerParseStart.parse(stmt, offset);

    // Assert result
    Assert.assertEquals(-1, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void parseInputNotNullPositiveOutputNegative4() {

    // Arrange
    final String stmt = "############U*\n TRa`saa``aaV?";
    final int offset = 11;

    // Act
    final int actual = ServerParseStart.parse(stmt, offset);

    // Assert result
    Assert.assertEquals(-1, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void parseInputNotNullPositiveOutputNegative5() {

    // Arrange
    final String stmt = "############\u0000*\n TRaN\u0001a\u0001\u0000\u0000\u0001\u0001\u0000?";
    final int offset = 11;

    // Act
    final int actual = ServerParseStart.parse(stmt, offset);

    // Assert result
    Assert.assertEquals(-1, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void parseInputNotNullPositiveOutputNegative6() {

    // Arrange
    final String stmt = "############\u0000*\n TRaNs\u0001\u0001\u0000\u0000\u0001\u0001\u0000?";
    final int offset = 11;

    // Act
    final int actual = ServerParseStart.parse(stmt, offset);

    // Assert result
    Assert.assertEquals(-1, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void parseInputNotNullPositiveOutputNegative7() {

    // Arrange
    final String stmt = "             #R\nTRanSacTION\u0000??";
    final int offset = 12;

    // Act
    final int actual = ServerParseStart.parse(stmt, offset);

    // Assert result
    Assert.assertEquals(-1, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void parseInputNotNullPositiveOutputPositive() {

    // Arrange
    final String stmt = "ttttttttttRANSACTION";
    final int offset = 9;

    // Act
    final int actual = ServerParseStart.parse(stmt, offset);

    // Assert result
    Assert.assertEquals(1, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void parseInputNotNullPositiveOutputPositive2() {

    // Arrange
    final String stmt = "ttttttttttRANSACTIOn";
    final int offset = 9;

    // Act
    final int actual = ServerParseStart.parse(stmt, offset);

    // Assert result
    Assert.assertEquals(1, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void parseInputNotNullPositiveOutputPositive3() {

    // Arrange
    final String stmt = "ttttttttttRANSAcTIOn";
    final int offset = 9;

    // Act
    final int actual = ServerParseStart.parse(stmt, offset);

    // Assert result
    Assert.assertEquals(1, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void parseInputNotNullPositiveOutputPositive4() {

    // Arrange
    final String stmt = "ttttttttttRANSAcTIon";
    final int offset = 9;

    // Act
    final int actual = ServerParseStart.parse(stmt, offset);

    // Assert result
    Assert.assertEquals(1, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void parseInputNotNullPositiveOutputPositive5() {

    // Arrange
    final String stmt = "ttttttttttRANSAcTion";
    final int offset = 9;

    // Act
    final int actual = ServerParseStart.parse(stmt, offset);

    // Assert result
    Assert.assertEquals(1, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void parseInputNotNullPositiveOutputPositive6() {

    // Arrange
    final String stmt = "ttttttttttRANSAction";
    final int offset = 9;

    // Act
    final int actual = ServerParseStart.parse(stmt, offset);

    // Assert result
    Assert.assertEquals(1, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void parseInputNotNullZeroOutputNegative() {

    // Arrange
    final String stmt = ",";
    final int offset = 0;

    // Act
    final int actual = ServerParseStart.parse(stmt, offset);

    // Assert result
    Assert.assertEquals(-1, actual);
  }

  // Test written by Diffblue Cover.

  @Test
  public void transactionCheckInputNotNullNegativeOutputStringIndexOutOfBoundsException() {

    // Arrange
    final String stmt = "foo";
    final int offset = -2_136_583_678;

    // Act
    thrown.expect(StringIndexOutOfBoundsException.class);
    ServerParseStart.transactionCheck(stmt, offset);

    // Method is not expected to return due to exception thrown
  }

  // Test written by Diffblue Cover.
  @Test
  public void transactionCheckInputNotNullPositiveOutputNegative() {

    // Arrange
    final String stmt = "foo";
    final int offset = 2_029_114_076;

    // Act
    final int actual = ServerParseStart.transactionCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(-1, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void transactionCheckInputNotNullPositiveOutputNegative2() {

    // Arrange
    final String stmt =
        "\uffee\uffee\uffee\uffee\uffee\uffee\uffee\uffee\uffee\uffee\uffee\uffee\uffee\uffee\uffee\uffee\uffee\uffee\uffee\ufffd\uffe9\uffe1\uffe1\uffe3\uffe2\uffe2\uffe3\ufff8\uffc3?";
    final int offset = 17;

    // Act
    final int actual = ServerParseStart.transactionCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(-1, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void transactionCheckInputNotNullPositiveOutputNegative3() {

    // Arrange
    final String stmt =
        "rrrrrrrrrrrrrrrrrrr\u001d\t\uffc1\uffc1\u0003\u0002\u0000\uffe3\ufff8\uffc3?";
    final int offset = 17;

    // Act
    final int actual = ServerParseStart.transactionCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(-1, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void transactionCheckInputNotNullPositiveOutputNegative4() {

    // Arrange
    final String stmt =
        "RRRRRRRRRRRRRRRRRRR\u001d\t\uffc1\uffc1\u0003\u0002\u0000\uffe3\ufff8\uffc3?";
    final int offset = 17;

    // Act
    final int actual = ServerParseStart.transactionCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(-1, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void transactionCheckInputNotNullPositiveOutputNegative5() {

    // Arrange
    final String stmt = "RRRRRRRRRRRRRRRRRRRa\t\uffc1\uffc1\u0003\u0002\u0000\uffe3\ufff8\uffc3?";
    final int offset = 17;

    // Act
    final int actual = ServerParseStart.transactionCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(-1, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void transactionCheckInputNotNullPositiveOutputNegative6() {

    // Arrange
    final String stmt = "rrrrrrrrrrrrrrrrrrrAn\uffc1\uffc1\u0003\u0002\u0000\uffc3\ufff8\uffe3?";
    final int offset = 17;

    // Act
    final int actual = ServerParseStart.transactionCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(-1, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void transactionCheckInputNotNullPositiveOutputNegative7() {

    // Arrange
    final String stmt = "rrrrrrrrrrrrrrrrrrrAns\u2ad1\u0003\u0002\u0000\u6ec3\ufff8\uffe3?";
    final int offset = 17;

    // Act
    final int actual = ServerParseStart.transactionCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(-1, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void transactionCheckInputNotNullPositiveOutputNegative8() {

    // Arrange
    final String stmt = "rrrrrrrrrrrrrrrrrrrAnsa\u0003\u0002\u0000\u6ec3\ufff8\uffe3?";
    final int offset = 17;

    // Act
    final int actual = ServerParseStart.transactionCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(-1, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void transactionCheckInputNotNullPositiveOutputNegative9() {

    // Arrange
    final String stmt = "rrrrrrrrrrrrrrrrrrrAnsac\u0002\u0000\u6ec3\ufff8\uffe3?";
    final int offset = 17;

    // Act
    final int actual = ServerParseStart.transactionCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(-1, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void transactionCheckInputNotNullPositiveOutputNegative10() {

    // Arrange
    final String stmt = "rrrrrrrrrrrrrrrrrrrAnsact\u0000\u6ec3\ubbb8\ubbe3?";
    final int offset = 17;

    // Act
    final int actual = ServerParseStart.transactionCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(-1, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void transactionCheckInputNotNullPositiveOutputNegative11() {

    // Arrange
    final String stmt = "rrrrrrrrrrrrrrrrrrrAnsacti\u6ec3\ubbb8\ubbe3?";
    final int offset = 17;

    // Act
    final int actual = ServerParseStart.transactionCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(-1, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void transactionCheckInputNotNullPositiveOutputPositive() {

    // Arrange
    final String stmt = "rrrrrrrrrrrAnsactioN\r?????????";
    final int offset = 9;

    // Act
    final int actual = ServerParseStart.transactionCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(1, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void transactionCheckInputNotNullPositiveOutputPositive2() {

    // Arrange
    final String stmt = "rrrrrrrrrrrAnsaction\r?????????";
    final int offset = 9;

    // Act
    final int actual = ServerParseStart.transactionCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(1, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void transactionCheckInputNotNullPositiveOutputPositive3() {

    // Arrange
    final String stmt = "rrrrrrrrrrrrrrrrrrrAnsaction";
    final int offset = 17;

    // Act
    final int actual = ServerParseStart.transactionCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(1, actual);
  }
}
