package kr.oshino.eataku.reservation.user.repository;
import kr.oshino.eataku.reservation.user.entity.Reservation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalTime;
import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation,Integer> {


    /***
     * 예약 등록하는 메소드
     * @param restaurantNo
     * @return
     */
    /* 예약 */
    @Query("SELECT r FROM Reservation r WHERE r.restaurantInfo.restaurantNo = :restaurantNo")
    List<Reservation> findReservationsByRestaurantNo(@Param("restaurantNo") Long restaurantNo);


    /***
     * 해당 하는 식당의 시간을 가져오는 메소드
     * @param restaurantNo
     * @return
     */
    @Query(value = "SELECT r.reservationTime FROM ReservationSetting r WHERE r.restaurantNo.restaurantNo = :restaurantNo")
    List<java.sql.Time> findAllTimesByRestaurantNo(@Param("restaurantNo") Long restaurantNo);




    /***
     * 해당 하는 식당의 인원수를 가져오는 메소드
     * @param restaurantNo
     * @return
     */
    @Query("SELECT r.reservationPeople FROM ReservationSetting r WHERE r.restaurantNo.restaurantNo  = :restaurantNo")
    int findPeopleByRestaurantNo(@Param("restaurantNo") Long restaurantNo);


    /**
     * 해당 인원 수를 제거하는 메소드
     * @param partySize
     * @param reservationNo
     */
    @Modifying
    @Query("UPDATE ReservationSetting r SET r.reservationPeople = r.reservationPeople - :partySize WHERE r.reservationNo = :reservationNo")
    void subtractPartySizeFromReservationPeople(@Param("partySize") int partySize, @Param("reservationNo") Long reservationNo);




}
