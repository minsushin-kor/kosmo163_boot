package com.google.app.pages;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Pager {
	
	//페이지 번호
	private Long page;
	private Long perPage;
	
	//시작 rowNum / 끝 rowNum
	private Long first;
	private Long last;
	
	// 변수를 담아오기 위해 변수 선언 (jsp에 출력할 시작번호 및 끝번호)
	private Long start;
	private Long end;
	
	// 이전 블럭이 있는지 없는지(true면 있다, false는 없다)
	private boolean pre = false;
	// 다음 블럭이 있는지 없는지(true면 있다, false는 없다)
	private boolean next = false;
	
	public Long getPerPage() {
		if(this.perPage==null || this.perPage%5 !=0) {
			this.perPage=10L;
		}
		return this.perPage;
	}
	
	// 기본값이 null이 오는 것을 방지하기 위해 직접 getter 선언
	public Long getPage() {
		if(this.page == null || this.page < 1) {
			this.page = 1L;
		}
		return this.page;
		
	}
	//---------------
	public void makeRowNumber() throws Exception{
		this.first = (this.getPage()-1) * this.getPerPage() + 1;
		this.last = this.getPerPage()*this.getPage();
	}
	
	
	
	//-----------------------
	
	public void makePageNumber(Long totalCount) throws Exception {
		//2. 총 페이지 수 계산
		Long totalPage = totalCount / this.getPerPage();
				
		if(totalCount%this.perPage != 0) {
			totalPage++;
		}
		
		if(page != null && page>totalPage) {
			this.page = totalPage;
		}
		
		//3. 총 블럭의 갯수 계산
		Long perBlock = 5L;
		Long totalBLock = totalPage/perBlock;
		if(totalPage%perBlock !=0) {
			totalBLock++;
		}	
		
		//4. curBlock > 현재 블럭번호 계산하기
		Long curBlock = this.getPage()/perBlock;
		if(this.page%perBlock !=0) {
			curBlock++;
		}

		//5. 현재 블럭번호로 시작 번호와 끝 번호 구하기
		//6. 두개의 값을 return 하기 위해 pager에 담기
		this.start = (curBlock-1)*perBlock + 1;
		this.setEnd(curBlock*perBlock);
		
		// 7. 이전 블럭이 있다면 true 없다면 false / 마찬가지로 다음 블럭이 있는지 판단
		if(curBlock > 1) {
			this.pre = true;
		}
		
		if(curBlock < totalBLock) {
			this.next = true;
		}
		else {
			this.setEnd(totalPage);
		}
		
		this.makeRowNumber();
	}
}
