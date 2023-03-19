package com.duong.jweb.dao.impl;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.regex.Pattern;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.duong.jweb.dao.MemberDao;
import com.duong.jweb.entities.Member;
import com.duong.jweb.utils.HibernateUtils;

public class MemberImpl implements MemberDao {

	@Override
	public Member getMember(String email, String password) {
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateUtils.openSession();
			tx = session.beginTransaction();
			String sql = "Select m From Member m Where m.email = :email";
			Query<Member> query = session.createQuery(sql, Member.class);
			query.setParameter("email", email);
			//query.uniqueResult tra ve null neu khong tim thay ket qua
			//query.getSingleResult se ban ra exception neu khong tim thay ket qua
			Member member = query.uniqueResult();
			tx.commit();
			if(member != null && member.getPassword().equals(password))
				return member;
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}finally {
			HibernateUtils.closeSession(session);
		}
		return null;
	}

	@Override
	public Set<Member> getAll() {
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateUtils.openSession();
			tx = session.beginTransaction();
			CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
			CriteriaQuery<Member> query = criteriaBuilder.createQuery(Member.class);
			Root<Member> root = query.from(Member.class);
			query.select(root);
			List<Member> list = session.createQuery(query).getResultList();
			Set<Member> set = new HashSet<>(list);
			return set;
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}finally {
			HibernateUtils.closeSession(session);
		}
		return null;
	}

	@Override
	public Member getMember(int id) {
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateUtils.openSession();
			tx = session.beginTransaction();
			String sql = "Select m From Member m Where m.id = :id";
			Query<Member> query = session.createQuery(sql, Member.class);
			query.setParameter("id", id);
			Member member = query.getSingleResult();
			//lay ra list content cua member nay
			member.getContents().size();
			tx.commit();
			return member;
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}finally {
			HibernateUtils.closeSession(session);
		}
		return null;
	}

	@Override
	public boolean saveMember(Member member) {
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateUtils.openSession();
			tx = session.beginTransaction();
			Integer id = (Integer) session.save(member);
			tx.commit();
			if(id > 0)
				return true;
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}finally {
			HibernateUtils.closeSession(session);
		}
		return false;
	}

	@Override
	public boolean updateMember(Member member) {
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateUtils.openSession();
			tx = session.beginTransaction();
			session.update(member);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
			return false;
		}finally {
			HibernateUtils.closeSession(session);
		}
		return true;
	}

	@Override
	public boolean deleteMember(Member member) {
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateUtils.openSession();
			tx = session.beginTransaction();
			session.update(member);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
			return false;
		}finally {
			HibernateUtils.closeSession(session);
		}
		return true;
	}
	
	

}
