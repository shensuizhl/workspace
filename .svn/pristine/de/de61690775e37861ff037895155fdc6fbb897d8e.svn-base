package com.bosch.mapper;

import com.bosch.dto.LeaveReport;
import com.bosch.dto.OT;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;

@Component("otMapper")
public interface OTMapper {

    @Insert({
            "<script>",
            "INSERT INTO TP_OT(USER_ID, TERMINATION, IMPORT_TIME, PER_NUMBER, PERIOD,",
            "ORGANIZATION_UNIT, OT_1_0, OT_1_5, OT_2_0, OT_3_0, OT_TOTAL, CHECKED) VALUES",
            "<foreach collection='otList' item='ot' index='index' separator=','>",
            "(#{userId}, #{termination}, NOW(), #{ot.perNumber}, #{ot.period}, #{ot.organizationUnit},",
            "#{ot.ot10}, #{ot.ot15} ,#{ot.ot20}, #{ot.ot30}, #{ot.otTotal}, 0)",
            "</foreach>",
            "</script>"
    })
    int insertOTList(@Param(value="otList") List<OT> otList,
                            @Param(value="userId") int userId,
                            @Param(value="termination") boolean termination);


    @Update("UPDATE TP_OT SET " +
            "IMPORT_TIME=now(), PER_NUMBER=#{perNumber}," +
            "PERIOD=#{period}, ORGANIZATION_UNIT=#{organizationUnit}, OT_1_0=#{ot10}," +
            "OT_1_5=#{ot15}, OT_2_0=#{ot20}, OT_3_0=#{ot30}, OT_TOTAL=#{otTotal}" +
            "WHERE OT_ID=#{otId} AND USER_ID=#{userId} AND TERMINATION=#{termination}")
    int updateOT(OT ot);

    @Results(id = "otMap", value = {
            @Result(property = "otId", column = "OT_ID"),
            @Result(property = "userId", column = "USER_ID"),
            @Result(property = "termination", column = "TERMINATION"),
            @Result(property = "importTime", column = "IMPORT_TIME"),
            @Result(property = "perNumber", column = "PER_NUMBER"),
            @Result(property = "period", column = "PERIOD"),
            @Result(property = "organizationUnit", column = "ORGANIZATION_UNIT"),
            @Result(property = "ot10", column = "OT_1_0"),
            @Result(property = "ot15", column = "OT_1_5"),
            @Result(property = "ot20", column = "OT_2_0"),
            @Result(property = "ot30", column = "OT_3_0"),
            @Result(property = "otTotal", column = "OT_TOTAL")
    })
    @Select("SELECT * FROM TP_OT WHERE TERMINATION=#{termination} AND CHECKED = 0 AND USER_ID=#{userId}")
    List<OT> selectOTList(int userId, boolean termination);

    @ResultMap("otMap")
    @Select("SELECT * FROM TP_OT WHERE USER_ID=#{userId} AND OT_ID=#{tempId}")
    OT selectOT(int userId, int tempId);

    @Delete("DELETE FROM TP_OT WHERE USER_ID=#{userId} AND TERMINATION=#{termination}")
    int deleteAllOT(int userId, boolean termination);
}
