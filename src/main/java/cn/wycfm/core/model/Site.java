package cn.wycfm.core.model;

public class Site {

	private Integer siteId;
	private String domain;
	private String sitePath;
	private String siteName;
	private String shortName;
	private String protocol;
	private String dynamicSuffix;
	private String staticSuffix;
	private String staticDir;
	private String indexToRoot;
	private String staticIndex;
	private String domainAlias;
	private String domainRedirect;
	private String tplIndex;
	private String keywords;
	private String description;
	
	public Site() {
		init();
	}
	
	
	public Site(Integer siteId, String domain, String sitePath, String siteName, String shortName, String protocol,
			String dynamicSuffix, String staticSuffix, String staticDir, String indexToRoot, String staticIndex,
			String domainAlias, String domainRedirect, String tplIndex, String keywords, String description) {
		this.siteId = siteId;
		this.domain = domain;
		this.sitePath = sitePath;
		this.siteName = siteName;
		this.shortName = shortName;
		this.protocol = protocol;
		this.dynamicSuffix = dynamicSuffix;
		this.staticSuffix = staticSuffix;
		this.staticDir = staticDir;
		this.indexToRoot = indexToRoot;
		this.staticIndex = staticIndex;
		this.domainAlias = domainAlias;
		this.domainRedirect = domainRedirect;
		this.tplIndex = tplIndex;
		this.keywords = keywords;
		this.description = description;
	}


	void init() {};
	
	public Integer getSiteId() {
		return siteId;
	}
	public void setSiteId(Integer siteId) {
		this.siteId = siteId;
	}
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	public String getSitePath() {
		return sitePath;
	}
	public void setSitePath(String sitePath) {
		this.sitePath = sitePath;
	}
	public String getSiteName() {
		return siteName;
	}
	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}
	public String getShortName() {
		return shortName;
	}
	public void setShortName(String shortName) {
		this.shortName = shortName;
	}
	public String getProtocol() {
		return protocol;
	}
	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}
	public String getDynamicSuffix() {
		return dynamicSuffix;
	}
	public void setDynamicSuffix(String dynamicSuffix) {
		this.dynamicSuffix = dynamicSuffix;
	}
	public String getStaticSuffix() {
		return staticSuffix;
	}
	public void setStaticSuffix(String staticSuffix) {
		this.staticSuffix = staticSuffix;
	}
	public String getStaticDir() {
		return staticDir;
	}
	public void setStaticDir(String staticDir) {
		this.staticDir = staticDir;
	}
	public String getIndexToRoot() {
		return indexToRoot;
	}
	public void setIndexToRoot(String indexToRoot) {
		this.indexToRoot = indexToRoot;
	}
	public String getStaticIndex() {
		return staticIndex;
	}
	public void setStaticIndex(String staticIndex) {
		this.staticIndex = staticIndex;
	}
	public String getDomainAlias() {
		return domainAlias;
	}
	public void setDomainAlias(String domainAlias) {
		this.domainAlias = domainAlias;
	}
	public String getDomainRedirect() {
		return domainRedirect;
	}
	public void setDomainRedirect(String domainRedirect) {
		this.domainRedirect = domainRedirect;
	}
	public String getTplIndex() {
		return tplIndex;
	}
	public void setTplIndex(String tplIndex) {
		this.tplIndex = tplIndex;
	}
	public String getKeywords() {
		return keywords;
	}
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
