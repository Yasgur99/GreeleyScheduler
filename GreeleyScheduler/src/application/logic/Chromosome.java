package application.logic;

/**
 * This class represents a possible schedule. It also has variables and methods that show how fit the schedule
 * is. It does this by determining how many conflicts there are in the schedule. A conflict is defined by a 
 * section meeting at the same time, a teacher teaching another course at the same time, or a teacher constraint 
 * being violated. The fitness of a schedule is found by taking the reciprocal of the (numOfConflicts+1) so a 
 * schedule is valid when the fraction equals one.
 * 
 * @author michaelmaitland
 */

import application.elements.Section;
import application.elements.Teacher;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Chromosome {

    /*Double that represents how fit a schedule is. Closer to 1 the better*/
    private double fitness;
    /*The exact number of conflicts/issues this schedule has*/
    private int numOfConflicts;
    /*The actual schedule and which courses/section/period each Section belongs to*/
    private Section[][] genes;
    /*The max number of Sections in each course/section/period*/
    private int maxInSlot;
    
    /**
     * This constructor takes in a list of sections and creates a schedule at random and then
     * calculates the fitness of the schedule. The schedule is represented by an array with 8 slots 
     * for an array of maxInSlot Sections.
     * 
     * @see Section
     **/
    public Chromosome(List<Section> sections){
        /*Determine how many sections can fit into a slot*/
        this.maxInSlot = (int)Math.ceil((double)sections.size()/8);
        /*Initialize array of 8 slots that hold maxInSlot Sections*/
        this.genes = new Section[8][maxInSlot];
        Random r = new Random();
        
        /*Loop all Sections so we can put each one in a time slot at random*/
        for(int i=0;i<sections.size();i++){
            int slot = r.nextInt(8);
            /*If there are already too enough Sections in current slot, try again*/
            if(this.genes[slot][maxInSlot-1] != null ){
                i--;
                continue;
            }
            /*Add section to time slot since there is room*/
            for(int k=0;k<maxInSlot;k++){
                /*If we are at the place where section should be inserted, put it in*/
                if(this.genes[slot][k] == null){
                    this.genes[slot][k] = sections.get(i);
                    break;
                }
            }
        }
        /*Calculate fitness for chromosome since it is ready*/
        calculateFitness();
    }
    
    /**
     * This method determines the number of conflicts this chromosome has and sets the fitness value.
     * The closer to 1 it returns, the less number of conflicts there are and the more fit it is.
     **/
    public void calculateFitness(){
        this.numOfConflicts = 0;
        for(int i=0;i<genes.length;i++){
        //TODO: add to fitness if it meets wanted constraints for each gene
        }
        this.fitness = 1/(double)numOfConflicts + 1;
    }
    
    /**
     * @return the fitness value of this schedule
     **/
    public double getFitness(){
        /*Re-calculate the fitness before returning*/
        calculateFitness();
        return this.fitness;
    }
    
    /**
     * @return the array of array of Sections that makeup this schedule
     */
    public Section[][] getGenes(){
        return this.genes;
    }
    
    /**
     * @return the number of slots this schedule has (course/period/section number)
     **/
    public int getSize(){
        return this.genes.length;
    }
    
    /**
     * @return the number of sections maximum in each slot
     **/
    public int getMaxInSlot(){
        return this.maxInSlot;
    }
    
    /**
     * @return the number of conflicts this schedule has
     **/
    public int getNumOfConflicts(){
        return this.numOfConflicts;
    }
    
    @Override
    public String toString(){
        return Arrays.toString(genes);
    }
}
