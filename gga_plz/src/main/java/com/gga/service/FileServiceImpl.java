package com.gga.service;

import java.io.File;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.gga.vo.BoardVo;
import com.gga.vo.ProductVo;

@Service("fileService")
public class FileServiceImpl {	
	/**
	 * multiFileCheck = 멀티파일 저장 기능
	 * @throws IOException 
	 * @throws IllegalStateException 
	 */
	/*
	public void multiFileCheck(ProductOrderVo productOrderVo, HttpServletRequest request) throws IllegalStateException, IOException {
		String root_path = request.getSession().getServletContext().getRealPath("/");
		String attach_path = "\\resources\\upload\\";
		int count = 0;
		for(CommonsMultipartFile file : productOrderVo.getFiles()) {
			if(file.getOriginalFilename() != null && !file.getOriginalFilename().equals("")) {
				File saveFile = new File(root_path + attach_path+ productOrderVo.getPsfiles().get(count));
				file.transferTo(saveFile);
			}
			count++;
		}
	}
	public NoticeVo multiFileCheck(ProductOrderVo productOrderVo) {
		
		for(CommonsMultipartFile file : productOrderVo.getFiles()) {
			if(!file.getOriginalFilename().equals("")) {
				UUID uuid = UUID.randomUUID();
				productOrderVo.getNfiles().add(file.getOriginalFilename());
				productOrderVo.getNsfiles().add(uuid+"_"+file.getOriginalFilename());
			} else {
				productOrderVo.getNfiles().add("");
				productOrderVo.getNsfiles().add("");
			}
		}
		
		productOrderVo.setNfile1(productOrderVo.getNfiles().get(0));
		productOrderVo.setNsfile1(productOrderVo.getNsfiles().get(0));
		productOrderVo.setNfile2(productOrderVo.getNfiles().get(1));
		productOrderVo.setNsfile2(productOrderVo.getNsfiles().get(1));
		
		
		return productOrderVo;
	}
	*/
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
System.out.println(root_path + attach_path+ oldFileName);			
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
