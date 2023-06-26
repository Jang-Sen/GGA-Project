package com.gga.service;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.gga.vo.BoardVo;
import com.gga.vo.MovieVo;
import com.gga.vo.NoticeVo;
import com.gga.vo.ProductOrderVo;
import com.gga.vo.ProductVo;

@Service("fileService")
public class FileServiceImpl {	
	/**
	 * multiFileCheck = 멀티파일 저장 기능
	 * @throws IOException 
	 * @throws IllegalStateException 
	 */
	
	public void multiFileCheck(MovieVo movieVo, HttpServletRequest request) throws IllegalStateException, IOException {
		String root_path = request.getSession().getServletContext().getRealPath("/");
		String attach_path = "\\resources\\upload\\";
		int count = 0;
		for(CommonsMultipartFile file : movieVo.getFiles()) {
			if(file.getOriginalFilename() != null && !file.getOriginalFilename().equals("")) {
				File saveFile = new File(root_path + attach_path+ movieVo.getMsfiles().get(count));
				file.transferTo(saveFile);
			}
			count++;
		}
	}
	public MovieVo multiFileCheck(MovieVo movieVo) {
		
		for(CommonsMultipartFile file : movieVo.getFiles()) {
			if(!file.getOriginalFilename().equals("")) {
				UUID uuid = UUID.randomUUID();
				movieVo.getMfiles().add(file.getOriginalFilename());
				movieVo.getMsfiles().add(uuid+"_"+file.getOriginalFilename());
			} else {
				movieVo.getMfiles().add("");
				movieVo.getMsfiles().add("");
			}
		}
		
		movieVo.setMainposter(movieVo.getMfiles().get(0));
		movieVo.setSmainposter(movieVo.getMsfiles().get(0));
		movieVo.setStillcut1(movieVo.getMfiles().get(1));
		movieVo.setSstillcut1(movieVo.getMsfiles().get(1));
		movieVo.setStillcut2(movieVo.getMfiles().get(2));
		movieVo.setSstillcut2(movieVo.getMsfiles().get(2));
		movieVo.setStillcut3(movieVo.getMfiles().get(3));
		movieVo.setSstillcut3(movieVo.getMsfiles().get(3));
		movieVo.setStillcut4(movieVo.getMfiles().get(4));
		movieVo.setSstillcut4(movieVo.getMsfiles().get(4));
		
		
		return movieVo;
	}
	
	/**
	 * fileDelete ��� - ���� ���� 
	 */
	public void fileDelete(HttpServletRequest request, String oldFileName) 
														throws Exception{
		//������ ������ġ
		String root_path = request.getSession().getServletContext().getRealPath("/");
		String attach_path = "\\resources\\upload\\";
		
		//������ �����ϸ� ������ ����
		if(oldFileName != null &&  !oldFileName.equals("")) { //���ο� ���� ����
			File deleteFile = new File(root_path + attach_path+ oldFileName);
			if(deleteFile.exists()) {
				deleteFile.delete();
			}
		}
	}
	
	
	/**
	 * fileDelete ��� - ���� ���� 
	 */
	public void fileDelete(BoardVo boardVo, HttpServletRequest request, String oldFileName) 
														throws Exception{
		//������ ������ġ
		String root_path = request.getSession().getServletContext().getRealPath("/");
		String attach_path = "\\resources\\upload\\";
		
		//������ �����ϸ� ������ ����
		if(!boardVo.getFile1().getOriginalFilename().equals("")) { //���ο� ���� ����
			File deleteFile = new File(root_path + attach_path+ oldFileName);
System.out.println(root_path + attach_path+ oldFileName);			
			if(deleteFile.exists()) {
				deleteFile.delete();
			}
		}
	}
	
	
	/**
	 * fileSave ��� - ������ �����ϸ� ������ �����ϴ� �޼ҵ�
	 */
	public void fileSave(ProductVo productVo, HttpServletRequest request) 
														throws Exception{
		//������ ������ġ
		String root_path = request.getSession().getServletContext().getRealPath("/");
		String attach_path = "\\resources\\upload\\";
		//������ �����ϸ� ������ ����
		if(productVo.getPfile() != null && !productVo.getPfile().equals("")) {
System.out.println("save file--->" + productVo.getPfile());			
			File saveFile = new File(root_path + attach_path+ productVo.getPsfile());
			productVo.getFile1().transferTo(saveFile);
		}
	}
	
	
	/**
	 * fileCheck ��� - ������ �����ϸ�  boardVo�� bfile, bsfile set!, ������ boardVo ����!
	 */
	public ProductVo fileCheck(ProductVo productVo) {
		if(productVo.getFile1().getOriginalFilename() != null
				&& !productVo.getFile1().getOriginalFilename().equals("")) {
			
			UUID uuid = UUID.randomUUID();
			String Pfile = productVo.getFile1().getOriginalFilename();
			String Psfile = uuid + "_" + Pfile;
			
			productVo.setPfile(Pfile);
			productVo.setPsfile(Psfile);
		}else {
			System.out.println("���� ����");
		}	
		
		return productVo;
	}
	
	
}
