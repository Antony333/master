package framework;

import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SoftAssert {
    private final List<String> errors = new ArrayList<>();

    public void assertEquals(Double actual, Double expected, String message) {
        if (!Objects.equals(actual, expected)) {
            errors.add(String.format("%s, actual value is: %f, expected value is: %f", message, actual, expected));
        }

    }

    public void assertEquals(String actual, String expected, String message) {
        if (!actual.equals(expected)) {
            errors.add(String.format("%s, actual value is: %s, expected value is: %s", message, actual, expected));
        }
    }

    public void assertEquals(Integer actual, Integer expected, String message) {
        if (!actual.equals(expected)) {
            errors.add(String.format("%s, actual value is: %d, expected value is: %d", message, actual, expected));
        }
    }

    public void assertEquals(Object actual, Object expected, String message) {
        if (!actual.equals(expected)) {
            errors.add(message);
        }
    }

    public void assertTrue(boolean b, String m) {
        if (!b) {
            errors.add(m);
        }

    }

    public void assertAll() {
        if (errors.size() > 0) {
            String allErrors = "";
            for (String error : errors) {
                allErrors += error + " ";
            }

            Assert.assertTrue(false, allErrors);
        }
    }
}
