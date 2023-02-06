package com.itbank.model;

public class Paging {

	private int page;					// 요청받은 페이지 번호 (*)
	private int boardCount;				// 총 게시글의 개수 (*)
	private final int perPage = 10;		// 페이지 당 출력할 글의 개수
	private final int perSection = 10;	// 페이지 번호를 출력할 개수
	
	private int offset;					// page에 의해 건너뛸 레코드의 개수
	private int section;				// 0(1~10), 1(11~20), 2(21~30)
	
	private int pageCount;				// 게시글이 253개이면, 페이지 개수는 26
	private int begin;					// section이 1이면 11
	private int end;					// section이 1이면 20
	private boolean prev;				// 이전 섹션이 존재하는가?
	private boolean next;				// 다음 섹션이 존재하는가?
	
	public Paging(int page, int boardCount) {	// 생성자 (요청받은 페이지, 총 게시글 수)
		
		this.page = page;				
		this.boardCount = boardCount;
		
		offset = (page - 1) * perPage;
		// 첫번째 레코드에서 건너뛸 개수
		
		begin = ((int)(page - 0.1) / perSection) * perSection + 1;
		//										  0       1       2
		// 페이지 구간을 섹션으로 구분할 때, 섹션의 시작점	(1~10),(11~20),(21~30)...
		
		end = begin + perSection - 1;
		// 시작 페이지번호 + 9
		
		boolean flag = boardCount % perPage != 0;
		// 총 게시글 수가 페이지 당 출력개수로 나누어 떨어지지 않는다 (=나머지가 있다)
		
		pageCount = boardCount / perPage + (flag ? 1 : 0);
		// 전체 게시글 수를 페이지당 출력개수로 나누고, 나머지가 있으면 1페이지를 더한다
		
		end = end >= pageCount ? pageCount : end;
		// 마지막 페이지 번호와 마지막 섹션번호를 비교하여 작은 값을 선택한다 
		// (41~50구간이지만 실제 46페이지만 있을 경우)
		
		section = (page - 1) / perSection;
		// 0(1~10), 1(11~20), 2(21~30) ...
		
		int lastSection = (pageCount - 1) / perSection;
		// [다음] 을 출력할지 말지 결정하기 위해 계산하는 지역변수 
		
		prev = begin > perSection;
		// 현재 섹션의 시작번호가 섹션당 출력개수보다 크면 이전 섹션이 있다
		// 현재 보고 있는 페이지가 13이고, begin은 11이면 perPage는 10이므로 이전 섹션이 존재함
		
		next = lastSection > section;
		// 마지막 섹션이 현재 섹션보다 더 큰값이면 [다음]을 출력한다
		// 내가 보는 페이지는 21, 마지막 값은 40이면 다음을 출력한다
	}
	
	// 확인용 toString()
	@Override
	public String toString() {
		String str = "";
		str += "요청 받은 페이지 : %d\n";
		str += "전체 게시글 개수 : %d\n";
		str += "전체 페이지 개수 : %d\n";
		str += "현재 섹션 번호 : %d\n";
		str += "페이지 시작 번호 : %d\n";
		str += "페이지 끝 번호 : %d\n";
		str += "[이전] 출력 : %s\n";
		str += "[다음] 출력 : %s\n";
		str = String.format(str, page, boardCount, pageCount, section, begin, end, prev, next);
		return str;
	}
	
	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getBoardCount() {
		return boardCount;
	}

	public void setBoardCount(int boardCount) {
		this.boardCount = boardCount;
	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getBegin() {
		return begin;
	}

	public void setBegin(int begin) {
		this.begin = begin;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public int getPerPage() {
		return perPage;
	}

	public int getPerSection() {
		return perSection;
	}

	
	
}


