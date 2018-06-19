package com.gpac.dbConfig;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "spring")
public class DatasourceConfigBean {
	private String username;
	private String url;

	private String password;
	private String driverClassName;
	private String dialect;
	@Value("show-sql")
	private String showSql;
	@Value("ddl-auto")
	private String ddl_auto;
	@Value("enabled")
	private String isEnabled;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDriverClassName() {
		return driverClassName;
	}

	public void setDriverClassName(String driverClassName) {
		this.driverClassName = driverClassName;
	}

	public String getDialect() {
		return dialect;
	}

	public void setDialect(String dialect) {
		this.dialect = dialect;
	}

	public String isShowSql() {
		return showSql;
	}

	public void setShowSql(String showSql) {
		this.showSql = showSql;
	}

	public String isDdl_auto() {
		return ddl_auto;
	}

	public void setDdl_auto(String ddl_auto) {
		this.ddl_auto = ddl_auto;
	}

	public String isEnabled() {
		return isEnabled;
	}

	public void setEnabled(String isEnabled) {
		this.isEnabled = isEnabled;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}