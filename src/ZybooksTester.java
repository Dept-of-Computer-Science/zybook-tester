/*
THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED 
TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. 
IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, 
WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE 
OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

import java.io.*;

/**
 * This class wraps various junit tests. By having it, we can write junit tests for 
 * development, but when putting them as unit tests in Zybooks it will instead use
 * this file - as it can't use junit. 
 */
public class ZybooksTester {

    final PrintWriter testFeedback;

    public ZybooksTester(PrintWriter testFeedback) {
        this.testFeedback = testFeedback;
    }

    public boolean assertEquals(Object expected, Object actual) {
        return assertEquals(expected, actual, null);
    }

    public boolean assertEquals(Object expected, Object actual, String message) {
        return assertEquals(expected, actual, message, true);
    }
    public boolean assertEquals(Object expected, Object actual, String message, boolean strip) {
        String expectedOut =  expected.toString();
        String actualOut =  actual.toString();
        if(strip) {
            actual = actual.toString().toLowerCase().replace("\\s+", "");
            expected = expected.toString().toLowerCase().replace("\\s+", "");
        }
        boolean val = expected.toString().equals(actual.toString());
        if(!val) {
            feedbackWriter(expectedOut, actualOut, message);
        }
        return val;
    }

    public boolean assertNull(Object obj) {
        return assertNull(obj,  null);
    }

    public boolean assertNull(Object obj, String message) {
        boolean val = obj == null;
        if(!val) {
            feedbackWriter(null, obj.toString(), message);
        }
        return val;
    }

    
    public static String readFileToString(String fileName) {
        StringBuilder out = new StringBuilder();
        try {
            BufferedReader reader1 = new BufferedReader(new FileReader(fileName));
            String line1 = reader1.readLine();
            while (line1 != null) {
                out.append(line1);
                line1 = reader1.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return out.toString();
    }
    
    private void feedbackWriter(String expected, String actual, String message) {
        testFeedback.write("Test Failed\n");
        testFeedback.write(String.format("Expected: %s%n", expected));
        testFeedback.write(String.format("Actual: %s%n", actual));
        if(message !=null) {
            testFeedback.write(message);
        }
    }
}