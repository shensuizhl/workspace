package com.bosch.mapper;

import com.bosch.dto.AgeGender;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Component("ageGenderMapper")
public interface AgeGenderMapper {

    @Insert({
            "<script>",
            "INSERT INTO TP_AGE_GENDER(USER_ID, TERMINATION, IMPORT_TIME, PER_NUMBER, START_DATE,",
            "END_DATE, GENDER_KEY, NO_CH, AGE_OF_EMPLOYEE, MARITAL_STATUS_KEY, CHECKED) VALUES",
            "<foreach collection='ageGenderList' item='age' index='index' separator=','>",
            "(#{userId}, #{termination}, NOW(), #{age.perNumber}, #{age.startDate}, #{action.endDate},",
            "#{age.genderKey}, #{age.noCh} ,#{age.ageOfEmployee}, #{age.maritalStatusKey}, 0)",
            "</foreach>",
            "</script>"
    })
    int insertAgeGenderList(@Param(value="ageGenderList") List<AgeGender> ageGenderList,
                                 @Param(value="userId") int userId,
                                 @Param(value="termination") boolean termination);

    @Update("UPDATE TP_AGE_GENDER SET " +
            "IMPORT_TIME=now(), PER_NUMBER=#{perNumber}," +
            "START_DATE=#{startDate}, END_DATE=#{endDate}, GENDER_KEY=#{genderKey}," +
            "NO_CH=#{noCh}, AGE_OF_EMPLOYEE=#{ageOfEmployee}, MARITAL_STATUS_KEY=#{maritalStatusKey}" +
            "WHERE AG_ID=#{agId} AND USER_ID=#{userId} AND TERMINATION=#{termination}")
    int updateAgeGender(AgeGender ageGender);

    @Results(id = "ageGenderMap", value = {
            @Result(property = "agId", column = "AG_ID"),
            @Result(property = "userId", column = "USER_ID"),
            @Result(property = "termination", column = "TERMINATION"),
            @Result(property = "importTime", column = "IMPORT_TIME"),
            @Result(property = "perNumber", column = "PER_NUMBER"),
            @Result(property = "startDate", column = "START_DATE"),
            @Result(property = "endDate", column = "END_DATE"),
            @Result(property = "genderKey", column = "GENDER_KEY"),
            @Result(property = "noCh", column = "NO_CH"),
            @Result(property = "ageOfEmployee", column = "AGE_OF_EMPLOYEE"),
            @Result(property = "maritalStatusKey", column = "MARITAL_STATUS_KEY")
    })
    @Select("SELECT * FROM TP_AGE_GENDER WHERE TERMINATION=#{termination} AND CHECKED = 0 AND USER_ID=#{userId}")
    List<AgeGender> selectAgeGenderList(int userId, boolean termination);

    @ResultMap("ageGenderMap")
    @Select("SELECT * FROM TP_AGE_GENDER WHERE USER_ID=#{userId} AND AG_ID=#{tempId}")
    AgeGender selectAgeGender(int userId, int tempId);

    @Delete("DELETE FROM TP_AGE_GENDER WHERE USER_ID=#{userId} AND TERMINATION=#{termination}")
    int deleteAllAgeGender(int userId, boolean termination);
}
