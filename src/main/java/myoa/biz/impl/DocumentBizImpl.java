package myoa.biz.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import myoa.biz.DocumentBiz;
import myoa.dao.DocumentDao;
import myoa.entity.Document;

@Service
public class DocumentBizImpl implements DocumentBiz {

	@Autowired
	private DocumentDao dd;

//	public static void main(String[] args) {
//		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-beans.xml");
//		DocumentBiz d = ctx.getBean(DocumentBiz.class);
//	}
	
	@Override
	public List<Document> getAllFoldersInLevel() {
		List<Document> list = dd.getAllFolders();
		return assembleFolders(list, 0);
	}
	
	private List<Document> assembleFolders(List<Document> folders, int parentId) {
		List<Document> currentLevel = new ArrayList<>();
		for(Document f : folders) {
			if(f.getParentid()==parentId) {
				currentLevel.add(f);
				List<Document> subLevel = assembleFolders(folders, f.getId());
				f.setChildren(subLevel);
			}
		}
		return currentLevel;
	}
	
	public void deletefolderId(int folderId) {
		List<Document> list = dd.getDocumentsByFolder(folderId);
		Document document = dd.findid(folderId);
		dd.delete(document);
		for(Document f : list) {
			System.out.println(f.getId());
			deletefolderId(f.getId());
		}
	}

	@Override
	public List<Document> getDocumentsByFolder(int folderId) {
		return dd.getDocumentsByFolder(folderId);
	}

	@Override
	public List<Document> findlikename(int folderId, String name) {
		// TODO Auto-generated method stub
		return dd.findlikename(folderId, name);
	}

	@Override
	public void save(Document entity) {
		// TODO Auto-generated method stub
		dd.save(entity);
	}

	@Override
	public Document findid(int id) {
		// TODO Auto-generated method stub
		return dd.findid(id);
	}

	@Override
	public void update(Document entity) {
		// TODO Auto-generated method stub
		dd.update(entity);
	}

	@Override
	public void delete(Document entity) {
		// TODO Auto-generated method stub
		dd.delete(entity);
	}

}
