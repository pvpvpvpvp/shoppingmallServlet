package com.conan.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestEvent;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.apache.tomcat.util.http.fileupload.servlet.ServletRequestContext;

import com.conan.dao.ProductDAO;
import com.conan.vo.ProductsVO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;


/**
 * Servlet implementation class ProductController
 */
@WebServlet("*.action")
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			actionDo(request, response);
		} catch (ServletException | IOException | SQLException | NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
public void actionDo(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException, SQLException, NamingException {
	
		String path = request.getRealPath("/upload");
		int size = 1024*1024*10; //10M
	
		String url = request.getRequestURI(); 
		String ctxPath = request.getContextPath();
		String cmd = url.substring(ctxPath.length());
		RequestDispatcher rd = null;
		// ProductContent
		if(cmd.equals("/product/select.action")) {
			ProductDAO dao = ProductDAO.getInstance();
			ProductsVO vo = dao.selectProduct(request.getParameter("proId"));
			request.setAttribute("product", vo);
			rd = getServletContext().getRequestDispatcher("/product/productview/productContentPage.jsp");	
		}
		// ProductAllList
		if(cmd.equals("/product/selectAll.action")) {
			ProductDAO dao = ProductDAO.getInstance();
			ArrayList<ProductsVO> arrayList = dao.selectProductAll();
			request.setAttribute("products", arrayList);
			rd = getServletContext().getRequestDispatcher("/product/productview/productListPage.jsp");	
		}
		if(cmd.equals("/product/cartDelete.action")) {
			HttpSession session = request.getSession(true);
			String proId = request.getParameter("proId");
			ArrayList<ProductsVO> cartList = (ArrayList<ProductsVO>)session.getAttribute("cartList");
			ProductsVO vo = new ProductsVO();
			for (int i = 0; i < cartList.size(); i++) {
				vo = cartList.get(i);
				if (vo.getProId().equals(proId)) {
					cartList.remove(vo);
				}
			}
			rd = getServletContext().getRequestDispatcher("/cart/cartview/cartPage.jsp");	
		}
		if(cmd.equals("/product/cartDeleteAll.action")) {
			HttpSession session = request.getSession(true);
			ArrayList<ProductsVO> cartList = (ArrayList<ProductsVO>)session.getAttribute("cartList");
			cartList.removeAll(cartList);
			rd = getServletContext().getRequestDispatcher("/cart/cartview/cartPage.jsp");	
		}
		if(cmd.equals("/product/cartListAll.action")) {
			rd = getServletContext().getRequestDispatcher("/cart/cartview/cartPage.jsp");	
		}
		// ProductAllList
		if(cmd.equals("/product/cartAdd.action")) {
			HttpSession session = request.getSession(true);
			ProductDAO dao = ProductDAO.getInstance();
			String proId = request.getParameter("proId");
			
			ProductsVO selectedItem = dao.selectProduct(proId);
			
			ArrayList<ProductsVO> cartList = (ArrayList<ProductsVO>)session.getAttribute("cartList");
			if (cartList==null) {
				cartList = new ArrayList<ProductsVO>();	
				session.setAttribute("cartList", cartList);
			}
			
			int cnt = 0;
			ProductsVO orderItem = new ProductsVO();
			for (int i = 0; i < cartList.size(); i++) {
				orderItem = cartList.get(i);
				if(orderItem.getProId().equals(proId)) {
					cnt++;
					int orderedQuantity = orderItem.getQuantity() + 1;
					orderItem.setQuantity(orderedQuantity);
				}
			}
			if(cnt==0) {
				selectedItem.setQuantity(1);
				cartList.add(selectedItem);
			}
		}
		// ProductInsert
		if(cmd.equals("/product/insert.action")) {
			MultipartRequest multi = new MultipartRequest(
					request,path,size,"UTF-8",new DefaultFileRenamePolicy());
			ProductDAO dao = ProductDAO.getInstance();
			request.setCharacterEncoding("UTF-8");
			String proId = multi.getParameter("proId");
			String proName = multi.getParameter("proName");
			int unitPrice = Integer.parseInt(multi.getParameter("unitPrice"));
			String description = multi.getParameter("description");
			String manufacturer = multi.getParameter("manufacturer");
			String category = multi.getParameter("category");
			int noOfStock = Integer.parseInt(multi.getParameter("noOfStock"));
			Enumeration files = multi.getFileNames();
			String name = (String)files.nextElement();
			String fileName = multi.getFilesystemName(name);
			ProductsVO vo = new ProductsVO(proId, proName, description, manufacturer , category, fileName,unitPrice, noOfStock);
			boolean isUpdate = 1==dao.insertProduct(vo)? true:false;
			System.out.println(isUpdate);
			rd = getServletContext().getRequestDispatcher("/product/selectAll.action");	
		}
		if(rd==null) {
			rd = getServletContext().getRequestDispatcher("/product/select.action");
		}
		rd.forward(request, response);
	}

}
