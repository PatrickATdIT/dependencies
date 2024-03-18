package de.hwglu.atdit_2024;

public class SecureCredentialStringBuilderImplementation implements CredentialStringBuilder {
    private final Encryption encryptor;

    public SecureCredentialStringBuilderImplementation(Encryption encryptor) {
        this.encryptor = encryptor;
    }

    @Override
    public String makeCredentialString(String user, String password) {
        StringBuilder sb = new StringBuilder();

        String encryptedUser = encryptor.encrypt(user);
        String encryptedPassword = encryptor.encrypt(password);

        sb.append(encryptedUser)
                .append(":")
                .append(encryptedPassword);

        return sb.toString();
    }
}
