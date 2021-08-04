import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.*;

public class CalcTestClass {
    private OutputStream stdin = null;
    private InputStream stdout = null;
    private BufferedReader reader = null;
    private final String PROJECT_PATH = System.getProperty("user.dir");

    private void stdinWriter(String input) throws IOException {
        stdin.write(input.getBytes());
        stdin.flush();
        stdin.close();
    }

    @BeforeMethod
    public void preparationMethod() throws IOException {
        Process process =  new ProcessBuilder(PROJECT_PATH
                + "\\src\\test\\resources\\calc_div.exe").start();
        stdin = process.getOutputStream();
        stdout = process.getInputStream();
        reader = new BufferedReader (new InputStreamReader(stdout));
    }

    @DataProvider (name = "testCase1")
    public Object[][] testCase1Values() {
        return new Object[][] {
                {"0.75", "1500 2000"},
                {"3", "6 2"}
        };
    }

    @DataProvider (name = "testCase2")
    public Object[][] testCase2Values() {
        return new Object[][]{
                {"-0.75", "-1500 2000"}
        };
    }

    @DataProvider (name = "testCase3")
    public Object[][] testCase3Values() {
        return new Object[][]{
                {"-1.2", "-2.4 2"},
        };
    }

    @DataProvider (name = "testCase4")
    public Object[][] testCase4Values() {
        return new Object[][]{
                {"-0.96", "-12 12.5"},
        };
    }

    @DataProvider (name = "testCase5")
    public Object[][] testCase5Values() {
        return new Object[][]{
                {"-1.2", "2.4 -2"},
        };
    }

    @DataProvider (name = "testCase6")
    public Object[][] testCase6Values() {
        return new Object[][]{
                {"-0.83", "2 -2.4"}
        };
    }

    @DataProvider (name = "testCase7")
    public Object[][] testCase7Values() {
        return new Object[][]{
                {"2.11", "4.22 2"}
        };
    }

    @DataProvider (name = "testCase8")
    public Object[][] testCase8Values() {
        return new Object[][]{
                {"0.96", "12 12.5"}
        };
    }

    @DataProvider (name = "testCase9")
    public Object[][] testCase9Values() {
        return new Object[][]{
                {"2", "2.4 1.2"}
        };
    }

    @DataProvider (name = "testCase10")
    public Object[][] testCase10Values() {
        return new Object[][]{
                {"0", "0 5"},
                {"0", "0 -5"},
                {"0", "0 2.55"},
                {"0", "0 -2.55"},
                {"0", "-0 1"}

        };
    }

    @DataProvider (name = "testCase11")
    public Object[][] testCase11Values() {
        return new Object[][]{
                {"error", "5 0"},
                {"error", "-5 0"},
                {"error", "2.55 0"},
                {"error", "-2.55 0"},
                {"error", "0 0"},
        };
    }

    @DataProvider (name = "testCase12")
    public Object[][] testCase12Values() {
        return new Object[][]{
                {"6.15", "9223372036854775807 15"}
        };
    }

    @DataProvider (name = "testCase13")
    public Object[][] testCase13Values() {
        return new Object[][]{
                {"1.36", "19 12"}
        };
    }

    @DataProvider (name = "testCase14")
    public Object[][] testCase14Values() {
        return new Object[][]{
                {"error", "# 3"},
                {"error", "3 #"},
                {"error", "? %"}
        };
    }


    @Test (dataProvider = "testCase1")
    public void naturalPositiveNumbersDivisionTest (String result, String input) throws IOException {
        stdinWriter(input);
        String appOutput = reader.readLine();
        Assert.assertEquals(appOutput, result);
    }

    @Test (dataProvider = "testCase2")
    public void negativeIntegerDividend (String result, String input) throws IOException {
        stdinWriter(input);
        String appOutput = reader.readLine();
        Assert.assertEquals(appOutput, result);
    }

    @Test (dataProvider = "testCase3")
    public void negativeFloatDividend (String result, String input) throws IOException {
        stdinWriter(input);
        String appOutput = reader.readLine();
        Assert.assertEquals(appOutput, result);
    }

    @Test (dataProvider = "testCase4")
    public void positiveFloatDivisor (String result, String input) throws IOException {
        stdinWriter(input);
        String appOutput = reader.readLine();
        Assert.assertEquals(appOutput, result);
    }

    @Test (dataProvider = "testCase5")
    public void negativeIntegerDivisor (String result, String input) throws IOException {
        stdinWriter(input);
        String appOutput = reader.readLine();
        Assert.assertEquals(appOutput, result);
    }

    @Test (dataProvider = "testCase6")
    public void negativeFloatDivisor (String result, String input) throws IOException {
        stdinWriter(input);
        String appOutput = reader.readLine();
        Assert.assertEquals(appOutput, result);
    }

    @Test (dataProvider = "testCase7")
    public void integerDivision (String result, String input) throws IOException {
        stdinWriter(input);
        String appOutput = reader.readLine();
        Assert.assertEquals(appOutput, result);
    }

    @Test (dataProvider = "testCase8")
    public void integerDividendFloatDivisor (String result, String input) throws IOException {
        stdinWriter(input);
        String appOutput = reader.readLine();
        Assert.assertEquals(appOutput, result);
    }

    @Test (dataProvider = "testCase9")
    public void floatDividendFloatDivisor (String result, String input) throws IOException {
        stdinWriter(input);
        String appOutput = reader.readLine();
        Assert.assertEquals(appOutput, result);
    }

    @Test (dataProvider = "testCase10", groups = {"zeroDivisionCheck"})
    public void zeroDividend (String result, String input) throws IOException {
        stdinWriter(input);
        String appOutput = reader.readLine();
        Assert.assertEquals(appOutput, result);
    }

    @Test (dataProvider = "testCase11", groups = {"zeroDivisionCheck"})
    public void zeroDivisor (String result, String input) throws IOException {
        stdinWriter(input);
        String appOutput = reader.readLine();
        Assert.assertEquals(appOutput, result);
    }

    @Test (dataProvider = "testCase12")
    public void bigNumbersTest (String result, String input) throws IOException {
        stdinWriter(input);
        String appOutput = reader.readLine();
        Assert.assertEquals(appOutput, result);
    }

    @Test (dataProvider = "testCase13")
    public void afterCommaSignsCount (String result, String input) throws IOException {
        stdinWriter(input);
        String appOutput = reader.readLine();
        Assert.assertEquals(appOutput, result);
    }

    @Test (dataProvider = "testCase14")
    public void nonNumberSignsTest (String result, String input) throws IOException {
        stdinWriter(input);
        String appOutput = reader.readLine();
        Assert.assertEquals(appOutput, result);
    }
}