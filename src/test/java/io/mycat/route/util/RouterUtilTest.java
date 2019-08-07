package io.mycat.route.util;

import static org.mockito.AdditionalMatchers.or;
import static org.mockito.Matchers.isA;
import static org.mockito.Matchers.isNull;
import static org.powermock.api.mockito.PowerMockito.mockStatic;

import com.alibaba.druid.sql.ast.SQLExpr;
import com.alibaba.druid.wall.spi.WallVisitorUtils;
import com.diffblue.deeptestutils.mock.DTUMemberMatcher;
import io.mycat.config.model.SchemaConfig;
import io.mycat.config.model.TableConfig;
import io.mycat.route.RouteResultset;
import io.mycat.route.parser.druid.DruidShardingParseInfo;
import io.mycat.route.util.RouterUtil;
import io.mycat.server.ServerConnection;
import io.mycat.sqlengine.mpp.ColumnRoutePair;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.rules.Timeout;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.sql.SQLNonTransientException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

@RunWith(PowerMockRunner.class)
public class RouterUtilTest {

  @Rule public final ExpectedException thrown = ExpectedException.none();

  @Rule public final Timeout globalTimeout = new Timeout(10000);

  /* testedClasses: RouterUtil */
  // Test written by Diffblue Cover.
  @Test
  public void getAlterTablePosInputNotNullNegativeOutput2() {

    // Arrange
    final String upStmt = "foo";
    final int start = -1_275_068_422;

    // Act
    final int[] actual = RouterUtil.getAlterTablePos(upStmt, start);

    // Assert result
    Assert.assertArrayEquals(new int[] {-1, 7}, actual);
  }

  // Test written by Diffblue Cover.

  @Test
  public void getCreateIndexPosInputNotNullPositiveOutput2() {

    // Arrange
    final String upStmt = "a\'b\'c";
    final int start = 2_147_483_646;

    // Act
    final int[] actual = RouterUtil.getCreateIndexPos(upStmt, start);

    // Assert result
    Assert.assertArrayEquals(new int[] {-1, 7}, actual);
  }

  // Test written by Diffblue Cover.

  @Test
  public void getCreateTablePosInputNotNullNegativeOutput2() {

    // Arrange
    final String upStmt = "1a 2b 3c";
    final int start = -1_073_741_825;

    // Act
    final int[] actual = RouterUtil.getCreateTablePos(upStmt, start);

    // Assert result
    Assert.assertArrayEquals(new int[] {-1, 7}, actual);
  }

  // Test written by Diffblue Cover.

