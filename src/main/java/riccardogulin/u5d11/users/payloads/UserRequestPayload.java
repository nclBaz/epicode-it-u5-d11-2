package riccardogulin.u5d11.users.payloads;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserRequestPayload {
	@NotNull(message = "Il nome è obbligatorio")
	@Size(min = 3, max = 30, message = "Nome deve avere minimo 3 caratteri, massimo 30")
	private String name;
	@NotNull(message = "Il cognome è obbligatorio")
	private String surname;
	@NotNull(message = "L'email è obbligatoria")
	@Email(message = "L'email inserita non è un indirizzo valido")
	private String email;
	@NotNull(message = "La password è obbligatoria")
	private String password;
	@NotNull(message = "La carta di credito è obbligatoria")
	private String creditCard;
}
