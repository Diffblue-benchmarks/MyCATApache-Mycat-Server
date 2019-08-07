package io.mycat.util;

import io.mycat.util.HexFormatUtil;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.rules.Timeout;

import java.lang.reflect.Array;

public class HexFormatUtilTest {

  @Rule public final ExpectedException thrown = ExpectedException.none();

  @Rule public final Timeout globalTimeout = new Timeout(10000);

  /* testedClasses: HexFormatUtil */
  // Test written by Diffblue Cover.
  @Test
  public void bytesToHexStringInput0OutputNotNull() {

    // Arrange
    final byte[] bytes = {};

    // Act
    final String actual = HexFormatUtil.bytesToHexString(bytes);

    // Assert result
    Assert.assertEquals(",", actual);
  }

  // Test written by Diffblue Cover.

  @Test
  public void bytesToHexStringInput1OutputNotNull() {

    // Arrange
    final byte[] bytes = {(byte)-104};

    // Act
    final String actual = HexFormatUtil.bytesToHexString(bytes);

    // Assert result
    Assert.assertEquals("98", actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void fromHexInputNotNullOutput1() {

    // Arrange
    final String src = "1234";

    // Act
    final byte[] actual = HexFormatUtil.fromHex(src);

    // Assert result
    Assert.assertArrayEquals(new byte[] {(byte)52}, actual);
  }
}
