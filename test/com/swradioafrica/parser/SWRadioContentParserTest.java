package com.swradioafrica.parser;

import java.net.URL;

import junit.framework.Assert;

import org.junit.Test;

import com.swradioafrica.model.ContentItem;


public class SWRadioContentParserTest {

	private final String BODY = "By Alex Bell 16 November 2009\n" + 
			"Scores of lawyers gathered in Harare on Monday to protest the increasing intimidation tactics being used by the state against them, as they try to defend various human rights activists in the country.\n" + 
			"The group of about 60 lawyers, dressed in their black gowns, braved the pouring rain in the capital to march to the office of Justice Minister Patrick Chinamasa. The group had first attended Monday’s High Court proceedings, in support of their colleague Mordecai Mahlangu who was arrested two weeks ago on charges of interfering with the course of justice. Mahlangu was arrested after writing a letter to Attorney General Johannes Tomana, saying his client Peter Hitschmann had no evidence to offer in the treason trial against MDC Treasurer General Roy Bennett.\n" + 
			"From the High Court the lawyers marched to Chinamasa’s offices to hand over a petition, calling for an end to the ongoing harassment of lawyers and rights defenders alike. Lawyers have been routinely harassed by police, often finding themselves facing trumped up charges. Magistrates too have expressed concern about the state’s overwhelming interference in the supposedly independent legal system.\n" + 
			"For example, Harare magistrate Chioniso Mutongi, has reportedly resigned on the basis of state interference and harassment. The magistrate, who has been presiding over the state’s case against top civil rights lawyer, Alec Muchadehama, said she had been ‘undermined’ after the state refused to carry out sentencing of the state prosecutor that Mutongi had ruled was in contempt of court. The prosecutor, Andrew Kumire, was facing a jail term as a result of the contempt charges, after he was disrespectful to Mutongi during court proceedings.\n" + 
			"But Mutongi reportedly said she had endured a “torrid time during which I was entirely abused and harassed at the hands of the State prosecution (authorities).” She added that she felt she “did not get professional protection from this office, as I reasonably anticipated.”\n" + 
			"Political analyst and lawyer, Alex Magaisa, said the situation “raises questions yet again about the independence of the judiciary and more significantly, about the plight of the officers in the lower echelons of the judiciary.”\n" + 
			"“The independence of the judiciary must be protected and this goes beyond concerns for judges in the superior courts but to all the men and women who are the foot soldiers of the judicial system,” Magaisa said.\n";
	
	
	private final String SAMPLE_HTML = 
			"<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\n" + 
			"<html>\n" + 
			"<head>\n" + 
			"<title>Lawyers protest increasing state intimidation</title>\n" + 
			"<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\"> \n" + 
			"<meta name=\"description\" content=\"SW Radio Africa is the independent voice of Zimbabwe broadcasting on the short wave\">\n" + 
			"<meta name=\"keywords\" content=\"sw radio, Zimbabwe, 6145Khz, africa, politics\">\n" + 
			"<link rel=\"stylesheet\" href=\"/css%20styles/swafricastyle.css\">\n" + 
			"\n" + 
			"<script type=\"text/javascript\" language=\"JavaScript1.2\" src=\"../Javascripts/stmenu.js\"></script>\n" + 
			"\n" + 
			"</head>\n" + 
			"<body bgcolor=\"#ffffff\" background=\"/swradio/bg_day.gif\" link=\"#990000\" vlink=\"#990000\">\n" + 
			" <script type=\"text/javascript\" language=\"JavaScript1.2\" src=\"../Javascripts/javascript1.js\"></script>\n" + 
			"<table width=\"658\" bgcolor=\"#FFFFFF\" align=\"center\">\n" + 
			"  <tr>\n" + 
			"    <td>\n" + 
			"      <table width=\"601\" align=\"center\">\n" + 
			"        <tr bgcolor=\"#FFFFFF\">\n" + 
			"          <td><div align=\"center\">\n" + 
			"              <script type=\"text/javascript\"><!--\n" + 
			"google_ad_client = \"pub-0119071566348730\";\n" + 
			"google_ad_width = 468;\n" + 
			"google_ad_height = 60;\n" + 
			"google_ad_format = \"468x60_as\";\n" + 
			"google_ad_type = \"text_image\";\n" + 
			"google_ad_channel =\"\";\n" + 
			"google_color_border = \"336699\";\n" + 
			"google_color_bg = \"FFFFFF\";\n" + 
			"google_color_link = \"0000FF\";\n" + 
			"google_color_url = \"008000\";\n" + 
			"google_color_text = \"000000\";\n" + 
			"//--></script>\n" + 
			"              <script type=\"text/javascript\"\n" + 
			"  src=\"http://pagead2.googlesyndication.com/pagead/show_ads.js\">\n" + 
			"          </script>\n" + 
			"          </div></td>\n" + 
			"        </tr>\n" + 
			"        <tr bgcolor=\"#FFFFFF\">\n" + 
			"          <td><span class=\"title_sub\">SW Radio Africa  news - The Independent Voice of Zimbabwe </span></span></td>\n" + 
			"        </tr>\n" + 
			"        <tr>\n" + 
			"          <td valign=\"top\" class=\"entry\"><h1>Lawyers protest increasing state intimidation</h1>\n" + 
			"        </tr>\n" + 
			"        <tr> \n" + 
			"          <td width=\"1184\" valign=\"top\" class=\"entry\">\n" + 
			"            <p><strong><br>\n" + 
			"  By Alex Bell<br>\n" + 
			"  16 November 2009</strong></p>\n" + 
			"            <p>Scores of lawyers gathered in Harare on Monday to protest the increasing intimidation tactics being used by the state against them, as they try to defend various human rights activists in the country.</p>\n" + 
			"            <p>The group of about 60 lawyers, dressed in their black gowns, braved the pouring rain in the capital to march to the office of Justice Minister Patrick Chinamasa. The group had first attended Monday’s High Court proceedings, in support of their colleague Mordecai Mahlangu who was arrested two weeks ago on charges of interfering with the course of justice. Mahlangu was arrested after writing a letter to Attorney General Johannes Tomana, saying his client Peter Hitschmann had no evidence to offer in the treason trial against MDC Treasurer General Roy Bennett.</p>\n" + 
			"            <p>From the High Court the lawyers marched to Chinamasa’s offices to hand over a petition, calling for an end to the ongoing harassment of lawyers and rights defenders alike. Lawyers have been routinely harassed by police, often finding themselves facing trumped up charges. Magistrates too have expressed concern about the state’s overwhelming interference in the supposedly independent legal system.</p>\n" + 
			"            <p>For example, Harare magistrate Chioniso Mutongi, has reportedly resigned on the basis of state interference and harassment. The magistrate, who has been presiding over the state’s case against top civil rights lawyer, Alec Muchadehama, said she had been ‘undermined’ after the state refused to carry out sentencing of the state prosecutor that Mutongi had ruled was in contempt of court. The prosecutor, Andrew Kumire, was facing a jail term as a result of the contempt charges, after he was disrespectful to Mutongi during court proceedings.</p>\n" + 
			"            <p>But Mutongi reportedly said she had endured a “torrid time during which I was entirely abused and harassed at the hands of the State prosecution (authorities).” She added that she felt she “did not get professional protection from this office, as I reasonably anticipated.”</p>\n" + 
			"            <p>Political analyst and lawyer, Alex Magaisa, said the situation “raises <br>\n" + 
			"  questions yet again about the independence of the judiciary and more <br>\n" + 
			"  significantly, about the plight of the officers in the lower echelons of the <br>\n" + 
			"  judiciary.”</p>\n" + 
			"            <p>“The independence of the judiciary must be protected and this goes <br>\n" + 
			"  beyond concerns for judges in the superior courts but to all the men and <br>\n" + 
			"  women who are the foot soldiers of the judicial system,” Magaisa said.<br>\n" + 
			"            </p>\n" + 
			"            <p> </p>\n" + 
			"            <p></p>\n" + 
			"            <p></p>\n" + 
			"            <p></p>\n" + 
			"            <p>            </p>\n" + 
			"          </tr>\n" + 
			"        <tr> \n" + 
			"          <td valign=\"top\" class=\"entry\"><!-- AddThis Button BEGIN -->\n" + 
			"<a class=\"addthis_button\" href=\"http://www.addthis.com/bookmark.php?v=250&amp;pub=xa-4aaa82d6064f4ae4\"><img src=\"http://s7.addthis.com/static/btn/v2/lg-share-en.gif\" width=\"125\" height=\"16\" alt=\"Bookmark and Share\" style=\"border:0\"/></a><script type=\"text/javascript\" src=\"http://s7.addthis.com/js/250/addthis_widget.js?pub=xa-4aaa82d6064f4ae4\"></script><!-- AddThis Button END --></td>\n" + 
			"        </tr>\n" + 
			"        <tr> \n" + 
			"          <td valign=\"top\" class=\"entry\"> \n" + 
			"            <div align=\"center\"><b><a href=\"/index.php\">Home</a>&nbsp;&nbsp;&nbsp;&nbsp;&#149;&nbsp;&nbsp;&nbsp;&nbsp;<a href=\"/pages/archives.php\">Archives</a>&nbsp;&nbsp;&nbsp;&nbsp;&#149;&nbsp;&nbsp;&nbsp;&nbsp;<a href=\"/pages/schedule.php\">Schedule</a> \n" + 
			"              &nbsp;&nbsp;&nbsp;&nbsp;&#149;&nbsp;&nbsp;&nbsp;&nbsp;<a href=\"/pages/links.php\">Links</a> \n" + 
			"              &nbsp;&nbsp;&nbsp;&nbsp;&#149;&nbsp;&nbsp;&nbsp;&nbsp;<a href=\"/pages/feedback.php\">Feedback</a> \n" + 
			"              &nbsp;&nbsp;&nbsp;&nbsp;&#149;&nbsp;&nbsp;&nbsp;&nbsp;<a href=\"/pages/views.php\">Views</a> \n" + 
			"              &nbsp;&nbsp;&nbsp;&nbsp;&#149;&nbsp;&nbsp;&nbsp;<a href=\"/pages/reports.htm\">&nbsp;Reports</a> \n" + 
			"              </b></div>\n" + 
			"          </td>\n" + 
			"        </tr>\n" + 
			"        <tr> \n" + 
			"          <td valign=\"top\" class=\"entry\">&nbsp;</td>\n" + 
			"        </tr>\n" + 
			"      </table>\n" + 
			"    <br></td>\n" + 
			"  </tr>\n" + 
			"</table>\n" + 
			"<script type=\"text/javascript\">\n" + 
			"var gaJsHost = ((\"https:\" == document.location.protocol) ? \"https://ssl.\" : \"http://www.\");\n" + 
			"document.write(unescape(\"%3Cscript src='\" + gaJsHost + \"google-analytics.com/ga.js' type='text/javascript'%3E%3C/script%3E\"));\n" + 
			"</script>\n" + 
			"<script type=\"text/javascript\">\n" + 
			"try {\n" + 
			"var pageTracker = _gat._getTracker(\"UA-11018329-3\");\n" + 
			"pageTracker._trackPageview();\n" + 
			"} catch(err) {}</script></body>\n" + 
			"</html>\n"; 
	@Test
	public void shouldParseContentItemFromValidHtml() {
		SWRadioContentParser parser = new SWRadioContentParser();
		ContentItem item = new ContentItem(); 
		parser.populateContentItem(item, SAMPLE_HTML);
		
		Assert.assertEquals("Lawyers protest increasing state intimidation", item.getTitle());
		Assert.assertEquals(BODY, item.getBody());
	}

	
}
