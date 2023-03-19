package com.duong.jweb.dao;

import java.util.Set;

import org.hibernate.Session;

import com.duong.jweb.entities.Content;

public interface ContenDao {

	public boolean saveContent(Content content);
	public boolean updateContent(Content content);
	public boolean deleteContent(Content content);
	public Set<Content> getAllContent();
	public Set<Content> getContentByAuthorId(int id);
}
