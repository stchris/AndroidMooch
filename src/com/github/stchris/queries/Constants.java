package com.github.stchris.queries;

/**
 * Constants helper class.
 * 
 * @author chris
 *
 */
public abstract class Constants {

	public final static String ASINS_URL = "http://api.bookmooch.com/api/asin?asins={ASINS}&o=json";
	public final static String ASINS_URL_PLACEHOLDER = "{ASINS}";
	
	public final static String SEARCH_URL = "http://api.bookmooch.com/api/search?txt={QUERY}&db={DB}&o=json";
	public final static String SEARCH_URL_QUERY = "{QUERY}";
	public final static String SEARCH_URL_DB = "{DB}";
	
	public final static String KEY_ID = "id";
	public final static String KEY_AUTHOR = "Author";
	public final static String KEY_BINDING = "Binding";
	public final static String KEY_DETAIL_PAGE_URL = "DetailPageURL";
	public final static String KEY_EDITION = "Edition";
	public final static String KEY_ISBN = "ISBN";
	public final static String KEY_PRICE = "ListPrice_FormattedPrice";
	public final static String KEY_CURRENCY = "ListPrice_CurrencyCode";
	public final static String KEY_NUMBER_OF_PAGES = "NumberOfPages";
	public final static String KEY_PUBLICATION_DATE = "PublicationDate";
	public final static String KEY_PUBLISHER = "Publisher";
	public final static String KEY_TITLE = "Title";
	public final static String KEY_STORE = "store";
	public final static String KEY_SMALLIMG_URL = "SmallImage_URL";
	public final static String KEY_SMALLIMG_WIDTH = "SmallImage_Width";
	public final static String KEY_SMALLIMG_HEIGHT = "SmallImage_Height";
	public final static String KEY_LARGEIMG_URL = "LargeImage_URL";
	public final static String KEY_LARGEIMG_WIDTH = "LargeImage_Width";
	public final static String KEY_LARGEIMG_HEIGHT = "LargeImage_Height";
	public final static String KEY_TOPICS = "Topics";
	
	public static final String ISBN_PARAMETER = "book.isbn";
	public static final String IMAGE_TO_SHOW = "image.to.show";
	public static final String SEARCH_STRING = "search.string";
	public static final String SEARCH_ENGINE = "search.engine";
	
	/**
	 TODO add these keys from the asins call
	  
	"giver_ids": ["kernsj", "markwp", "mbreault", "chris28", "luhost", "emessufan", "guidingpaws", "jmgrover", "libladyny", "mlthompson"],
	"moocher_ids": ["alasen", "plingenfelter", "mariahj", "suef", "cyall8tr", "welshhelen", "lynnholland", "mlthompson", "lynnholland", "needsun"],
	"transactions": ["alasen/58", "plingenfelter/331", "mariahj/40", "suef/84", "cyall8tr/68", "welshhelen/55", "lynnholland/29", "mlthompson/20", "lynnholland/60", "needsun/192"],
	"userids": ["waywardcats"]
	 */
}
