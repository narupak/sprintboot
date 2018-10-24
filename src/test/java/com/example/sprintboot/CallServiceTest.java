package com.example.sprintboot;

import com.example.sprintboot.Business.BusinessService;
import com.example.sprintboot.entity.*;
import com.example.sprintboot.web.LicenseCarVM;
import com.example.sprintboot.web.RegisAuctionRealtimeVM;
import com.example.sprintboot.web.RegisterAuctionVM;
import com.example.sprintboot.web.UserVM;
import com.google.gson.Gson;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;

import java.util.*;

public class CallServiceTest {

    public BusinessService service;

    @Test
    public void test() {
        //Assert.assertTrue(1 == 2);
        String url = "http://157.179.133.2:8080/queryMemberRegisterAuctionLicenseCar";
        String url_firebase = "https://auctioncarapp.firebaseio.com/.json";
        String url_firbase_monai = "https://carauctionapp-dee69.firebaseio.com/.json";
        RestTemplate restTemplate = new RestTemplate();
        GenericResponse<RegisAuctionRealtimeVM> result = restTemplate.getForObject(url, GenericResponse.class);
        List<RegisAuctionRealtimeVM> regis = result.getResults();
        Map regisMap = new HashMap();
        Member member;
        /////////////////// loop for  regis ////////////////////////////////////////////
        for (LinkedHashMap<String, RegisAuctionRealtimeVM> realtime : regis) {
            /////////////////// map UserVM//////////////////////////////
            List<Map> userList = new ArrayList<>();
            userList = (List<Map>) realtime.get("userVM");
            /////////////////// map UserVM//////////////////////////////

            /////////////////// map licenseCarVM//////////////////////////
            Map<String, RegisAuctionRealtimeVM> licenseCarVM = realtime.get("licenseCarVM");
            /////////////////// map licenseCarVM//////////////////////////

            //////////////////// initial object////////////////////////////
            History history = new History();
            Person person = new Person();
            member = new Member();
            Map<String, Member> memberMap = new HashMap<>();
            //////////////////// initial object////////////////////////////
            //////////////////// loop for set member//////////////////////
            for(Map<String,Integer> userLists : userList){
                member.setId(1L);
                memberMap.put(userLists.get("id").toString(), member);
            }
            //////////////////// loop for set member//////////////////////

            //////////////////// set AuctionType//////////////////////////////
            AuctionType auctionType = new AuctionType();
            member.setId(1L);
            history.setMember(member);
            person.setMember(memberMap);
            Winner winner = new Winner();
            winner.setPrice(Long.valueOf(String.valueOf(licenseCarVM.get("firstprice"))));
            winner.setBidTime(0L);
            winner.setMember(memberMap);
            auctionType.setHistory(history);
            auctionType.setPerson(person);
            auctionType.setWinner(winner);
            //////////////////// set AuctionType//////////////////////////////

            //////////////////// map licenseCarId to key//////////////////////
            regisMap.put(licenseCarVM.get("seq"), auctionType);
            //////////////////// map licenseCarId to key//////////////////////

            //////////////////// put data to firebase////////////////////////
            restTemplate.put(url_firebase,regisMap,String.class);
            restTemplate.put(url_firbase_monai,regisMap,String.class);
            //////////////////// put data to firebase////////////////////////

        }

        /////////////////// loop for  regis ////////////////////////////////////////////
    }
}
