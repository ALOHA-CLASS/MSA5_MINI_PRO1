package users.model;

import java.util.Date;

import lombok.Data;

@Data
public class Users {
	private String id;
    private String username;
    private String password;
    private String name;
    private String email;
    private Date regDate;
    private Date updDate;
}
