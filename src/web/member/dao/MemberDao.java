package web.member.dao;

import java.util.List;

public interface MemberDao<B, K> {
	//新增
	int insert(B bean);
	//查詢 by key
	B selectByKey(K key);
	//查詢ALL
	List<B>selectAll();
	//修改
	int update(B bean);
	//刪除
	int deletaByKey(K key);
	
	
}
