package database_use_case;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DatabaseTestCopy {

    @Test
    public void checkEnvWorking(){
        Assertions.assertEquals("DatingAppStaging", (System.getenv("DatabaseCollection")));
    }

}
