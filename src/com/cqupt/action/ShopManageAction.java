package com.cqupt.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.List;
import java.util.UUID;

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
import com.cqupt.domain.Order;
import com.cqupt.domain.Shop;
import com.cqupt.domain.Shopcategory;
import com.cqupt.domain.Usercomment;
import com.cqupt.service.GoodsService;
import com.cqupt.service.GoodscategoryService;
import com.cqupt.service.OrderService;
import com.cqupt.service.ShopService;
import com.cqupt.service.ShopcategoryService;
import com.cqupt.service.UsercommentService;
import com.opensymphony.xwork2.ActionContext;

/*
 * @author lsx
 */

@Namespace("/shopmanage")
@Results({ @Result(name = "success", location = "/pages/admin/Success.jsp"),
	       @Result(name = "adminList", location = "/pages/admin/UserList.jsp"),
	       @Result(name = "error", location = "/pages/admin/Error.jsp"),
	       
	       @Result(name = "orderlist", location = "/pages/shopmanage/order.jsp"),
	       @Result(name = "orderdelredirect", location="getorderlist", type="redirectAction"),
	       
	       @Result(name = "commentlist", location = "/pages/shopmanage/comment.jsp"),
	       @Result(name = "commentdelredirect", location="getcommentlist", type="redirectAction"),
	       
	       @Result(name = "goodslist", location = "/pages/shopmanage/goods.jsp"),
	       @Result(name = "goodsadd", location = "/pages/shopmanage/goodsadd.jsp"),
	       @Result(name = "goodsupdate", location = "/pages/shopmanage/goodsupdate.jsp"),
	       @Result(name = "goodslistredirect", location="getgoodslist", type="redirectAction"),
	       
	       /** 商家首页*/
	       @Result(name = "index", location = "/pages/shopmanage/shopindex.jsp"),
	       @Result(name = "shopindexupdate", location = "/pages/shopmanage/shopindexupdate.jsp"),
	       @Result(name = "shopindexupdateredirect", location="shopindexupdate", type="redirectAction"),
	       
	       @Result(name = "logout", location = "/pages/shopmanage/shoplogin.jsp")
        })
public class ShopManageAction extends BaseAction {

	public Goodscategory getGoodscategory() {
		return goodscategory;
	}

	public void setGoodscategory(Goodscategory goodscategory) {
		this.goodscategory = goodscategory;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -8498992573226219929L;
	
	Shop shop = new Shop();
	
	Usercomment usercomment = new Usercomment();
	
	Order order = new Order();
	
	Shopcategory shopcategory = new Shopcategory();
	Goodscategory goodscategory = new Goodscategory();
	
	ShopcategoryService shopcategoryService;
	
	List categorylist;
	
	PageBean pageBean = new PageBean();
	
	Goods goods = new Goods();
	
	ShopService shopService;
	
	GoodsService goodsService;
	
	OrderService orderService;
	
	UsercommentService usercommentService;
	
	GoodscategoryService goodscategoryService;
	
	boolean success;
	
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
	

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public OrderService getOrderService() {
		return orderService;
	}

	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}

	public Usercomment getUsercomment() {
		return usercomment;
	}

	public void setUsercomment(Usercomment usercomment) {
		this.usercomment = usercomment;
	}

	public UsercommentService getUsercommentService() {
		return usercommentService;
	}

	public void setUsercommentService(UsercommentService usercommentService) {
		this.usercommentService = usercommentService;
	}

	public GoodscategoryService getGoodscategoryService() {
		return goodscategoryService;
	}

	public void setGoodscategoryService(GoodscategoryService goodscategoryService) {
		this.goodscategoryService = goodscategoryService;
	}

	public GoodsService getGoodsService() {
		return goodsService;
	}

	public void setGoodsService(GoodsService goodsService) {
		this.goodsService = goodsService;
	}

	public PageBean getPageBean() {
		return pageBean;
	}

	public void setPageBean(PageBean pageBean) {
		this.pageBean = pageBean;
	}

