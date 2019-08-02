package com.bosch.mapper;

import com.bosch.dto.BasepayGrade;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;

@Component("basepayGradeMapper")
public interface BasepayGradeMapper {
    @Insert({
            "<script>",
            "INSERT INTO TP_BASEPAY_GRADE(USER_ID, TERMINATION, IMPORT_TIME, PER_NUMBER, ORGANIZATION_UNIT,",
            "START_DATE, END_DATE, PAYMENT, GRADE, CHECKED) VALUES",
            "<foreach collection='basepayGradeList' item='basePay' index='index' separator=','>",
            "(#{userId}, #{termination}, NOW(), #{basePay.perNumber}," ,
            "#{basePay.organizationUnit}, #{basePay.startDate}, #{basePay.endDate}, #{basePay.payment}, #{basePay.grade}, 0)",
            "</foreach>",
            "</script>"
    })
    int insertBasepayGradeList(@Param(value="basepayGradeList") List<BasepayGrade> basepayGradeList,
                      @Param(value="userId") int userId,
                      @Param(value="termination") boolean termination);

    @Update("UPDATE TP_BASEPAY_GRADE SET " +
            "IMPORT_TIME=now(), PER_NUMBER=#{perNumber}," +
            "ORGANIZATION_UNIT=#{organizationUnit}, START_DATE=#{startDate}, END_DATE=#{endDate}, " +
            "PAYMENT=#{payment}, GRADE=#{grade} WHERE BASEPAY_ID=#{basepayId} AND USER_ID=#{userId} AND TERMINATION=#{termination}")
    int updateBasepayGrade(BasepayGrade basepayGrade);

    @Results(id = "basepayGradeMap", value = {
            @Result(property = "basepayId", column = "BASEPAY_ID"),
            @Result(property = "userId", column = "USER_ID"),
            @Result(property = "termination", column = "TERMINATION"),
            @Result(property = "importTime", column = "IMPORT_TIME"),
            @Result(property = "perNumber", column = "PER_NUMBER"),
            @Result(property = "organizationUnit", column = "ORGANIZATION_UNIT"),
            @Result(property = "startDate", column = "START_DATE"),
            @Result(property = "endDate", column = "END_DATE"),
            @Result(property = "payment", column = "PAYMENT"),
            @Result(property = "grade", column = "GRADE"),
    })
    @Select("SELECT * FROM TP_BASEPAY_GRADE WHERE TERMINATION=#{termination} AND CHECKED = 0 AND USER_ID=#{userId}")
    List<BasepayGrade> selectBasepayGradeList(int userId, boolean termination);

    @ResultMap("basepayGradeMap")
    @Select("SELECT * FROM TP_BASEPAY_GRADE WHERE USER_ID=#{userId} AND BASEPAY_ID=#{tempId}")
    BasepayGrade selectBasepayGrade(int userId, int tempId);

    @Delete("DELETE FROM TP_BASEPAY_GRADE WHERE USER_ID=#{userId} AND TERMINATION=#{termination}")
    int deleteAllBasepayGrade(int userId, boolean termination);
}
