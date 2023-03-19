package com.duong.jweb.services;

import java.util.regex.Pattern;

import com.duong.jweb.dao.MemberDao;
import com.duong.jweb.dao.impl.MemberImpl;
import com.duong.jweb.entities.Member;
import com.duong.jweb.utils.ConstraintUtils;

public class MemberService {
	
	private MemberDao dao;
	
	public MemberService() {
		// TODO Auto-generated constructor stub
		dao = new MemberImpl();
	}

	private boolean validate(String userName, String email, String password, String rePassword) {
		if(userName == null || userName.isEmpty() || email == null
				|| email.isEmpty() || password == null || password.isEmpty() || rePassword == null || rePassword.isEmpty()) {
			return false;
		}
		if(!password.equals(rePassword))
			return false;
		String emailPattern = "^[A-Za-z0-9+_.-]+@(.+)$";
		boolean checkEmail = Pattern.compile(emailPattern).matcher(email).matches();
		if(!checkEmail)
			return false;
		return true;
	}
	
	
	public int addMember(String userName, String email, String password, String rePassword) {
		boolean validate = this.validate(userName, email, password, rePassword);
		if(validate) {
			Member member = new Member(userName, password, email);
			boolean save = dao.saveMember(member);
			if(save)
				return ConstraintUtils.SUCCESS;
			else
				return ConstraintUtils.NOT_SUCCESS;
		}else {
			return ConstraintUtils.DATA_INVALID;
		}
	}
}
