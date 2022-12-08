package database_use_case;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DatabaseTestCopy {

    @Test
    public void checkEnvWithInput(){
        Assertions.assertEquals("DatingAppStaging", System.getenv("INPUT_DatabaseCollection"));
    }

    @Test
    public void checkEnvWithoutInput(){
        Assertions.assertEquals("DatingAppStaging", System.getenv("DatabaseCollection"));
    }

}
