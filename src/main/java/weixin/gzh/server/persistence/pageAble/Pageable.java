/**
 * @(#) Pageable	2016年4月29日 下午3:58:43
 * 
 * 版权所有 © 深圳市宜保通金融服务（集团）有限公司
 *
 */
package weixin.gzh.server.persistence.pageAble;


/**
 * @description 分页请求对象
 * 
 * @author Liebin.Zheng
 * 
 * @createTime 下午3:58:43
 *
 */
public class Pageable {

	private final int page;
	private final int size;
	
	/**
	 * 是否查询总记录数
	 */
	private final boolean countable;

	/**
	 * 
	 * @param page the page no you want to request, start from 0
	 * @param size page size
	 */
	public Pageable(int page, int size) {

		this(page, size, true);
	}
	
	public Pageable() {
		page=1;
		size=10;
		countable=false;
	}
	
	public int getPage() {
		return page;
	}

	public int getSize() {
		return size;
	}

	/**
	 * 
	 * @param page the page no you want to request, start from 0
	 * @param size page size
	 * @param countable whether count total numbers
	 */
	public Pageable(int page, int size, boolean countable) {

		if (page < 0) {
			throw new IllegalArgumentException("Page index must not be less than zero!");
		}

		if (size < 0) {
			throw new IllegalArgumentException("Page size must not be less than zero!");
		}

		this.page = page;
		this.size = size;
		
		this.countable = countable;
	}
	
	public boolean getCountable() {
		return countable;
	}
	
	public int getPageSize() {

		return size;
	}

	public int getPageNumber() {
		return page;
	}

	public int getOffset() {
		return page * size;
	}

	public boolean hasPrevious() {
		return page > 0;
	}

	public Pageable next() {
		return new Pageable(page + 1, size);
	}

	public Pageable previousOrFirst() {
		return hasPrevious() ? new Pageable(page - 1, size) : this;
	}

	public Pageable first() {
		return new Pageable(0, size);
	}

	/* 
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.format("Page request [number: %d, size %d, sort: %s]", page, size);
	}
	
}
