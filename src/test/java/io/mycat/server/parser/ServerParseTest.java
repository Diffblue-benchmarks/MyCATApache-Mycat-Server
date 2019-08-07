package io.mycat.server.parser;

import io.mycat.server.parser.ServerParse;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.rules.Timeout;

import java.lang.reflect.Method;

public class ServerParseTest {

  @Rule public final ExpectedException thrown = ExpectedException.none();

  @Rule public final Timeout globalTimeout = new Timeout(10000);

  /* testedClasses: ServerParse */
  // Test written by Diffblue Cover.
  @Test
  public void beginCheckInputNotNullPositiveOutputNegative() {

    // Arrange
    final String stmt = "1234";
    final int offset = 16_777_245;

    // Act
    final int actual = ServerParse.beginCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(-1, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void beginCheckInputNotNullPositiveOutputNegative2() {

    // Arrange
    final String stmt = "eeeeeGDDE?????";
    final int offset = 3;

    // Act
    final int actual = ServerParse.beginCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(-1, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void beginCheckInputNotNullPositiveOutputNegative3() {

    // Arrange
    final String stmt = "eeeeeeeeeeeeeGij";
    final int offset = 11;

    // Act
    final int actual = ServerParse.beginCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(-1, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void beginCheckInputNotNullPositiveOutputNegative4() {

    // Arrange
    final String stmt = "EEEEEEEEEEEEEGij";
    final int offset = 11;

    // Act
    final int actual = ServerParse.beginCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(-1, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void beginCheckInputNotNullPositiveOutputNegative5() {

    // Arrange
    final String stmt = "EEEEEEEEEEEEEEEEEEg\u2069n;?";
    final int offset = 16;

    // Act
    final int actual = ServerParse.beginCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(-1, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void beginCheckInputNotNullPositiveOutputNegative6() {

    // Arrange
    final String stmt = "EEEEEEEEEEEEEEEEEEgIN\u803b?";
    final int offset = 16;

    // Act
    final int actual = ServerParse.beginCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(-1, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void beginCheckInputNotNullPositiveOutputPositive() {

    // Arrange
    final String stmt = "EEEEEEEEEEEEEGin";
    final int offset = 11;

    // Act
    final int actual = ServerParse.beginCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(1, actual);
  }

  // Test written by Diffblue Cover.

  @Test
  public void beginCheckInputNotNullZeroOutputNegative() {

    // Arrange
    final String stmt = "a\'b\'c";
    final int offset = 0;

    // Act
    final int actual = ServerParse.beginCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(-1, actual);
  }

  // Test written by Diffblue Cover.

  @Test
  public void callCheckInputNotNullNegativeOutputNegative() {

    // Arrange
    final String stmt = "a\'b\'c";
    final int offset = -1;

    // Act
    final int actual = ServerParse.callCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(-1, actual);
  }

  // Test written by Diffblue Cover.

  @Test
  public void callCheckInputNotNullNegativeOutputNegative2() {

    // Arrange
    final String stmt = "A1B2C3";
    final int offset = -1;

    // Act
    final int actual = ServerParse.callCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(-1, actual);
  }

  // Test written by Diffblue Cover.

  @Test
  public void callCheckInputNotNullNegativeOutputStringIndexOutOfBoundsException() {

    // Arrange
    final String stmt = "a\'b\'c";
    final int offset = -2_134_816_770;

    // Act
    thrown.expect(StringIndexOutOfBoundsException.class);
    ServerParse.callCheck(stmt, offset);

    // Method is not expected to return due to exception thrown
  }

  // Test written by Diffblue Cover.
  @Test
  public void callCheckInputNotNullPositiveOutputNegative() {

    // Arrange
    final String stmt = "1a 2b 3c";
    final int offset = 108;

    // Act
    final int actual = ServerParse.callCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(-1, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void callCheckInputNotNullPositiveOutputPositive() {

    // Arrange
    final String stmt = "AAAAAAAAAAAAAAAAlL??????";
    final int offset = 14;

    // Act
    final int actual = ServerParse.callCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(20, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void callCheckInputNotNullPositiveOutputPositive2() {

    // Arrange
    final String stmt = "AAAAAAAAAAAAAAAAll??????";
    final int offset = 14;

    // Act
    final int actual = ServerParse.callCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(20, actual);
  }

  // Test written by Diffblue Cover.

  @Test
  public void commitCheckInputNotNullNegativeOutputNegative() {

    // Arrange
    final String stmt = "a\'b\'c";
    final int offset = -1;

    // Act
    final int actual = ServerParse.commitCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(-1, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void commitCheckInputNotNullNegativeOutputStringIndexOutOfBoundsException() {

    // Arrange
    final String stmt = "foo";
    final int offset = -5;

    // Act
    thrown.expect(StringIndexOutOfBoundsException.class);
    ServerParse.commitCheck(stmt, offset);

    // Method is not expected to return due to exception thrown
  }

  // Test written by Diffblue Cover.

  @Test
  public void commitCheckInputNotNullPositiveOutputNegative() {

    // Arrange
    final String stmt = "a\'b\'c";
    final int offset = 3;

    // Act
    final int actual = ServerParse.commitCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(-1, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void commitCheckInputNotNullPositiveOutputNegative2() {

    // Arrange
    final String stmt = "oooooooooooooooooooooooooNMNN";
    final int offset = 23;

    // Act
    final int actual = ServerParse.commitCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(-1, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void commitCheckInputNotNullPositiveOutputNegative3() {

    // Arrange
    final String stmt = "OOOOOOOOOOOOOOOOOOOOOOOOONMNN";
    final int offset = 23;

    // Act
    final int actual = ServerParse.commitCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(-1, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void commitCheckInputNotNullPositiveOutputNegative4() {

    // Arrange
    final String stmt = "OOOOOOOOOOOOOOOOOOOOOOOOOm\u804d\u804e\u804e";
    final int offset = 23;

    // Act
    final int actual = ServerParse.commitCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(-1, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void commitCheckInputNotNullPositiveOutputNegative5() {

    // Arrange
    final String stmt = "OOOOOOOOOOOOOOOOOOOOOOOOOmmTTU";
    final int offset = 23;

    // Act
    final int actual = ServerParse.commitCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(-1, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void commitCheckInputNotNullPositiveOutputNegative6() {

    // Arrange
    final String stmt = "OOOOOOOOOOOOOOOOOOOOOOOOOmmiTu";
    final int offset = 23;

    // Act
    final int actual = ServerParse.commitCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(-1, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void commitCheckInputNotNullPositiveOutputNegative7() {

    // Arrange
    final String stmt = "OOOOOOOOOOOOOOOOOOOOOOOOOmmitu";
    final int offset = 23;

    // Act
    final int actual = ServerParse.commitCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(-1, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void commitCheckInputNotNullPositiveOutputPositive() {

    // Arrange
    final String stmt = "OOOOOOOOOOOOOOOOOOOOOOOOOmmiT";
    final int offset = 23;

    // Act
    final int actual = ServerParse.commitCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(2, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void commitOrCallCheckOrCreateInputNotNullPositiveOutputNegative() {

    // Arrange
    final String stmt = "a,b,c";
    final int offset = 3;

    // Act
    final int actual = ServerParse.commitOrCallCheckOrCreate(stmt, offset);

    // Assert result
    Assert.assertEquals(-1, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void commitOrCallCheckOrCreateInputNotNullPositiveOutputStringIndexOutOfBoundsException() {

    // Arrange
    final String stmt = "\'";
    final int offset = 1_515_978_749;

    // Act
    thrown.expect(StringIndexOutOfBoundsException.class);
    ServerParse.commitOrCallCheckOrCreate(stmt, offset);

    // Method is not expected to return due to exception thrown
  }

  // Test written by Diffblue Cover.
  @Test
  public void dCheckInputNotNullPositiveOutputNegative() {

    // Arrange
    final String stmt = "3";
    final int offset = 1_677_721_604;

    // Act
    final int actual = ServerParse.dCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(-1, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void dCheckInputNotNullPositiveOutputStringIndexOutOfBoundsException() {

    // Arrange
    final String stmt = "3";
    final int offset = 2_147_483_643;

    // Act
    thrown.expect(StringIndexOutOfBoundsException.class);
    ServerParse.dCheck(stmt, offset);

    // Method is not expected to return due to exception thrown
  }

  // Test written by Diffblue Cover.
  @Test
  public void deleteOrdCheckInputNotNullNegativeOutputNegative() {

    // Arrange
    final String stmt = ",";
    final int offset = -1;

    // Act
    final int actual = ServerParse.deleteOrdCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(-1, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void deleteOrdCheckInputNotNullNegativeOutputStringIndexOutOfBoundsException() {

    // Arrange
    final String stmt = ",";
    final int offset = -1_398_898_689;

    // Act
    thrown.expect(StringIndexOutOfBoundsException.class);
    ServerParse.deleteOrdCheck(stmt, offset);

    // Method is not expected to return due to exception thrown
  }

  // Test written by Diffblue Cover.
  @Test
  public void describeCheckInputNotNullNegativeOutputNegative() {

    // Arrange
    final String stmt = "1a 2b 3c";
    final int offset = -1;

    // Act
    final int actual = ServerParse.describeCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(-1, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void describeCheckInputNotNullNegativeOutputStringIndexOutOfBoundsException() {

    // Arrange
    final String stmt = "A1B2C3";
    final int offset = -2_147_483_615;

    // Act
    thrown.expect(StringIndexOutOfBoundsException.class);
    ServerParse.describeCheck(stmt, offset);

    // Method is not expected to return due to exception thrown
  }

  // Test written by Diffblue Cover.
  @Test
  public void describeCheckInputNotNullPositiveOutputNegative() {

    // Arrange
    final String stmt = "1a 2b 3c";
    final int offset = 129;

    // Act
    final int actual = ServerParse.describeCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(-1, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void describeCheckInputNotNullPositiveOutputNegative2() {

    // Arrange
    final String stmt = "1a 2b 3c";
    final int offset = 3;

    // Act
    final int actual = ServerParse.describeCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(-1, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void describeCheckInputNotNullPositiveOutputNegative3() {

    // Arrange
    final String stmt = "eeeeeeeeeescR\u0001\u0002\u0000\u0003????????????";
    final int offset = 8;

    // Act
    final int actual = ServerParse.describeCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(-1, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void describeCheckInputNotNullPositiveOutputNegative4() {

    // Arrange
    final String stmt = "EEEEEEEEEEscR\u0001\u0002\u0000\u0003????????????";
    final int offset = 8;

    // Act
    final int actual = ServerParse.describeCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(-1, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void describeCheckInputNotNullPositiveOutputNegative5() {

    // Arrange
    final String stmt = "EEEEEEEEEEscr\u0001\u0002\u0000\u0003????????????";
    final int offset = 8;

    // Act
    final int actual = ServerParse.describeCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(-1, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void describeCheckInputNotNullPositiveOutputNegative6() {

    // Arrange
    final String stmt = "EEEEEEEEEEscri\u0002\u0000\u0003????????????";
    final int offset = 8;

    // Act
    final int actual = ServerParse.describeCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(-1, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void describeCheckInputNotNullPositiveOutputNegative7() {

    // Arrange
    final String stmt = "EEEEEEEEEEscrib\u0000\u0003????????????";
    final int offset = 8;

    // Act
    final int actual = ServerParse.describeCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(-1, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void describeCheckInputNotNullPositiveOutputPositive() {

    // Arrange
    final String stmt = "eeeeeeeeeeeeeeeeeeeeeeeeeeSC ";
    final int offset = 24;

    // Act
    final int actual = ServerParse.describeCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(21, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void describeCheckInputNotNullPositiveOutputPositive2() {

    // Arrange
    final String stmt = "EEEEEEEEEEEEEEEEEEEEEEEEEESC ";
    final int offset = 24;

    // Act
    final int actual = ServerParse.describeCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(21, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void describeCheckInputNotNullPositiveOutputPositive3() {

    // Arrange
    final String stmt = "EEEEEEEEEEEEEEEEEEEEEEEEEESc ";
    final int offset = 24;

    // Act
    final int actual = ServerParse.describeCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(21, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void describeCheckInputNotNullPositiveOutputPositive4() {

    // Arrange
    final String stmt = "EEEEEEEEEEEEEEEEEEEEEEEEEESc\t";
    final int offset = 24;

    // Act
    final int actual = ServerParse.describeCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(21, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void describeCheckInputNotNullPositiveOutputPositive5() {

    // Arrange
    final String stmt = "EEEEEEEEEEEEEEEEEEEEEEEEEEsc\t";
    final int offset = 24;

    // Act
    final int actual = ServerParse.describeCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(21, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void describeCheckInputNotNullPositiveOutputPositive6() {

    // Arrange
    final String stmt = "EEEEEEEEEEEEEEEEEEEEEEEEEEsc\n";
    final int offset = 24;

    // Act
    final int actual = ServerParse.describeCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(21, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void describeCheckInputNotNullPositiveOutputPositive7() {

    // Arrange
    final String stmt = "EEEEEEEEEEscribe ????????????";
    final int offset = 8;

    // Act
    final int actual = ServerParse.describeCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(21, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void describeCheckInputNotNullPositiveOutputPositive8() {

    // Arrange
    final String stmt = "EEEEEEEEEEscribe\t????????????";
    final int offset = 8;

    // Act
    final int actual = ServerParse.describeCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(21, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void describeCheckInputNotNullPositiveOutputPositive9() {

    // Arrange
    final String stmt = "EEEEEEEEEEscribe\r????????????";
    final int offset = 8;

    // Act
    final int actual = ServerParse.describeCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(21, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void describeCheckInputNotNullPositiveOutputPositive10() {

    // Arrange
    final String stmt = "EEEEEEEEEEscribe\n????????????";
    final int offset = 8;

    // Act
    final int actual = ServerParse.describeCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(21, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void explainCheckInputNotNullNegativeOutputNegative() {

    // Arrange
    final String stmt = "3";
    final int offset = -5;

    // Act
    final int actual = ServerParse.explainCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(-1, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void explainCheckInputNotNullNegativeOutputNegative2() {

    // Arrange
    final String stmt = "1a 2b 3c";
    final int offset = -1;

    // Act
    final int actual = ServerParse.explainCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(-1, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void explainCheckInputNotNullNegativeOutputStringIndexOutOfBoundsException() {

    // Arrange
    final String stmt = "3";
    final int offset = -7;

    // Act
    thrown.expect(StringIndexOutOfBoundsException.class);
    ServerParse.explainCheck(stmt, offset);

    // Method is not expected to return due to exception thrown
  }

  // Test written by Diffblue Cover.
  @Test
  public void explainCheckInputNotNullPositiveOutputPositive() {

    // Arrange
    final String stmt = "EXPLAIN2OOOOOOOOO";
    final int offset = 21;

    // Act
    final int actual = ServerParse.explainCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(5527, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void explainCheckInputNotNullPositiveOutputPositive2() {

    // Arrange
    final String stmt = "EXPLAIN2xxxxxxxxxHK\u00d9HHY";
    final int offset = 15;

    // Act
    final int actual = ServerParse.explainCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(5783, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void explainCheckInputNotNullPositiveOutputPositive3() {

    // Arrange
    final String stmt = "EXPlAIN2XXXXXXXXXXW\u00d9XXY";
    final int offset = 15;

    // Act
    final int actual = ServerParse.explainCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(5783, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void explainCheckInputNotNullPositiveOutputPositive4() {

    // Arrange
    final String stmt = "EXpLAIN2XXXXXXXXXXXXXpW\u00d9DDY";
    final int offset = 19;

    // Act
    final int actual = ServerParse.explainCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(6807, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void explainCheckInputNotNullPositiveOutputPositive5() {

    // Arrange
    final String stmt = "EXpLAIN2XXXXXXXXXXXXXpl\u00d9PPY";
    final int offset = 19;

    // Act
    final int actual = ServerParse.explainCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(6807, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void explainCheckInputNotNullPositiveOutputPositive6() {

    // Arrange
    final String stmt = "EXplAIN2XXXXXXXXXXXXXplaIN ";
    final int offset = 19;

    // Act
    final int actual = ServerParse.explainCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(6671, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void explainCheckInputNotNullPositiveOutputPositive7() {

    // Arrange
    final String stmt = "EXplAIN2XXXXXXXXXXXXXplaiN ";
    final int offset = 19;

    // Act
    final int actual = ServerParse.explainCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(6671, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void explainCheckInputNotNullPositiveOutputPositive8() {

    // Arrange
    final String stmt = "EXpLAIN2!!!!!!!!!XXXXplain ";
    final int offset = 19;

    // Act
    final int actual = ServerParse.explainCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(6671, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void explainCheckInputNotNullPositiveOutputPositive9() {

    // Arrange
    final String stmt = "EXPLAIN2AAAAAAAAA\u0001XXXplain\t";
    final int offset = 19;

    // Act
    final int actual = ServerParse.explainCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(6671, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void explainCheckInputNotNullPositiveOutputPositive10() {

    // Arrange
    final String stmt = "EXPLAIN2HHHHHHHHHHXXXplain\n";
    final int offset = 19;

    // Act
    final int actual = ServerParse.explainCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(6671, actual);
  }

  // Test written by Diffblue Cover.

  @Test
  public void helpCheckInputNotNullNegativeOutputNegative() {

    // Arrange
    final String stmt = "1234";
    final int offset = -1;

    // Act
    final int actual = ServerParse.helpCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(-1, actual);
  }

  // Test written by Diffblue Cover.

  @Test
  public void helpCheckInputNotNullNegativeOutputStringIndexOutOfBoundsException() {

    // Arrange
    final String stmt = "foo";
    final int offset = -1_073_741_824;

    // Act
    thrown.expect(StringIndexOutOfBoundsException.class);
    ServerParse.helpCheck(stmt, offset);

    // Method is not expected to return due to exception thrown
  }

  // Test written by Diffblue Cover.
  @Test
  public void helpCheckInputNotNullPositiveOutputNegative() {

    // Arrange
    final String stmt = "Bar";
    final int offset = 1_073_741_824;

    // Act
    final int actual = ServerParse.helpCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(-1, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void helpCheckInputNotNullZeroOutputNegative() {

    // Arrange
    final String stmt = "eefg?";
    final int offset = 0;

    // Act
    final int actual = ServerParse.helpCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(-1, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void helpCheckInputNotNullZeroOutputNegative2() {

    // Arrange
    final String stmt = "eelm?";
    final int offset = 0;

    // Act
    final int actual = ServerParse.helpCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(-1, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void helpCheckInputNotNullZeroOutputPositive() {

    // Arrange
    final String stmt = "eelp?";
    final int offset = 0;

    // Act
    final int actual = ServerParse.helpCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(785, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void helpCheckInputNotNullZeroOutputPositive2() {

    // Arrange
    final String stmt = "EElp?";
    final int offset = 0;

    // Act
    final int actual = ServerParse.helpCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(785, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void insertCheckInputNotNullNegativeOutputNegative() {

    // Arrange
    final String stmt = "nFEFFG?";
    final int offset = -1;

    // Act
    final int actual = ServerParse.insertCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(-1, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void insertCheckInputNotNullNegativeOutputNegative2() {

    // Arrange
    final String stmt = "N\u0000EFFG?";
    final int offset = -1;

    // Act
    final int actual = ServerParse.insertCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(-1, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void insertCheckInputNotNullNegativeOutputNegative3() {

    // Arrange
    final String stmt = "nSDFFG?";
    final int offset = -1;

    // Act
    final int actual = ServerParse.insertCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(-1, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void insertCheckInputNotNullNegativeOutputNegative4() {

    // Arrange
    final String stmt = "nSeRFG?";
    final int offset = -1;

    // Act
    final int actual = ServerParse.insertCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(-1, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void insertCheckInputNotNullNegativeOutputNegative5() {

    // Arrange
    final String stmt = "nSerF\u0007?";
    final int offset = -1;

    // Act
    final int actual = ServerParse.insertCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(-1, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void insertCheckInputNotNullNegativeOutputPositive() {

    // Arrange
    final String stmt = "nSert ?";
    final int offset = -1;

    // Act
    final int actual = ServerParse.insertCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(4, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void insertCheckInputNotNullNegativeOutputPositive2() {

    // Arrange
    final String stmt = "nSert\t?";
    final int offset = -1;

    // Act
    final int actual = ServerParse.insertCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(4, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void insertCheckInputNotNullNegativeOutputPositive3() {

    // Arrange
    final String stmt = "nSert\n?";
    final int offset = -1;

    // Act
    final int actual = ServerParse.insertCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(4, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void insertCheckInputNotNullNegativeOutputStringIndexOutOfBoundsException() {

    // Arrange
    final String stmt = "\'";
    final int offset = -1_831_659_652;

    // Act
    thrown.expect(StringIndexOutOfBoundsException.class);
    ServerParse.insertCheck(stmt, offset);

    // Method is not expected to return due to exception thrown
  }

  // Test written by Diffblue Cover.

  @Test
  public void insertCheckInputNotNullPositiveOutputNegative() {

    // Arrange
    final String stmt = "BAZ";
    final int offset = 1_443_618_940;

    // Act
    final int actual = ServerParse.insertCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(-1, actual);
  }

  // Test written by Diffblue Cover.

  @Test
  public void insertCheckInputNotNullZeroOutputNegative() {

    // Arrange
    final String stmt = "1a 2b 3c";
    final int offset = 0;

    // Act
    final int actual = ServerParse.insertCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(-1, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void killCheckInputNotNullNegativeOutputStringIndexOutOfBoundsException() {

    // Arrange
    final String stmt = "1";
    final int offset = -10;

    // Act
    thrown.expect(StringIndexOutOfBoundsException.class);
    ServerParse.killCheck(stmt, offset);

    // Method is not expected to return due to exception thrown
  }

  // Test written by Diffblue Cover.

  @Test
  public void killCheckInputNotNullPositiveOutputNegative() {

    // Arrange
    final String stmt = "foo";
    final int offset = 2;

    // Act
    final int actual = ServerParse.killCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(-1, actual);
  }

  // Test written by Diffblue Cover.

  @Test
  public void killCheckInputNotNullPositiveOutputNegative2() {

    // Arrange
    final String stmt = "1a 2b 3c";
    final int offset = 2;

    // Act
    final int actual = ServerParse.killCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(-1, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void killCheckInputNotNullPositiveOutputNegative3() {

    // Arrange
    final String stmt = "iiiiiiiiiiiiiiLUT";
    final int offset = 12;

    // Act
    final int actual = ServerParse.killCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(-1, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void killCheckInputNotNullPositiveOutputNegative4() {

    // Arrange
    final String stmt = "iiiiiiiiiiiiiil\u0005 ";
    final int offset = 12;

    // Act
    final int actual = ServerParse.killCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(-1, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void killCheckInputNotNullPositiveOutputNegative5() {

    // Arrange
    final String stmt = "IIIIIIIIIIIIIIl\u0005 ";
    final int offset = 12;

    // Act
    final int actual = ServerParse.killCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(-1, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void killCheckInputNotNullPositiveOutputNegative6() {

    // Arrange
    final String stmt = "IIIIIIIIIIIIIIlL ";
    final int offset = 12;

    // Act
    final int actual = ServerParse.killCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(-1, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void killCheckInputNotNullPositiveOutputNegative7() {

    // Arrange
    final String stmt = "IIIIIIIIIIIIIIlL\t";
    final int offset = 12;

    // Act
    final int actual = ServerParse.killCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(-1, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void killCheckInputNotNullPositiveOutputNegative8() {

    // Arrange
    final String stmt = "iiiiiiLL\u8009\u0001QMD\u0000\u0001@\u0001F\u0001????????";
    final int offset = 4;

    // Act
    final int actual = ServerParse.killCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(-1, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void killCheckInputNotNullPositiveOutputNegative9() {

    // Arrange
    final String stmt = "iiiiiiiiiiLL\n\n";
    final int offset = 8;

    // Act
    final int actual = ServerParse.killCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(-1, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void killCheckInputNotNullPositiveOutputPositive() {

    // Arrange
    final String stmt = "iiiiiiLL\n\u0001QMD\u0000\u0001@\u0001F\u0001????????";
    final int offset = 4;

    // Act
    final int actual = ServerParse.killCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(2316, actual);
  }

  // Test written by Diffblue Cover.

  @Test
  public void killQueryCheckInputNotNullNegativeOutputNegative() {

    // Arrange
    final String stmt = "a/b/c";
    final int offset = -1;

    // Act
    final int actual = ServerParse.killQueryCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(-1, actual);
  }

  // Test written by Diffblue Cover.

  @Test
  public void killQueryCheckInputNotNullNegativeOutputStringIndexOutOfBoundsException() {

    // Arrange
    final String stmt = "a\'b\'c";
    final int offset = -2_147_483_647;

    // Act
    thrown.expect(StringIndexOutOfBoundsException.class);
    ServerParse.killQueryCheck(stmt, offset);

    // Method is not expected to return due to exception thrown
  }

  // Test written by Diffblue Cover.
  @Test
  public void killQueryCheckInputNotNullPositiveOutputNegative() {

    // Arrange
    final String stmt = "foo";
    final int offset = 587_641;

    // Act
    final int actual = ServerParse.killQueryCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(-1, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void killQueryCheckInputNotNullPositiveOutputNegative2() {

    // Arrange
    final String stmt = "uuuuuutvwuttu??";
    final int offset = 4;

    // Act
    final int actual = ServerParse.killQueryCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(-1, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void killQueryCheckInputNotNullPositiveOutputNegative3() {

    // Arrange
    final String stmt = "UUUUUUt\u0002\u0003\u0001t\u0000u??";
    final int offset = 4;

    // Act
    final int actual = ServerParse.killQueryCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(-1, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void killQueryCheckInputNotNullPositiveOutputNegative4() {

    // Arrange
    final String stmt = "UUUUUUeR\u0003\u0001t\u0000e??";
    final int offset = 4;

    // Act
    final int actual = ServerParse.killQueryCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(-1, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void killQueryCheckInputNotNullPositiveOutputNegative5() {

    // Arrange
    final String stmt = "UUUUUUeRy\u0001t\u0000e??";
    final int offset = 4;

    // Act
    final int actual = ServerParse.killQueryCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(-1, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void killQueryCheckInputNotNullPositiveOutputNegative6() {

    // Arrange
    final String stmt = "UUUUUUery\u0001t\u0000e??";
    final int offset = 4;

    // Act
    final int actual = ServerParse.killQueryCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(-1, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void killQueryCheckInputNotNullPositiveOutputNegative7() {

    // Arrange
    final String stmt = "UUUUUUUUUUUUUUUUUUUUUUerY ";
    final int offset = 20;

    // Act
    final int actual = ServerParse.killQueryCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(-1, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void killQueryCheckInputNotNullPositiveOutputNegative8() {

    // Arrange
    final String stmt = "UUUUUUUUUUUUUerY \n";
    final int offset = 11;

    // Act
    final int actual = ServerParse.killQueryCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(-1, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void killQueryCheckInputNotNullPositiveOutputPositive() {

    // Arrange
    final String stmt = "UUUUUUUUUUUUUerY \b";
    final int offset = 11;

    // Act
    final int actual = ServerParse.killQueryCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(4368, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void lCheckInputNotNullNegativeOutputNegative() {

    // Arrange
    final String stmt = "OON";
    final int offset = -1;

    // Act
    final int actual = ServerParse.lCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(-1, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void lCheckInputNotNullNegativeOutputNegative2() {

    // Arrange
    final String stmt = "Oa@";
    final int offset = -1;

    // Act
    final int actual = ServerParse.lCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(-1, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void lCheckInputNotNullNegativeOutputPositive() {

    // Arrange
    final String stmt = "oCK";
    final int offset = -1;

    // Act
    final int actual = ServerParse.lCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(22, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void lCheckInputNotNullNegativeOutputPositive2() {

    // Arrange
    final String stmt = "oCk";
    final int offset = -1;

    // Act
    final int actual = ServerParse.lCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(22, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void lCheckInputNotNullNegativeOutputStringIndexOutOfBoundsException() {

    // Arrange
    final String stmt = "3";
    final int offset = -2_147_483_648;

    // Act
    thrown.expect(StringIndexOutOfBoundsException.class);
    ServerParse.lCheck(stmt, offset);

    // Method is not expected to return due to exception thrown
  }

  // Test written by Diffblue Cover.
  @Test
  public void lCheckInputNotNullPositiveOutputNegative() {

    // Arrange
    final String stmt = "1";
    final int offset = 268_435_456;

    // Act
    final int actual = ServerParse.lCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(-1, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void lCheckInputNotNullZeroOutputNegative() {

    // Arrange
    final String stmt = "1234";
    final int offset = 0;

    // Act
    final int actual = ServerParse.lCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(-1, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void parseInputNotNullOutputNegative() {

    // Arrange
    final String stmt = "foo";

    // Act
    final int actual = ServerParse.parse(stmt);

    // Assert result
    Assert.assertEquals(-1, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void parseInputNotNullOutputStringIndexOutOfBoundsException() {

    // Arrange
    final String stmt = "/";

    // Act
    thrown.expect(StringIndexOutOfBoundsException.class);
    ServerParse.parse(stmt);

    // Method is not expected to return due to exception thrown
  }

  // Test written by Diffblue Cover.
  @Test
  public void rCheckInputNotNullNegativeOutputNegative() {

    // Arrange
    final String stmt = "/";
    final int offset = -1;

    // Act
    final int actual = ServerParse.rCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(-1, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void rCheckInputNotNullPositiveOutputNegative() {

    // Arrange
    final String stmt = "1a 2b 3c";
    final int offset = 838_860_861;

    // Act
    final int actual = ServerParse.rCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(-1, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void replaceCheckInputNotNullNegativeOutputStringIndexOutOfBoundsException() {

    // Arrange
    final String stmt = "\'";
    final int offset = -1_748_824_580;

    // Act
    thrown.expect(StringIndexOutOfBoundsException.class);
    ServerParse.replaceCheck(stmt, offset);

    // Method is not expected to return due to exception thrown
  }

  // Test written by Diffblue Cover.
  @Test
  public void replaceCheckInputNotNullPositiveOutputNegative() {

    // Arrange
    final String stmt = "foo";
    final int offset = 508;

    // Act
    final int actual = ServerParse.replaceCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(-1, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void replaceCheckInputNotNullPositiveOutputNegative2() {

    // Arrange
    final String stmt = "1a 2b 3c";
    final int offset = 1;

    // Act
    final int actual = ServerParse.replaceCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(-1, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void replaceCheckInputNotNullPositiveOutputNegative3() {

    // Arrange
    final String stmt = "pppppppppppppqsrrs";
    final int offset = 11;

    // Act
    final int actual = ServerParse.replaceCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(-1, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void replaceCheckInputNotNullPositiveOutputNegative4() {

    // Arrange
    final String stmt = "ppppppppppppplA\u0002\u0000\u0003";
    final int offset = 11;

    // Act
    final int actual = ServerParse.replaceCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(-1, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void replaceCheckInputNotNullPositiveOutputNegative5() {

    // Arrange
    final String stmt = "ppppppppppppplAc\u0000\u0003";
    final int offset = 11;

    // Act
    final int actual = ServerParse.replaceCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(-1, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void replaceCheckInputNotNullPositiveOutputNegative6() {

    // Arrange
    final String stmt = "PPPPPPPPPPPPPlAc\u0000\u0003";
    final int offset = 11;

    // Act
    final int actual = ServerParse.replaceCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(-1, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void replaceCheckInputNotNullPositiveOutputNegative7() {

    // Arrange
    final String stmt = "PPPPPPPPPPPPPla\u0003e\u0003";
    final int offset = 11;

    // Act
    final int actual = ServerParse.replaceCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(-1, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void replaceCheckInputNotNullPositiveOutputPositive() {

    // Arrange
    final String stmt = "PPPPPPPPPPPPPlacE ";
    final int offset = 11;

    // Act
    final int actual = ServerParse.replaceCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(5, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void replaceCheckInputNotNullPositiveOutputPositive2() {

    // Arrange
    final String stmt = "PPPPPPPPPPPPPlacE\t";
    final int offset = 11;

    // Act
    final int actual = ServerParse.replaceCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(5, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void replaceCheckInputNotNullPositiveOutputPositive3() {

    // Arrange
    final String stmt = "PPPPPPPPPPPPPlacE\r";
    final int offset = 11;

    // Act
    final int actual = ServerParse.replaceCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(5, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void replaceCheckInputNotNullPositiveOutputPositive4() {

    // Arrange
    final String stmt = "PPPPPPPPPPPPPlacE\n";
    final int offset = 11;

    // Act
    final int actual = ServerParse.replaceCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(5, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void rollabckCheckInputNotNullNegativeOutputNegative() {

    // Arrange
    final String stmt = "1a 2b 3c";
    final int offset = -1;

    // Act
    final int actual = ServerParse.rollabckCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(-1, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void rollabckCheckInputNotNullNegativeOutputNegative2() {

    // Arrange
    final String stmt = "L\uff91\uff90\uff91\uff92\uff92\uff93?";
    final int offset = -1;

    // Act
    final int actual = ServerParse.rollabckCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(-1, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void rollabckCheckInputNotNullNegativeOutputNegative3() {

    // Arrange
    final String stmt = "Ll\uc9ac\ua9ed\uc9be\uc9be\uc9bf?";
    final int offset = -1;

    // Act
    final int actual = ServerParse.rollabckCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(-1, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void rollabckCheckInputNotNullNegativeOutputNegative4() {

    // Arrange
    final String stmt = "LlbAC\uc9be\uc9bf?";
    final int offset = -1;

    // Act
    final int actual = ServerParse.rollabckCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(-1, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void rollabckCheckInputNotNullNegativeOutputNegative5() {

    // Arrange
    final String stmt = "LlbAc\uc9be\uc9bf?";
    final int offset = -1;

    // Act
    final int actual = ServerParse.rollabckCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(-1, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void rollabckCheckInputNotNullNegativeOutputPositive() {

    // Arrange
    final String stmt = "LlbAcK";
    final int offset = -1;

    // Act
    final int actual = ServerParse.rollabckCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(6, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void rollabckCheckInputNotNullNegativeOutputPositive2() {

    // Arrange
    final String stmt = "LlbacK";
    final int offset = -1;

    // Act
    final int actual = ServerParse.rollabckCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(6, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void rollabckCheckInputNotNullPositiveOutputNegative() {

    // Arrange
    final String stmt = "foo";
    final int offset = 2_145_953_898;

    // Act
    final int actual = ServerParse.rollabckCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(-1, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void rollabckCheckInputNotNullPositiveOutputNegative2() {

    // Arrange
    final String stmt = "LLLLLLLLLLLLlBACK\uc9bf???????";
    final int offset = 10;

    // Act
    final int actual = ServerParse.rollabckCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(-1, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void rollabckCheckInputNotNullPositiveOutputStringIndexOutOfBoundsException() {

    // Arrange
    final String stmt = "\'";
    final int offset = 2_147_483_644;

    // Act
    thrown.expect(StringIndexOutOfBoundsException.class);
    ServerParse.rollabckCheck(stmt, offset);

    // Method is not expected to return due to exception thrown
  }

  // Test written by Diffblue Cover.
  @Test
  public void savepointCheckInputNotNullNegativeOutputNegative() {

    // Arrange
    final String stmt = "1a 2b 3c";
    final int offset = -1;

    // Act
    final int actual = ServerParse.savepointCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(-1, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void savepointCheckInputNotNullNegativeOutputStringIndexOutOfBoundsException() {

    // Arrange
    final String stmt = "A1B2C3";
    final int offset = -1_215_811_914;

    // Act
    thrown.expect(StringIndexOutOfBoundsException.class);
    ServerParse.savepointCheck(stmt, offset);

    // Method is not expected to return due to exception thrown
  }

  // Test written by Diffblue Cover.
  @Test
  public void savepointCheckInputNotNullPositiveOutputNegative() {

    // Arrange
    final String stmt = "foo";
    final int offset = 124_002_294;

    // Act
    final int actual = ServerParse.savepointCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(-1, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void savepointCheckInputNotNullZeroOutputPositive() {

    // Arrange
    final String stmt = "vvEPOINT ";
    final int offset = 0;

    // Act
    final int actual = ServerParse.savepointCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(13, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void savepointCheckInputNotNullZeroOutputPositive2() {

    // Arrange
    final String stmt = "vvEPOINT\t";
    final int offset = 0;

    // Act
    final int actual = ServerParse.savepointCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(13, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void savepointCheckInputNotNullZeroOutputPositive3() {

    // Arrange
    final String stmt = "vvEPOiNT\t";
    final int offset = 0;

    // Act
    final int actual = ServerParse.savepointCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(13, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void savepointCheckInputNotNullZeroOutputPositive4() {

    // Arrange
    final String stmt = "vvEPOinT\t";
    final int offset = 0;

    // Act
    final int actual = ServerParse.savepointCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(13, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void savepointCheckInputNotNullZeroOutputPositive5() {

    // Arrange
    final String stmt = "vvEpOinT\t";
    final int offset = 0;

    // Act
    final int actual = ServerParse.savepointCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(13, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void savepointCheckInputNotNullZeroOutputPositive6() {

    // Arrange
    final String stmt = "vvEpOinT\r";
    final int offset = 0;

    // Act
    final int actual = ServerParse.savepointCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(13, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void savepointCheckInputNotNullZeroOutputPositive7() {

    // Arrange
    final String stmt = "vvEpOinT\n";
    final int offset = 0;

    // Act
    final int actual = ServerParse.savepointCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(13, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void savepointCheckInputNotNullZeroOutputPositive8() {

    // Arrange
    final String stmt = "vvEpoinT\n";
    final int offset = 0;

    // Act
    final int actual = ServerParse.savepointCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(13, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void savepointCheckInputNotNullZeroOutputPositive9() {

    // Arrange
    final String stmt = "vvepoinT\n";
    final int offset = 0;

    // Act
    final int actual = ServerParse.savepointCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(13, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void savepointCheckInputNotNullZeroOutputPositive10() {

    // Arrange
    final String stmt = "VVepoinT\n";
    final int offset = 0;

    // Act
    final int actual = ServerParse.savepointCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(13, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void savepointCheckInputNotNullZeroOutputPositive11() {

    // Arrange
    final String stmt = "VVepoint\n";
    final int offset = 0;

    // Act
    final int actual = ServerParse.savepointCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(13, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void sCheckInputNotNullNegativeOutputStringIndexOutOfBoundsException() {

    // Arrange
    final String stmt = ",";
    final int offset = -1_065_320_450;

    // Act
    thrown.expect(StringIndexOutOfBoundsException.class);
    ServerParse.sCheck(stmt, offset);

    // Method is not expected to return due to exception thrown
  }

  // Test written by Diffblue Cover.

  @Test
  public void sCheckInputNotNullPositiveOutputNegative() {

    // Arrange
    final String stmt = "A1B2C3";
    final int offset = 30;

    // Act
    final int actual = ServerParse.sCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(-1, actual);
  }

  // Test written by Diffblue Cover.

  @Test
  public void sCheckInputNotNullPositiveOutputNegative2() {

    // Arrange
    final String stmt = "1a 2b 3c";
    final int offset = 6;

    // Act
    final int actual = ServerParse.sCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(-1, actual);
  }

  // Test written by Diffblue Cover.

  @Test
  public void seCheckInputNotNullNegativeOutputNegative() {

    // Arrange
    final String stmt = "/";
    final int offset = -1;

    // Act
    final int actual = ServerParse.seCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(-1, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void seCheckInputNotNullNegativeOutputNegative2() {

    // Arrange
    final String stmt = "t\uf035\uf035\uf036\uf036";
    final int offset = -1;

    // Act
    final int actual = ServerParse.seCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(-1, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void seCheckInputNotNullNegativeOutputNegative3() {

    // Arrange
    final String stmt = "t";
    final int offset = -1;

    // Act
    final int actual = ServerParse.seCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(-1, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void seCheckInputNotNullNegativeOutputPositive() {

    // Arrange
    final String stmt = "t \u6021v`";
    final int offset = -1;

    // Act
    final int actual = ServerParse.seCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(264, actual);
  }

  // Test written by Diffblue Cover.

  @Test
  public void seCheckInputNotNullPositiveOutputNegative() {

    // Arrange
    final String stmt = "BAZ";
    final int offset = 17;

    // Act
    final int actual = ServerParse.seCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(-1, actual);
  }

  // Test written by Diffblue Cover.

  @Test
  public void selectCheckInputNotNullNegativeOutputNegative() {

    // Arrange
    final String stmt = "a,b,c";
    final int offset = -1;

    // Act
    final int actual = ServerParse.selectCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(-1, actual);
  }

  // Test written by Diffblue Cover.

  @Test
  public void selectCheckInputNotNullNegativeOutputStringIndexOutOfBoundsException() {

    // Arrange
    final String stmt = "\'";
    final int offset = -4;

    // Act
    thrown.expect(StringIndexOutOfBoundsException.class);
    ServerParse.selectCheck(stmt, offset);

    // Method is not expected to return due to exception thrown
  }

  // Test written by Diffblue Cover.
  @Test
  public void selectCheckInputNotNullPositiveOutputNegative() {

    // Arrange
    final String stmt = "foo";
    final int offset = 135_918_217;

    // Act
    final int actual = ServerParse.selectCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(-1, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void selectCheckInputNotNullPositiveOutputPositive() {

    // Arrange
    final String stmt = "EEEEEEECT ??????";
    final int offset = 5;

    // Act
    final int actual = ServerParse.selectCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(2311, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void selectCheckInputNotNullPositiveOutputPositive2() {

    // Arrange
    final String stmt = "EEEEEEECt ??????";
    final int offset = 5;

    // Act
    final int actual = ServerParse.selectCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(2311, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void selectCheckInputNotNullPositiveOutputPositive3() {

    // Arrange
    final String stmt = "EEEEEEECt\r??????";
    final int offset = 5;

    // Act
    final int actual = ServerParse.selectCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(2311, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void selectCheckInputNotNullPositiveOutputPositive4() {

    // Arrange
    final String stmt = "EEEEEEECt/??????";
    final int offset = 5;

    // Act
    final int actual = ServerParse.selectCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(2311, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void selectCheckInputNotNullPositiveOutputPositive5() {

    // Arrange
    final String stmt = "EEEEEEECt#??????";
    final int offset = 5;

    // Act
    final int actual = ServerParse.selectCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(2311, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void selectCheckInputNotNullPositiveOutputPositive6() {

    // Arrange
    final String stmt = "EEEEEEEct#??????";
    final int offset = 5;

    // Act
    final int actual = ServerParse.selectCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(2311, actual);
  }

  // Test written by Diffblue Cover.

  @Test
  public void showCheckInputNotNullNegativeOutputStringIndexOutOfBoundsException() {

    // Arrange
    final String stmt = "1234";
    final int offset = -1_073_741_820;

    // Act
    thrown.expect(StringIndexOutOfBoundsException.class);
    ServerParse.showCheck(stmt, offset);

    // Method is not expected to return due to exception thrown
  }

  // Test written by Diffblue Cover.
  @Test
  public void showCheckInputNotNullPositiveOutputNegative() {

    // Arrange
    final String stmt = "Bar";
    final int offset = 1_073_741_824;

    // Act
    final int actual = ServerParse.showCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(-1, actual);
  }

  // Test written by Diffblue Cover.

  @Test
  public void showCheckInputNotNullPositiveOutputNegative2() {

    // Arrange
    final String stmt = "1a 2b 3c";
    final int offset = 4;

    // Act
    final int actual = ServerParse.showCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(-1, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void showCheckInputNotNullZeroOutputNegative() {

    // Arrange
    final String stmt = "OOV\u0001??";
    final int offset = 0;

    // Act
    final int actual = ServerParse.showCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(-1, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void showCheckInputNotNullZeroOutputPositive() {

    // Arrange
    final String stmt = "ooW ??";
    final int offset = 0;

    // Act
    final int actual = ServerParse.showCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(777, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void showCheckInputNotNullZeroOutputPositive2() {

    // Arrange
    final String stmt = "oow ??";
    final int offset = 0;

    // Act
    final int actual = ServerParse.showCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(777, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void showCheckInputNotNullZeroOutputPositive3() {

    // Arrange
    final String stmt = "OOw\t??";
    final int offset = 0;

    // Act
    final int actual = ServerParse.showCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(777, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void showCheckInputNotNullZeroOutputPositive4() {

    // Arrange
    final String stmt = "OOw\r??";
    final int offset = 0;

    // Act
    final int actual = ServerParse.showCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(777, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void showCheckInputNotNullZeroOutputPositive5() {

    // Arrange
    final String stmt = "OOw\n??";
    final int offset = 0;

    // Act
    final int actual = ServerParse.showCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(777, actual);
  }

  // Test written by Diffblue Cover.

  @Test
  public void startCheckInputNotNullNegativeOutputNegative() {

    // Arrange
    final String stmt = "A1B2C3";
    final int offset = -1;

    // Act
    final int actual = ServerParse.startCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(-1, actual);
  }

  // Test written by Diffblue Cover.

  @Test
  public void startCheckInputNotNullNegativeOutputStringIndexOutOfBoundsException() {

    // Arrange
    final String stmt = "\'";
    final int offset = -2_147_483_634;

    // Act
    thrown.expect(StringIndexOutOfBoundsException.class);
    ServerParse.startCheck(stmt, offset);

    // Method is not expected to return due to exception thrown
  }

  // Test written by Diffblue Cover.
  @Test
  public void startCheckInputNotNullPositiveOutputNegative() {

    // Arrange
    final String stmt = "foo";
    final int offset = 5;

    // Act
    final int actual = ServerParse.startCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(-1, actual);
  }

  // Test written by Diffblue Cover.

  @Test
  public void startCheckInputNotNullPositiveOutputNegative2() {

    // Arrange
    final String stmt = "1a 2b 3c";
    final int offset = 2;

    // Act
    final int actual = ServerParse.startCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(-1, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void startCheckInputNotNullPositiveOutputPositive() {

    // Arrange
    final String stmt = "AAAAAAART\r??????";
    final int offset = 5;

    // Act
    final int actual = ServerParse.startCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(2314, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void startCheckInputNotNullPositiveOutputPositive2() {

    // Arrange
    final String stmt = "AAAAAAARt\r??????";
    final int offset = 5;

    // Act
    final int actual = ServerParse.startCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(2314, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void startCheckInputNotNullPositiveOutputPositive3() {

    // Arrange
    final String stmt = "AAAAAAARt\n??????";
    final int offset = 5;

    // Act
    final int actual = ServerParse.startCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(2314, actual);
  }

  // Test written by Diffblue Cover.

  @Test
  public void startCheckInputNotNullZeroOutputNegative() {

    // Arrange
    final String stmt = "1a 2b 3c";
    final int offset = 0;

    // Act
    final int actual = ServerParse.startCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(-1, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void uCheckInputNotNullNegativeOutputStringIndexOutOfBoundsException() {

    // Arrange
    final String stmt = "3";
    final int offset = -2_147_385_347;

    // Act
    thrown.expect(StringIndexOutOfBoundsException.class);
    ServerParse.uCheck(stmt, offset);

    // Method is not expected to return due to exception thrown
  }

  // Test written by Diffblue Cover.
  @Test
  public void uCheckInputNotNullPositiveOutputNegative() {

    // Arrange
    final String stmt = "3";
    final int offset = 2_005_630_973;

    // Act
    final int actual = ServerParse.uCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(-1, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void uCheckInputNotNullPositiveOutputNegative2() {

    // Arrange
    final String stmt = "A1B2C3";
    final int offset = 2;

    // Act
    final int actual = ServerParse.uCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(-1, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void uCheckInputNotNullPositiveOutputNegative3() {

    // Arrange
    final String stmt = "nnnnnnnnnnnnnnnnnn\ubff7\ubff8";
    final int offset = 16;

    // Act
    final int actual = ServerParse.uCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(-1, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void uCheckInputNotNullPositiveOutputNegative4() {

    // Arrange
    final String stmt = "pppppppppppppppppp\ubff7\ubff8";
    final int offset = 16;

    // Act
    final int actual = ServerParse.uCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(-1, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void uCheckInputNotNullPositiveOutputNegative5() {

    // Arrange
    final String stmt = "ssssssssssssssssss\ubff7\u30b8";
    final int offset = 16;

    // Act
    final int actual = ServerParse.uCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(-1, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void uCheckInputNotNullPositiveOutputNegative6() {

    // Arrange
    final String stmt = "ssssssssssssssssssE\u3098";
    final int offset = 16;

    // Act
    final int actual = ServerParse.uCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(-1, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void uCheckInputNotNullPositiveOutputNegative7() {

    // Arrange
    final String stmt = "pppppppppppppppLocK\n???";
    final int offset = 13;

    // Act
    final int actual = ServerParse.uCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(-1, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void uCheckInputNotNullPositiveOutputNegative8() {

    // Arrange
    final String stmt = "pppppppppppppppdocK\n???";
    final int offset = 13;

    // Act
    final int actual = ServerParse.uCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(-1, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void uCheckInputNotNullPositiveOutputNegative9() {

    // Arrange
    final String stmt = "pppppppppppppppdacK\n???";
    final int offset = 13;

    // Act
    final int actual = ServerParse.uCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(-1, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void uCheckInputNotNullPositiveOutputNegative10() {

    // Arrange
    final String stmt = "pppppppppppppppDacK\n???";
    final int offset = 13;

    // Act
    final int actual = ServerParse.uCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(-1, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void uCheckInputNotNullPositiveOutputNegative11() {

    // Arrange
    final String stmt = "pppppppppppppppDaTK\r???";
    final int offset = 13;

    // Act
    final int actual = ServerParse.uCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(-1, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void uCheckInputNotNullPositiveOutputNegative12() {

    // Arrange
    final String stmt = "pppppppppppppppDaTe\u0089???";
    final int offset = 13;

    // Act
    final int actual = ServerParse.uCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(-1, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void uCheckInputNotNullPositiveOutputPositive() {

    // Arrange
    final String stmt = "ssssssssssssssssssE\n";
    final int offset = 16;

    // Act
    final int actual = ServerParse.uCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(4878, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void uCheckInputNotNullPositiveOutputPositive2() {

    // Arrange
    final String stmt = "ppppppppppppppppppppDaTe\t?????";
    final int offset = 18;

    // Act
    final int actual = ServerParse.uCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(11, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void uCheckInputNotNullZeroOutputNegative() {

    // Arrange
    final String stmt = "nnE\n\u100b\u3f95\u3d07???????????????";
    final int offset = 0;

    // Act
    final int actual = ServerParse.uCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(-1, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void uCheckInputNotNullZeroOutputNegative2() {

    // Arrange
    final String stmt = "NNlO\u100b\u3f95\u3d07???????????????";
    final int offset = 0;

    // Act
    final int actual = ServerParse.uCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(-1, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void uCheckInputNotNullZeroOutputNegative3() {

    // Arrange
    final String stmt = "NNlOc\u3f9d\u3d07???????????????";
    final int offset = 0;

    // Act
    final int actual = ServerParse.uCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(-1, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void uCheckInputNotNullZeroOutputNegative4() {

    // Arrange
    final String stmt = "NNLOc\u3fbd\u3d07???????????????";
    final int offset = 0;

    // Act
    final int actual = ServerParse.uCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(-1, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void uCheckInputNotNullZeroOutputNegative5() {

    // Arrange
    final String stmt = "NNLo\u2063K\u3607???????????????";
    final int offset = 0;

    // Act
    final int actual = ServerParse.uCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(-1, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void uCheckInputNotNullZeroOutputPositive() {

    // Arrange
    final String stmt = "NNLocK ???????????????";
    final int offset = 0;

    // Act
    final int actual = ServerParse.uCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(23, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void uCheckInputNotNullZeroOutputPositive2() {

    // Arrange
    final String stmt = "NNLocK\n???????????????";
    final int offset = 0;

    // Act
    final int actual = ServerParse.uCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(23, actual);
  }
}
