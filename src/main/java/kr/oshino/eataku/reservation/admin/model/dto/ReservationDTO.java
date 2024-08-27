package kr.oshino.eataku.reservation.admin.model.dto;

import kr.oshino.eataku.common.enums.ReservationStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ReservationDTO {


    private int reservationNo;
    private Long memberNo;
    private Long restaurantNo;
    private int partySize;
    private Set<ReservationStatus> reservationStatus;
    private LocalDate reservationDate;
    private LocalTime reservationTime;
    private LocalDateTime createdTime;
    private LocalDateTime updatedTime;
}