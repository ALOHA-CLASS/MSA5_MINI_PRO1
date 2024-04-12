package lombok.DTO;

import java.util.Date;

import lombok.Data;

//@NoArgsConstructor
//@AllArgsConstructor
//@Getter
//@Setter
//@ToString
@Data
public class User {
	
	private String id;
	private String username;
	private String password;
	private Date regDate;
	private Date updDate;
	
}
