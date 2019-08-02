package com.bosch.mapper;

import com.bosch.dto.AgeGender;
import com.bosch.dto.Education;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;

@Component("educationMapper")
public interface EducationMapper {

    @Insert({
            "<script>",
            "INSERT INTO TP_EDUCATION(USER_ID, TERMINATION, IMPORT_TIME, PER_NUMBER, START_DATE,",
            "END_DATE, INSTITUTION, LOCATION, CERTIFICATE, MAJOR, CHECKED) VALUES",
            "<foreach collection='educationList' item='education' index='index' separator=','>",
            "(#{userId}, #{termination}, NOW(), #{education.perNumber}, #{education.startDate}, #{education.endDate},",
            "#{education.institution}, #{education.location} ,#{education.certificate}, #{education.major}, 0)",
            "</foreach>",
            "</script>"
    })
    int insertEducationList(@Param(value="educationList") List<Education> educationList,
                            @Param(value="userId") int userId,
                            @Param(value="termination") boolean termination);


    @Update("UPDATE TP_EDUCATION SET " +
            "IMPORT_TIME=now(), PER_NUMBER=#{perNumber}," +
            "START_DATE=#{startDate}, END_DATE=#{endDate}, INSTITUTION=#{institution}," +
            "LOCATION=#{location}, CERTIFICATE=#{certificate}, MAJOR=#{major}" +
            "WHERE EDU_ID=#{eduId} AND USER_ID=#{userId} AND TERMINATION=#{termination}")
    int updateEducation(Education education);

    @Results(id = "educationMap", value = {
            @Result(property = "eduId", column = "EDU_ID"),
            @Result(property = "userId", column = "USER_ID"),
            @Result(property = "termination", column = "TERMINATION"),
            @Result(property = "importTime", column = "IMPORT_TIME"),
            @Result(property = "perNumber", column = "PER_NUMBER"),
            @Result(property = "startDate", column = "START_DATE"),
            @Result(property = "endDate", column = "END_DATE"),
            @Result(property = "institution", column = "INSTITUTION"),
            @Result(property = "location", column = "LOCATION"),
            @Result(property = "certificate", column = "CERTIFICATE"),
            @Result(property = "major", column = "MAJOR")
    })
    @Select("SELECT * FROM TP_EDUCATION WHERE TERMINATION=#{termination} AND CHECKED = 0 AND USER_ID=#{userId}")
    List<Education> selectEducationList(int userId, boolean termination);

    @ResultMap("educationMap")
    @Select("SELECT * FROM TP_EDUCATION WHERE USER_ID=#{userId} AND EDU_ID=#{tempId}")
    Education selectEducation(int userId, int tempId);

    @Delete("DELETE FROM TP_EDUCATION WHERE USER_ID=#{userId} AND TERMINATION=#{termination}")
    int deleteAllEducation(int userId, boolean termination);
}
