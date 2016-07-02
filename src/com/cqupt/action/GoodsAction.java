/*
 *@Project: framework 
 *@Package: com.cqupt.action 
 *@File: GoodsAction.java 
 *@Date: 2015-12-11 
 *@author: chenyongzheng
 *@Copyright: V1.0 www.cqupt.edu.cn Inc. All rights reserved. 
 *@Description: 本内容仅限于公司内部传阅，禁止外泄以及用于其他的商业目的 
 */
package com.cqupt.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.cqupt.common.BaseAction;
import com.cqupt.common.GlobalConst;
import com.cqupt.common.PageBean;
import com.cqupt.domain.Goods;
import com.cqupt.domain.Goodscategory;
import com.cqupt.domain.Shop;
import com.cqupt.service.GoodsService;

/**
 * 
 * @Description: 前台商品模块
 * @author lsx
 * @since 2015-12-11
 * @see com.cqupt.common.BaseAction
 * 
 */
@Namespace("/goods")
@Results({ @Result(name = "goodslist", location = "/pages/goodslist.jsp")
        })
public class GoodsAction extends BaseAction {
	/**
	 * @Fields serialVersionUID
	 */
	private static final long serialVersionUID = 5572405848705072190L;
	
	
	Goods goods = new Goods();
	
	Shop shop = new Shop();
	
	int shid;
	
	GoodsService goodsService;
	
	Goodscategory goodscategory = new Goodscategory();
	
	static Logger logger = LogManager.getLogger(GoodsAction.class.getName());
	/**
	 * 文件对象
	 */
	private File file;
 
	/**
	 * 提交过来的file的名字
	 */
	private String fileFileName;

	/**
	 * 提交过来的file的MIME类型
	 */
	private String fileContentType;
    /**
     * 分页
     */
	PageBean pageBean = new PageBean();
	
	

	@Action("queryGoodsByPage")
	public String queryGoodsByPage(){
		if(shop.getShopid() != null){
			shop.setShopid(shop.getShopid());
			goods.setShop(shop);
			shid = shop.getShopid();
		}
		System.out.println(goodscategory.getGoodscategoryid()+"------------------------------------");
		if(goodscategory.getGoodscategoryid()!=null){
			goods.setGoodscateogry(goodscategory);
		}
		goods.setState(1);
		pageBean.setPageSize(20);
		pageBean = goodsService.queryGoodsByPage(goods, pageBean);
		return "goodslist";
	}
	
	




	/**
	 * 
	 * @Title: register
	 * @Description: 用户注册
	 * @return String 返回注册成功/失败地址
	 * @throws Exception
	 *             注册异常
	 */

	@Action("register")
	public String register() {

		try {
			logger.debug("用户注册开始...");
			/**
			 * 文件保存路径
			 */
			String root = ServletActionContext.getServletContext().getRealPath(
					GlobalConst.UPLOADPATH);
			// 保存文件名,避免文件名重复
			fileFileName = UUID.randomUUID() + fileFileName;

			InputStream is = new FileInputStream(file);

			OutputStream os = new FileOutputStream(new File(root, fileFileName));

			logger.debug("文件临时文件保存路径: " + file.getPath());

			logger.debug("上传保存文件名: " + fileFileName);

			byte[] buffer = new byte[500];
			int length = 0;

			while ((length = is.read(buffer, 0, buffer.length)) != -1) {
				os.write(buffer, 0, length);
			}

			os.close();
			is.close();

			goods.setPhoto(fileFileName);
			// 调用业务处理类进行注册业务处理
			Goods u = goodsService.saveGoods(goods);
			logger.debug(u.getGoodsname() + "用户注册成功...");

			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			logger.debug("用户注册异常...");
			addFieldError("error", "用戶主注册异常,请联系管理员!");
			return "error";

		}

	}

	



	/**
	 * @return the file
	 */
	public File getFile() {
		return file;
	}

	/**
	 * @param file
	 *            the file to set
	 */
	public void setFile(File file) {
		this.file = file;
	}

	/**
	 * @return the fileFileName
	 */
	public String getFileFileName() {
		return fileFileName;
	}

	



	/**
	 * @param fileFileName
	 *            the fileFileName to set
	 */
	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}

	/**
	 * @return the fileContentType
	 */
	public String getFileContentType() {
		return fileContentType;
	}

	/**
	 * @param fileContentType
	 *            the fileContentType to set
	 */
	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}

	/**
	 * @return the goods
	 */
	public Goods getGoods() {
		return goods;
	}

	/**
	 * @param goods
	 *            the goods to set
	 */
	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	/**
	 * @param goodsService
	 *            the goodsService to set
	 */
	public void setGoodsService(GoodsService goodsService) {
		this.goodsService = goodsService;
	}



	public PageBean getPageBean() {
		return pageBean;
	}



	public void setPageBean(PageBean pageBean) {
		this.pageBean = pageBean;
	}

	public Shop getShop() {
		return shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}


	public Goodscategory getGoodscategory() {
		return goodscategory;
	}


	public void setGoodscategory(Goodscategory goodscategory) {
		this.goodscategory = goodscategory;
	}

	public int getShid() {
		return shid;
	}

	public void setShid(int shid) {
		this.shid = shid;
	}
	
	

}
