package board.entity;

import java.util.Date;

public class Comment {
	private String writerProfileImageUrl;
	private String writerNickname;
	private Date writeDatetime;
	private String content;

	public Comment() {
	}

	public Comment(String writerProfileImageUrl, String writerNickname, Date writeDatetime, String content) {
		this.writerProfileImageUrl = writerProfileImageUrl;
		this.writerNickname = writerNickname;
		this.writeDatetime = writeDatetime;
		this.content = content;
	}

	public String getWriterProfileImageUrl() {
		return writerProfileImageUrl;
	}

	public String getWriterNickname() {
		return writerNickname;
	}

	public Date getWriteDatetime() {
		return writeDatetime;
	}

	public String getContent() {
		return content;
	}

	public void setWriterProfileImageUrl(String writerProfileImageUrl) {
		this.writerProfileImageUrl = writerProfileImageUrl;
	}

	public void setWriterNickname(String writerNickname) {
		this.writerNickname = writerNickname;
	}

	public void setWriteDatetime(Date writeDatetime) {
		this.writeDatetime = writeDatetime;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "Comment [writerProfileImageUrl=" + writerProfileImageUrl + ", writerNickname=" + writerNickname
				+ ", writeDatetime=" + writeDatetime + ", content=" + content + "]";
	}

}
