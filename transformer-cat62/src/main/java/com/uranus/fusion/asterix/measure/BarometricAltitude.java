package com.uranus.fusion.asterix.measure;

/**
 * BarometricAltitude
 *
 * @author 肖鹏 tellxp@github.com
 * @date 2018/10/26
 */
public class BarometricAltitude {

  private QnhStatus qnhStatus;
  private Double altitude;

  public QnhStatus getQnhStatus() {
    return qnhStatus;
  }

  public void setQnhStatus(QnhStatus qnhStatus) {
    this.qnhStatus = qnhStatus;
  }

  public Double getAltitude() {
    return altitude;
  }

  public void setAltitude(Double altitude) {
    this.altitude = altitude;
  }

}
