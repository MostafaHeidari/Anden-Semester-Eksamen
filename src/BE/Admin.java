package BE;

public class Admin {
    private int AdminId;
    private String userNameAdmin;
    private String passwordAdmin;

    /**
     * @param userNameAdmin
     * @param passwordAdmin
     * Constructor with Admin, adminId,  userNameAdmin, passwordAdmin
     */
    public Admin(int adminId, String userNameAdmin, String passwordAdmin) {
        AdminId = adminId;
        this.userNameAdmin = userNameAdmin;
        this.passwordAdmin = passwordAdmin;
    }


    public int getAdminId() {
        return AdminId;
    }

    public void setAdminId(int adminId) {
        AdminId = adminId;
    }

    public String getUserNameAdmin() {
        return userNameAdmin;
    }

    public void setUserNameAdmin(String userNameAdmin) {
        this.userNameAdmin = userNameAdmin;
    }

    public String getPasswordAdmin() {
        return passwordAdmin;
    }

    public void setPasswordAdmin(String passwordAdmin) {
        this.passwordAdmin = passwordAdmin;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "AdminId=" + AdminId +
                ", userNameAdmin='" + userNameAdmin + '\'' +
                ", passwordAdmin='" + passwordAdmin + '\'' +
                '}';
    }
}