  @Test
  public void getDropIndexPosInputNotNullNegativeOutput2() {

    // Arrange
    final String upStmt = ",";
    final int start = -4100;

    // Act
    final int[] actual = RouterUtil.getDropIndexPos(upStmt, start);

    // Assert result
    Assert.assertArrayEquals(new int[] {-1, 7}, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void getDropTablePosInputNotNullNegativeOutput2() {

    // Arrange
    final String upStmt = "A1B2C3";
    final int start = -1;

    // Act
    final int[] actual = RouterUtil.getDropTablePos(upStmt, start);

    // Assert result
    Assert.assertArrayEquals(new int[] {-1, 7}, actual);
  }

  // Test written by Diffblue Cover.

  @Test
  public void getFixedSqlInputNotNullOutputNotNull() {

    // Arrange
    final String stmt = "A1B2C3";

    // Act
    final String actual = RouterUtil.getFixedSql(stmt);

    // Assert result
    Assert.assertEquals("", actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void getShowTableNameInputNotNull3OutputNotNull() {

    // Arrange
    final String stmt =
        "%,,,,,,,,.\u0084\u0084\u0084\u0084\u0084\u0084\u0084 \u0085\u0085\u0085\u0085\u0085\u0085";
    final int[] repPos = {0, 0, 0};

    // Act
    final String actual = RouterUtil.getShowTableName(stmt, repPos);

    // Assert side effects
    Assert.assertArrayEquals(new int[] {0, 17, 0}, repPos);

    // Assert result
    Assert.assertEquals("\u0084\u0084\u0084\u0084\u0084\u0084\u0084", actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void getShowTableNameInputNotNull6OutputNotNull() {

    // Arrange
    final String stmt = "A1B2C3";
    final int[] repPos = {0, 0, 0, 0, 0, 0};

    // Act
    final String actual = RouterUtil.getShowTableName(stmt, repPos);

    // Assert side effects
    Assert.assertArrayEquals(new int[] {0, 6, 0, 0, 0, 0}, repPos);

    // Assert result
    Assert.assertEquals("A1B2C3", actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void getShowTableNameInputNotNull6OutputStringIndexOutOfBoundsException() {

    // Arrange
    final String stmt = "foo";
    final int[] repPos = {2_147_483_646, 0, 0, 0, 0, 0};
    try {

      // Act
      thrown.expect(StringIndexOutOfBoundsException.class);
      RouterUtil.getShowTableName(stmt, repPos);
    } catch (StringIndexOutOfBoundsException ex) {

      // Assert side effects
      Assert.assertArrayEquals(new int[] {2_147_483_646, 3, 0, 0, 0, 0}, repPos);
      throw ex;
    }
  }

  // Test written by Diffblue Cover.
  @Test
  public void getShowTableNameInputNotNull6OutputStringIndexOutOfBoundsException2() {

    // Arrange
    final String stmt = "1a 2b 3c";
    final int[] repPos = {-2_147_483_642, 0, 0, 0, 0, 0};
    try {

      // Act
      thrown.expect(StringIndexOutOfBoundsException.class);
      RouterUtil.getShowTableName(stmt, repPos);
    } catch (StringIndexOutOfBoundsException ex) {

      // Assert side effects
      Assert.assertArrayEquals(new int[] {-2_147_483_642, 2, 0, 0, 0, 0}, repPos);
      throw ex;
    }
  }

  // Test written by Diffblue Cover.
  @Test
  public void getSpecPosInputNotNullNegativeOutput2() {

    // Arrange
    final String upStmt = "3";
    final int start = -1_073_741_826;

    // Act
    final int[] actual = RouterUtil.getSpecPos(upStmt, start);

    // Assert result
    Assert.assertArrayEquals(new int[] {-1, 4}, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void getTableNameInputNotNull3OutputNotNull() {

    // Arrange
    final String stmt = "1a 2b 3c";
    final int[] repPos = {130, 0, 0};

    // Act
    final String actual = RouterUtil.getTableName(stmt, repPos);

    // Assert side effects
    Assert.assertArrayEquals(new int[] {130, 8, 0}, repPos);

    // Assert result
    Assert.assertEquals("", actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void getTableNameInputNotNull3OutputNotNull2() {

    // Arrange
    final String stmt = "1a 2b 3c";
    final int[] repPos = {3, 0, 0};

    // Act
    final String actual = RouterUtil.getTableName(stmt, repPos);

    // Assert side effects
    Assert.assertArrayEquals(new int[] {3, 5, 0}, repPos);

    // Assert result
    Assert.assertEquals("3c", actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void getTableNameInputNotNull3OutputNotNull3() {

    // Arrange
    final String stmt = "1a 2b 3c";
    final int[] repPos = {-491_524, 0, 0};

    // Act
    final String actual = RouterUtil.getTableName(stmt, repPos);

    // Assert side effects
    Assert.assertArrayEquals(new int[] {-491_524, 2, 0}, repPos);

    // Assert result
    Assert.assertEquals("2b", actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void getTableNameInputNotNull17OutputNotNull() {

    // Arrange
    final String stmt = " ()\b,";
    final int[] repPos = {-2_147_483_633, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

    // Act
    final String actual = RouterUtil.getTableName(stmt, repPos);

    // Assert result
    Assert.assertEquals("", actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void getTruncateTablePosInputNotNullNegativeOutput2() {

    // Arrange
    final String upStmt = "2";
    final int start = -1_207_959_553;

    // Act
    final int[] actual = RouterUtil.getTruncateTablePos(upStmt, start);

    // Assert result
    Assert.assertArrayEquals(new int[] {-1, 7}, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void handleBatchInsertInputNotNullNegativeOutput0() {

    // Arrange
    final String origSQL = "1234";
    final int valuesIndex = -2;

    // Act
    final List<String> actual = RouterUtil.handleBatchInsert(origSQL, valuesIndex);

    // Assert result
    final LinkedList<String> linkedList = new LinkedList<String>();
    Assert.assertEquals(linkedList, actual);
  }

  // Test written by Diffblue Cover.

  @Test
  public void handleBatchInsertInputNotNullNegativeOutput02() {

    // Arrange
    final String origSQL = "a/b/c";
    final int valuesIndex = -2;

    // Act
    final List<String> actual = RouterUtil.handleBatchInsert(origSQL, valuesIndex);

    // Assert result
    final LinkedList<String> linkedList = new LinkedList<String>();
    Assert.assertEquals(linkedList, actual);
  }

  // Test written by Diffblue Cover.

  @Test
  public void handleBatchInsertInputNotNullNegativeOutput03() {

    // Arrange
    final String origSQL = ",";
    final int valuesIndex = -6;

    // Act
    final List<String> actual = RouterUtil.handleBatchInsert(origSQL, valuesIndex);

    // Assert result
    final LinkedList<String> linkedList = new LinkedList<String>();
    Assert.assertEquals(linkedList, actual);
  }

  // Test written by Diffblue Cover.

  @Test
  public void handleBatchInsertInputNotNullNegativeOutput04() {

    // Arrange
    final String origSQL = "\'";
    final int valuesIndex = -6;

    // Act
    final List<String> actual = RouterUtil.handleBatchInsert(origSQL, valuesIndex);

    // Assert result
    final LinkedList<String> linkedList = new LinkedList<String>();
    Assert.assertEquals(linkedList, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void handleBatchInsertInputNotNullNegativeOutput05() {

    // Arrange
    final String origSQL = "(\'";
    final int valuesIndex = -6;

    // Act
    final List<String> actual = RouterUtil.handleBatchInsert(origSQL, valuesIndex);

    // Assert result
    final LinkedList<String> linkedList = new LinkedList<String>();
    Assert.assertEquals(linkedList, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void handleBatchInsertInputNotNullNegativeOutput06() {

    // Arrange
    final String origSQL = "(\"";
    final int valuesIndex = -6;

    // Act
    final List<String> actual = RouterUtil.handleBatchInsert(origSQL, valuesIndex);

    // Assert result
    final LinkedList<String> linkedList = new LinkedList<String>();
    Assert.assertEquals(linkedList, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void handleBatchInsertInputNotNullNegativeOutputStringIndexOutOfBoundsException() {

    // Arrange
    final String origSQL = "3";
    final int valuesIndex = -100_000_102;

    // Act
    thrown.expect(StringIndexOutOfBoundsException.class);
    RouterUtil.handleBatchInsert(origSQL, valuesIndex);

    // Method is not expected to return due to exception thrown
  }

  // Test written by Diffblue Cover.
  @Test
  public void handleBatchInsertInputNotNullPositiveOutput0() {

    // Arrange
    final String origSQL =
        "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\\\u0000";
    final int valuesIndex = 9;

    // Act
    final List<String> actual = RouterUtil.handleBatchInsert(origSQL, valuesIndex);

    // Assert result
    final LinkedList<String> linkedList = new LinkedList<String>();
    Assert.assertEquals(linkedList, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void handleBatchInsertInputNotNullPositiveOutput1() {

    // Arrange
    final String origSQL = "ttttttttttttttt()";
    final int valuesIndex = 9;

    // Act
    final List<String> actual = RouterUtil.handleBatchInsert(origSQL, valuesIndex);

    // Assert result
    final LinkedList<String> linkedList = new LinkedList<String>();
    linkedList.add("ttttttttttttttt()");
    Assert.assertEquals(linkedList, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void handleBatchInsertInputNotNullPositiveOutput02() {

    // Arrange
    final String origSQL =
        "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\\)";
    final int valuesIndex = 9;

    // Act
    final List<String> actual = RouterUtil.handleBatchInsert(origSQL, valuesIndex);

    // Assert result
    final LinkedList<String> linkedList = new LinkedList<String>();
    Assert.assertEquals(linkedList, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void handleBatchInsertInputNotNullPositiveOutput03() {

    // Arrange
    final String origSQL =
        "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\\\"";
    final int valuesIndex = 9;

    // Act
    final List<String> actual = RouterUtil.handleBatchInsert(origSQL, valuesIndex);

    // Assert result
    final LinkedList<String> linkedList = new LinkedList<String>();
    Assert.assertEquals(linkedList, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void handleBatchInsertInputNotNullPositiveOutput04() {

    // Arrange
    final String origSQL = "ttttttttttttttt((";
    final int valuesIndex = 9;

    // Act
    final List<String> actual = RouterUtil.handleBatchInsert(origSQL, valuesIndex);

    // Assert result
    final LinkedList<String> linkedList = new LinkedList<String>();
    Assert.assertEquals(linkedList, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void isAllGlobalTableInputNotNullNullOutputFalse() {

    // Arrange
    final DruidShardingParseInfo ctx = new DruidShardingParseInfo();
    final SchemaConfig schema = null;

    // Act
    final boolean actual = RouterUtil.isAllGlobalTable(ctx, schema);

    // Assert result
    Assert.assertFalse(actual);
  }

  // Test written by Diffblue Cover.
  @PrepareForTest(WallVisitorUtils.class)
  @Test
  public void isConditionAlwaysFalseInputNullOutputFalse() throws Exception {

    // Setup mocks
    PowerMockito.mockStatic(WallVisitorUtils.class);

    // Arrange
    final SQLExpr expr = null;
    final Method getValueMethod =
        DTUMemberMatcher.method(WallVisitorUtils.class, "getValue", SQLExpr.class);
    PowerMockito.doReturn(null)
        .when(WallVisitorUtils.class, getValueMethod)
        .withArguments(or(isA(SQLExpr.class), isNull(SQLExpr.class)));

    // Act
    final boolean actual = RouterUtil.isConditionAlwaysFalse(expr);

    // Assert result
    Assert.assertFalse(actual);
  }

  // Test written by Diffblue Cover.
  @PrepareForTest(WallVisitorUtils.class)
  @Test
  public void isConditionAlwaysTrueInputNullOutputFalse() throws Exception {

    // Setup mocks
    PowerMockito.mockStatic(WallVisitorUtils.class);

    // Arrange
    final SQLExpr expr = null;
    final Method getValueMethod =
        DTUMemberMatcher.method(WallVisitorUtils.class, "getValue", SQLExpr.class);
    PowerMockito.doReturn(null)
        .when(WallVisitorUtils.class, getValueMethod)
        .withArguments(or(isA(SQLExpr.class), isNull(SQLExpr.class)));

    // Act
    final boolean actual = RouterUtil.isConditionAlwaysTrue(expr);

    // Assert result
    Assert.assertFalse(actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void isSystemSchemaInputNotNullOutputFalse() {

    // Arrange
    final String tableName = "a,b,c";

    // Act
    final boolean actual = RouterUtil.isSystemSchema(tableName);

    // Assert result
    Assert.assertFalse(actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void isSystemSchemaInputNotNullOutputTrue() {

    // Arrange
    final String tableName =
        "MYSQL.\uffe0\uffe0\uffe0\uffe0\uffe1\uffe0\uffe0\uffe0\uffe0\uffe0\uffe0\uffe0\uffe0?";

    // Act
    final boolean actual = RouterUtil.isSystemSchema(tableName);

    // Assert result
    Assert.assertTrue(actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void isSystemSchemaInputNotNullOutputTrue2() {

    // Arrange
    final String tableName = "INFORMATION_SCHEMA.B";

    // Act
    final boolean actual = RouterUtil.isSystemSchema(tableName);

    // Assert result
    Assert.assertTrue(actual);
  }

  // Test written by Diffblue Cover.

  @Test
  public void parseSqlValueArrayAndSuffixStrInputNotNullNegativeOutput1() {

    // Arrange
    final String origSQL = "1234";
    final int valuesIndex = -2;

    // Act
    final Object[] actual = RouterUtil.parseSqlValueArrayAndSuffixStr(origSQL, valuesIndex);

    // Assert result
    final ArrayList arrayList = new ArrayList();
    Assert.assertArrayEquals(new Object[] {arrayList}, actual);
  }

  // Test written by Diffblue Cover.

  @Test
  public void parseSqlValueArrayAndSuffixStrInputNotNullNegativeOutput2() {

    // Arrange
    final String origSQL = "foo";
    final int valuesIndex = -5;

    // Act
    final Object[] actual = RouterUtil.parseSqlValueArrayAndSuffixStr(origSQL, valuesIndex);

    // Assert result
    final ArrayList arrayList = new ArrayList();
    Assert.assertArrayEquals(new Object[] {arrayList, "oo"}, actual);
  }

  // Test written by Diffblue Cover.

  @Test
  public void parseSqlValueArrayAndSuffixStrInputNotNullNegativeOutput12() {

    // Arrange
    final String origSQL = "3";
    final int valuesIndex = -6;

    // Act
    final Object[] actual = RouterUtil.parseSqlValueArrayAndSuffixStr(origSQL, valuesIndex);

    // Assert result
    final ArrayList arrayList = new ArrayList();
    Assert.assertArrayEquals(new Object[] {arrayList}, actual);
  }

  // Test written by Diffblue Cover.

  @Test
  public void parseSqlValueArrayAndSuffixStrInputNotNullNegativeOutput13() {

    // Arrange
    final String origSQL = "\'";
    final int valuesIndex = -6;

    // Act
    final Object[] actual = RouterUtil.parseSqlValueArrayAndSuffixStr(origSQL, valuesIndex);

    // Assert result
    final ArrayList arrayList = new ArrayList();
    Assert.assertArrayEquals(new Object[] {arrayList}, actual);
  }

  // Test written by Diffblue Cover.

  @Test
  public void parseSqlValueArrayAndSuffixStrInputNotNullNegativeOutput14() {

    // Arrange
    final String origSQL = "((";
    final int valuesIndex = -5;

    // Act
    final Object[] actual = RouterUtil.parseSqlValueArrayAndSuffixStr(origSQL, valuesIndex);

    // Assert result
    final ArrayList arrayList = new ArrayList();
    Assert.assertArrayEquals(new Object[] {arrayList}, actual);
  }

  // Test written by Diffblue Cover.

  @Test
  public void parseSqlValueArrayAndSuffixStrInputNotNullNegativeOutput15() {

    // Arrange
    final String origSQL = "((\"";
    final int valuesIndex = -5;

    // Act
    final Object[] actual = RouterUtil.parseSqlValueArrayAndSuffixStr(origSQL, valuesIndex);

    // Assert result
    final ArrayList arrayList = new ArrayList();
    Assert.assertArrayEquals(new Object[] {arrayList}, actual);
  }

  // Test written by Diffblue Cover.

  @Test
  public void parseSqlValueArrayAndSuffixStrInputNotNullNegativeOutput16() {

    // Arrange
    final String origSQL = "\'\'\'";
    final int valuesIndex = -5;

    // Act
    final Object[] actual = RouterUtil.parseSqlValueArrayAndSuffixStr(origSQL, valuesIndex);

    // Assert result
    final ArrayList arrayList = new ArrayList();
    Assert.assertArrayEquals(new Object[] {arrayList}, actual);
  }

  // Test written by Diffblue Cover.

  @Test
  public void parseSqlValueArrayAndSuffixStrInputNotNullNegativeOutput17() {

    // Arrange
    final String origSQL = "\"\"\"";
    final int valuesIndex = -5;

    // Act
    final Object[] actual = RouterUtil.parseSqlValueArrayAndSuffixStr(origSQL, valuesIndex);

    // Assert result
    final ArrayList arrayList = new ArrayList();
    Assert.assertArrayEquals(new Object[] {arrayList}, actual);
  }

  // Test written by Diffblue Cover.

  @Test
  public void parseSqlValueArrayAndSuffixStrInputNotNullNegativeOutput18() {

    // Arrange
    final String origSQL = "((,";
    final int valuesIndex = -5;

    // Act
    final Object[] actual = RouterUtil.parseSqlValueArrayAndSuffixStr(origSQL, valuesIndex);

    // Assert result
    final ArrayList arrayList = new ArrayList();
    Assert.assertArrayEquals(new Object[] {arrayList}, actual);
  }

  // Test written by Diffblue Cover.

  @Test
  public void parseSqlValueArrayAndSuffixStrInputNotNullNegativeOutput19() {

    // Arrange
    final String origSQL = "(()";
    final int valuesIndex = -5;

    // Act
    final Object[] actual = RouterUtil.parseSqlValueArrayAndSuffixStr(origSQL, valuesIndex);

    // Assert result
    final ArrayList arrayList = new ArrayList();
    final ArrayList arrayList1 = new ArrayList();
    arrayList1.add("");
    arrayList.add(arrayList1);
    Assert.assertArrayEquals(new Object[] {arrayList}, actual);
  }

  // Test written by Diffblue Cover.

  @Test
  public void parseSqlValueArrayAndSuffixStrInputNotNullNegativeOutput110() {

    // Arrange
    final String origSQL = "((i";
    final int valuesIndex = -5;

    // Act
    final Object[] actual = RouterUtil.parseSqlValueArrayAndSuffixStr(origSQL, valuesIndex);

    // Assert result
    final ArrayList arrayList = new ArrayList();
    Assert.assertArrayEquals(new Object[] {arrayList}, actual);
  }

  // Test written by Diffblue Cover.

  @Test
  public void parseSqlValueArrayAndSuffixStrInputNotNullNegativeOutput111() {

    // Arrange
    final String origSQL = "(((";
    final int valuesIndex = -5;

    // Act
    final Object[] actual = RouterUtil.parseSqlValueArrayAndSuffixStr(origSQL, valuesIndex);

    // Assert result
    final ArrayList arrayList = new ArrayList();
    Assert.assertArrayEquals(new Object[] {arrayList}, actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void
  parseSqlValueArrayAndSuffixStrInputNotNullNegativeOutputStringIndexOutOfBoundsException() {

    // Arrange
    final String origSQL = "((\"\\";
    final int valuesIndex = -5;

    // Act
    thrown.expect(StringIndexOutOfBoundsException.class);
    RouterUtil.parseSqlValueArrayAndSuffixStr(origSQL, valuesIndex);

    // Method is not expected to return due to exception thrown
  }

  // Test written by Diffblue Cover.
  @Test
  public void
  parseSqlValueArrayAndSuffixStrInputNotNullNegativeOutputStringIndexOutOfBoundsException2() {

    // Arrange
    final String origSQL = "\"\",\\";
    final int valuesIndex = -5;

    // Act
    thrown.expect(StringIndexOutOfBoundsException.class);
    RouterUtil.parseSqlValueArrayAndSuffixStr(origSQL, valuesIndex);

    // Method is not expected to return due to exception thrown
  }

  // Test written by Diffblue Cover.
  @Test
  public void
  parseSqlValueArrayAndSuffixStrInputNotNullNegativeOutputStringIndexOutOfBoundsException3() {

    // Arrange
    final String origSQL = "\"\"\'\\";
    final int valuesIndex = -5;

    // Act
    thrown.expect(StringIndexOutOfBoundsException.class);
    RouterUtil.parseSqlValueArrayAndSuffixStr(origSQL, valuesIndex);

    // Method is not expected to return due to exception thrown
  }

  // Test written by Diffblue Cover.
  @Test
  public void
  parseSqlValueArrayAndSuffixStrInputNotNullNegativeOutputStringIndexOutOfBoundsException4() {

    // Arrange
    final String origSQL = "\"\"\\\"\\";
    final int valuesIndex = -5;

    // Act
    thrown.expect(StringIndexOutOfBoundsException.class);
    RouterUtil.parseSqlValueArrayAndSuffixStr(origSQL, valuesIndex);

    // Method is not expected to return due to exception thrown
  }

  // Test written by Diffblue Cover.
  @Test
  public void
  parseSqlValueArrayAndSuffixStrInputNotNullNegativeOutputStringIndexOutOfBoundsException5() {

    // Arrange
    final String origSQL = "\'\'\"\\";
    final int valuesIndex = -5;

    // Act
    thrown.expect(StringIndexOutOfBoundsException.class);
    RouterUtil.parseSqlValueArrayAndSuffixStr(origSQL, valuesIndex);

    // Method is not expected to return due to exception thrown
  }

  // Test written by Diffblue Cover.
  @Test
  public void
  parseSqlValueArrayAndSuffixStrInputNotNullNegativeOutputStringIndexOutOfBoundsException6() {

    // Arrange
    final String origSQL = "\"\"\\\'\\";
    final int valuesIndex = -5;

    // Act
    thrown.expect(StringIndexOutOfBoundsException.class);
    RouterUtil.parseSqlValueArrayAndSuffixStr(origSQL, valuesIndex);

    // Method is not expected to return due to exception thrown
  }

  // Test written by Diffblue Cover.
  @Test
  public void
  parseSqlValueArrayAndSuffixStrInputNotNullPositiveOutputStringIndexOutOfBoundsException() {

    // Arrange
    final String origSQL = "3";
    final int valuesIndex = 1_009_778_682;

    // Act
    thrown.expect(StringIndexOutOfBoundsException.class);
    RouterUtil.parseSqlValueArrayAndSuffixStr(origSQL, valuesIndex);

    // Method is not expected to return due to exception thrown
  }

  // Test written by Diffblue Cover.
  @Test
  public void processWithMycatSeqInputNullZeroNotNullNullOutputFalse() {

    // Arrange
    final SchemaConfig schema = null;
    final int sqlType = 0;
    final String origSQL = "3";
    final ServerConnection sc = null;

    // Act
    final boolean actual = RouterUtil.processWithMycatSeq(schema, sqlType, origSQL, sc);

    // Assert result
    Assert.assertFalse(actual);
  }

  // Test written by Diffblue Cover.
  @Test
  public void removeSchemaInputNotNullNotNullOutputNotNull() {

    // Arrange
    final String stmt = "A1B2C3";
    final String schema = "1";

    // Act
    final String actual = RouterUtil.removeSchema(stmt, schema);

    // Assert result
    Assert.assertEquals("A1B2C3", actual);
  }

  // Test written by Diffblue Cover.

  @Test
  public void routeToMultiNodeInputFalseNull0NotNullOutputNullPointerException() {

    // Arrange
    final boolean cache = false;
    final RouteResultset rrs = null;
    final ArrayList<String> dataNodes = new ArrayList<String>();
    final String stmt = "";

    // Act
    thrown.expect(NullPointerException.class);
    RouterUtil.routeToMultiNode(cache, rrs, dataNodes, stmt);

    // Method is not expected to return due to exception thrown
  }

  // Test written by Diffblue Cover.

  @Test
  public void routeToMultiNodeInputFalseNull1NotNullOutputNullPointerException() {

    // Arrange
    final boolean cache = false;
    final RouteResultset rrs = null;
    final ArrayList<String> dataNodes = new ArrayList<String>();
    dataNodes.add(null);
    final String stmt = "";

    // Act
    thrown.expect(NullPointerException.class);
    RouterUtil.routeToMultiNode(cache, rrs, dataNodes, stmt);

    // Method is not expected to return due to exception thrown
  }

  // Test written by Diffblue Cover.
  @Test
  public void ruleByJoinValueCalculateInputNullNullNotNullOutputNoSuchElementException()
      throws SQLNonTransientException {

    // Arrange
    final RouteResultset rrs = null;
    final TableConfig tc = null;
    final HashSet<ColumnRoutePair> colRoutePairSet = new HashSet<ColumnRoutePair>();

    // Act
    thrown.expect(NoSuchElementException.class);
    RouterUtil.ruleByJoinValueCalculate(rrs, tc, colRoutePairSet);

    // Method is not expected to return due to exception thrown
  }
}
