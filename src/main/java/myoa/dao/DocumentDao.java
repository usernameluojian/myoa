package myoa.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import myoa.entity.Document;

public interface DocumentDao {
	List<Document> getAllFolders();

	List<Document> getDocumentsByFolder(int folderId);

	List<Document> findlikename(int folderId, String name);
	
	public void save(Document entity);
	
	public Document findid(int id);
	
	public void update(Document entity);
	
	public void delete(Document entity);
}
