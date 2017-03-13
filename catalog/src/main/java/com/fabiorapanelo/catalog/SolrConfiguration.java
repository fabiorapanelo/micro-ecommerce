package com.fabiorapanelo.catalog;

import org.apache.solr.client.solrj.SolrClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.repository.config.EnableSolrRepositories;
import org.springframework.data.solr.server.support.HttpSolrClientFactoryBean;

@Configuration
@EnableSolrRepositories(basePackages = { "com.fabiorapanelo.catalog" }, multicoreSupport = false)
public class SolrConfiguration {

	@Bean
	public SolrClient solrClient(@Value("${solr.host}") String solrHost) throws Exception {
		HttpSolrClientFactoryBean factory = new HttpSolrClientFactoryBean();
		factory.setUrl(solrHost);
		factory.afterPropertiesSet();
		
		return factory.getSolrClient();
	}

	@Bean
	public SolrTemplate solrTemplate(SolrClient solrClient) throws Exception {
		SolrTemplate solrTemplate = new CustomizedSolrTemplate(solrClient);		
		return solrTemplate;
	}

}
