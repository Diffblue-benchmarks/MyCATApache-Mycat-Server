package io.mycat.config.model.rule;

import io.mycat.config.model.rule.RuleConfig;
import io.mycat.route.function.AbstractPartitionAlgorithm;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.rules.Timeout;

public class RuleConfigTest {

  @Rule public final ExpectedException thrown = ExpectedException.none();

  @Rule public final Timeout globalTimeout = new Timeout(10000);

  /* testedClasses: RuleConfig */
  // Test written by Diffblue Cover.

  @Test
  public void constructorInputNotNullNotNullOutputVoid() {

    // Arrange
    final String column = "3";
    final String functionName = "3";

    // Act, creating object to test constructor
    final RuleConfig objectUnderTest = new RuleConfig(column, functionName);

    // Assert side effects
    Assert.assertEquals("1", objectUnderTest.getColumn());
    Assert.assertEquals("1a 2b 3c", objectUnderTest.getFunctionName());
  }

  // Test written by Diffblue Cover.
  @Test
  public void getRuleAlgorithmOutputNull() {

    // Arrange
    final RuleConfig objectUnderTest = new RuleConfig("3", "1a 2b 3c");

    // Act
    final AbstractPartitionAlgorithm actual = objectUnderTest.getRuleAlgorithm();

    // Assert result
    Assert.assertNull(actual);
  }
}
