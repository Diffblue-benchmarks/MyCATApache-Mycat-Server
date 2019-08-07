package io.mycat.memory.unsafe.utils;

import static org.mockito.Matchers.anyDouble;
import static org.powermock.api.mockito.PowerMockito.mockStatic;

import io.mycat.memory.unsafe.utils.ByteUnit;
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
public class ByteUnitTest {

  @Rule public final ExpectedException thrown = ExpectedException.none();

  @Rule public final Timeout globalTimeout = new Timeout(10000);

  /* testedClasses: ByteUnit */
  // Test written by Diffblue Cover.
  @PrepareForTest({ByteUnit.class, Math.class})
  @Test
  public void convertFromInputPositiveNotNullOutputIllegalArgumentException() throws Exception {

    // Setup mocks
    PowerMockito.mockStatic(Math.class);

    // Arrange
    final ByteUnit objectUnderTest = ByteUnit.GiB;
    final long d = 7L;
    final ByteUnit u = ByteUnit.PiB;
    PowerMockito.when(Math.pow(anyDouble(), anyDouble()))
        .thenReturn(-0x1.0000000420014p+42 /* -4.39805e+12 */)
        .thenReturn(-0x1.200008002p+0 /* -1.125 */)
        .thenReturn(0x1.0001080103408p+6 /* 64.001 */)
        .thenReturn(0x1.00380080faba8p+49 /* 5.63431e+14 */);

    // Act
    thrown.expect(IllegalArgumentException.class);
    objectUnderTest.convertFrom(d, u);

    // Method is not expected to return due to exception thrown
  }

  // Test written by Diffblue Cover.
  @PrepareForTest({ByteUnit.class, Math.class})
  @Test
  public void convertFromInputPositiveNotNullOutputPositive() throws Exception {

    // Setup mocks
    PowerMockito.mockStatic(Math.class);

    // Arrange
    final ByteUnit objectUnderTest = ByteUnit.MiB;
    final long d = 3L;
    final ByteUnit u = ByteUnit.MiB;
    PowerMockito.when(Math.pow(anyDouble(), anyDouble()))
        .thenReturn(-0x1.000000a0f201cp+43 /* -8.79609e+12 */)
        .thenReturn(-0x1.41e4000501e4p+18 /* -329616.0 */)
        .thenReturn(-0x1.41e4000141ep-1006 /* -1.83355e-303 */)
        .thenReturn(0x1.fffbc0000002p+63 /* 1.84461e+19 */);

    // Act
    final long actual = objectUnderTest.convertFrom(d, u);

    // Assert result
    Assert.assertEquals(3L, actual);
  }

  // Test written by Diffblue Cover.
  @PrepareForTest({ByteUnit.class, Math.class})
  @Test
  public void convertToInputPositiveNotNullOutputIllegalArgumentException() throws Exception {

    // Setup mocks
    PowerMockito.mockStatic(Math.class);

    // Arrange
    final ByteUnit objectUnderTest = ByteUnit.GiB;
    final long d = 79L;
    final ByteUnit u = ByteUnit.TiB;
    PowerMockito.when(Math.pow(anyDouble(), anyDouble()))
        .thenReturn(0x1.e3dbff7f189f8p+51 /* 4.25607e+15 */)
        .thenReturn(0x1.04a0190104p+24 /* 1.70803e+07 */)
        .thenReturn(-0x1.1fd1200fffd53p+19 /* -589449.0 */)
        .thenReturn(0x1.5c7c80ffd3608p+17 /* 178425.0 */);

    // Act
    thrown.expect(IllegalArgumentException.class);
    objectUnderTest.convertTo(d, u);

    // Method is not expected to return due to exception thrown
  }

  // Test written by Diffblue Cover.
  @PrepareForTest({ByteUnit.class, Math.class})
  @Test
  public void convertToInputPositiveNotNullOutputPositive() throws Exception {

    // Setup mocks
    PowerMockito.mockStatic(Math.class);

    // Arrange
    final ByteUnit objectUnderTest = ByteUnit.MiB;
    final long d = 1L;
    final ByteUnit u = ByteUnit.TiB;
    PowerMockito.when(Math.pow(anyDouble(), anyDouble()))
        .thenReturn(0x1.0000000000001p+60 /* 1.15292e+18 */)
        .thenReturn(0x1.800000019p+1 /* 3.0 */)
        .thenReturn(0x1p+60 /* 1.15292e+18 */)
        .thenReturn(-0x1.fff7f7ffffffep+62 /* -9.22281e+18 */);

    // Act
    final long actual = objectUnderTest.convertTo(d, u);

    // Assert result
    Assert.assertEquals(1L, actual);
  }

