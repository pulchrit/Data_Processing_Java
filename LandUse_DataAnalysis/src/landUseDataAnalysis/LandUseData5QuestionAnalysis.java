package landUseDataAnalysis;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;

/**
 * Analyzes LandUseData from csv file after that data has been processed
 * through LandUseDataProcessing.java to answer the following five questions.
 * 
 * Question 1: Which region had the most "Grassland pasture and range" in 1974?
 * 
 * Question 2: How many states had at least 2,000 in the “Land in Urban areas” 
 * column for any year prior to 1987?
 * 
 * Question 3: What is the average value of the “Cropland used for pasture” column 
 * among all states within the Pacific and Mountain regions for 1964?
 * 
 * Question 4: Consider the original 13 colonies of England which became what is 
 * now the United States. Of the states that have land within the territory of 
 * those 13 colonies, which state made the largest contribution to its region's 
 * total “Forest-use land” in 2012?
 * 
 * Question 5: Which region has had the largest shift in its land use between 
 * 1945 and 2012? Please explain your reasoning, including the data that you 
 * used to reach that conclusion.
 * 
 * 
 * @author M Lafranchise
 * @email pulchrit@gmail.com
 *
 */
public class LandUseData5QuestionAnalysis {
        
    /** 
     * Answer question 1.
     * Which region had the most Grassland pasture and range in 1974?
     * 
     * @param List, processed LandUseDataLineItem objects. 
     * @return String, region with most Grassland pasture and range in 1974. 
     */
    public static String findRegionMaxGrasslandPasture1974(List<LandUseDataLineItem> processedData) {
        
        /* Make a Stream of processedData.
         * Filter for regions that contain the word "total" (this should 
         * ensure that we are only looking at regional, not state totals) 
         * and the year 1974.
         * Find max using Comparator of Grassland Pasture and Range field.
         * Attribution: https://docs.oracle.com/javase/8/docs/api/?java/util/stream/Stream.html
         * Attribution: http://www.technicalkeeda.com/java-8-tutorials/java-8-stream-min-and-max
         * Attribution: https://docs.oracle.com/javase/8/docs/api/java/util/Comparator.html#comparing-java.util.function.Function-
         * Get the object that has been found to have the max GrasslandPastureAndRange
         * acres.
         */
        LandUseDataLineItem regionMaxGrasslandObject = 
                processedData.stream()
                .filter(dataInstance -> dataInstance.getYear().equals("1974")
                        && dataInstance.getRegion().contains("total"))
                .max(Comparator.comparing(dataInstance -> dataInstance.getGrasslandPastureAndRange()))
                .get();
        
        // Get and return the region from the LandUseDataLineItem object instance 
        // with the maximum acres in Grassland Pasture and Range for 1974.
        return regionMaxGrasslandObject.getRegion();
                    
    }
    
    public static void main(String[] args) throws IOException {
        
        // Get processed data from csv file. 
        // Considered creating a new method in this class to get processed data, 
        // but it seemed redundant to the method that already exists in 
        // LandUseDataProcessing.java. So, I'm calling the processData() method 
        // from the LandUseDataProcessing here instead.
        List<LandUseDataLineItem> processedData = LandUseDataProcessing.processData("/Users/pulchrit/ada/C11_App_DataAnalysis/LandUse_DataAnalysis/src/USDA_MajorLandUse_1945-2012.csv");
        
        // Call 
        System.out.println(findRegionMaxGrasslandPasture1974(processedData));
    }

}
