package com.lytear.memo.post.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.lytear.memo.common.FileManagerService;
import com.lytear.memo.post.dao.PostDAO;
import com.lytear.memo.post.model.Post;

@Service
public class PostBO {

	@Autowired
	private PostDAO postDAO;
	
	public int addPost(int userId, String subject, String content, MultipartFile file) {
	//public int addPost(int userId, String subject, String content) {	
		
		// file(필수 항목 X) null일 때 예외 처리 
		
		
		// 암호화에서도 static 이란 키워드 통해서 객체 생성 없이 메소드 쓰는 방법 배웠음
		
		
		String imagePath = null;//어차피 파일이 안 넘어왔는 때는 imagePath가 null이 되어야 하니 if 문 밖에 기본으로 null 세팅
		// 파일이 있을 경우에만 저장 로직 진행
		if(file != null) {
			//FileManagerService fileManagerService = new FileManagerService(); => 삭제
			//FileManagerService에서 객체 생성 없이 static으로 사용하게 설정했으므로 위가 아니라 아래 방식으로 진행
			imagePath = FileManagerService.saveFile(userId, file);//리턴해주는 filepath를 저장해야 함 => xml에 imagePath 추가
			// saveFile에서 파일 저장에 실패 한 경우
			if(imagePath == null) {
				return 0;//imagePath에 문제가 있으면 PostRestController에서 1이 아니므로 자연스럽게 실패가 되게 만들어 줌
			} 
			
		}
		
		//최초 예외처리 전(imagePath == null 인 경우). 위 내용은 saveFile(userId, file)의 file == null 예외처리까지 반영
		//파일 등록이 필수 항목이 아니라면 saveFile(userId, file)의 file == null 로 들어갔을 때의 예외처리가 필요
//		String imagePath  = FileManagerService.saveFile(userId, file);
//		if(imagePath == null) {
//			return 0;
//		}
//		
//		return postDAO.insertTimeline(userId, userNameTest, content, imagePath);
		
		
		//return postDAO.insertPost(userId, subject, content, file);
		return postDAO.insertPost(userId, subject, content, imagePath);
		//디비에 파일을 저장하는건 좋지 않기 때문에 파일 저장하고 경로(imagePath)만 저장하는 겁니다
		
		
	}
	public List<Post> getMemoList(int userId) {
		
		return postDAO.selectMemoList(userId);
	}
	public Post getMemo(int id, int userId) {// id 를 기반으로 딱 하나만 값을 가져오므로 리턴 타입은 리스트 아닌 Post
		return postDAO.selectMemo(id, userId);
	}
	
	//public int deleteMemo(int postId) {
		// 아래 리턴에서 파일 삭제하기 전체 메소드 만든 대로 경로부터 삭제
		//FileManagerService.removeFile(null);//아래 괄호에 null로 나오므로 데이터 조회해서 가져와야 함. userId 받아와 post에 있는 imagePath 꺼내기
	public int deleteMemo(int id, int userId) { // id라도 적었지만 처리하는 부분상 당연히 postId임
		Post post = this.getMemo(id, userId);
		
		
		if(post.getImagePath() != null) {//FilePath가 null 일 때는 호출하지 않는다
			FileManagerService.removeFile(post.getImagePath());		
		}
		
		return postDAO.deleteMemo(id, userId);
		// FileManagerService 통해 파일 삭제하기
		
		// 이 글의 id를 알고 있는 사람이 임의로 삭제하면 안 됨 => userId 포함해서 삭제(글쓴사람만 삭제): dao에 userId 추가
	}
	
	public int updateMemo(int id, String subject, String content, int userId) {//아무나 수정하면 안 되니 userId도 추가
		return postDAO.updateMemo(id, subject, content, userId);
	}
	
	
	
}
