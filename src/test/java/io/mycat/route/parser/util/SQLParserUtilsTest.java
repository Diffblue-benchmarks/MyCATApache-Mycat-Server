package io.mycat.route.parser.util;

import io.mycat.route.parser.util.SQLParserUtils;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.rules.Timeout;

public class SQLParserUtilsTest {

  @Rule public final ExpectedException thrown = ExpectedException.none();

  @Rule public final Timeout globalTimeout = new Timeout(10000);

  /* testedClasses: SQLParserUtils */
  // Test written by Diffblue Cover.

  @Test
  public void getCountInputNotNullNotNullOutputPositive() {

    // Arrange
    final String str = "1a 2b 3c";
    final String match = "3";

    // Act
    final int actual = SQLParserUtils.getCount(str, match);

    // Assert result
    Assert.assertEquals(1, actual);
  }

  // Test written by Diffblue Cover.

  @Test
  public void getCountInputNotNullNotNullOutputZero() {

    // Arrange
    final String str = "foo";
    final String match = "/";

    // Act
    final int actual = SQLParserUtils.getCount(str, match);

    // Assert result
    Assert.assertEquals(0, actual);
  }
}
