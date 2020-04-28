package com.am.utils;

import java.util.ArrayList;
import java.util.List;

public class GenerateData {
 

static String result;

     static void isDataPerson(String inputNumber){
        List<String> listPersonData = new ArrayList<String>();
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

    }


   private static String isPrintString(String tx){
      int endindex = tx.length();
      String  ntext = tx.substring(1,endindex-1);
      System.out.println(ntext);
      return ntext;
   }
}
