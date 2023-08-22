package riccardogulin.u5d11.users;

import java.security.Key;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.stereotype.Component;

import jakarta.persistence.AttributeConverter;

@Component
public class CreditCardConverter implements AttributeConverter<String, String> {

	private static final String secret = "mysup3rs3cr3tttt";

	@Override
	public String convertToDatabaseColumn(String datoDaCifrare) {
		try {
			Key key = new SecretKeySpec(secret.getBytes(), "AES");
			Cipher c = Cipher.getInstance("AES/ECB/PKCS5Padding");

			c.init(Cipher.ENCRYPT_MODE, key);

			return Base64.getEncoder().encodeToString(c.doFinal(datoDaCifrare.getBytes()));
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	@Override
	public String convertToEntityAttribute(String encryptedCreditCard) {
		try {
			Key key = new SecretKeySpec(secret.getBytes(), "AES");

			Cipher c = Cipher.getInstance("AES/ECB/PKCS5Padding");
			c.init(Cipher.DECRYPT_MODE, key);
			return new String(c.doFinal(Base64.getDecoder().decode(encryptedCreditCard)));
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}

}


