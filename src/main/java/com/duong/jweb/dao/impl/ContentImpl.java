package com.duong.jweb.dao.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.duong.jweb.dao.ContenDao;
import com.duong.jweb.entities.Content;
import com.duong.jweb.utils.HibernateUtils;

public class ContentImpl implements ContenDao {


	@Override
	public boolean saveContent(Content content) {
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateUtils.openSession();
			tx = session.beginTransaction();
			Integer id = (Integer) session.save(content);
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
	public boolean updateContent(Content content) {
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateUtils.openSession();
			tx = session.beginTransaction();
			session.update(content);
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
	public boolean deleteContent(Content content) {
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateUtils.openSession();
			tx = session.beginTransaction();
			session.update(content);
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
	public Set<Content> getAllContent() {
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateUtils.openSession();
			tx = session.beginTransaction();
			String sql = "select c from Content c";
			Query<Content> query = session.createQuery(sql, Content.class);
			List<Content> list = query.getResultList();
			tx.commit();
			return new HashSet<>(list);
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}finally {
			HibernateUtils.closeSession(session);
		}
		return null;
	}

	@Override
	public Set<Content> getContentByAuthorId(int id) {
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateUtils.openSession();
			tx = session.beginTransaction();
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Content> query = builder.createQuery(Content.class);
			Root<Content> root = query.from(Content.class);
			query.select(root).where(builder.equal(root.get("member").get("id"), id));
			List<Content> list = session.createQuery(query).getResultList();
			tx.commit();
			return new HashSet<>(list);
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}finally {
			HibernateUtils.closeSession(session);
		}
		return null;
	}

}
