package top.kai.mall.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Description MyBatis配置类
 * @Author Kai
 * @Date 2020/12/26 21:25
 */
@Configuration
@MapperScan("top.kai.mall.mbg.mapper")
public class MyBatisConfig {
}
