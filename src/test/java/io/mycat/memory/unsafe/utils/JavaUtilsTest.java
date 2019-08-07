package io.mycat.memory.unsafe.utils;

import static org.powermock.api.mockito.PowerMockito.mockStatic;

import com.google.common.collect.ImmutableMap;
import io.mycat.memory.unsafe.utils.JavaUtils;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.rules.Timeout;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.lang.reflect.Method;

@RunWith(PowerMockRunner.class)
public class JavaUtilsTest {

  @Rule public final ExpectedException thrown = ExpectedException.none();

  @Rule public final Timeout globalTimeout = new Timeout(10000);

  /* testedClasses: JavaUtils */
  // Test written by Diffblue Cover.
  @Test
  public void bytesToString2InputNegativeOutputNotNull() {

    // Arrange
    final long size = -9_223_372_032_559_808_517L;

    // Act
    final String actual = JavaUtils.bytesToString2(size);

    // Assert result
    Assert.assertEquals("-5B", actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void bytesToString2InputPositiveOutputNotNull() {

    // Arrange
    final long size = 4_287_625_201L;

    // Act
    final String actual = JavaUtils.bytesToString2(size);

    // Assert result
    Assert.assertEquals("3GB", actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void bytesToString2InputPositiveOutputNotNull2() {

    // Arrange
    final long size = 1_152_921_573_326_323_712L;

    // Act
    final String actual = JavaUtils.bytesToString2(size);

    // Assert result
    Assert.assertEquals("1048576TB", actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void bytesToString2InputPositiveOutputNotNull3() {

    // Arrange
    final long size = 540_016_640L;

    // Act
    final String actual = JavaUtils.bytesToString2(size);

    // Assert result
    Assert.assertEquals("515MB", actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void bytesToString2InputPositiveOutputNotNull4() {

    // Arrange
    final long size = 526_336L;

    // Act
    final String actual = JavaUtils.bytesToString2(size);

    // Assert result
    Assert.assertEquals("514KB", actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void bytesToStringInputNegativeOutputNotNull() {

    // Arrange
    final long size = -1L;

    // Act
    final String actual = JavaUtils.bytesToString(size);

    // Assert result
    Assert.assertEquals("--1.0 B", actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void bytesToStringInputPositiveOutputNotNull() {

    // Arrange
    final long size = 13_102_869_844_273L;

    // Act
    final String actual = JavaUtils.bytesToString(size);

    // Assert result
    Assert.assertEquals("NaN TB", actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void bytesToStringInputPositiveOutputNotNull2() {

    // Arrange
    final long size = 1_008_241_938_737L;

    // Act
    final String actual = JavaUtils.bytesToString(size);

    // Assert result
    Assert.assertEquals("NaN GB", actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void bytesToStringInputPositiveOutputNotNull3() {

    // Arrange
    final long size = 3_145_729L;

    // Act
    final String actual = JavaUtils.bytesToString(size);

    // Assert result
    Assert.assertEquals("3.0 MB", actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void bytesToStringInputPositiveOutputNotNull4() {

    // Arrange
    final long size = 9217L;

    // Act
    final String actual = JavaUtils.bytesToString(size);

    // Assert result
    Assert.assertEquals("9.0 KB", actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void nonNegativeHashInputNullOutputZero() {

    // Arrange
    final Object obj = null;

    // Act
    final int actual = JavaUtils.nonNegativeHash(obj);

    // Assert result
    Assert.assertEquals(0, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void nonNegativeHashInputPositiveOutputZero() {

    // Arrange
    final Object obj = 2_147_483_647;

    // Act
    final int actual = JavaUtils.nonNegativeHash(obj);

    // Assert result
    Assert.assertEquals(0, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void nonNegativeHashInputZeroOutputZero() {

    // Arrange
    final Object obj = 0;

    // Act
    final int actual = JavaUtils.nonNegativeHash(obj);

    // Assert result
    Assert.assertEquals(0, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void nonNegativeModInputNegativePositiveOutputPositive() {

    // Arrange
    final int x = -1_342_176_768;
    final int mod = 1_342_176_770;

    // Act
    final int actual = JavaUtils.nonNegativeMod(x, mod);

    // Assert result
    Assert.assertEquals(2, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void nonNegativeModInputZeroPositiveOutputZero() {

    // Arrange
    final int x = 0;
    final int mod = 1;

    // Act
    final int actual = JavaUtils.nonNegativeMod(x, mod);

    // Assert result
    Assert.assertEquals(0, actual);
  }

  // Test written by Diffblue Cover.
  @PrepareForTest(ImmutableMap.class)
  @Test
  public void timeStringAsMsInputNullOutputNullPointerException() throws Exception {

    // Setup mocks
    PowerMockito.mockStatic(ImmutableMap.class);

    // Arrange
    final String str = null;
    PowerMockito.doReturn(null).when(ImmutableMap.class);
    ImmutableMap.builder();

    // Act
    thrown.expect(NullPointerException.class);
    JavaUtils.timeStringAsMs(str);

    // Method is not expected to return due to exception thrown
  }
}
