package io.mycat.sqlengine.mpp;

import io.mycat.sqlengine.mpp.ColumnRoutePair;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.rules.Timeout;

public class ColumnRoutePairTest {

  @Rule public final ExpectedException thrown = ExpectedException.none();

  @Rule public final Timeout globalTimeout = new Timeout(10000);

  /* testedClasses: ColumnRoutePair */
  // Test written by Diffblue Cover.

  @Test
  public void constructorInputNotNullOutputVoid() {

    // Arrange
    final String colValue = "A1B2C3";

    // Act, creating object to test constructor
    final ColumnRoutePair objectUnderTest = new ColumnRoutePair(colValue);

    // Assert side effects
    Assert.assertEquals("A1B2C3", objectUnderTest.colValue);
  }

  // Test written by Diffblue Cover.
  @Test
  public void equalsInputNotNullOutputFalse() {

    // Arrange
    final ColumnRoutePair objectUnderTest = new ColumnRoutePair(null);
    final ColumnRoutePair obj = new ColumnRoutePair(null);

    // Act
    final boolean actual = objectUnderTest.equals(obj);

    // Assert result
    Assert.assertFalse(actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void equalsInputNullOutputFalse() {

    // Arrange
    final ColumnRoutePair objectUnderTest = new ColumnRoutePair(null);
    final Object obj = null;

    // Act
    final boolean actual = objectUnderTest.equals(obj);

    // Assert result
    Assert.assertFalse(actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void getNodeIdOutputNull() {

    // Arrange
    final ColumnRoutePair objectUnderTest = new ColumnRoutePair(null);

    // Act
    final Integer actual = objectUnderTest.getNodeId();

    // Assert result
    Assert.assertNull(actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void getSlotOutputNegative() {

    // Arrange
    final ColumnRoutePair objectUnderTest = new ColumnRoutePair(null);

    // Act
    final int actual = objectUnderTest.getSlot();

    // Assert result
    Assert.assertEquals(-2, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void hashCodeOutputPositive() {

    // Arrange
    final ColumnRoutePair objectUnderTest = new ColumnRoutePair(null);

    // Act
    final int actual = objectUnderTest.hashCode();

    // Assert result
    Assert.assertEquals(29_791, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void setSlotInputZeroOutputVoid() {

    // Arrange
    final ColumnRoutePair objectUnderTest = new ColumnRoutePair(null);
    final int slot = 0;

    // Act
    objectUnderTest.setSlot(slot);

    // Assert side effects
    Assert.assertEquals(0, objectUnderTest.getSlot());
  }

  // Test written by Diffblue Cover.
  @Test
  public void toStringOutputNotNull() {

    // Arrange
    final ColumnRoutePair objectUnderTest = new ColumnRoutePair("3");

    // Act
    final String actual = objectUnderTest.toString();

    // Assert result
    Assert.assertEquals("ColumnRoutePair [colValue=3, nodeId=null]", actual);
  }
}
