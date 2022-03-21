import java.util.Random;

/*
THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED 
TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. 
IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, 
WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE 
OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

/** 
 * Common utility methods that help with testing. 
 */
public class ZybooksTesterUtil {
    private static Random rnd = new  Random();
    private static String capitalLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static String lowercaseLetters = "abcdefghijklmnopqrstuvxyz";
    private static String numericLetters = "0123456789";

    public static String getAlphaNumericString(int n) {
        return getRandomFromString(n, capitalLetters+lowercaseLetters+numericLetters);
    }
    
    public static String getAlphaString(int n) {
        String alphaString = capitalLetters + lowercaseLetters;
        return getRandomFromString(n, alphaString);
    }

    /**
     * Gets a random ordered string from the passed in string of length N
     * @param length
     * @param str
     * @return
     */
    public static String getRandomFromString(int length, String str) { 
        // create StringBuffer size of AlphaNumericString
        StringBuilder sb = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            int index = rnd.nextInt(str.length());
            sb.append(str.charAt(index));
        }

        return sb.toString();
    }

    
}
