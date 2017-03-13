package com.fabiorapanelo.catalog;

import org.apache.solr.client.solrj.SolrClient;
import org.springframework.dao.DataAccessException;
import org.springframework.data.solr.UncategorizedSolrException;
import org.springframework.data.solr.core.CollectionCallback;
import org.springframework.data.solr.core.SolrTemplate;

public class CustomizedSolrTemplate extends SolrTemplate {

	public CustomizedSolrTemplate(SolrClient solrClient) {
		super(solrClient);
	}

	//Workaround for https://jira.spring.io/browse/DATASOLR-364
	@Override
	public <T> T execute(String collection, CollectionCallback<T> action) {
		try {
			SolrClient solrClient = this.getSolrClient();
			return action.doInSolr(solrClient, null);
		} catch (Exception e) {
			DataAccessException resolved = getExceptionTranslator().translateExceptionIfPossible(
					e instanceof RuntimeException ? (RuntimeException) e : new RuntimeException(e.getMessage(), e));
			throw resolved == null ? new UncategorizedSolrException(e.getMessage(), e) : resolved;
		}
	}
}
