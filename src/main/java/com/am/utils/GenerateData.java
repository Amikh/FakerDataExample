package com.am.utils;

import com.am.db.MySQLAccess;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class GenerateData {
 

   static String result;
   static List<String> listPersonData = null;
     public static void isDataPerson(String inputNumber)throws Exception{
        listPersonData= new ArrayList<String>();
        FakerData fd = new FakerData();
        Person p = new Person();
        String fn = fd.isFirstName();
        String ln = fd.isSecondName();
        String em = fn+"@company.com";
        String cy = fd.isCity();
        String cu = fd.isCountry();
           int nd = fd.generateUserId();

        p.setFirstName(fn);
        p.setLastName(ln);
        p.setEmail(em);
        p.setCity(cy);
        p.setCountry(cu);
        p.setId(nd);

        String tmpstr = Integer.toString(p.getId());
        listPersonData.add(inputNumber);
        listPersonData.add(p.getFirstName());
        listPersonData.add(p.getLastName());
        listPersonData.add(p.getEmail());
        listPersonData.add(p.getCity());
        listPersonData.add(p.getCountry());
        listPersonData.add(tmpstr);
        result= isPrintString(listPersonData.toString());
        isInsertDataToDB();

    }


   private static String isPrintString(String tx){
      int endindex = tx.length();
      String  ntext = tx.substring(1,endindex-1);
      System.out.println(ntext);
      return ntext;
   }

    public static  void isInsertDataToDB()throws Exception{
        String id = listPersonData.get(0);
        int idn = Integer.parseInt(id);
        String fn = listPersonData.get(1);
        String ln = listPersonData.get(2);
        String em = listPersonData.get(3);
        String cn = listPersonData.get(4);
        String cy = listPersonData.get(5);
        String soc = listPersonData.get(6);
        int sn = Integer.parseInt(soc);

       String query="INSERT INTO person_data " + "VALUES ('"+ idn +"', '"+ fn +"', '"+ ln +"', '"+ em +"', '"+ cn +"', '"+ cy +"','"+ sn +"')";
       //MySQLAccess.readDataBase("person",query);
       MySQLAccess ms = new MySQLAccess();
       ms.readDataBase("person",query);
    }
}
