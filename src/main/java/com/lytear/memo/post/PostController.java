package com.lytear.memo.post;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lytear.memo.post.bo.PostBO;
import com.lytear.memo.post.model.Post;
@Controller
@RequestMapping("/post")
public class PostController {

	@Autowired
	private PostBO postBO;
	
	@GetMapping("/create_view")
	public String getPost() {
		return "post/createView";
	}
	
	@GetMapping("/list_view")
	public String listView(
			Model model
			, HttpServletRequest request
			
			) {
		HttpSession session = request.getSession();
		
		int userId = (Integer)session.getAttribute("userId");
		
		List<Post> memoList = postBO.getMemoList(userId);
		
		model.addAttribute("memoList",memoList);
		
		return "post/listView";
	}
	
	@GetMapping("/detail_view")
	public String detailView(
			@RequestParam("id") int id
			, Model model
			, HttpServletRequest request
			) {
		
		HttpSession session = request.getSession();
		int userId = (Integer)session.getAttribute("userId");
		
		Post memo = postBO.getMemo(id, userId);
		
		model.addAttribute("memo",memo);//"" : 키 = 모델에서 꺼내 쓸 때 변수처럼 쓸 수 있는 것, 값: id를 전달받아 그에 해당하는 딱 하나
		
		return "post/detailView";//url : http://localhost:8080/post/detail_view?id=3
	}
	
	
	
}
