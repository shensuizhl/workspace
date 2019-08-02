package com.bosch.mapper;

import com.bosch.vo.EmployeeVO;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component("employeeMapper")
public interface EmployeeMapper {

    @Update("UPDATE TM_EMPLOYEE SET " +
            "TERMINATION=#{termination}, IMPORT_TIME=now(), LOC_CHANGE_STATUS=#{locChangeStatus}," +
            "ADDRESS=#{yearOfGraduation}, CERTIFICATE=#{certificate}, STAR_LEVEL=#{starLevel}," +
            "LOCATION_OF_UNIVERSITY=#{locationOfUniversity}, AGE_OF_EMPLOYEE=#{ageOfEmployee}, BIRTH_DATE=#{birthDate}," +
            "GENDER_KEY=#{genderKey}, MARITAL_STATUS_KEY=#{maritalStatusKey}, NO_CH=#{noCh}, PAYMENT=#{payment}," +
            "GRADE=#{grade}, GRADE_CHANGE_PER=#{gradeChangePer}, ORGANIZATION_UNIT=#{organizationUnit}," +
            "POSITION=#{position}, YEAR_OF_WORK=#{yearOfWork}, TERMINATION_DATE=#{terminationDate}," +
            "YEAR_OF_CURRENT_POSITION=#{yearOfCurrentPosition} WHERE PER_NUMBER=#{perNumber}")
    int updateEmployee(EmployeeVO employeeVO);

    @Results({
            @Result(property = "perNumber", column = "PER_NUMBER"),
            @Result(property = "termination", column = "TERMINATION"),
            @Result(property = "importTime", column = "IMPORT_TIME"),
            @Result(property = "locChangeStatus", column = "LOC_CHANGE_STATUS"),
            @Result(property = "address", column = "ADDRESS"),
            @Result(property = "distance", column = "DISTANCE"),
            @Result(property = "institution", column = "INSTITUTION"),
            @Result(property = "yearOfGraduation", column = "YEAR_OF_GRADUCATION"),
            @Result(property = "certificate", column = "CERTIFICATE"),
            @Result(property = "starLevel", column = "STAR_LEVEL"),
            @Result(property = "locationOfUniversity", column = "LOCATION_OF_UNIVERSITY"),
            @Result(property = "ageOfEmployee", column = "AGE_OF_EMPLOYEE"),
            @Result(property = "birthDate", column = "BIRTH_DATE"),
            @Result(property = "genderKey", column = "GENDER_KEY"),
            @Result(property = "maritalStatusKey", column = "MARITAL_STATUS_KEY"),
            @Result(property = "noCh", column = "NO_CH"),
            @Result(property = "payment", column = "PAYMENT"),
            @Result(property = "grade", column = "GRADE"),
            @Result(property = "gradeChangePer", column = "GRADE_CHANGE_PER"),
            @Result(property = "organizationUnit", column = "ORGANIZATION_UNIT"),
            @Result(property = "position", column = "POSITION"),
            @Result(property = "yearOfWork", column = "YEAR_OF_WORK"),
            @Result(property = "terminationDate", column = "TERMINATION_DATE"),
            @Result(property = "yearOfCurrentPosition", column = "YEAR_OF_CURRENT_POSITION")
    })
    @Select("SELECT * FROM TM_EMPLOYEE")
    List<EmployeeVO> selectEmployee();
}
