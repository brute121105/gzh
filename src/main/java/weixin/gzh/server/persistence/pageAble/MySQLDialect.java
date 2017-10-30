package weixin.gzh.server.persistence.pageAble;


/**
 * 
 * @description MySQL分页SQL语法
 * 
 * @author Liebin.Zheng
 * 
 * @createTime 上午10:35:37
 *
 */
//@Component
public class MySQLDialect extends Dialect{

	public boolean supportsLimitOffset(){
		return true;
	}
	
    public boolean supportsLimit() {   
        return true;   
    }  
    
	public String getLimitString(String sql, int offset,String offsetPlaceholder, int limit, String limitPlaceholder) {
        if (offset > 0) {   
        	return sql + " limit "+offsetPlaceholder+","+limitPlaceholder; 
        } else {   
            return sql + " limit "+limitPlaceholder;
        }  
	}   
  
}
