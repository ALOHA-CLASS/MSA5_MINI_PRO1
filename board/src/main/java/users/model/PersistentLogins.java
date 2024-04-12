package users.model;

import java.util.Date;

import lombok.Data;

@Data
public class PersistentLogins {
	
	private String id;
    private String usersId;
    private String username;
    private String token;
    private Date regDate;
    private Date updDate;
	

}
