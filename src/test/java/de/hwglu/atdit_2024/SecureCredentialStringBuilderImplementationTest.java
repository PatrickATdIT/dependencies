package de.hwglu.atdit_2024;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SecureCredentialStringBuilderImplementationTest {
    @Test
    public void userAndPasswordMustBeSeparatedByColon() {
        String inputUser = "myuser";
        String inputPassword = "mypassword";
        String expected = "pbxvhu:pbsdvvzrug";
        var cut = new SecureCredentialStringBuilderImplementation();

        var actual = cut.makeCredentialString(inputUser, inputPassword);

        Assertions.assertEquals(expected, actual);
    }
}
