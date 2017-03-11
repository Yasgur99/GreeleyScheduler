package application.logic;

/**
 * This class is responsible for taking a valid Chromosome (a valid schedule) and 
 * writing the data in it to a file in the format specified by the school.
 * 
 * @author michaelmaitland
 **/

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class ScheduleWriter {

    /*The schedule which resulted from the completion of the genetic algorithm*/
    private Chromosome validSchedule;
    /*The filename for the file we will create and write the data to*/
    private String outputFilename;
    /*The year this schedule belongs to*/
    private String year;
    
    /**
     * This constructor takes in a validChromosome and a filename and sets the instance variables
     * with the information given.
     * 
     * @param validSchedule the schedule which resulted from the completion of the genetic algorithm.
     * @param outputFilename the filename for the file that we will create and write data to.
     */
    public ScheduleWriter(Chromosome validSchedule, String outputFilename, String year){
        this.validSchedule = validSchedule;
        this.outputFilename = outputFilename;
    }
    
    /**
     * This method is responsible for taking the data from the valid Chromosome and 
     * writing it to a file in the format specified by the school.
     */
    public void write(){
        try(Writer writer = new BufferedWriter(
                new FileWriter(this.outputFilename))){
            /*File header*/
            writer.write("Horace Greeley Master Schedule  " + year + "\n");
            writer.write("Dept/Course/Section        Teacher        Term        Schedule        Period");
        }catch(IOException ex){
            System.out.println("IOException writing to file");
        }
    }
}
