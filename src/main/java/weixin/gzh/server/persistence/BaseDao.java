package weixin.gzh.server.persistence;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import weixin.gzh.server.persistence.pageAble.Page;
import weixin.gzh.server.persistence.pageAble.Pageable;





	public interface BaseDao<T, PK extends Serializable> {

		/**
		 * 查找所有数据
		 * 
		 * @return
		 */
		public abstract List<T> findAll();

		/**
		 * 根据主键查找指定数据
		 * 
		 * @param paramPK
		 * @return
		 */
		public abstract T findById(PK paramPK);

		/**
		 * 保存数据
		 * 
		 * @param paramT
		 */
		public abstract void save(T paramT);

		/**
		 * 更新数据
		 * 
		 * @param paramT
		 */
		public abstract void update(T paramT);

		/**
		 * 根据业务主键删除数据
		 * 
		 * @param paramPK
		 */
		public abstract void deleteById(PK paramPK);

		/**
		 * 根据指定参数删除数据
		 * 
		 * @param paramT
		 */
		public abstract void delete(T paramT);


		/**
		 * 根据条件找到唯一数据值
		 * 
		 * @param paramArrayOfObject
		 * @return
		 */
		public abstract T findUnique(Object[] paramArrayOfObject);

		/**
		 * 根据条件找到唯一数据值
		 * 
		 * @param paramMap
		 * @return
		 */
		public abstract T findUnique(Map<String, Object> paramMap);



		/**
		 * @param paramString
		 * @param paramBoolean
		 * @param paramArrayOfObject
		 * @return
		 */
		public abstract List<T> findList(T paramT);
		
		

	    /**
	     * 获取指定参数的分页数据
	     * 
	     * @param paramT
	     * @param pageRequest
	     * @return
	     */
	    public abstract Page<T> findPageList(T paramT, Pageable pageRequest);
	    
	    
	    /**
	     * 获取指定参数的分页数据
	     * 
	     * @param paramString
	     * @param paramBoolean
	     * @param paramArrayOfObject
	     * @return
	     */
	    public abstract Page<T> findPageListByMap(Map<String, Object> paramMap, Pageable pageRequest);

		/**
		 * @param paramMap
		 * @return
		 */
		public abstract T findByMap(Map<String, Object> paramMap);
		
		/**
		 * 根据map条件查询返回list
		 * @param paramMap
		 * @return
		 */
	    public abstract List<T> findListByMap(Map<String, Object> paramMap);

		/**
		 * @param paramMap
		 * @param paramBoolean
		 * @return
		 */
		public abstract T findUniqueByMap(Map<String, Object> paramMap,
				boolean paramBoolean);

		/**
		 * @param paramMap
		 * @return
		 */
		public abstract List<T> find(Map<String, Object> paramMap);
		
		/**
		 * @desc 批量保存
		 * @author Bin
		 * @param paramList
		 * @return
		 */
		public abstract void saveByList(List<T> paramList);
		
		/**
		 * 根据Map条件统计
		 * @param paramMap
		 * @return
		 */
		public abstract Long countByMap(Map<String, Object> paramMap);
		
}
