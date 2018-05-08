package myoa.biz;

import java.util.List;

import myoa.entity.Document;

public interface DocumentBiz {
	List<Document> getAllFoldersInLevel();
	List<Document> getDocumentsByFolder(int folderId);
	List<Document> findlikename(int folderId, String name);
	public void save(Document entity);
	public Document findid(int id);
	public void deletefolderId(int folderId);
	public void update(Document entity);
	public void delete(Document entity);
}
