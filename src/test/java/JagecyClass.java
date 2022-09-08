import com.jagacy.Key;
import com.jagacy.Session3270;
import com.jagacy.util.JagacyException;


public class JagecyClass extends Session3270 {

    private int userIdRow;
    private int userIdColumn;
    private String message = null;

    public JagecyClass() throws JagacyException {
        super("sessionA", "host3270.absa.co.za", 993, "IBM-3279-5-E", true);
    }

    public boolean userLogin(String username, String password) throws JagacyException, InterruptedException {
        waitForChange(10000);
        userIdRow = 22;
        userIdColumn = 26;
        this.writePosition(userIdRow, userIdColumn, "iv01");
        this.writeKey(Key.ENTER);


        this.waitForChange(50000);
        userIdRow = 14;
        userIdColumn = 10;
        this.writePosition(userIdRow, userIdColumn, username);

        userIdRow = 16;
        userIdColumn = 11;
        this.writePosition(userIdRow, userIdColumn, password);
        this.writeKey(Key.ENTER);
        this.waitForChange(30000);

        userIdRow = 23;
        userIdColumn = 22;
        message = this.readPosition(userIdRow, userIdColumn, 40).trim();

        if (message.equalsIgnoreCase("INCORRECT OR NO PASSWORD ENTERED.") || message.equalsIgnoreCase("USERID IS NOT DEFINED TO RACF.") || message.equalsIgnoreCase("Your USERID is already logged on.")) {
            return false;
        } else {

            System.out.println("Successfully loggedIn");
            return true;
        }
    }

}
