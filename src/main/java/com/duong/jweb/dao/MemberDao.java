package com.duong.jweb.dao;

import java.util.Set;

import com.duong.jweb.entities.Member;

public interface MemberDao {

	public Member getMember(String email, String password);
	public Set<Member> getAll();
	public Member getMember(int id);
	public boolean saveMember(Member member);
	public boolean updateMember(Member member);
	public boolean deleteMember(Member member);
}
