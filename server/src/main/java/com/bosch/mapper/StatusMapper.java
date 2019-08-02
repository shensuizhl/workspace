package com.bosch.mapper;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component("statusMapper")
public interface StatusMapper {

    @Select("SELECT * FROM TM_STATUS WHERE USER_ID=#{userId}")
    HashMap selectStatus(int userId);

    @Update("UPDATE TM_STATUS SET ${type}=1 WHERE USER_ID=#{userId}")
    int updateStatusToTrue(int userId, String type);

    @Update("UPDATE TM_STATUS SET ${type}=0 WHERE USER_ID=#{userId}")
    int updateStatusToFalse(int userId, String type);

    @Update("UPDATE TM_STATUS SET ACTIVE_ACTION_POSITION=0, ACTIVE_ADDRESS=0, ACTIVE_AGE_GENDER=0, ACTIVE_BASEPAY_GRADE=0, " +
            "ACTIVE_EDUCATION=0, ACTIVE_LEAVE_REPORT=0, ACTIVE_OT=0, TERMINATION_ACTION_POSITION=0, TERMINATION_ADDRESS=0, " +
            "TERMINATION_AGE_GENDER=0, TERMINATION_BASEPAY_GRADE=0, TERMINATION_EDUCATION=0, TERMINATION_LEAVE_REPORT=0, " +
            "TERMINATION_OT=0 WHERE USER_ID=#{userId}")
    int updateAllStatusToFalse(int userId);
}
