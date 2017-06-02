package app;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;


@Configuration
@ComponentScan({"model,controller,db"}) // search the com.company package for @Component classes
@ImportResource("classpath:/beans.xml") // XML with DataSource bean
public class WebAppConfig {
	
	@Bean
    JedisConnectionFactory jedisConnectionFactory() {
        return new JedisConnectionFactory();
    }

	 @Bean
	    RedisTemplate< String, String > redisTemplate() {
	        final RedisTemplate< String, String > template =  new RedisTemplate< String, String >();
	        template.setConnectionFactory( jedisConnectionFactory() );
	        
	        return template;
	    }
}
