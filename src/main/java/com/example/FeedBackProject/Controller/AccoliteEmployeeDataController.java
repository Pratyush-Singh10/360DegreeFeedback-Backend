package com.example.FeedBackProject.Controller;

import com.example.FeedBackProject.Entity.DarwinData;
import com.example.FeedBackProject.Repository.DarwinDataRepository;
import com.example.FeedBackProject.utils.AccoliteEmployeeData;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/test")
public class AccoliteEmployeeDataController {

    @Autowired
    private DarwinDataRepository darwinDataRepository;

    @GetMapping("/employees")
    public Map<String, String> getEmployees() throws IOException {
        String url = "https://eo66tim1i8ga55j.m.pipedream.net/";

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        String username = "au_master_prod_user";
        String password = "bScK@LMjTsVVa#E2PiUQrfEE";
        String credentials = username + ":" + password;
        byte[] credentialsBytes = credentials.getBytes(StandardCharsets.UTF_8);
        byte[] encodedBytes = Base64.encodeBase64(credentialsBytes);
        String encodedCredentials = new String(encodedBytes, StandardCharsets.UTF_8);

        headers.add("Authorization", "Basic " + encodedCredentials);

        Map<String, String> requestBody = new HashMap<>();
        requestBody.put("api_key", "zp6ueklch320sl#kvxf#2$eitbpk!+^%%jqr+y^2jck$12@i+hgx6#&l!1yqxingq0s4fd3f@r^jgaup6d00povw307ubm4egdjzdoorv?rchr8ywvyjh0accfz9c!*^");
        requestBody.put("dataset_key", "x04!ib5wgtztnabfpmdxzkct6+b&kstz3bskiw|bd6h2q4af@^4qi7j#x*|0mk4n08f5*i|iqruopkxtnasqalmbsh5nzetnbj^7qm*hyuk&uo%yc$#fp!cthy7gwhpa");

        HttpEntity<Map<String, String>> requestEntity = new HttpEntity<>(requestBody, headers);

        ResponseEntity<String> responseEntity = restTemplate.postForEntity(url, requestEntity, String.class);

        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> responseMap = objectMapper.readValue(responseEntity.getBody(), new TypeReference<Map<String, Object>>(){});

        List<AccoliteEmployeeData> employeeDataList = objectMapper.convertValue(responseMap.get("employee_data"), new TypeReference<List<AccoliteEmployeeData>>(){});
        Map<String, String> employeeMap = new HashMap<>();
        for(AccoliteEmployeeData employeeData : employeeDataList) {
            String name = employeeData.getFirst_name()+" "+employeeData.getMiddle_name()+" "+employeeData.getLast_name();
            DarwinData darwinData = new DarwinData();
            darwinData.setEmpId(employeeData.getEmployee_id());
            darwinData.setEmailId(employeeData.getCompany_email_id());
            darwinData.setName(name);
            darwinData.setManagerEmpId(employeeData.getDirect_manager_employee_id());
            darwinData.setBuName(employeeData.getBusiness_unit());
            darwinData.setHod(employeeData.getHod());
            this.darwinDataRepository.save(darwinData);

            employeeMap.put(employeeData.getCompany_email_id(), employeeData.getEmployee_id());
        }
        return employeeMap;
    }
}

