package com.example.FeedBackProject.Controller;

import com.example.FeedBackProject.Entity.User;
import com.example.FeedBackProject.Repository.UserRepository;
import com.example.FeedBackProject.utils.AccoliteEmployeeData;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.tomcat.util.codec.binary.Base64;
import org.apache.tomcat.util.codec.binary.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.*;

@RestController
@RequestMapping("api/test")
public class AccoliteEmployeeDataController {

    @Autowired
    private UserRepository userRepository;

    @Scheduled(cron = "0 15 0 * * ?")
    public Map<String, String> getEmployees() throws IOException {
        System.out.println("Started");

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

        Set<String> oldSet = new HashSet<>();
        Set<String> newSet = new HashSet<>();

        List<User> employeeList = userRepository.findAll();
        Map<String ,String >employeeMap = new HashMap<>();
        for(User user : employeeList){
            oldSet.add(user.getEmpId());
        }

        for(AccoliteEmployeeData employeeData : employeeDataList) {
            newSet.add(employeeData.getEmployee_id());

            String name;
            name = employeeData.getFirst_name();
            if(!employeeData.getMiddle_name().equals(""))
                name+=" "+employeeData.getMiddle_name();
            name+=" "+employeeData.getLast_name();


            String hod = employeeData.getHod();
            if(hod.equals("N.A."))
                hod="null";
            else {
                hod = hod.substring(hod.indexOf("(") + 1);
                hod = hod.substring(0, hod.indexOf(")"));
            }

            User user = new User();
            user.setEmpId(employeeData.getEmployee_id());
            user.setEmailId(employeeData.getCompany_email_id());
            user.setName(name);
            user.setManagerEmpId(employeeData.getDirect_manager_employee_id());
            user.setBuName(employeeData.getBusiness_unit());
            user.setHod(hod);
            user.setActive(true);
            this.userRepository.save(user);

            employeeMap.put("Message", "Successfully Dumped data from API");
        }

        oldSet.removeAll(newSet);
        System.out.println("\n"+oldSet);

        for(String str : oldSet){
            User user = userRepository.findByEmpId(str);
            user.setActive(false);
            userRepository.save(user);
        }
        System.out.println("Ended");
        return employeeMap;
    }
}


