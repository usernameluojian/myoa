package myoa.dao;

import java.util.List;

import myoa.entity.Document;

public interface DocumentDao {
	public List<Document> findParentId(int ParentId);
}
