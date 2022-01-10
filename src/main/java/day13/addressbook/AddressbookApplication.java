package day13.addressbook;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.DefaultApplicationArguments;
import org.springframework.boot.SpringApplication; 
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.slf4j.Logger; import org.slf4j.LoggerFactory;

@SpringBootApplication
public class AddressbookApplication {

	private static final Logger logger = LoggerFactory.getLogger(AddressbookApplication.class);
	private static String userDir;
	
	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(AddressbookApplication.class);
		ApplicationArguments appArgs = new DefaultApplicationArguments(args);
		List<String> optsval = appArgs.getOptionValues("dataDir");
		if (optsval!=null)
			{userDir = optsval.get(0);}	else{System.err.println("no dir specified"); System.exit(1);}

			// File f = Paths.get(userDir).toFile();
			// if(!f.exists()&&!f.isFile())
			// 	{f.mkdirs();
			// 	logger.info("2. DIRECTORY CREATED >>" + userDir);}else{logger.info("2. DIRECTORY EXISTS >>" + userDir);}

		app.run(args);		
	}
}