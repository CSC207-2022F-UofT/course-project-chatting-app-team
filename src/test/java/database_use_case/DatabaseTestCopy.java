package database_use_case;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DatabaseTestCopy {

    @Test
    public void checkEnvWorking(){
        System.out.println(System.getenv("INPUT_DatabaseCollection"));
        Assertions.assertEquals("DatingAppStaging", (System.getenv("INPUT_DatabaseCollection")));
    }

}
