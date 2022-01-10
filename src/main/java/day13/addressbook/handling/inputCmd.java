package day13.addressbook.handling;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.ui.Model;


import day13.addressbook.data.ContactDetails;

public class inputCmd {
    private static final Logger logger = LoggerFactory.getLogger(inputCmd.class);
    public void saveDetails(ContactDetails contact, ApplicationArguments appargs){
            List<String> optsval = appargs.getOptionValues("dataDir");
            String hex=contact.getId();
            File f = new File(""); String absPath = f.getAbsolutePath(); logger.info(absPath); //absPath=absPath.replace("\\", "/");    logger.info(absPath);
            File dir = Paths.get(absPath + optsval.get(0)).toFile(); dir.mkdirs();
            dir = Paths.get(absPath + optsval.get(0) + "/" + hex + ".txt").toFile();logger.info(dir.toString() + hex +optsval.get(0));
            
            try {
                dir.createNewFile();
            } catch (Exception e) {logger.info("File not created"+ dir.toString());}
            
            try {
                BufferedWriter bw = new BufferedWriter(new FileWriter(dir, StandardCharsets.UTF_8, true));
                bw.write(contact.getName());bw.newLine(); 
                bw.write(contact.getEmail());bw.newLine();
                bw.write(contact.getPhone());bw.newLine();
                bw.flush();bw.close();
            } catch (Exception e) {logger.info("BUFFERED WRITER ERROR");}
            
            
    }

    public ContactDetails retrieveId(String id, ApplicationArguments appargs){
        ContactDetails contact = new ContactDetails();
        List<String> optsval = appargs.getOptionValues("dataDir");
        File f = new File(""); String absPath = f.getAbsolutePath();
        File dir = Paths.get(absPath + optsval.get(0) + "/" + id + ".txt").toFile();logger.info("retrieveID>>" + dir.toString());
        if(dir.exists() && dir.canRead()){
            try{
                BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(dir),StandardCharsets.UTF_8));
                    contact.setName(br.readLine());
                    contact.setEmail(br.readLine());
                    contact.setPhone(br.readLine());br.close();
                    logger.info("Contact "+id+" details retrieved:");}catch(Exception e){System.err.println("Buffered Reader Error");}
        }
        contact.setId(id);
        return contact;
    }
}
