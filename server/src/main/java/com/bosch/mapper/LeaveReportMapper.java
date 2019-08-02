package com.bosch.mapper;

import com.bosch.dto.LeaveReport;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;

@Component("leaveReportMapper")
public interface LeaveReportMapper {

    @Insert({
            "<script>",
            "INSERT INTO TP_LEAVE_REPORT(USER_ID, TERMINATION, IMPORT_TIME, PER_NUMBER, START_DATE,",
            "END_DATE, START_TIME, END_TIME, ATTENDANCE_OF_ABSENCE_TYPE, HOURS, TOTAL_ABS_HOURS, TOTA_ABS_DAYS, CHECKED) VALUES",
            "<foreach collection='leaveReportList' item='leave' index='index' separator=','>",
            "(#{userId}, #{termination}, NOW(), #{leave.perNumber}, #{leave.startDate}, #{leave.endDate},",
            "#{leave.startTime}, #{leave.endTime} ,#{leave.attendanceOfAbsenceType}, #{leave.hours},",
            "#{leave.totalAbsHours}, #{leave.totalAbsDays}, 0)",
            "</foreach>",
            "</script>"
    })
    int insertLeaveReportList(@Param(value="leaveReportList") List<LeaveReport> leaveReportList,
                            @Param(value="userId") int userId,
                            @Param(value="termination") boolean termination);

    @Update("UPDATE TP_LEAVE_REPORT SET " +
            "IMPORT_TIME=now(), PER_NUMBER=#{perNumber}," +
            "START_DATE=#{startDate}, END_DATE=#{endDate}, START_TIME=#{startTime}," +
            "END_TIME=#{endTime}, ATTENDANCE_OF_ABSENCE_TYPE=#{attendanceOfAbsenceType}, HOURS=#{hours}," +
            "TOTAL_ABS_HOURS=#{totalAbsHours}, TOTAL_ABS_DAYS=#{totalAbsDays}" +
            "WHERE LEAVE_REPORT_ID=#{leaveReportId} AND USER_ID=#{userId} AND TERMINATION=#{termination}")
    int updateLeaveReport(LeaveReport leaveReport);

    @Results(id = "leaveReportMap", value = {
            @Result(property = "leaveReportId", column = "LEAVE_REPORT_ID"),
            @Result(property = "userId", column = "USER_ID"),
            @Result(property = "termination", column = "TERMINATION"),
            @Result(property = "importTime", column = "IMPORT_TIME"),
            @Result(property = "perNumber", column = "PER_NUMBER"),
            @Result(property = "startDate", column = "START_DATE"),
            @Result(property = "endDate", column = "END_DATE"),
            @Result(property = "startTime", column = "START_TIME"),
            @Result(property = "endTime", column = "END_TIME"),
            @Result(property = "attendanceOfAbsenceType", column = "ATTENDANCE_OF_ABSENCE_TYPE"),
            @Result(property = "hours", column = "HOURS"),
            @Result(property = "totalAbsHours", column = "TOTAL_ABS_HOURS"),
            @Result(property = "totalAbsDays", column = "TOTAL_ABS_DAYS")
    })
    @Select("SELECT * FROM TP_LEAVE_REPORT WHERE TERMINATION=#{termination} AND CHECKED = 0 AND USER_ID=#{userId}")
    List<LeaveReport> selectLeaveReportList(int userId, boolean termination);

    @ResultMap("leaveReportMap")
    @Select("SELECT * FROM TP_LEAVE_REPORT WHERE USER_ID=#{userId} AND LEAVE_REPORT_ID=#{tempId}")
    LeaveReport selectLeaveReport(int userId, int tempId);

    @Delete("DELETE FROM TP_LEAVE_REPORT WHERE USER_ID=#{userId} AND TERMINATION=#{termination}")
    int deleteAllLeaveReport(int userId, boolean termination);
}
