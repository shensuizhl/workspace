package com.bosch.mapper;

import com.bosch.dto.ActionPosition;
import com.bosch.dto.Address;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;

@Component("addressMapper")
public interface AddressMapper {

    @Insert({
            "<script>",
            "INSERT INTO TP_ADDRESS(USER_ID, TERMINATION, IMPORT_TIME, PER_NUMBER, START_DATE,",
            "END_DATE, ADDRESS_RECORD_TYPE, STREET_AND_HOUSE_NUMBER, CHECKED) VALUES",
            "<foreach collection='addressList' item='address' index='index' separator=','>",
            "(#{userId}, #{termination}, NOW(), #{address.perNumber}, #{address.startDate}, #{address.endDate}, ",
            "#{address.addressRecordType}, #{address.streetAndHouseNumber}, 0)",
            "</foreach>",
            "</script>"
    })
    int insertAddressList(@Param(value="addressList") List<Address> addressList, @Param(value="userId") int userId,
                                 @Param(value="termination") boolean termination);

    @Update("UPDATE TP_ADDRESS SET " +
            "IMPORT_TIME=now(), PER_NUMBER=#{perNumber}," +
            "START_DATE=#{startDate}, END_DATE=#{endDate}, ADDRESS_RECORD_TYPE=#{addressRecordType}," +
            "STREET_AND_HOUSE_NUMBER=#{streetAndHouseNumber} WHERE ADDRESS_ID=#{addressId} AND USER_ID=#{userId} AND TERMINATION=#{termination}")
    int updateAddress(Address address);

    @Results(id = "addressMap", value = {
            @Result(property = "addressId", column = "ADDRESS_ID"),
            @Result(property = "userId", column = "USER_ID"),
            @Result(property = "termination", column = "TERMINATION"),
            @Result(property = "importTime", column = "IMPORT_TIME"),
            @Result(property = "perNumber", column = "PER_NUMBER"),
            @Result(property = "startDate", column = "START_DATE"),
            @Result(property = "endDate", column = "END_DATE"),
            @Result(property = "addressRecordType", column = "ADDRESS_RECORD_TYPE"),
            @Result(property = "streetAndHouseNumber", column = "STREET_AND_HOUSE_NUMBER")
    })
    @Select("SELECT * FROM TP_ADDRESS WHERE TERMINATION=#{termination} AND CHECKED = 0 AND USER_ID=#{userId}")
    List<Address> selectAddressList(int userId, boolean termination);

    @ResultMap("addressMap")
    @Select("SELECT * FROM TP_ADDRESS WHERE USER_ID=#{userId} AND ADDRESS_ID=#{tempId}")
    Address selectAddress(int userId, int tempId);

    @Delete("DELETE FROM TP_ADDRESS WHERE USER_ID=#{userId} AND TERMINATION=#{termination}")
    int deleteAllAddress(int userId, boolean termination);


}
