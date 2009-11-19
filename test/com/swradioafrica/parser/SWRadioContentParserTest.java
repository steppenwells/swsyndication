package com.swradioafrica.parser;

import java.net.URL;

import junit.framework.Assert;

import net.htmlparser.jericho.Element;
import net.htmlparser.jericho.Source;

import org.junit.Test;

import com.swradioafrica.model.ContentItem;


public class SWRadioContentParserTest {
	private String SAMPLE_HTML = "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\n" + 
			"<html>\n" + 
			"<head>\n" + 
			"<title>Students arrested over ‘gun’ found in hostel</title>\n" + 
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
			"          <td valign=\"top\" class=\"entry\"><h1>Students arrested over ‘gun’ found in hostel</h1>\n" + 
			"        </tr>\n" + 
			"        <tr> \n" + 
			"          <td width=\"1184\" valign=\"top\" class=\"entry\">\n" + 
			"            <p><br>\n" + 
			"              <strong>              By Lance Guma<br>\n" + 
			"  19 November 2009</strong></p>\n" + 
			"            <p>The Zimbabwe National Students Union (ZINASU) on Wednesday reported that 7 students were arrested over trumped-up charges of possessing a gun on campus. The pistol was allegedly found in a hostel at the Great Zimbabwe University in Masvingo. </p>\n" + 
			"            <p>ZINASU issued a statement saying the students had met in the room of Blessing Dubi. The discussion centered on demands by college authorities that student’s who had not paid tuition fees could not access their exam results and consequently could not proceed to the next year.</p>\n" + 
			"            <p>It was then that 15 college security guards ‘pounced on them accusing them of holding an illegal meeting’. The guards beat up the students who initially were able to escape from the room. One hour after the disturbances police arrested Dubi, Robson Ruhanya and Zivanai Muzorodzi, the current Students Representative Council president. <br>\n" + 
			"              <br>\n" + 
			"  ‘At first, the three students thought the police were joking but were shell shocked when four other students were picked up on similar allegations and were quickly whisked away to Masvingo Central Police Station,’ a ZINASU statement read. Police allege they found a fire arm in Dubi’s room. <br>\n" + 
			"  On Thursday more information on the incident filtered through with new reports saying the total number of students arrested had gone up to 10 while another 11 were on the run. The students say the Hostel Warden, a Reverend Gwararauno is the one who got into the room where the students were meeting and was brandishing a gun. When the police arrived the warden turned around and said he had found the students with the gun.<br>\n" + 
			"  <br>\n" + 
			"  ZINASU said the students are still being detained at Masvingo Central Police and their lawyers are being denied access to them. Since Thursday the students have also not been able to eat anything. The students union said it is now seeking an audience with the co-Home Affairs Ministers Giles Mutsekwa and Kembo Mohadi. They compared the harassment of their leaders to that of MDC Treasurer General Roy Bennett, who is facing similar trumped-up weapons charges.</p>\n" + 
			"            <p>&nbsp;            </p>\n" + 
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
	public void shouldParseValidUrl() throws Exception {
		SWRadioContentParser parser = new SWRadioContentParser();
		String url = "http://www.swradioafrica.com/news191109/students191109.htm";
		ContentItem item = parser.parseContent(new URL(url));
		
		Assert.assertNotNull(item);
		Assert.assertEquals(url, item.getUrl());
		Assert.assertNotNull(item.getBody());
		Assert.assertNotNull(item.getTitle());
		Assert.assertEquals("Students arrested over ‘gun’ found in hostel", item.getTitle());
		
	}

	@Test
	public void shouldHandleInvalidUrl() throws Exception {
		SWRadioContentParser parser = new SWRadioContentParser();
		String url = "http://x/news161109/mtmeets161109.htm";
		ContentItem item = parser.parseContent(new URL(url));
		
		Assert.assertNotNull(item);
		Assert.assertEquals("", item.getBody());
		Assert.assertEquals("", item.getTitle());
		Assert.assertNotNull(item.getUrl());
		Assert.assertNotNull(item.getPublishedDate());
		
	}
	
	@Test 
	public void shouldExtractParentWithLongestParagraph() throws Exception {
		String HTML = 	"<html><body>" +
						"<div><p>1</p><p>22</p></div>" +
						"<div id='longest'><p>333</p><p>4444</p></div>" +
						"</body></html>";
			
		Source source = new Source(HTML);
		source.fullSequentialParse();
		SWRadioContentParser parser = new SWRadioContentParser();
		Element bodyElement = parser.extractElementContainingBody(source);
		Assert.assertEquals("longest", bodyElement.getAttributeValue("id"));
	}


}
