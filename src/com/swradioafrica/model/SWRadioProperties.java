package com.swradioafrica.model;

import siena.Column;
import siena.Id;
import siena.Model;
import siena.Query;
import siena.Table;

@Table("swradio_properties")
public class SWRadioProperties extends Model {

	@Id public Long id;
	
	@Column("twitterUsername") public String twitterUsername;
	@Column("twitterPassword") public String twitterPassword;
	@Column("JMPUsername") public String JMPUsername;
	@Column("JMPKey") public String JMPKey;

	public static Query<SWRadioProperties> all() {
		return Model.all(SWRadioProperties.class);
	}	
	
}
