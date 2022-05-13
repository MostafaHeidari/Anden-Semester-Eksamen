package BE;

import BE.Interface.ILogin;

public class Login implements ILogin {

    private int id;
    private String username;
    private String password;
    private String salt
    private String UserType;

    /**
     * Constructor
     */
    public Login() {
    }

    /**
     * @param id
     * @param username
     * @param password
     * @param userType
     * Constructor with id, username and password
     */
    public Login(int id, String username, String password, String UserType) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.UserType = userType;
    }

    /**
     * Gets the id
     * @return id
     */
    @Override
    public int getId() {
        return id;
    }

    /**
     * Sets the id
     * @param id
     */
    @Override
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets the username
     * @return username
     */
    @Override
    public String getUsername() {
        return username;
    }

    /**
     * Sets the username
     * @param username
     */
    @Override
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gets the password
     * @return password
     */
    @Override
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password
     * @param password
     */
    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets the UserType
     * @return UserType
     */
    @Override
    public String getUserType() {
        return UserType;
    }

    /**
     * Sets the UserType
     * @param UserType
     */
    @Override
    public void setUserType(String UserType) {
        this.UserType = UserType;
    }

}
