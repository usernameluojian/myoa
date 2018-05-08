package myoa.web.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

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

import myoa.biz.EmployeeBiz;
import myoa.biz.MessageBiz;
import myoa.biz.MessageReceptionBiz;
import myoa.biz.MessageattachmentBiz;
import myoa.entity.Document;
import myoa.entity.Message;
import myoa.entity.MessageReception;
import myoa.entity.Messageattachment;

@Controller
public class MessageSaveController {
	
	@Autowired
	private EmployeeBiz eb;
	
	@Autowired
	private MessageBiz mb;
	
	@Autowired
	private MessageattachmentBiz mtb;
	
	@Autowired
	private MessageReceptionBiz mrb;
	
	@RequestMapping(value="/messagesave",method=RequestMethod.GET)
	public String messagesave() {
		return "messagesave";
	}
	
	@RequestMapping(value="/messageadd",method=RequestMethod.POST)
	public String Docmentadd(HttpServletRequest request, HttpServletResponse response) throws FileUploadException, IOException {
				boolean bool = false;
				Message message = new Message();
				Messageattachment ma = new Messageattachment();
				List<Integer> listinteger = new ArrayList<>();
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
		        		  if(name.equals("CreatorId")) {
		        			  message.setEmployee(eb.findid(Integer.valueOf(value)));
		        		  }else if(name.equals("IsSent")){
		        			  if(value.equals("0")) {
		        				  message.setIssent(false);
		        			  }else {
		        				  message.setIssent(true);
		        			  }
		        		  }else if(name.equals("EmployeeId")){
		        			  listinteger.add(Integer.valueOf(value));
		        		  }else if(name.equals("Employeename")){
		        			  message.setReceivers(message.getReceivers()+","+value);
		        		  }else if(name.equals("Title")){
		        			  message.setTitle(value);
		        		  }else if(name.equals("Level")){
		        			  message.setLevel(Integer.valueOf(value));
		        		  }else if(name.equals("Content")){
		        			  message.setContent(value);
		        		  }
		        		  
		        	}else {
		        		String filename = item.getName();
		        		if(!filename.equals("")) {
		        			bool = true;
			        		System.out.println("文件名："+filename);
                        filename = filename.substring(filename.lastIndexOf("\\")+1);
                         InputStream in = item.getInputStream();
                         ma.setFileurl(savePath+"\\"+filename);
                         ma.setName(filename);
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
		        message.setSendtime(new java.sql.Date(System.currentTimeMillis()));
		        message.setReceivers(message.getReceivers().substring(5,message.getReceivers().length()));
		        mb.Add(message);
		        if(bool) {
		        	ma.setMessageid(mb.finddescone().getId());
		        	mtb.Add(ma);
		        }
		        for (Integer integer : listinteger) {
		        	MessageReception mrp = new MessageReception();
		        	mrp.setIsread(true);
		        	mrp.setMessageid(mb.finddescone().getId());
		        	mrp.setReceiverid(integer);
		        	mrp.setStatus(0);
		        	mrb.Add(mrp);
				}
		return "redirect:messageInbox";
	}
}