	public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	public Shopcategory getShopcategory() {
		return shopcategory;
	}

	public ShopService getShopService() {
		return shopService;
	}

	public Shop getShop() {
		return shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}

	public void setShopService(ShopService shopService) {
		this.shopService = shopService;
	}

	public void setShopcategory(Shopcategory shopcategory) {
		this.shopcategory = shopcategory;
	}

	public ShopcategoryService getShopcategoryService() {
		return shopcategoryService;
	}

	public void setShopcategoryService(ShopcategoryService shopcategoryService) {
		this.shopcategoryService = shopcategoryService;
	}

	public List getCategorylist() {
		return categorylist;
	}

	public void setCategorylist(List categorylist) {
		this.categorylist = categorylist;
	}
	
	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public String getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}

	public String getFileContentType() {
		return fileContentType;
	}

	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}

	@Action("orderdel")
	public String orderdel(){
		int orderid = order.getOrderid();
		Order o = orderService.getOrder(orderid);
		if(o!=null)
		{
			orderService.delOrder(orderid);
			System.out.println("-------");
		}
		
		return "orderdelredirect";
	}
	
	@Action("getorderlist")
	public String getorderlist(){
		pageBean.setPageSize(10);
		pageBean = orderService.queryOrderByPage(order, pageBean);
		return "orderlist";
	}
	
	
	@Action("commentchangestate")
	public String commentchangestate(){
		int commentid = usercomment.getUsercommentid();
		Usercomment uc = usercommentService.getUsercomment(commentid);
		if(uc.getState()==1)
		{
			uc.setState(0);
			Usercomment uc2= usercommentService.updateUsercomment(uc);
			System.out.println(uc2.getContent()+"----------------------"+uc2.getState());
		}
		else
		{
			uc.setState(1);
			usercommentService.updateUsercomment(uc);
		}
		
		return "commentdelredirect";
	}
	
	@Action("commentdel")
	public String commentdel(){
		int commentid = usercomment.getUsercommentid();
		Usercomment uc = usercommentService.getUsercomment(commentid);
		if(uc != null)
		{
			usercommentService.delUsercomment(commentid);
		}
		
		return "commentdelredirect";
	}
	
	
	@Action("getcommentlist")
	public String getcommentlist(){
		pageBean.setPageSize(10);
		pageBean = usercommentService.queryUsercommentByPage(usercomment, pageBean);
		usercomment = (Usercomment) pageBean.getList().get(0);
		System.out.println(usercomment.getUser().getUsername()+"---------------------");
		return "commentlist";
	}
	
	
	@Action("goodsupdateoperate")
	public String goodsupdateoperate(){
		Goods g = new Goods();
		int shopid = (Integer) ActionContext.getContext().getSession().get("shopid");
		Shop shop = shopService.getShop(shopid);
		g = goodsService.getGoods(goods.getGoodsid());
		g.setGoodscateogry(goodscategory);
		g.setShop(shop);
		g.setGoodscateogry(goods.getGoodscateogry());
		g.setGoodsname(goods.getGoodsname());
		g.setSales(goods.getSales());
		g.setPrice(goods.getPrice());
		g.setIntroduc(goods.getIntroduc());
		g.setState(0);
		g.setCreatetime(new Date());
		goodsService.updateGoods(g);
		return "goodsupdate";
	}
	
	@Action("goodsdel")
	public String goodsdel(){
		int id = goods.getGoodsid();
		Goods g = goodsService.getGoods(id);
		if(g != null){
			goodsService.delGoods(id);
		}
		return "goodslistredirect";
	}
	
	@Action("goodsupdate")
	public String goodsupdate(){
		int id = goods.getGoodsid();
		goods = goodsService.getGoods(id);
		Goodscategory category = new Goodscategory();
		categorylist = goodscategoryService.queryGoodsCategory(category);
		return "goodsupdate";
	}
	
	@Action("goodsaddop")
	public String goodsaddop() throws Exception{
		int shopid = (Integer) ActionContext.getContext().getSession().get("shopid");
		Shop shop = shopService.getShop(shopid);
		
		/**
		 * 文件保存路径
		 */
		String root = ServletActionContext.getServletContext().getRealPath(
				GlobalConst.UPLOADPATH);
		// 保存文件名,避免文件名重复
		fileFileName = UUID.randomUUID() + fileFileName;

		InputStream is = new FileInputStream(file);

		OutputStream os = new FileOutputStream(new File(root, fileFileName));

		byte[] buffer = new byte[500];
		int length = 0;

		while ((length = is.read(buffer, 0, buffer.length)) != -1) {
			os.write(buffer, 0, length);
		}

		os.close();
		is.close();
		
		success = false;
		Goods g = new Goods();
		g.setShop(shop);
		g.setGoodscateogry(goodscategory);
		g.setGoodsname(goods.getGoodsname());
		g.setSales(goods.getSales());
		g.setPrice(goods.getPrice());
		g.setPhoto("http://localhost:8080/wsdc/resources/upload/"+fileFileName);
		g.setIntroduc(goods.getIntroduc());
		g.setState(0);
		g.setCreatetime(new Date());
		
		Goods g2 = goodsService.saveGoods(g);
		
		if(g2 != null){
			success = true;
		}
		
		return "goodslistredirect";
	}

	/*@Action("goodtest")
	public String goodtest(){
		System.out.println("goodsoperate--------------------");
		int shopid = (int) ActionContext.getContext().getSession().get("shopid");
		success = false;
		Shop shop = shopService.getShop(shopid);
		System.out.println(shop.getIntroduc());
		Goods g = new Goods();	
		g.setShop(shop);
		g.setGoodscateogry(goods.getGoodscateogry());
		g.setGoodsname(goods.getGoodsname());
		g.setSales(goods.getSales());
		g.setPrice(goods.getPrice());
		g.setPhoto(goods.getPhoto());
		g.setIntroduc(goods.getIntroduc());
		g.setState(0);
		g.setCreatetime(new Date());
		
		Goods g2 = goodsService.saveGoods(g);
		System.out.println(g2);
		if(g2 != null){
			success = true;
		}
		//return "goodslistredirect";
		return null;
	}*/
	
	@Action("goodsadd")
	public String goodsadd(){
		Goodscategory category = new Goodscategory();
		categorylist = goodscategoryService.queryGoodsCategory(category);
		return "goodsadd";
	}
	
	@Action("getgoodslist")
	public String getgoodslist(){
		pageBean.setPageSize(10);
		pageBean = goodsService.queryGoodsByPage(goods, pageBean);
		return "goodslist";
	}
	
	
	@Action("index")
	public String index(){
		int shopid = (Integer) ActionContext.getContext().getSession().get("shopid");
		shop = shopService.getShop(shopid);
		return "index";
	}
	
	@Action("shopindexupdate")
	public String shopindexupdate(){
		int shopid = (Integer) ActionContext.getContext().getSession().get("shopid");
		Shopcategory category = new Shopcategory();
		categorylist = shopcategoryService.queryShopcategory(category);
		shop = shopService.getShop(shopid);
		return "shopindexupdate";
	}
	
	@Action("shopindexupdateoperate")
	public String shopindexupdateoperate(){
		Shop s = new Shop();
		s = shopService.getShop(shop.getShopid());
		s.setShopcategory(shopcategory);
		s.setShopname(shop.getShopname());
		s.setShopaddress(shop.getShopaddress());
		s.setTel(shop.getTel());
		//s.setRank(shop.getRank());
		s.setIntroduc(shop.getIntroduc());
		//s.setPhoto(shop.getPhoto());
		//s.setState(shop.getState());
		s.setCreatetime(new Date());
		
		Shopcategory category = new Shopcategory();
		categorylist = shopcategoryService.queryShopcategory(category);
		shopService.updateShop(s);
		return "shopindexupdateredirect";
	}
	
	@Action("logout")
	public String logout(){
		ActionContext.getContext().getSession().remove("shopid");
		return "logout";
	}
	
	
	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

}
