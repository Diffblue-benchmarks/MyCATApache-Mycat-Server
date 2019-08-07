package io.mycat.config.util;

import static org.powermock.api.mockito.PowerMockito.mockStatic;

import io.mycat.config.util.BeanConfig;
import io.mycat.config.util.ConfigUtil;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.rules.Timeout;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.w3c.dom.Element;

import java.util.Properties;

@RunWith(PowerMockRunner.class)
@PowerMockIgnore({"javax.management.*"})
public class ConfigUtilTest {

  @Rule public final ExpectedException thrown = ExpectedException.none();

  @Rule public final Timeout globalTimeout = new Timeout(10000);

  /* testedClasses: ConfigUtil */
  // Test written by Diffblue Cover.
  @Test
  public void filterInputNotNullNullOutputNotNull() {

    // Arrange
    final String text = "\'";
    final Properties properties = null;

    // Act
    final String actual = ConfigUtil.filter(text, properties);

    // Assert result
    Assert.assertEquals("\'", actual);
  }

  // Test written by Diffblue Cover.
  @PrepareForTest({ConfigUtil.class, System.class})
  @Test
  public void filterInputNotNullOutputNotNull() throws Exception {

    // Setup mocks
    PowerMockito.mockStatic(System.class);

    // Arrange
    final String text = "/";
    PowerMockito.when(System.getProperties()).thenReturn(null);

    // Act
    final String actual = ConfigUtil.filter(text);

    // Assert result
    Assert.assertEquals("/", actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void loadBeanInputNullOutputNull() {

    // Arrange
    final Element e = null;

    // Act
    final BeanConfig actual = ConfigUtil.loadBean(e);

    // Assert result
    Assert.assertNull(actual);
  }
}
