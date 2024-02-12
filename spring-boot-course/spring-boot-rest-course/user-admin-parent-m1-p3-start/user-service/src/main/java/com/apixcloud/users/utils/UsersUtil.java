package com.apixcloud.users.utils;

public final class UsersUtil { 
   
    /*public static final String NAME = ADMIN_USERNAME;
    public static final String PASS = ADMIN_PASS;
    public static final String EMAIL = ADMIN_EMAIL;*/

    public static final class Users{
        public static final String ADMIN_USERNAME = "admin";
        public static final String ADMIN_PASS = "admin123";
        public static final String ADMIN_EMAIL = "admin@dummy.com.mx";

        public static final String VIEWER_USERNAME = "enduser";
        public static final String VIEWER_PASS = "endusers123";
        public static final String VIEWER_EMAIL = "enduser@dummy.com.mx";
    
    }

    // privileges
    /**
     * Privileges <br/>
     * - note: the fact that these Privileges are prefixed with `ROLES` is a Spring convention (which can be overriden if needed)
     */
    public static final class Privileges {

        // User
        public static final String CAN_USER_READ = "ROLE_USER_READ";
        public static final String CAN_USER_WRITE = "ROLE_USER_WRITE";

        // Role
        public static final String CAN_ROLE_READ = "ROLE_ROLE_READ";
        public static final String CAN_ROLE_WRITE = "ROLE_ROLE_WRITE";

        // Privilege
        public static final String CAN_PRIVILEGE_READ = "ROLE_PRIVILEGE_READ";
        public static final String CAN_PRIVILEGE_WRITE = "ROLE_PRIVILEGE_WRITE";

        public static final String DESCRIPTION = "User privileges";

    }

    public static final class Roles {

        /** A placeholder role for administrator. */
        public static final String ROLE_ADMIN = "ROLE_ADMIN";
        /** A placeholder role for enduser. */
        public static final String ROLE_ENDUSER = "ROLE_ENDUSER";

    }

    private UsersUtil() {
        throw new AssertionError();
    }

}
