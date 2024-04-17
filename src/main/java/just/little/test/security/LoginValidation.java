package just.little.test.security;

public class LoginValidation {
    public static boolean validate(String username, String password, String repeatPassword) {
        return checkPassword(password, repeatPassword) && !(isInDB(username));
    }

    private static boolean isInDB(String username) {
        return true;
    }

    private static boolean checkPassword(String password, String repeatPassword) {
        return password.equals(repeatPassword);
    }
}