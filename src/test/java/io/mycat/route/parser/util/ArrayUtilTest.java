package io.mycat.route.parser.util;

import io.mycat.route.parser.util.ArrayUtil;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.rules.Timeout;

import java.lang.reflect.Array;

public class ArrayUtilTest {

  @Rule public final ExpectedException thrown = ExpectedException.none();

  @Rule public final Timeout globalTimeout = new Timeout(10000);

  /* testedClasses: ArrayUtil */
  // Test written by Diffblue Cover.
  @Test
  public void containsInput0NotNullOutputFalse() {

    // Arrange
    final String[] list = {};
    final String str = "\'";

    // Act
    final boolean actual = ArrayUtil.contains(list, str);

    // Assert result
    Assert.assertFalse(actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void containsInput1NotNullOutputFalse() {

    // Arrange
    final String[] list = {null};
    final String str = "a\'b\'c";

    // Act
    final boolean actual = ArrayUtil.contains(list, str);

    // Assert result
    Assert.assertFalse(actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void containsInput1NotNullOutputTrue() {

    // Arrange
    final String[] list = {"a\'b\'c"};
    final String str = "a\'b\'c";

    // Act
    final boolean actual = ArrayUtil.contains(list, str);

    // Assert result
    Assert.assertTrue(actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void containsInputNullNotNullOutputFalse() {

    // Arrange
    final String[] list = null;
    final String str = "3";

    // Act
    final boolean actual = ArrayUtil.contains(list, str);

    // Assert result
    Assert.assertFalse(actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void equalsInputNotNullNotNullOutputFalse() {

    // Arrange
    final String str1 = "foo";
    final String str2 = "A1B2C3";

    // Act
    final boolean actual = ArrayUtil.equals(str1, str2);

    // Assert result
    Assert.assertFalse(actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void equalsInputNullNullOutputTrue() {

    // Arrange
    final String str1 = null;
    final String str2 = null;

    // Act
    final boolean actual = ArrayUtil.equals(str1, str2);

    // Assert result
    Assert.assertTrue(actual);
  }
}
