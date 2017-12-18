package alex.stud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = {"alex.stud.dao","alex.stud.service"})
public class SpringConfig {

    /*@Bean
    public CustomerService getCustomerService(){
        return new CustomerServiceImpl();
    }

    @Bean
    public CustomerDao getCustomerDao(){
        return new CustomerDaoImpl();
    }*/

    @Bean
    public JdbcTemplate getJdbcTemplate(){
        return new JdbcTemplate(getDataSource());
    }

    @Bean
    public DataSource getDataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/Shop");
        dataSource.setUsername("root");
        dataSource.setPassword("QAZxsw1!");
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        return dataSource;
    }
}
