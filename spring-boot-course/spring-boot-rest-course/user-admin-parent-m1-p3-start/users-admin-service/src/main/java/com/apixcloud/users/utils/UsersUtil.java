package com.apixcloud.users.utils;

public final class UsersUtil { 

    public static final class Users{
        public static final String ADMIN_USERNAME = "admin";
        public static final String ADMIN_PASS = "admin123";
        public static final String ADMIN_EMAIL = "email-admin@dummy.com.mx";
        public static final String ADMIN_NAME = "Juanito";

        public static final String VIEWER_USERNAME = "viewer";
        public static final String VIEWER_PASS = "viewer123";
        public static final String VIEWER_EMAIL = "email-viewer@dummy.com.mx";
        public static final String VIEWER_NAME = "Pedrito";

        public static final String EDITOR_USERNAME = "editor";
        public static final String EDITOR_PASS = "editor123";
        public static final String EDITOR_EMAIL = "email-editor@dummy.com.mx";
        public static final String EDITOR_NAME = "Julanito";
    
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
        public static final String ROLE_VIEWER = "ROLE_VIEWER";
        /** A placeholder role for editor. */
        public static final String ROLE_EDITOR = "ROLE_EDITOR";

    }

    private UsersUtil() {
        throw new AssertionError();
    }

}
