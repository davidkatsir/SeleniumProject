package swagLabs03;

public class LoginPage03 {

    // Page Locators
    public static final String userNameLocator = "[data-test=\"username\"]";
    public static final String passWordLocator = "[data-test=\"password\"]";
    public static final String loginButtonLocator = "[id=\"login-button\"]";
    public static final String loginErrorMessageLocator = "[data-test=\"error\"]";

    // Explanation of: "public static final" -
    // public static final for the page locators in a separate class allows:
    // 1. Easy access to the locators from any part of your code.
    // 2. No need to create an instance of the class to access them.
    // 3. Ensures they remain constant throughout the program, preventing accidental changes.
}