  // Test written by Diffblue Cover.
  @PrepareForTest({ByteUnit.class, Math.class})
  @Test
  public void convertToInputPositiveNotNullOutputPositive2() throws Exception {

    // Setup mocks
    PowerMockito.mockStatic(Math.class);

    // Arrange
    final ByteUnit objectUnderTest = ByteUnit.PiB;
    final long d = 2L;
    final ByteUnit u = ByteUnit.TiB;
    PowerMockito.when(Math.pow(anyDouble(), anyDouble()))
        .thenReturn(-0x1.4p+62 /* -5.76461e+18 */)
        .thenReturn(0x1.800000019p-127 /* 8.81621e-39 */)
        .thenReturn(-0x1.cp+62 /* -8.07045e+18 */)
        .thenReturn(-0x1.cp+62 /* -8.07045e+18 */);

    // Act
    final long actual = objectUnderTest.convertTo(d, u);

    // Assert result
    Assert.assertEquals(2L, actual);
  }

  // Test written by Diffblue Cover.
  @PrepareForTest({ByteUnit.class, Math.class})
  @Test
  public void toBytesInputNegativeOutputIllegalArgumentException() throws Exception {

    // Setup mocks
    PowerMockito.mockStatic(Math.class);

    // Arrange
    final ByteUnit objectUnderTest = ByteUnit.BYTE;
    final long d = -8L;
    PowerMockito.when(Math.pow(anyDouble(), anyDouble()))
        .thenReturn(-0x1.4004000000001p+57 /* -1.80153e+17 */)
        .thenReturn(Double.NaN)
        .thenReturn(0x1.f802p+28 /* 5.2849e+08 */)
        .thenReturn(0x1p-767 /* 1.28823e-231 */);

    // Act
    thrown.expect(IllegalArgumentException.class);
    objectUnderTest.toBytes(d);

    // Method is not expected to return due to exception thrown
  }

  // Test written by Diffblue Cover.
  @PrepareForTest({ByteUnit.class, Math.class})
  @Test
  public void toBytesInputPositiveOutputPositive() throws Exception {

    // Setup mocks
    PowerMockito.mockStatic(Math.class);

    // Arrange
    final ByteUnit objectUnderTest = ByteUnit.BYTE;
    final long d = 6L;
    PowerMockito.when(Math.pow(anyDouble(), anyDouble()))
        .thenReturn(-0x1.4004000000001p+57 /* -1.80153e+17 */)
        .thenReturn(Double.NaN)
        .thenReturn(0x1.f802p+28 /* 5.2849e+08 */)
        .thenReturn(0x1p-767 /* 1.28823e-231 */);

    // Act
    final double actual = objectUnderTest.toBytes(d);

    // Assert result
    Assert.assertEquals(6.0, actual, 0.0);
  }

  // Test written by Diffblue Cover.
  @PrepareForTest({ByteUnit.class, Math.class})
  @Test
  public void toGiBInputPositiveOutputIllegalArgumentException() throws Exception {

    // Setup mocks
    PowerMockito.mockStatic(Math.class);

    // Arrange
    final ByteUnit objectUnderTest = ByteUnit.BYTE;
    final long d = 9L;
    PowerMockito.when(Math.pow(anyDouble(), anyDouble()))
        .thenReturn(-0x1.0100000121ap+0 /* -1.00391 */)
        .thenReturn(-0x1.00000001p+0 /* -1.0 */)
        .thenReturn(-0x1.2000000000001p+63 /* -1.03763e+19 */)
        .thenReturn(0x1.63fffb72008p+48 /* 3.91426e+14 */);

    // Act
    thrown.expect(IllegalArgumentException.class);
    objectUnderTest.toGiB(d);

    // Method is not expected to return due to exception thrown
  }

  // Test written by Diffblue Cover.
  @PrepareForTest({ByteUnit.class, Math.class})
  @Test
  public void toGiBInputPositiveOutputZero() throws Exception {

    // Setup mocks
    PowerMockito.mockStatic(Math.class);

    // Arrange
    final ByteUnit objectUnderTest = ByteUnit.MiB;
    final long d = 7L;
    PowerMockito.when(Math.pow(anyDouble(), anyDouble()))
        .thenReturn(0x1.7f77a6001eb8p+35 /* 5.14681e+10 */)
        .thenReturn(-0x1.5f6a5d903ffffp+63 /* -1.26611e+19 */)
        .thenReturn(-0x1.800009c80bce8p+60 /* -1.72938e+18 */)
        .thenReturn(-0x1.ddfdf7fdffff1p+63 /* -1.72215e+19 */);

    // Act
    final long actual = objectUnderTest.toGiB(d);

    // Assert result
    Assert.assertEquals(0L, actual);
  }

  // Test written by Diffblue Cover.
  @PrepareForTest({ByteUnit.class, Math.class})
  @Test
  public void toKiBInputPositiveOutputIllegalArgumentException() throws Exception {

    // Setup mocks
    PowerMockito.mockStatic(Math.class);

    // Arrange
    final ByteUnit objectUnderTest = ByteUnit.GiB;
    final long d = 5180L;
    PowerMockito.when(Math.pow(anyDouble(), anyDouble()))
        .thenReturn(-0x1.e002p+63 /* -1.72941e+19 */)
        .thenReturn(-0x1.0e2bb8p+63 /* -9.73393e+18 */)
        .thenReturn(-0x1.001ffffffcp+59 /* -5.76742e+17 */)
        .thenReturn(-0x1.a001fffffffffp+63 /* -1.49883e+19 */);

    // Act
    thrown.expect(IllegalArgumentException.class);
    objectUnderTest.toKiB(d);

    // Method is not expected to return due to exception thrown
  }

