package education.model.dto;

import java.util.List;

public class EduOneDto {
//	EDU_ID          NOT NULL NUMBER         
//	EDU_SUBJECT     NOT NULL VARCHAR2(100)  
//	EDU_CONTENT     NOT NULL VARCHAR2(4000) 
//	EDU_ADDRESS     NOT NULL VARCHAR2(300)
//	EDU_PARTICIPANT NOT NULL VARCHAR2(30)
//	EDU_DAY         NOT NULL VARCHAR2(6)    
//	EDU_BOOK_START  NOT NULL DATE           
//	EDU_BOOK_END    NOT NULL DATE           
//	EDU_START       NOT NULL DATE           
//	EDU_END         NOT NULL DATE           
//	EDU_WRITE_TIME  NOT NULL TIMESTAMP(6) 
	private Integer eduId;
	private String eduSubject;
	private String eduContent;
	private String eduAddress;
	private String eduParticipant;
	private String eduDay;
	private String eduBookStart;
	private String eduBookEnd;
	private String eduStart;
	private String eduEnd;
	private String eduWriteTime;
	private Integer eduMaxNum;
	private Integer eduBookNum;
	private List<EduFileDto> eduFileDtoList;

	@Override
	public String toString() {
		return "EduOneDto [eduId=" + eduId + ", eduSubject=" + eduSubject + ", eduContent=" + eduContent
				+ ", eduAddress=" + eduAddress + ", eduParticipant=" + eduParticipant + ", eduDay=" + eduDay
				+ ", eduBookStart=" + eduBookStart + ", eduBookEnd=" + eduBookEnd + ", eduStart=" + eduStart
				+ ", eduEnd=" + eduEnd + ", eduWriteTime=" + eduWriteTime + ", eduMaxNum=" + eduMaxNum + ", eduBookNum="
				+ eduBookNum + ", eduFileDtoList=" + eduFileDtoList + "]";
	}

	public EduOneDto(Integer eduId, String eduSubject, String eduContent, String eduAddress, String eduParticipant,
			String eduDay, String eduBookStart, String eduBookEnd, String eduStart, String eduEnd, String eduWriteTime,
			Integer eduMaxNum, Integer eduBookNum) {
		super();
		this.eduId = eduId;
		this.eduSubject = eduSubject;
		eduContent = eduContent.replaceAll("\\n", "<br>");
//		eduContent = eduContent.replaceAll(" ", "&nbsp;");
		this.eduContent = eduContent;
		this.eduAddress = eduAddress;
		this.eduParticipant = eduParticipant;
		this.eduDay = eduDay;
		this.eduBookStart = eduBookStart;
		this.eduBookEnd = eduBookEnd;
		this.eduStart = eduStart;
		this.eduEnd = eduEnd;
		this.eduWriteTime = eduWriteTime;
		this.eduMaxNum = eduMaxNum;
		this.eduBookNum = eduBookNum;
	}

	public List<EduFileDto> getEduFileDtoList() {
		return eduFileDtoList;
	}

	public void setEduFileDtoList(List<EduFileDto> eduFileDtoList) {
		this.eduFileDtoList = eduFileDtoList;
	}

	public Integer getEduId() {
		return eduId;
	}

	public String getEduSubject() {
		return eduSubject;
	}

	public String getEduContent() {
		return eduContent;
	}

	public String getEduAddress() {
		return eduAddress;
	}

	public String getEduParticipant() {
		return eduParticipant;
	}

	public String getEduDay() {
		return eduDay;
	}

	public String getEduBookStart() {
		return eduBookStart;
	}

	public String getEduBookEnd() {
		return eduBookEnd;
	}

	public String getEduStart() {
		return eduStart;
	}

	public String getEduEnd() {
		return eduEnd;
	}

	public String getEduWriteTime() {
		return eduWriteTime;
	}

	public Integer getEduMaxNum() {
		return eduMaxNum;
	}

	public Integer getEduBookNum() {
		return eduBookNum;
	}

}
