package com.durga.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.durga.dao.UserDAO;
import com.durga.dao.UserDAOImpl;
import com.durga.service.UserService;
import com.durga.service.UserServiceImpl;
import com.durga.util.CassandraUtil;
import com.durga.util.MyCassandraTemplate;

@Configuration
@Import(CassandraUtil.class)

public class MainAppConfiguration {
	@Bean
    public UserService getUserService() {
        return new UserServiceImpl();
    }

    
    @Bean
    public UserDAO getUserDAO() {
        return new UserDAOImpl();
    }
    
    /**
     * Creating the MyCassandraTemplate bean.
     * @return {@link MyCassandraTemplate}
     */
    @Bean
    public MyCassandraTemplate getMyCassandraTemplate() {
        return new MyCassandraTemplate();
    }

}
