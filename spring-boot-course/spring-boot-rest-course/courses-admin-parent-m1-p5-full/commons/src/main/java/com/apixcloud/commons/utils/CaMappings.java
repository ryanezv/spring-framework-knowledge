package com.apixcloud.commons.utils;

public final class CaMappings {

    public static final String USERS = "users";
    public static final String PRIVILEGES = "privileges";
    public static final String ROLES = "roles";

    public static final class Singular {

        public static final String USER = "user";
        public static final String PRIVILEGE = "privilege";
        public static final String ROLE = "role";

    }

    public static final String AUTHENTICATION = "authentication";

    private CaMappings() {
        throw new AssertionError();
    }

}
