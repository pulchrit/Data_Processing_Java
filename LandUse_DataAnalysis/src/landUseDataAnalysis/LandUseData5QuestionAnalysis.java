package landUseDataAnalysis;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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
     * Which region had the most "Grassland pasture and range" in 1974?
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
    
    /** 
     * Answer question 2. 
     * How many states had at least 2,000 in the “Land in Urban areas” column for 
     * any year prior to 1987?
     * 
     * @param  List, processed LandUseDataLineItem objects.
     * @return int, number of states with more than 2000 in Land in Urban areas
     * prior to 1987.
     * 
     */
    public static int findRegionsUrbanLand2000Prior1987(List<LandUseDataLineItem> processedData) {
        
        /* Make a stream of processed data.
         * Filter for LandUseDataLineItems that have greater than or equal to 
         * 2000 acres in Land in Urban Areas, and do not contain the word "total"
         * in the Region field (this will remove regional totals leaving us with only
         * state totals which is what we want), and where the year is less than (i.e.,
         * prior to) 1987.
         * Then use map to get the state names from the Region or State field.
         * And collect these to a set which will remove duplicates. 
         * Get and return the size of this set which will be equal to the number 
         * of states that had at least 2000 in "Land in Urban Areas" for any year
         * prior to 1987.
         */
        Set<String> regionsUrbanLand2000Prior1987 = 
                processedData.stream()
                .filter(dataInstance -> dataInstance.getLandInUrbanAreas() >= 2000
                        && !dataInstance.getRegion().contains("total") 
                        && Integer.parseInt(dataInstance.getYear()) < 1987)
                .map(dataInstance -> dataInstance.getRegionOrState())
                .collect(Collectors.toSet());

        return regionsUrbanLand2000Prior1987.size();
    }
    
    /**
     * Answer question 3. 
     * What is the average value of the “Cropland used for pasture” column 
     * among all states within the Pacific and Mountain regions for 1964?
     * 
     * @param  List, processed LandUseDataLineItem objects.
     * @return int, average acres of Cropland used for pasture in the 
     * Pacific and Mountain regions in 1964.
     */
    public static double findAverageCroplandForPasturePacificMountain1964(List<LandUseDataLineItem> processedData) {
        
        /* Make a stream of processed data.
         * Filter for LandUseDataLineItem instances where the year is 1964, 
         * and the region is "Pacific" or "Mountain".
         * Use special collector averagingInt to find the average Cropland
         * Used for Pasture of these filtered LandUseDataLineItem instances.
         * Attribution: https://www.oracle.com/technetwork/articles/java/architect-streams-pt2-2227132.html 
         * Return that average.
         */
        double averageCroplandPasturePacificMountian1964 =
                processedData.stream()
                .filter(dataInstance -> dataInstance.getRegion().equals("Pacific")
                        || dataInstance.getRegion().equals("Mountain"))
                .filter(dataInstance -> dataInstance.getYear().equals("1964"))
                .collect(Collectors.averagingInt(dataInstance -> dataInstance.getCroplandUsedForPasture()));
        return averageCroplandPasturePacificMountian1964;
    }
    
    /**
     * Answer question 4.
     * Consider the original 13 colonies of England which became what is now the 
     * United States. Of the states that have land within the territory of those 
     * 13 colonies, which state made the largest contribution to its region's total 
     * “Forest-use land” in 2012?
     */
    public static String findMaxForestUseland13Colonies2012(List<LandUseDataLineItem> processedData) {
        
        /* Make a stream of processed data.
         * Filter for the year 2012.
         * Filter for the original 13 colonies with the following caveats: 
         *      - Modern day state equivalents are used in place of the 13 colonies.
         *      Much of the western borders of those colonies were different than the
         *      modern state equivalents, but I am using modern state equivalents here. 
         *      - West Virginia is included as the colony of Virginia included 
         *      all of modern-day West Virginia.
         *      - States/colonies that contain the letter y and the District of 
         *      Columbia are not included because they have already been 
         *      removed from the processed data.
         *      Attribution for 13 colony info: 
         *      https://www.worldatlas.com/webimage/countrys/namerica/usstates/colonies.htm
         * We are looking for the maximum Forest Use Land of the 13 
         * colonies/modern-state-equivalents. By default, that colony/state will 
         * have contributed the most to its region's total. We don't need to 
         * group by region and then look at individual state totals. We can just
         * look at state totals. The max Forest Use Land of these states will be 
         * the state that contributes the most to its region's total Forest Use Land. 
         * So, we find the max using the Comparator of ForestUseLand and save 
         * the LandUseDatLineItem instance to the variable.
         */
        LandUseDataLineItem stateMaxForestUseLand13Colonies2012 = 
                processedData.stream()
                .filter(dataInstance -> dataInstance.getYear().equals("2012"))
                .filter(dataInstance -> dataInstance.getRegionOrState().equals("Delaware")
                        || dataInstance.getRegionOrState().equals("Georgia")
                        || dataInstance.getRegionOrState().equals("Connecticut")
                        || dataInstance.getRegionOrState().equals("Massachusetts")
                        || dataInstance.getRegionOrState().equals("South Carolina")
                        || dataInstance.getRegionOrState().equals("New Hampshire")
                        || dataInstance.getRegionOrState().equals("Virginia")
                        || dataInstance.getRegionOrState().equals("West Virginia")
                        || dataInstance.getRegionOrState().equals("North Carolina")
                        || dataInstance.getRegionOrState().equals("Rhode Island"))
                .max(Comparator.comparing(dataInstance -> dataInstance.getForestUseLand()))
                .get();
        
        // Get and return the state name of the LandUseDataLineItem.
        return stateMaxForestUseLand13Colonies2012.getRegionOrState();
                
    }
    
    /**
     * Main method that is called to answer all five questions and output 
     * answers to console. 
     * 
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        
        // Get processed data from csv file. 
        // Considered creating a new method in this class to get processed data, 
        // but it seemed redundant to the method that already exists in 
        // LandUseDataProcessing.java. So, I'm calling the processData() method 
        // from the LandUseDataProcessing here instead.
        List<LandUseDataLineItem> processedData = LandUseDataProcessing.processData("/Users/pulchrit/ada/C11_App_DataAnalysis/LandUse_DataAnalysis/src/USDA_MajorLandUse_1945-2012.csv");
        
        // Call findRegionMaxGrasslandPasture1974() to answer question 1.
        // Output the result to the console.
        System.out.println("Question 1: " + findRegionMaxGrasslandPasture1974(processedData));
        
        // Call findRegionsUrbanLand2000Prior1987() to answer question 2.
        // Output the result to the console.
        System.out.println("Question 2: " + findRegionsUrbanLand2000Prior1987(processedData));
    
        // Call findAverageCroplandForPasturePacificMountain1964() to answer question 3.
        // Output result to the console.
        System.out.println("Question 3: " + findAverageCroplandForPasturePacificMountain1964(processedData));
   
        // Call findMaxForestUseland13Colonies2012 to answer question 4. 
        // Output result to console.
        System.out.println("Question 4: " + findMaxForestUseland13Colonies2012(processedData));
    }

}
