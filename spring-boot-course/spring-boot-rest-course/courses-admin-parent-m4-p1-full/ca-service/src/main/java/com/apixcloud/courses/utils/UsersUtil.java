package com.apixcloud.courses.utils;

public final class UsersUtil { 

    public static final class Users{
        public static final String ADMIN_USERNAME = "admin";
        public static final String ADMIN_PASS = "admin123";
        public static final String ADMIN_EMAIL = "email-admin@dummy.com.mx";
        public static final String ADMIN_NAME = "Ricardo";

        public static final String MEMBER_USERNAME = "member";
        public static final String MEMBER_PASS = "member123";
        public static final String MEMBER_EMAIL = "member@dummy.com.mx";
        public static final String MEMBER_NAME = "Juanito";
    
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
        /** A placeholder role for viewer. */
        public static final String ROLE_MEMBER = "ROLE_MEMBER";
        /** A placeholder role for editor. */
        //public static final String ROLE_OTHER = "ROLE_OTHER";

    }

    private UsersUtil() {
        throw new AssertionError();
    }

}
