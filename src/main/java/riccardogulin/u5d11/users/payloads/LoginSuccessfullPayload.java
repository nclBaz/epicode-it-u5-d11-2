package riccardogulin.u5d11.users.payloads;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class LoginSuccessfullPayload {
	String accessToken;
}
