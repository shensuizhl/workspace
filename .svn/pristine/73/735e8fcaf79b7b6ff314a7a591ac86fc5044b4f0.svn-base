package com.bosch.mapper;

import com.bosch.dto.ActionPosition;
import com.bosch.dto.BasepayGrade;
import com.bosch.vo.ChartVO;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Component("actionPositionMapper")
public interface ActionPositionMapper {

//    @Results({
//            @Result(property = "index", column = "NUM"),
//            @Result(property = "label", column = "ORGANIZATION"),
//            @Result(property = "value", column = "VALUE")
//    })
//    @Select("SELECT @num:=@num+1 AS NUM, ACTION_POSITION.ORGANIZATIONAL_UNIT, COUNT(*) AS VALUE FROM ACTION_POSITION,(SELECT@num:=0) r " +
//            "WHERE TP_ACTION_POSITION.ACTION_TYPE='TERMINATION' GROUP BY TP_ACTION_POSITION.ORGANIZATIONAL_UNIT;")
//    List<ChartVO> queryDepartmentTermination();


    @Insert({
            "<script>",
            "INSERT INTO TP_ACTION_POSITION(USER_ID, TERMINATION, IMPORT_TIME, PER_NUMBER, ORGANIZATION_UNIT,",
            "START_DATE, END_DATE, ACTION_TYPE, REASON_FOR_ACTION, LAST, ENTRY, START_DATE_1, END_DATE_1,",
            "POSITION, CHECKED) VALUES",
            "<foreach collection='actionPositionList' item='action' index='index' separator=','>",
            "(#{userId}, #{termination}, NOW(), #{action.perNumber}, #{action.organizationUnit}, #{action.startDate}, ",
            "#{action.endDate}, #{action.actionType}, #{action.reasonForAction} ,#{action.last}, #{action.entry}",
            "#{action.startDate1}, #{action.endDate1}, #{action.position}, 0)",
            "</foreach>",
            "</script>"
    })
    int insertActionPositionList(@Param(value="actionPositionList") List<ActionPosition> actionPositionList,
                               @Param(value="userId") int userId,
                               @Param(value="termination") boolean termination);


    @Update("UPDATE TP_ACTION_POSITION SET " +
            "IMPORT_TIME=now(), PER_NUMBER=#{perNumber}," +
            "ORGANIZATION_UNIT=#{organizationUnit}, START_DATE=#{startDate}, END_DATE=#{endDate}, " +
            "ACTION_TYPE=#{actionType}, REASON_FOR_ACTION=#{reasonForAction}, LAST=#{last}," +
            "ENTRY=#{entry}, START_DATE_1=#{startDate1}, END_DATE_1=#{endDate1}, POSITION=#{position}" +
            "WHERE ACTION_ID=#{actionId} AND USER_ID=#{userId}")
    int updateActionPosition(ActionPosition actionPosition);

    @Results(id = "actionPositionMap", value = {
            @Result(property = "actionId", column = "ACTION_ID"),
            @Result(property = "userId", column = "USER_ID"),
            @Result(property = "termination", column = "TERMINATION"),
            @Result(property = "importTime", column = "IMPORT_TIME"),
            @Result(property = "perNumber", column = "PER_NUMBER"),
            @Result(property = "organizationUnit", column = "ORGANIZATION_UNIT"),
            @Result(property = "startDate", column = "START_DATE"),
            @Result(property = "endDate", column = "END_DATE"),
            @Result(property = "actionType", column = "ACTION_TYPE"),
            @Result(property = "reasonForAction", column = "REASON_FOR_ACTION"),
            @Result(property = "last", column = "LAST"),
            @Result(property = "entry", column = "ENTRY"),
            @Result(property = "startDate1", column = "START_DATE_1"),
            @Result(property = "endDate1", column = "END_DATE_1"),
            @Result(property = "position", column = "POSITION")
    })
    @Select("SELECT * FROM TP_ACTION_POSITION WHERE TERMINATION=#{termination} AND CHECKED = 0 AND USER_ID=#{userId}")
    List<ActionPosition> selectActionPositionList(int userId, boolean termination);

    @ResultMap("actionPositionMap")
    @Select("SELECT * FROM TP_ACTION_POSITION WHERE USER_ID=#{userId} AND ACTION_ID=#{tempId}")
    ActionPosition selectActionPosition(int userId, int tempId);

    @Delete("DELETE FROM TP_ACTION_POSITION WHERE USER_ID=#{userId} AND TERMINATION=#{termination}")
    int deleteAllActionPosition(int userId, boolean termination);


}
