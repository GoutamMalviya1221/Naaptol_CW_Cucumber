package Runner;



import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;




@CucumberOptions(features = {"src/test/resources/NaapTol/BodyCare.feature" , 
							"src/test/resources/NaapTol/BabyBedding.feature" ,
							"src/test/resources/NaapTol/BabyCare_KidsWare.feature" ,
							"src/test/resources/NaapTol/BabyCare.feature",
							"src/test/resources/NaapTol/GamesPuzzles.feature",
							"src/test/resources/NaapTol/Outdoor.feature" },
                  glue = "Definations")
public class Runner extends AbstractTestNGCucumberTests {

}
