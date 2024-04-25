package com.tobeto.dto.employee;

import lombok.Data;

@Data
public class EditAdminPasswordRequestDTO {
	private String newPassword;
	private String email;
}
