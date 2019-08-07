package io.mycat.server.parser;

import io.mycat.server.parser.ServerParseShow;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.rules.Timeout;

import java.lang.reflect.Method;

public class ServerParseShowTest {

  @Rule public final ExpectedException thrown = ExpectedException.none();

  @Rule public final Timeout globalTimeout = new Timeout(10000);

  /* testedClasses: ServerParseShow */
  // Test written by Diffblue Cover.
  @Test
  public void dataCheckInputNotNullNegativeOutputNegative() {

    // Arrange
    final String stmt = "A1B2C3";
    final int offset = -1;

    // Act
    final int actual = ServerParseShow.dataCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(-1, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void dataCheckInputNotNullNegativeOutputStringIndexOutOfBoundsException() {

    // Arrange
    final String stmt = ",";
    final int offset = -639_893_520;

    // Act
    thrown.expect(StringIndexOutOfBoundsException.class);
    ServerParseShow.dataCheck(stmt, offset);

    // Method is not expected to return due to exception thrown
  }

  // Test written by Diffblue Cover.
  @Test
  public void dataCheckInputNotNullZeroOutputNegative() {

    // Arrange
    final String stmt = ",";
    final int offset = 0;

    // Act
    final int actual = ServerParseShow.dataCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(-1, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void dataCheckInputNotNullZeroOutputNegative2() {

    // Arrange
    final String stmt = "a,b,c";
    final int offset = 0;

    // Act
    final int actual = ServerParseShow.dataCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(-1, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void dataCheckInputNotNullZeroOutputNegative3() {

    // Arrange
    final String stmt = "1a 2b 3c";
    final int offset = 0;

    // Act
    final int actual = ServerParseShow.dataCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(-1, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void mycatCheckInputNotNullNegativeOutputStringIndexOutOfBoundsException() {

    // Arrange
    final String stmt = "2";
    final int offset = -2_147_475_476;

    // Act
    thrown.expect(StringIndexOutOfBoundsException.class);
    ServerParseShow.mycatCheck(stmt, offset);

    // Method is not expected to return due to exception thrown
  }

  // Test written by Diffblue Cover.
  @Test
  public void mycatCheckInputNotNullPositiveOutputNegative() {

    // Arrange
    final String stmt = "2";
    final int offset = 8172;

    // Act
    final int actual = ServerParseShow.mycatCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(-1, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void mycatCheckInputNotNullZeroOutputNegative() {

    // Arrange
    final String stmt = "1a 2b 3c";
    final int offset = 0;

    // Act
    final int actual = ServerParseShow.mycatCheck(stmt, offset);

    // Assert result
    Assert.assertEquals(-1, actual);
  }

  // Test written by Diffblue Cover.

  @Test
  public void parseInputNotNullNegativeOutputStringIndexOutOfBoundsException() {

    // Arrange
    final String stmt = "1a 2b 3c";
    final int offset = -2_080_374_776;

    // Act
    thrown.expect(StringIndexOutOfBoundsException.class);
    ServerParseShow.parse(stmt, offset);

    // Method is not expected to return due to exception thrown
  }

  // Test written by Diffblue Cover.

  @Test
  public void parseInputNotNullPositiveOutputNegative() {

    // Arrange
    final String stmt = "a\'b\'c";
    final int offset = 1_589_455_165;

    // Act
    final int actual = ServerParseShow.parse(stmt, offset);

    // Assert result
    Assert.assertEquals(-1, actual);
  }

  // Test written by Diffblue Cover.

  @Test
  public void parseInputNotNullPositiveOutputNegative2() {

    // Arrange
    final String stmt = "1a 2b 3c";
    final int offset = 4;

    // Act
    final int actual = ServerParseShow.parse(stmt, offset);

    // Assert result
    Assert.assertEquals(-1, actual);
  }

  // Test written by Diffblue Cover.

  @Test
  public void showDatabasesInputNotNullNegativeOutputNegative() {

    // Arrange
    final String stmt = "A1B2C3";
    final int offset = -1;

    // Act
    final int actual = ServerParseShow.showDatabases(stmt, offset);

    // Assert result
    Assert.assertEquals(-1, actual);
  }

  // Test written by Diffblue Cover.

  @Test
  public void showDatabasesInputNotNullNegativeOutputStringIndexOutOfBoundsException() {

    // Arrange
    final String stmt = "\'";
    final int offset = -369_098_752;

    // Act
    thrown.expect(StringIndexOutOfBoundsException.class);
    ServerParseShow.showDatabases(stmt, offset);

    // Method is not expected to return due to exception thrown
  }

  // Test written by Diffblue Cover.
  @Test
  public void showDatabasesInputNotNullPositiveOutputNegative() {

    // Arrange
    final String stmt = "foo";
    final int offset = 1_241_513_999;

    // Act
    final int actual = ServerParseShow.showDatabases(stmt, offset);

    // Assert result
    Assert.assertEquals(-1, actual);
  }

  // Test written by Diffblue Cover.

  @Test
  public void showDatabasesInputNotNullPositiveOutputNegative2() {

    // Arrange
    final String stmt = "1a 2b 3c";
    final int offset = 3;

    // Act
    final int actual = ServerParseShow.showDatabases(stmt, offset);

    // Assert result
    Assert.assertEquals(-1, actual);
  }

  // Test written by Diffblue Cover.

  @Test
  public void showDatabasesInputNotNullZeroOutputNegative() {

    // Arrange
    final String stmt = "1a 2b 3c";
    final int offset = 0;

    // Act
    final int actual = ServerParseShow.showDatabases(stmt, offset);

    // Assert result
    Assert.assertEquals(-1, actual);
  }

  // Test written by Diffblue Cover.

  @Test
  public void showDataSourcesInputNotNullNegativeOutputStringIndexOutOfBoundsException() {

    // Arrange
    final String stmt = "foo";
    final int offset = -2_147_482_626;

    // Act
    thrown.expect(StringIndexOutOfBoundsException.class);
    ServerParseShow.showDataSources(stmt, offset);

    // Method is not expected to return due to exception thrown
  }

  // Test written by Diffblue Cover.
  @Test
  public void showDataSourcesInputNotNullPositiveOutputNegative() {

    // Arrange
    final String stmt = "foo";
    final int offset = 1022;

    // Act
    final int actual = ServerParseShow.showDataSources(stmt, offset);

    // Assert result
    Assert.assertEquals(-1, actual);
  }

  // Test written by Diffblue Cover.

  @Test
  public void showDataSourcesInputNotNullPositiveOutputNegative2() {

    // Arrange
    final String stmt = "1a 2b 3c";
    final int offset = 1;

    // Act
    final int actual = ServerParseShow.showDataSources(stmt, offset);

    // Assert result
    Assert.assertEquals(-1, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void showMyCatClusterInputNotNullNegativeOutputNegative() {

    // Arrange
    final String stmt = "A1B2C3";
    final int offset = -1;

    // Act
    final int actual = ServerParseShow.showMyCatCluster(stmt, offset);

    // Assert result
    Assert.assertEquals(-1, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void showMyCatClusterInputNotNullNegativeOutputStringIndexOutOfBoundsException() {

    // Arrange
    final String stmt = "a\'b\'c";
    final int offset = -1_610_612_742;

    // Act
    thrown.expect(StringIndexOutOfBoundsException.class);
    ServerParseShow.showMyCatCluster(stmt, offset);

    // Method is not expected to return due to exception thrown
  }

  // Test written by Diffblue Cover.
  @Test
  public void showMyCatClusterInputNotNullPositiveOutputNegative() {

    // Arrange
    final String stmt = "foo";
    final int offset = 1_073_741_855;

    // Act
    final int actual = ServerParseShow.showMyCatCluster(stmt, offset);

    // Assert result
    Assert.assertEquals(-1, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void showMyCatStatusInputNotNullNegativeOutputStringIndexOutOfBoundsException() {

    // Arrange
    final String stmt = "A1B2C3";
    final int offset = -1_065_353_205;

    // Act
    thrown.expect(StringIndexOutOfBoundsException.class);
    ServerParseShow.showMyCatStatus(stmt, offset);

    // Method is not expected to return due to exception thrown
  }

  // Test written by Diffblue Cover.
  @Test
  public void showMyCatStatusInputNotNullPositiveOutputNegative() {

    // Arrange
    final String stmt = "foo";
    final int offset = 1_082_130_455;

    // Act
    final int actual = ServerParseShow.showMyCatStatus(stmt, offset);

    // Assert result
    Assert.assertEquals(-1, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void showMyCatStatusInputNotNullZeroOutputNegative() {

    // Arrange
    final String stmt = "A1B2C3";
    final int offset = 0;

    // Act
    final int actual = ServerParseShow.showMyCatStatus(stmt, offset);

    // Assert result
    Assert.assertEquals(-1, actual);
  }
}
