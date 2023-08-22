package riccardogulin.u5d11.exceptions;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class ErrorsPayloadWithList {
	private String message;
	private Date timestamp;
	private int internalCode;
	private List<String> errorsList;
}
