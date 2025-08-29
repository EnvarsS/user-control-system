package org.envycorp.usercontrolsystem.storage_util;

public class IdGenerator {
    private static int currentId = 0;

    public static int generateId() {
        return ++currentId;
    }
}
