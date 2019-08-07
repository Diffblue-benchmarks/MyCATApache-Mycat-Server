package io.mycat.config.util;

import io.mycat.config.util.BeanConfig;
import io.mycat.config.util.ConfigException;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.rules.Timeout;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class BeanConfigTest {

  @Rule public final ExpectedException thrown = ExpectedException.none();

  @Rule public final Timeout globalTimeout = new Timeout(10000);

  /* testedClasses: BeanConfig */
  // Test written by Diffblue Cover.
  @Test
  public void cloneOutputConfigException() {

    // Arrange
    final BeanConfig objectUnderTest = new BeanConfig();

    // Act
    thrown.expect(ConfigException.class);
    objectUnderTest.clone();

    // Method is not expected to return due to exception thrown
  }

  // Test written by Diffblue Cover.
  @Test
  public void equalsInputNullOutputFalse() {

    // Arrange
    final BeanConfig objectUnderTest = new BeanConfig();
    final Object object = null;

    // Act
    final boolean actual = objectUnderTest.equals(object);

    // Assert result
    Assert.assertFalse(actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void getClassNameOutputNull() {

    // Arrange
    final BeanConfig objectUnderTest = new BeanConfig();

    // Act
    final String actual = objectUnderTest.getClassName();

    // Assert result
    Assert.assertNull(actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void getNameOutputNull() {

    // Arrange
    final BeanConfig objectUnderTest = new BeanConfig();

    // Act
    final String actual = objectUnderTest.getName();

    // Assert result
    Assert.assertNull(actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void getParamsOutput0() {

    // Arrange
    final BeanConfig objectUnderTest = new BeanConfig();

    // Act
    final Map<String, Object> actual = objectUnderTest.getParams();

    // Assert result
    final HashMap<String, Object> hashMap = new HashMap<String, Object>();
    Assert.assertEquals(hashMap, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void hashCodeOutputPositive() {

    // Arrange
    final BeanConfig objectUnderTest = new BeanConfig();

    // Act
    final int actual = objectUnderTest.hashCode();

    // Assert result
    Assert.assertEquals(37, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void hashCodeOutputPositive2() throws InvocationTargetException {

    // Arrange
    final BeanConfig objectUnderTest = new BeanConfig();
    objectUnderTest.setClassName("1");
    objectUnderTest.setName("1");
    objectUnderTest.setParams(null);

    // Act
    final int actual = objectUnderTest.hashCode();

    // Assert result
    Assert.assertEquals(135, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void setClassNameInputNotNullOutputVoid() {

    // Arrange
    final BeanConfig objectUnderTest = new BeanConfig();
    final String beanObject = ",";

    // Act
    objectUnderTest.setClassName(beanObject);

    // Assert side effects
    Assert.assertEquals(",", objectUnderTest.getClassName());
  }

  // Test written by Diffblue Cover.
  @Test
  public void setNameInputNotNullOutputVoid() {

    // Arrange
    final BeanConfig objectUnderTest = new BeanConfig();
    final String name = ",";

    // Act
    objectUnderTest.setName(name);

    // Assert side effects
    Assert.assertEquals(",", objectUnderTest.getName());
  }

  // Test written by Diffblue Cover.
  @Test
  public void setParamsInputNullOutputVoid() {

    // Arrange
    final BeanConfig objectUnderTest = new BeanConfig();
    final Map<String, Object> params = null;

    // Act
    objectUnderTest.setParams(params);

    // Assert side effects
    Assert.assertNull(objectUnderTest.getParams());
  }
}
