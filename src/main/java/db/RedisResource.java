package db;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class RedisResource {
	// inject the actual template
	@Autowired
	private RedisTemplate<String, String> template;



	@Resource(name = "redisTemplate")
	private ListOperations<String, String> listOps;

	public void addType(String userId, String type) {
		listOps.leftPushAll(userId, type);
	}

	public String getType(String userId) {
		long listSize = listOps.size(userId);
		System.out.println(listSize);
		return listOps.range(userId,0, 1).get(0);
	}
	
	public List<String> getAll(String userId){
		long listSize = listOps.size(userId);
		System.out.println(listSize);
		return listOps.range(userId, 0l, listSize);
	}
}
