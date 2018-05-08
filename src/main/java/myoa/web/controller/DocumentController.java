package myoa.web.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import myoa.biz.DocumentBiz;
import myoa.biz.EmployeeBiz;
import myoa.entity.Document;

@Controller
public class DocumentController {

	@Autowired
	private EmployeeBiz eb;
	
	@Autowired
	private DocumentBiz documentBiz;
	
	@RequestMapping("/zTree")
	public String index() {
		return "zTree";
	}
	
	@RequestMapping("/DocmentSave")
	public String DocmentSave(Map<String,Object> model,int ParentId) {
		model.put("ParentId", ParentId);
		return "DocmentSave";
	}
	
	@RequestMapping(value="/Docmentadd",method=RequestMethod.POST)
	public String Docmentadd(HttpServletRequest request, HttpServletResponse response) throws FileUploadException, IOException {
					Document document = new Document();
				String savePath = request.getServletContext().getRealPath("/WEB-INF/File");
				File file = new File(savePath);
		        if (!file.exists() && !file.isDirectory()) {
		              System.out.println(savePath+"目录不存在，需要创建");
		              file.mkdir();
		        }
		        DiskFileItemFactory factory = new DiskFileItemFactory();
		        ServletFileUpload upload = new ServletFileUpload(factory);
		        upload.setHeaderEncoding("UTF-8"); 
		        if(!ServletFileUpload.isMultipartContent(request)){
				        return savePath;
		         }

		        List<FileItem> list = upload.parseRequest(request);
		        for(FileItem item : list){
		        	if(item.isFormField()){
		        		  String name = item.getFieldName();
		        		  String value = item.getString("UTF-8");
		        		  System.out.println(name + "=" + value);
		        		  if(name.equals("userid")) {
		        			  document.setEmployee(eb.findid(Integer.valueOf(value)));
		        		  }else if(name.equals("ParentId")){
		        			  document.setParentid(Integer.valueOf(value));
		        		  }
		        	}else {
		        		String filename = item.getName();
		        		if(filename!="") {
                        filename = filename.substring(filename.lastIndexOf("\\")+1);
                         InputStream in = item.getInputStream();
                         document.setType(filename.substring(filename.indexOf(".")+1,filename.length()));
		        		 document.setName(filename.substring(0,filename.indexOf(".")));
		        		 document.setFileurl(savePath+"\\"+filename);
                         FileOutputStream out = new FileOutputStream(savePath + "\\" + filename);
                         byte buffer[] = new byte[1024];
                         int len = 0;
                         while((len=in.read(buffer))>0){
                             out.write(buffer, 0, len);
                         }
                         try {
							in.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
                         out.close();
                         item.delete();
		        	}
		        	}
		        }
		        document.setCreatetime(new java.sql.Date(System.currentTimeMillis()));
		        System.out.println(document.getEmployee());
		        documentBiz.save(document);
		return "zTree";
	}
	@RequestMapping("/DownloadFile")
	public String DownloadFile(HttpServletRequest request, HttpServletResponse response,int id) throws IOException{			
					Document download = documentBiz.findid(id);
					String Filed = download.getFileurl();
					String fileName = Filed.substring(Filed.lastIndexOf("\\")+1);	
					fileName = new String(fileName.getBytes("iso8859-1"),"UTF-8");
					String realname = fileName.substring(fileName.indexOf("_")+1);
					File file = new File(Filed);
					response.setHeader("content-disposition", "attachment;filename=" + URLEncoder.encode(realname, "UTF-8"));
					FileInputStream in = new FileInputStream(Filed);
					OutputStream out = response.getOutputStream();
			         byte buffer[] = new byte[1024];
			         int len = 0;
			         while((len=in.read(buffer))>0){
			             out.write(buffer, 0, len);
			         }
			         in.close();
			         out.close();
					return "redirect:zTree";
		        
	}
	@RequestMapping("/deleteid")
	public String deleteid(int id){
		documentBiz.deletefolderId(id);
		return "redirect:zTree";
	}
}
