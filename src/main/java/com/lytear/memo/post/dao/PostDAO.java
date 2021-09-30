package com.lytear.memo.post.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.lytear.memo.post.model.Post;

@Repository
public interface PostDAO {
	public int insertPost(
			@Param("userId") int userId 
			,@Param("subject") String subject
			,@Param("content") String content
			,@Param("imagePath") String imagePath
			);
	
	
	public List<Post> selectMemoList(@Param("userId") int userId);
	
	public Post selectMemo(
			@Param("id") int id
			,@Param("userId") int userId 
			
			);
	
	public int deleteMemo(@Param("id") int id
			,@Param("userId") int userId 
			);
	// 쿼리를 날리는 dao 입장에서는 postId 보다는 그냥 자체 id 이름을 잡았음
	
	public int updateMemo(@Param("id") int id
			,@Param("subject") String subject 
			,@Param("content") String content 
			,@Param("userId") int userId 
			);
	
}
