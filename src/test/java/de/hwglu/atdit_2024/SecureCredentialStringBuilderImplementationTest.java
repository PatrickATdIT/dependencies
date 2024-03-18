package de.hwglu.atdit_2024;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Objects;

public class SecureCredentialStringBuilderImplementationTest {


    @Test
    public void userAndPasswordMustBeSeparatedByColon() {
        Encryption encryptorMock = plain -> {
            if (!Objects.equals(plain, "myuser") && !Objects.equals(plain, "mypassword"))
                Assertions.fail("unexpected input");
            return plain;
        };

        String inputUser = "myuser";
        String inputPassword = "mypassword";
        String expected = "myuser:mypassword";
        var cut = new SecureCredentialStringBuilderImplementation(encryptorMock);

        var actual = cut.makeCredentialString(inputUser, inputPassword);

        Assertions.assertEquals(expected, actual);
    }
}
