package org.codeprism;


import com.fasterxml.jackson.databind.ObjectMapper;

public class SerilizationAndDeserilization {
    void ConvertPojoToJson()
    {
        data pojo = new data();
        pojo.setEmail("");
        pojo.setLocation("");
        pojo.setPhone("");
        String nameArr[] = {"", ""};
        pojo.setNameArr(nameArr);
        ObjectMapper objmapper = new ObjectMapper();

    }
}
