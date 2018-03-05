package config.root;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

import cn.lijuntao.boot.repository.MyRepositoryImpl;

@Configuration
@ComponentScan(basePackages={"cn.lijuntao.boot.repository"})
@EnableElasticsearchRepositories(basePackages = "cn.lijuntao.boot.repository", 
repositoryImplementationPostfix="Impl",
repositoryBaseClass=MyRepositoryImpl.class)
@EnableSpringDataWebSupport
public class RootConfig {

}
