/*
THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED 
TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. 
IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, 
WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE 
OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

import java.io.PrintWriter;

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
        return assertEquals(expected, actual, "");
    }

    public boolean assertEquals(Object expected, Object actual, String testID) {
        boolean val = expected.toString().equals(actual.toString());
        if(!val) {
            testFeedback.write(String.format("Test %s Failed\n", testID));
            testFeedback.write(String.format("Expected: %s%n", expected));
            testFeedback.write(String.format("Actual: %s%n", actual));
        }
        return val;
    }

    public boolean assertNull(Object obj) {
        return assertNull(obj,  "");
    }

    public boolean assertNull(Object obj, String testID) {
        boolean val = obj == null;
        if(!val) {
            testFeedback.write(String.format("Test %s Failed\n", testID));
            testFeedback.write(String.format("Expected: %s%n", null));
            testFeedback.write(String.format("Actual: %s%n", obj));
        }
        return val;
    }

}