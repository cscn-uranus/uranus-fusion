package com.uranus.transition.common.dto;

import com.uranus.transition.common.asterix.uap.shared.track.TimeOfTrack;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * @author tellxp@github.com
 * @date 2019/5/24 15:06
 */
public class TimeOfTrackParser {
  public static LocalDateTime parse(TimeOfTrack timeOfTrack) {
    if (null==timeOfTrack) {
      return LocalDateTime.now();
    }

    LocalDate today = LocalDate.now();
    LocalDate yesterday = LocalDate.now().minusDays(1);
    long secondOfTrack = timeOfTrack.getTime().longValue();
    long secondOfToday = LocalTime.now().toSecondOfDay();

    LocalDateTime time;
    if (secondOfTrack > secondOfToday) {
      time = LocalDateTime.of(yesterday, LocalTime.ofSecondOfDay(secondOfTrack));
    } else {
      time = LocalDateTime.of(today, LocalTime.ofSecondOfDay(secondOfTrack));
    }

    return time;
  }
}
