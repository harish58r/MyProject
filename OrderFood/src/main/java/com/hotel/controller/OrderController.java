package com.hotel.controller;

import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.hotel.model.Cart;
import com.hotel.model.FoodItems;
import com.hotel.model.OrderDetail;
import com.hotel.service.CartService;
import com.hotel.service.FoodItemService;
import com.hotel.service.OrderService;

@Controller
public class OrderController {

	@Autowired
	private FoodItemService foodItemService;

	@Autowired
	private CartService cartService;

	@Autowired
	private OrderService orderService;

	@RequestMapping("/selectveg")
	public ModelAndView selectVeg(HttpSession session) {
		ModelAndView modelAndView = new ModelAndView("order");

		String veg = "Veg";
		List<FoodItems> list = this.foodItemService.getVeg(veg);
		modelAndView.addObject("select", "veg");
		modelAndView.addObject("list", list);
		modelAndView.addObject("title", "Select_veg");
		return modelAndView;
	}

	@RequestMapping("/selectnonveg")
	public ModelAndView SelectNonveg() {
		ModelAndView modelAndView = new ModelAndView("order");
		String nonveg = "Non-Veg";
		List<FoodItems> list = this.foodItemService.getNonVeg(nonveg);
		modelAndView.addObject("select", "nonveg");
		modelAndView.addObject("list", list);
		modelAndView.addObject("title", "Select_nonveg");
		return modelAndView;
	}

	@RequestMapping("/cart")
	public String cartedItems(Model m, HttpServletRequest req, HttpSession session) {
		System.out.println(session.getAttribute("email"));
		if (session.getAttribute("email") != null) {
			int uid = (Integer) session.getAttribute("userid");
			List<Cart> carteddata = this.cartService.getAllCartedDataByUid(uid);
			m.addAttribute("carteddata", carteddata);
			m.addAttribute("title", "cart");
		} else {
			return "login";
		}

		return "cart";
	}

	@RequestMapping("/cart/{id}")
	public RedirectView cartedItem(@PathVariable("id") int id, Model m, HttpServletRequest req, HttpSession session) {
		RedirectView rdview = new RedirectView();
		System.out.println(session.getAttribute("email"));
		if (session.getAttribute("email") != null) {

			FoodItems food = this.foodItemService.getdata(id);
			int uid = (Integer) session.getAttribute("userid");
			// Random rand = new Random();
			// int cid = rand.nextInt(1000);
			Cart cart = new Cart();
			cart.setId(food.getId());
			cart.setItemname(food.getItemname());

			cart.setPrice(food.getPrice());
			cart.setUserid(uid);
			m.addAttribute("title", "cart");
			rdview.setUrl(req.getContextPath() + "/cart");
			this.cartService.addtocart(cart);

		} else {
			rdview.setUrl(req.getContextPath() + "/login");
		}
		return rdview;

	}

	@RequestMapping("/delete/{id}")
	public RedirectView delete(@PathVariable("id") int id, HttpServletRequest req, Model m) {
		RedirectView rdview = new RedirectView();
		m.addAttribute("title", "cart");
		this.cartService.delete(id);
		rdview.setUrl(req.getContextPath() + "/cart");
		return rdview;

	}

	@RequestMapping("/buy")
	public ModelAndView buy(HttpServletRequest req, Model m, HttpSession session) {
		ModelAndView rv = new ModelAndView();
		if (session.getAttribute("email") != null) {
			int uid = (Integer) session.getAttribute("userid");
			List<Cart> carteddata = this.cartService.getAllCartedDataByUid(uid);
			OrderDetail od = new OrderDetail();
			Random rand = new Random();
			long oid = rand.nextInt(1000);
			OrderDetail od1;
			od.setOrderid(oid);
			for (Cart cart : carteddata) {
				int id=rand.nextInt(1000);
				od.setId(id);
				od.setCartid(cart.getId());
				od.setCartItemName(cart.getItemname());
				od.setCartPrice(cart.getPrice());
				od.setUserid(cart.getUserid());
				od1 = this.orderService.addOrderedData(od);
				if (od1 != null) {
					this.cartService.deleteData(cart.getId());
				} else {
					rv.setViewName("cart");					
				}

			}
			
			m.addAttribute("buystatus", "carted items not found");
			m.addAttribute("title", "buy");
			List<OrderDetail> data=this.orderService.getDataByOrderId(oid);
			m.addAttribute("size",data.size());
			
			m.addAttribute("orderDetail", data);
			int total_amount=0;
			for (OrderDetail orderDetail : data) {
				total_amount=total_amount+Integer.parseInt(orderDetail.getCartPrice());
			}
			m.addAttribute("totalamount", total_amount);
			rv.setViewName("ordertoken");

		} else {
			rv.setViewName("login");
			m.addAttribute("title", "Login");
		}

		return rv;
	}

}
