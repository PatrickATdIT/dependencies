package de.hwglu.atdit_2024;

public class SecureCredentialStringBuilderImplementation implements CredentialStringBuilder {
    @Override
    public String makeCredentialString(String user, String password) {
        StringBuilder sb = new StringBuilder();
        Encryption encrypter = new Caesar3Encryption();

        String encryptedUser = encrypter.encrypt(user);
        String encryptedPassword = encrypter.encrypt(password);

        sb.append(encryptedUser)
                .append(":")
                .append(encryptedPassword);

        return sb.toString();
    }
}