  // Test written by Diffblue Cover.
  @PrepareForTest({ByteUnit.class, Math.class})
  @Test
  public void toKiBInputPositiveOutputZero() throws Exception {

    // Setup mocks
    PowerMockito.mockStatic(Math.class);

    // Arrange
    final ByteUnit objectUnderTest = ByteUnit.GiB;
    final long d = 8L;
    PowerMockito.when(Math.pow(anyDouble(), anyDouble()))
        .thenReturn(0.0)
        .thenReturn(-0x1.000000010001p+6 /* -64.0 */)
        .thenReturn(-0x1.0004000400fcp+23 /* -8.38912e+06 */)
        .thenReturn(-0x1.7bfff401fffffp+31 /* -3.18767e+09 */);

    // Act
    final long actual = objectUnderTest.toKiB(d);

    // Assert result
    Assert.assertEquals(0L, actual);
  }

  // Test written by Diffblue Cover.
  @PrepareForTest({ByteUnit.class, Math.class})
  @Test
  public void toMiBInputZeroOutputIllegalArgumentException() throws Exception {

    // Setup mocks
    PowerMockito.mockStatic(Math.class);

    // Arrange
    final ByteUnit objectUnderTest = ByteUnit.PiB;
    final long d = 0L;
    PowerMockito.when(Math.pow(anyDouble(), anyDouble()))
        .thenReturn(-0x1.000000000008p+4 /* -16.0 */)
        .thenReturn(-0x1p+61 /* -2.30584e+18 */)
        .thenReturn(0x1.ep+63 /* 1.72938e+19 */)
        .thenReturn(-0x1.8p+63 /* -1.38351e+19 */);

    // Act
    thrown.expect(IllegalArgumentException.class);
    objectUnderTest.toMiB(d);

    // Method is not expected to return due to exception thrown
  }

  // Test written by Diffblue Cover.
  @PrepareForTest({ByteUnit.class, Math.class})
  @Test
  public void toMiBInputZeroOutputZero() throws Exception {

    // Setup mocks
    PowerMockito.mockStatic(Math.class);

    // Arrange
    final ByteUnit objectUnderTest = ByteUnit.TiB;
    final long d = 0L;
    PowerMockito.when(Math.pow(anyDouble(), anyDouble()))
        .thenReturn(-0x1.000000000008p+4 /* -16.0 */)
        .thenReturn(-0x1.4p+63 /* -1.15292e+19 */)
        .thenReturn(-0x1.0ffffff00e101p+4 /* -17.0 */)
        .thenReturn(-0x1.0000000000001p+60 /* -1.15292e+18 */);

    // Act
    final long actual = objectUnderTest.toMiB(d);

    // Assert result
    Assert.assertEquals(0L, actual);
  }

  // Test written by Diffblue Cover.
  @PrepareForTest({ByteUnit.class, Math.class})
  @Test
  public void toPiBInputPositiveOutputPositive() throws Exception {

    // Setup mocks
    PowerMockito.mockStatic(Math.class);

    // Arrange
    final ByteUnit objectUnderTest = ByteUnit.MiB;
    final long d = 8L;
    PowerMockito.when(Math.pow(anyDouble(), anyDouble()))
        .thenReturn(-0x1.f8203dff2p+63 /* -1.81631e+19 */)
        .thenReturn(-0x1.fffffep+63 /* -1.84467e+19 */)
        .thenReturn(-0x1p+63 /* -9.22337e+18 */)
        .thenReturn(0x1.00000001011p+0 /* 1.0 */);

    // Act
    final long actual = objectUnderTest.toPiB(d);

    // Assert result
    Assert.assertEquals(2_269_541_548_343_427_072L, actual);
  }

  // Test written by Diffblue Cover.
  @PrepareForTest({ByteUnit.class, Math.class})
  @Test
  public void toTiBInputZeroOutputZero() throws Exception {

    // Setup mocks
    PowerMockito.mockStatic(Math.class);

    // Arrange
    final ByteUnit objectUnderTest = ByteUnit.GiB;
    final long d = 0L;
    PowerMockito.when(Math.pow(anyDouble(), anyDouble()))
        .thenReturn(0x1.ffffffffffep+63 /* 1.84467e+19 */)
        .thenReturn(0x1.ffffffffffep+63 /* 1.84467e+19 */)
        .thenReturn(0x1p+54 /* 1.80144e+16 */)
        .thenReturn(0x1.000da7c00018cp+44 /* 1.75959e+13 */);

    // Act
    final long actual = objectUnderTest.toTiB(d);

    // Assert result
    Assert.assertEquals(0L, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void valueOfInputNotNullOutputIllegalArgumentException() {

    // Arrange
    final String name = ",";

    // Act
    thrown.expect(IllegalArgumentException.class);
    ByteUnit.valueOf(name);

    // Method is not expected to return due to exception thrown
  }
}
