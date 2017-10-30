/**
 * @(#) Page	2016年4月29日 下午3:58:08
 * 
 * 版权所有 © 深圳市宜保通金融服务（集团）有限公司
 *
 */
package weixin.gzh.server.persistence.pageAble;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * @description 分页对象, 存放单页数据
 * 
 * @author Liebin.Zheng
 * 
 * @createTime 下午3:58:08
 *
 */
public class Page<T> {

	private final List<T> content = new ArrayList<T>();
	private final Pageable pageable;
	private final int total;

	public Page(List<T> content, Pageable pageable, int total) {

		if (null == content) {
			throw new IllegalArgumentException("Content must not be null!");
		}

		this.content.addAll(content);
		this.total = total;
		this.pageable = pageable;
	}

	public Page(List<T> content) {
		this(content, null, null == content ? 0 : content.size());
	}
	
	public Page() {
		pageable=null;
		total=0;		
	}

	/**
	 * 请求页面
	 * @return
	 */
	public int getNumber() {
		return pageable == null ? 0 : pageable.getPageNumber();
	}

	/**
	 * page size
	 * @return
	 */
	public int getSize() {
		return pageable == null ? 0 : pageable.getPageSize();
	}

	/**
	 * 总页数
	 * @return
	 */
	public int getTotalPages() {
		return getSize() == 0 ? 1 : (int) Math.ceil((double) total / (double) getSize());
	}

	/**
	 * 当前页记录条数
	 * @return
	 */
	public int getNumberOfElements() {
		return content.size();
	}

	/**
	 * 总记录条数
	 * @return
	 */
	public int getTotalElements() {
		return total;
	}

	/**
	 * 是否有上一页
	 * @return
	 */
	public boolean hasPreviousPage() {
		return getNumber() > 0;
	}

	/**
	 * 是否首页
	 * @return
	 */
	public boolean isFirstPage() {
		return !hasPreviousPage();
	}

	/**
	 * 是否有下一页
	 * @return
	 */
	public boolean hasNextPage() {
		return getNumber() + 1 < getTotalPages();
	}

	/**
	 * 是否末页
	 * @return
	 */
	public boolean isLastPage() {
		return !hasNextPage();
	}

	/**
	 * 下一页请求对象
	 * @return
	 */
	public Pageable nextPageable() {
		return hasNextPage() ? pageable.next() : null;
	}

	/**
	 * 上一页请求对象
	 * @return
	 */
	public Pageable previousPageable() {

		if (hasPreviousPage()) {
			return pageable.previousOrFirst();
		}

		return null;
	}

	/**
	 * 迭代器
	 * @return
	 */
	public Iterator<T> iterator() {
		return content.iterator();
	}

	/**
	 * 当前页元素列表
	 * @return
	 */
	public List<T> getContent() {
		return Collections.unmodifiableList(content);
	}

	/**
	 * 当前页是否有元素
	 * @return
	 */
	public boolean hasContent() {
		return !content.isEmpty();
	}


	public Pageable getPageable() {
		return pageable;
	}

	public int getTotal() {
		return total;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {

		String contentType = "UNKNOWN";

		if (content.size() > 0) {
			contentType = content.get(0).getClass().getName();
		}

		return String.format("Page %s of %d containing %s instances", getNumber(), getTotalPages(), contentType);
	}
	
}
