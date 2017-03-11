package application.logic;

/**
 * This class is responsible for taking in a list of Sections and using these
 * sections to carry out a genetic algorithm. This genetic algorithm works by
 * creating a population of randomly created schedules, represented by a
 * Chromosome, and evolving the population to yield a more fit generation. This
 * process is modeled after survival of the fittest. Each schedule (Chromosome)
 * will have a fitness score, and more fit schedules are more likely to
 * reproduce. Reproduction is done in the crossover method. Crossover occur when
 * the genes within two chromosomes are randomly combined to yield a new, and
 * hopefully more fit chromosome. Each Chromosome also has a chance of
 * undergoing a mutation, which means a gene could change. This occurs in order
 * to ensure diversity within the schedule. Once a schedule has no conflicts, or
 * a fitness score of 1.0, that schedule is the one we will choose as the master
 * schedule.
 *
 * @author yasgur99
 **/

import application.elements.Course;
import application.elements.Section;
import application.elements.Teacher;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class MasterSchedule {

    /*A List of sections that the school needs to offer*/
    private List<Section> sections;
    /*A list of chromosomes which act as our population of schedules*/
    private List<Chromosome> chromosomes;
    /*The schedule which resulted from the completion of the genetic algorithm*/
    private Chromosome validSchedule;

    /**
     * This constructor takes in a List of sections in which the school needs to offer
     * as well as the population size we will use for the genetic algorithm and initializes
     * our population of Chromosomes according to the size and sections given.
     * 
     * @param sections list of Sections in which the school must offer
     * @param populationSize the number of chromosomes we will work with in the genetic algorithm
     **/
    public MasterSchedule(List<Section> sections, int populationSize) {
        this.sections = sections;
        this.chromosomes = new ArrayList<>();
        this.validSchedule = null;
        initializePopulation(populationSize);
    }

    /**
     * Takes in the size of the population, and creates size number of randomly
     * formatted schedules. A schedule is represented by a Chromosome.
     *
     * @param size the number of schedules we want in our population
     * @see Chromosome
     **/
    private void initializePopulation(int size) {
        for (int i = 0; i < size; i++) {
            chromosomes.add(new Chromosome(sections));
        }
    }

    /**
     * This method is responsible for evolving each generation until a valid
     * schedule is found. It does this by calling evolve() over and over until
     * isDone() returns true.
     * <p>
     * Note: the isDone() method calculates fitness for all Chromosomes before
     * each call to evolve(), so we don't need to recalculate fitness anywhere
     * else in this class.
     **/
    public void run() {
        while (!isDone()) {
            evolve();
        }
        System.out.println("Finished running genetic alogrith, call getValidSchedule() for result");
    }

    /**
     * Evolves the population by one generation. This includes calculating
     * fitness, facilitating mating (crossover), and facilitating random
     * mutation.
     **/
    private void evolve() {

    }

    /**
     * Takes in two chromosomes and randomly takes genes from one or the other
     * to return a new chromosome that has traits from both. See crossover in
     * biology for more information on how it works.
     *
     * @param c1 a chromosome that will undergo crossover
     * @param c2 another chromosome that will undergo crossover
     * @return a new chromosome with genes from c1 and c2
     * @see Chromosme
     **/
    private Chromosome crossover(Chromosome c1, Chromosome c2) {
        Chromosome c3 = new Chromosome(sections);
        /*Loop through each gene slot*/
        for (int i = 0; i < c3.getSize(); i++) {
            if (new Random().nextDouble() < .5)
                /*Take gene from c1 and give to c3*/
                c3.getGenes()[i] = c1.getGenes()[i];
            else
                /*Take gene from c2 and give to c3*/
                c3.getGenes()[i] = c2.getGenes()[i];
        }
        return c3;
    }

    /**
     * Takes in a chromosome and determines if it should undergo a mutation. A
     * mutation is the random change of a gene(s) in order to ensure diversity
     * within the population. The chance of mutation per gene is 3% in this
     * method.
     *
     * @param c the chromosome that might undergo a mutation
     * @return a new mutated chromosome or the original chromosome if no
     * mutation occurred
     * @see Chromosome
     **/
    private Chromosome mutate(Chromosome c) {
        Random r = new Random();
        /*Loop slots*/
        for (int i = 0; i < c.getSize(); i++) {
            /*Loop sections in current slot*/
            for (int k = 0; k < c.getMaxInSlot(); k++) {
                /*Check to see if a mutation should occur*/
                if (r.nextDouble() <= .03) {
                    /*Swap random gene with this gene*/
                    int randomSlot = r.nextInt(8);
                    int randomIndex = r.nextInt(c.getMaxInSlot());
                    Section temp = c.getGenes()[i][k];
                    c.getGenes()[i][k]= c.getGenes()[randomSlot][randomIndex];
                    c.getGenes()[randomSlot][randomIndex] = temp;
                }
            }
        }
        return c;
    }

    /**
     * @return the schedule that resulted from running the genetic algorithm.
     **/
    public Chromosome getValidSchedule() {
        return this.validSchedule;
    }

    /**
     * This method checks the population to see if there is a Chromosome that
     * has a fitness score of 1.0, meaning that there are no conflicts and it is
     * a valid schedule. This method sets this.validSchedule as the Chromosome
     * that represents the valid schedule if one is found otherwise it leaves
     * the variable null.
     *
     * @return true if there is a valid schedule in our population.
     * @see Chromosome
     **/
    private boolean isDone() {
        for (Chromosome c : this.chromosomes) {
            if (c.getFitness() == 1.0) {
                this.validSchedule = c;
                return true;
            }
        }
        return false;
    }
}
