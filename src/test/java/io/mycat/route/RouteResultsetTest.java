package io.mycat.route;

import io.mycat.route.Procedure;
import io.mycat.route.RouteResultset;
import io.mycat.route.RouteResultsetNode;
import io.mycat.route.SQLMerge;
import io.mycat.sqlengine.mpp.HavingCols;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.rules.Timeout;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class RouteResultsetTest {

  @Rule public final ExpectedException thrown = ExpectedException.none();

  @Rule public final Timeout globalTimeout = new Timeout(10000);

  /* testedClasses: RouteResultset */
  // Test written by Diffblue Cover.
  @Test
  public void getAutoIncrementOutputFalse() {

    // Arrange
    final RouteResultset objectUnderTest = new RouteResultset("1", 0);

    // Act
    final boolean actual = objectUnderTest.getAutoIncrement();

    // Assert result
    Assert.assertFalse(actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void getCanRunInReadDBOutputNull() {

    // Arrange
    final RouteResultset objectUnderTest = new RouteResultset("1", 0);

    // Act
    final Boolean actual = objectUnderTest.getCanRunInReadDB();

    // Assert result
    Assert.assertNull(actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void getDataNodeSlotMapOutput0() {

    // Arrange
    final RouteResultset objectUnderTest = new RouteResultset(",", 0);

    // Act
    final Map<String, Integer> actual = objectUnderTest.getDataNodeSlotMap();

    // Assert result
    final HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
    Assert.assertEquals(hashMap, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void getGroupByColsOutputNull() {

    // Arrange
    final RouteResultset objectUnderTest = new RouteResultset(",", 0);

    // Act
    final String[] actual = objectUnderTest.getGroupByCols();

    // Assert result
    Assert.assertNull(actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void getHavingColsOutputNull() {

    // Arrange
    final RouteResultset objectUnderTest = new RouteResultset("\'", 0);

    // Act
    final HavingCols actual = objectUnderTest.getHavingCols();

    // Assert result
    Assert.assertNull(actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void getLimitSizeOutputNegative() {

    // Arrange
    final RouteResultset objectUnderTest = new RouteResultset(",", 0);

    // Act
    final int actual = objectUnderTest.getLimitSize();

    // Assert result
    Assert.assertEquals(-1, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void getLimitStartOutputZero() {

    // Arrange
    final RouteResultset objectUnderTest = new RouteResultset("1a 2b 3c", 0);

    // Act
    final int actual = objectUnderTest.getLimitStart();

    // Assert result
    Assert.assertEquals(0, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void getMergeColsOutputNull() {

    // Arrange
    final RouteResultset objectUnderTest = new RouteResultset(",", 0);

    // Act
    final Map<String, Integer> actual = objectUnderTest.getMergeCols();

    // Assert result
    Assert.assertNull(actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void getNodesOutputNull() {

    // Arrange
    final RouteResultset objectUnderTest = new RouteResultset("1", 0);

    // Act
    final RouteResultsetNode[] actual = objectUnderTest.getNodes();

    // Assert result
    Assert.assertNull(actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void getOrderByColsOutputNull() {

    // Arrange
    final RouteResultset objectUnderTest = new RouteResultset("/", 0);

    // Act
    final LinkedHashMap<String, Integer> actual = objectUnderTest.getOrderByCols();

    // Assert result
    Assert.assertNull(actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void getPrimaryKeyOutputNull() {

    // Arrange
    final RouteResultset objectUnderTest = new RouteResultset(",", 0);

    // Act
    final String actual = objectUnderTest.getPrimaryKey();

    // Assert result
    Assert.assertNull(actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void getProcedureOutputNull() {

    // Arrange
    final RouteResultset objectUnderTest = new RouteResultset(",", 0);

    // Act
    final Procedure actual = objectUnderTest.getProcedure();

    // Assert result
    Assert.assertNull(actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void getRunOnSlaveDebugInfoOutputNotNull() {

    // Arrange
    final RouteResultset objectUnderTest = new RouteResultset(",", 0);

    // Act
    final String actual = objectUnderTest.getRunOnSlaveDebugInfo();

    // Assert result
    Assert.assertEquals("default", actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void getRunOnSlaveOutputNull() {

    // Arrange
    final RouteResultset objectUnderTest = new RouteResultset("1a 2b 3c", 0);

    // Act
    final Boolean actual = objectUnderTest.getRunOnSlave();

    // Assert result
    Assert.assertNull(actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void getSqlMergeOutputNull() {

    // Arrange
    final RouteResultset objectUnderTest = new RouteResultset("1a 2b 3c", 0);

    // Act
    final SQLMerge actual = objectUnderTest.getSqlMerge();

    // Assert result
    Assert.assertNull(actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void getSqlTypeOutputZero() {

    // Arrange
    final RouteResultset objectUnderTest = new RouteResultset("1a 2b 3c", 0);

    // Act
    final int actual = objectUnderTest.getSqlType();

    // Assert result
    Assert.assertEquals(0, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void getStatementOutputNotNull() {

    // Arrange
    final RouteResultset objectUnderTest = new RouteResultset("1", 0);

    // Act
    final String actual = objectUnderTest.getStatement();

    // Assert result
    Assert.assertEquals("1", actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void getSubTablesOutputNull() {

    // Arrange
    final RouteResultset objectUnderTest = new RouteResultset(",", 0);

    // Act
    final Set<String> actual = objectUnderTest.getSubTables();

    // Assert result
    Assert.assertNull(actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void getTablesOutputNull() {

    // Arrange
    final RouteResultset objectUnderTest = new RouteResultset(",", 0);

    // Act
    final List<String> actual = objectUnderTest.getTables();

    // Assert result
    Assert.assertNull(actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void isAutocommitOutputTrue() {

    // Arrange
    final RouteResultset objectUnderTest = new RouteResultset(",", 0);

    // Act
    final boolean actual = objectUnderTest.isAutocommit();

    // Assert result
    Assert.assertTrue(actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void isCacheAbleOutputFalse() {

    // Arrange
    final RouteResultset objectUnderTest = new RouteResultset("1", 0);

    // Act
    final boolean actual = objectUnderTest.isCacheAble();

    // Assert result
    Assert.assertFalse(actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void isCallStatementOutputFalse() {

    // Arrange
    final RouteResultset objectUnderTest = new RouteResultset(",", 0);

    // Act
    final boolean actual = objectUnderTest.isCallStatement();

    // Assert result
    Assert.assertFalse(actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void isDistTableOutputFalse() {

    // Arrange
    final RouteResultset objectUnderTest = new RouteResultset(",", 0);

    // Act
    final boolean actual = objectUnderTest.isDistTable();

    // Assert result
    Assert.assertFalse(actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void isFinishedRouteOutputFalse() {

    // Arrange
    final RouteResultset objectUnderTest = new RouteResultset(",", 0);

    // Act
    final boolean actual = objectUnderTest.isFinishedRoute();

    // Assert result
    Assert.assertFalse(actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void isGlobalTableOutputFalse() {

    // Arrange
    final RouteResultset objectUnderTest = new RouteResultset("foo", 0);

    // Act
    final boolean actual = objectUnderTest.isGlobalTable();

    // Assert result
    Assert.assertFalse(actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void isHasAggrColumnOutputFalse() {

    // Arrange
    final RouteResultset objectUnderTest = new RouteResultset(",", 0);

    // Act
    final boolean actual = objectUnderTest.isHasAggrColumn();

    // Assert result
    Assert.assertFalse(actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void isLoadDataOutputFalse() {

    // Arrange
    final RouteResultset objectUnderTest = new RouteResultset(",", 0);

    // Act
    final boolean actual = objectUnderTest.isLoadData();

    // Assert result
    Assert.assertFalse(actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void isSelectForUpdateOutputFalse() {

    // Arrange
    final RouteResultset objectUnderTest = new RouteResultset(",", 0);

    // Act
    final boolean actual = objectUnderTest.isSelectForUpdate();

    // Assert result
    Assert.assertFalse(actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void needMergeOutputFalse() {

    // Arrange
    final RouteResultset objectUnderTest = new RouteResultset(",", 0);

    // Act
    final boolean actual = objectUnderTest.needMerge();

    // Assert result
    Assert.assertFalse(actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void setDataNodeSlotMapInputNullOutputVoid() {

    // Arrange
    final RouteResultset objectUnderTest = new RouteResultset("3", 0);
    final Map<String, Integer> dataNodeSlotMap = null;

    // Act
    objectUnderTest.setDataNodeSlotMap(dataNodeSlotMap);

    // Assert side effects
    Assert.assertNull(objectUnderTest.getDataNodeSlotMap());
  }

  // Test written by Diffblue Cover.
  @Test
  public void setLimitSizeInputZeroOutputVoid() {

    // Arrange
    final RouteResultset objectUnderTest = new RouteResultset("3", 0);
    final int limitSize = 0;

    // Act
    objectUnderTest.setLimitSize(limitSize);

    // Assert side effects
    Assert.assertEquals(0, objectUnderTest.getLimitSize());
  }

  // Test written by Diffblue Cover.
  @Test
  public void setPrimaryKeyInputNotNullOutputIllegalArgumentException() {

    // Arrange
    final RouteResultset objectUnderTest = new RouteResultset("1", 0);
    final String primaryKey = "3";

    // Act
    thrown.expect(IllegalArgumentException.class);
    objectUnderTest.setPrimaryKey(primaryKey);

    // Method is not expected to return due to exception thrown
  }

  // Test written by Diffblue Cover.
  @Test
  public void toStringOutputNotNull() {

    // Arrange
    final RouteResultset objectUnderTest = new RouteResultset("\'", 0);

    // Act
    final String actual = objectUnderTest.toString();

    // Assert result
    Assert.assertEquals("\', route={\n}", actual);
  }
}
