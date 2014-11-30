package lgq.model;


public class Paper {
	private int articleId;
	private String title;
	private String keyWord;
	private String type1;
	private String type2;
	private String userId;
	private String author;
	private int flag;
	private byte[] content;
	private int downloadTimes;
	private int authorNum;
	private double score;
	private int year;
	private int month;
	private String name;
	private String sci;
	private String ei;
	private String istp;
	private String effect;
	private String otherInfo;
	
	public int getAuthorNum() {
		return authorNum;
	}
	public void setAuthorNum(int authorNum) {
		this.authorNum = authorNum;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSci() {
		return sci;
	}
	public void setSci(String sci) {
		this.sci = sci;
	}
	public String getEi() {
		return ei;
	}
	public void setEi(String ei) {
		this.ei = ei;
	}
	public String getIstp() {
		return istp;
	}
	public void setIstp(String istp) {
		this.istp = istp;
	}
	public String getEffect() {
		return effect;
	}
	public void setEffect(String effect) {
		this.effect = effect;
	}
	public String getOtherInfo() {
		return otherInfo;
	}
	public void setOtherInfo(String otherInfo) {
		this.otherInfo = otherInfo;
	}
	public int getDownloadTimes() {
		return downloadTimes;
	}
	public void setDownloadTimes(int downloadTimes) {
		this.downloadTimes = downloadTimes;
	}
	public int getArticleId() {
		return articleId;
	}
	public void setArticleId(int articleId) {
		this.articleId = articleId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getKeyWord() {
		return keyWord;
	}
	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}
	public String getType1() {
		return type1;
	}
	public void setType1(String type1) {
		this.type1 = type1;
	}
	public String getType2() {
		return type2;
	}
	public void setType2(String type2) {
		this.type2 = type2;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	public byte[] getContent() {
		return content;
	}
	public void setContent(byte[] content) {
		this.content = content;
	}
}

