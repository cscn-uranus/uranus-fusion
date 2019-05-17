package com.uranus.fusion.tfr.cat062.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Objects;

/**
 * AddmDTO
 *
 * @author tellxp@github.com
 * @date 2018/11/23
 */
public class AddmDTO implements Serializable {

  private String text;

  private String title;

  private LocalTime sendingTime;

  private String source;

  private String sourceMessageId;

  private LocalDateTime receivedTime;

  private Long receivedTimeNano;


  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public LocalTime getSendingTime() {
    return sendingTime;
  }

  public void setSendingTime(LocalTime sendingTime) {
    this.sendingTime = sendingTime;
  }

  public String getSource() {
    return source;
  }

  public void setSource(String source) {
    this.source = source;
  }

  public String getSourceMessageId() {
    return sourceMessageId;
  }

  public void setSourceMessageId(String sourceMessageId) {
    this.sourceMessageId = sourceMessageId;
  }

  public LocalDateTime getReceivedTime() {
    return receivedTime;
  }

  public void setReceivedTime(LocalDateTime receivedTime) {
    this.receivedTime = receivedTime;
  }

  public Long getReceivedTimeNano() {
    return receivedTimeNano;
  }

  public void setReceivedTimeNano(Long receivedTimeNano) {
    this.receivedTimeNano = receivedTimeNano;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof AddmDTO)) {
      return false;
    }
    AddmDTO that = (AddmDTO) o;
    return Objects.equals(text, that.text) &&
        Objects.equals(title, that.title) &&
        Objects.equals(sendingTime, that.sendingTime) &&
        Objects.equals(source, that.source) &&
        Objects.equals(sourceMessageId, that.sourceMessageId);
  }

  @Override
  public int hashCode() {

    return Objects.hash(text, title, sendingTime, source, sourceMessageId);
  }

  @Override
  public String toString() {
    return "AddmDTO{" +
        "text='" + text + '\'' +
        ", title='" + title + '\'' +
        ", sendingTime=" + sendingTime +
        ", source='" + source + '\'' +
        ", sourceMessageId='" + sourceMessageId + '\'' +
        ", receivedTime=" + receivedTime +
        ", receivedTimeNano=" + receivedTimeNano +
        '}';
  }

  public AddmDTO() {
  }


}
