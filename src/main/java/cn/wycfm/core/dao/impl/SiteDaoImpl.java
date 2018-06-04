package cn.wycfm.core.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import cn.wycfm.core.dao.BaseDao;
import cn.wycfm.core.dao.SiteDao;
import cn.wycfm.core.jdbc.ParameterizedRowMapper;
import cn.wycfm.core.jdbc.ResultSetExtractor;
import cn.wycfm.core.model.Site;

public class SiteDaoImpl extends BaseDao implements SiteDao{

	@SuppressWarnings("unchecked")
	public List<Site> listSite() throws Exception{
		StringBuilder sql = new StringBuilder("select site_id, domain, site_path, site_name, short_name, protocol, dynamic_suffix")
				.append(",static_suffix, static_dir, is_index_to_root, is_static_index, domain_alias")
				.append(",domain_redirect, tpl_index, keywords, description ")
				.append(" from site ");
		
		return this.queryForList(sql.toString(), new ParameterizedRowMapper<Object>() {
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				Site site = new Site(rs.getInt("site_id"), rs.getString("domain"),
						rs.getString("site_path"), rs.getString("site_name"),
						rs.getString("short_name"), rs.getString("protocol"),
						rs.getString("dynamic_suffix"),rs.getString("static_suffix"), 
						rs.getString("static_dir"),rs.getString("is_index_to_root"),
						rs.getString("is_static_index"),rs.getString("domain_alias"),
						rs.getString("domain_redirect"),rs.getString("tpl_index"),
						rs.getString("keywords"),rs.getString("description"));
				
				return site;
			}});
	}

	public Site getSite(String domain) throws Exception{
		StringBuilder sql = new StringBuilder("select site_id, domain, site_path, site_name, short_name, protocol, dynamic_suffix")
				.append(",static_suffix, static_dir, is_index_to_root, is_static_index, domain_alias")
				.append(",domain_redirect, tpl_index, keywords, description ")
				.append(" from site ")
				.append(" where domain=? ");
		Object[] args = new Object[] {domain};
		int[] argTypes = new int[] {Types.VARCHAR};
		return (Site) this.queryForObject(sql.toString(), args, argTypes, new ResultSetExtractor<Object>() {
			
			public Object extractData(ResultSet rs) throws SQLException {
				Site site = null;
				while(rs.next()) {
					site = new Site(rs.getInt("site_id"), rs.getString("domain"),
							rs.getString("site_path"), rs.getString("site_name"),
							rs.getString("short_name"), rs.getString("protocol"),
							rs.getString("dynamic_suffix"),rs.getString("static_suffix"), 
							rs.getString("static_dir"),rs.getString("is_index_to_root"),
							rs.getString("is_static_index"),rs.getString("domain_alias"),
							rs.getString("domain_redirect"),rs.getString("tpl_index"),
							rs.getString("keywords"),rs.getString("description"));
					
				}
				return site;
			}
		});
	}

	public void saveSite(Site site) throws Exception {
		StringBuilder sql = new StringBuilder("insert into site(site_id, domain, site_path, site_name, short_name, protocol, dynamic_suffix")
				.append(",static_suffix, static_dir, is_index_to_root, is_static_index, domain_alias")
				.append(",domain_redirect, tpl_index, keywords, description) values ")
				.append(" (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ");
		Object[] args = new Object[] {site.getSiteId(), site.getDomain(), site.getSitePath(), site.getSiteName(), site.getShortName(), site.getProtocol(), site.getDynamicSuffix(), 
				site.getStaticSuffix(), site.getStaticDir(), site.getIndexToRoot(), site.getStaticIndex(), site.getDomainAlias(),
				site.getDomainRedirect(), site.getTplIndex(), site.getKeywords(), site.getDescription()};
		int[] argTypes = new int[] {Types.INTEGER, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR,
				Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR
				, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR};
		this.executeForUpdate(sql.toString(), args, argTypes);
	}

	

}
