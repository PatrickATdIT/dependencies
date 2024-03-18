package de.hwglu.atdit_2024;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class SecureCredentialStringBuilderImplementationTest {


    @Test
    public void userAndPasswordMustBeSeparatedByColon() {
        //assemble
        String inputUser = "myuser";
        String inputPassword = "mypassword";
        String expected = "myuser:mypassword";

        //create mock and tell it how to behave!
        Encryption encryptorMock = Mockito.mock(Encryption.class);
        Mockito.when(encryptorMock.encrypt(inputUser)).thenReturn(inputUser);
        Mockito.when(encryptorMock.encrypt(inputPassword)).thenReturn(inputPassword);

        var cut = new SecureCredentialStringBuilderImplementation(encryptorMock);

        //act
        var actual = cut.makeCredentialString(inputUser, inputPassword);

        //assert
        //confirm that the encryptor was called as expected
        Mockito.verify(encryptorMock, Mockito.times(1)).encrypt(inputUser);
        Mockito.verify(encryptorMock, Mockito.times(1)).encrypt(inputPassword);
        Assertions.assertEquals(expected, actual);
    }
}
