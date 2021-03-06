package landUseDataAnalysis;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
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
     * 
     * @param  List, processed LandUseDataLineItem objects.
     * @return String, name of state in territory of original 13 colonies with most 
     * Forest Use Land for its region.
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
     * Answer question 5.
     * Which region has had the largest shift in its land use between 1945 and 2012? 
     * Please explain your reasoning, including the data that you used to reach 
     * that conclusion.
     * 
     * Please note: There is a lot of room for improvement/refactoring in this code. 
     * It seems like better use of Streams and the creation of intermediary objects 
     * to stream instead of hashmaps of hashmaps would be a better solution. 
     * 
     * @param  List, processed LandUseDataLineItem objects.
     * @return RegionMaxLandUseDelta object, object instance representing the 
     * region with largest shift in land use between 1945 and 2012.
     */
    public static RegionMaxLandUseDelta findRegionMaxShiftLandUse1945To2012(List<LandUseDataLineItem> processedData) {
        
        /* Make a stream of processed data.
         * Filter for Regions that DO contain the word "total" as this
         * will exclude individual state line item which we don't need 
         * to answer this question.
         * Filter for the years 1945 and 2012.
         * Collect output to map with String/Region for keys and a list of
         * LandUseDataLineItem instances for values, 
         * (i.e.,  {Region = [instance, instance, etc.]}).
         */
        Map<String, List<LandUseDataLineItem>> regionTotal19452012 = 
                processedData.stream()
                .filter(dataInstance -> dataInstance.getRegion().contains("total"))
                .filter(dataInstance -> dataInstance.getYear().equals("1945")
                        || dataInstance.getYear().equals("2012"))
                .collect(Collectors.groupingBy(dataInstance -> dataInstance.getRegion()));
        
        // Creating a hashmap with an inner hashmap. Inner hashmap will hold the delta 
        // between the 2012 and 1945 land values. External hashmap will link these values
        // to their appropriate region. 
        // IMPORTANT: The inner HashMap is initialized within the forEach loop below, so that
        // it's values are reset with each iteration of the loop. This ensures that the 
        // deltas calculated for each region are saved correctly in the external hashmap. If 
        // you don't initialize within the loop, each subsequent iteration will replace the 
        // previous, and you'll have duplicate data. 
        // Attribution: https://coderanch.com/t/570043/java/Populating-HashMaps-HashMap-Objects
        HashMap<String, HashMap<String, Integer>> regionDeltas = new HashMap<String, HashMap<String, Integer>>();
        
        
        // Iterate over each region of the hashmap.
        regionTotal19452012.forEach((k, v) -> {
           
            // Initialize inner hashmap to hold landUseDeltas for each region. Initializing
            // here so that the hashmap is reset for each iteration of the forEach loop.
            HashMap<String, Integer> landUseDeltas = new HashMap<String, Integer>();
                           
            // Now, we want to find the delta between the 2012 and 1945 field values. 
            // There are only two elements for each hashmap value (one for 1945 
            // and one for 2012). So, I call each of these elements using their
            // appropriate index (0 for 1945, 1 for 2012).
            // I am subtracting 1945 values from 2012 values (i.e., 2012-1945) so that 
            // a decrease is signed negative (-) and an increase is signed positive (+).
            // Then, I am adding that delta to the inner hashmap with a key of the field
            // name or type of land use. (i.e., "Cropland Used for Crops" : -150).
            // I manually enter all land use types/field names below. 
            // !!This is arduous and not re-usable code. I'm sure there is a cleaner
            // way to manage it using Streams, but I was not finding the correct way to 
            // write the Collector code!!
            
            Integer deltaCroplandForCrops = 
                    v.get(1).getCroplandUsedForCrops() - v.get(0).getCroplandUsedForCrops();
            landUseDeltas.put("Cropland Used For Crops", deltaCroplandForCrops);
            
            Integer deltaCroplandForPasture = 
                    v.get(1).getCroplandUsedForPasture() - v.get(0).getCroplandUsedForPasture();
            landUseDeltas.put("Cropland Used For Pasture", deltaCroplandForPasture);
            
            Integer deltaCroplandIdled = 
                    v.get(1).getCroplandIdled() - v.get(0).getCroplandIdled();
            landUseDeltas.put("Cropland Idled", deltaCroplandIdled);
            
            Integer deltaGrasslandPastureAndRange = 
                    v.get(1).getGrasslandPastureAndRange() - v.get(0).getGrasslandPastureAndRange();
            landUseDeltas.put("Grassland Pasture And Range", deltaGrasslandPastureAndRange);
            
            Integer deltaForestUseLandGrazed =
                    v.get(1).getForestUseLandGrazed() - v.get(0).getForestUseLandGrazed();
            landUseDeltas.put("Forest Use Land Grazed", deltaForestUseLandGrazed);
            
            Integer deltaForestUseLandNotGrazed =
                    v.get(1).getForestUseLandNotGrazed() - v.get(0).getForestUseLandNotGrazed();
            landUseDeltas.put("Forest Use Land Not Grazed", deltaForestUseLandNotGrazed);
            
            Integer deltaLandInRuralTransportationFacilities =
                    v.get(1).getLandInRuralTransportationFacilities() - v.get(0).getLandInRuralTransportationFacilities();
            landUseDeltas.put("Land In Rural Transportation Facilities", deltaLandInRuralTransportationFacilities);
            
            Integer deltaLandInRuralParksAndWildlifeAreas =
                    v.get(1).getLandInRuralParksAndWildlifeAreas() - v.get(0).getLandInRuralParksAndWildlifeAreas();
            landUseDeltas.put("Land In Rural Parks And Wildlife Areas", deltaLandInRuralParksAndWildlifeAreas);
            
            Integer deltaLandInDefenseAndIndustrialAreas =
                    v.get(1).getLandInDefenseAndIndustrialAreas() - v.get(0).getLandInDefenseAndIndustrialAreas();
            landUseDeltas.put("Land In Defense And Industrial Areas", deltaLandInDefenseAndIndustrialAreas);
            
            Integer deltaFarmsteadsRoadsAndMiscellaneousFarmland =
                    v.get(1).getFarmsteadsRoadsAndMiscellaneousFarmland() - v.get(0).getFarmsteadsRoadsAndMiscellaneousFarmland();
            landUseDeltas.put("Farmsteads Roads And Miscellaneous Farmland", deltaFarmsteadsRoadsAndMiscellaneousFarmland);
            
            Integer deltaLandInUrbanAreas =
                    v.get(1).getLandInUrbanAreas() - v.get(0).getLandInUrbanAreas();
            landUseDeltas.put("Land In Urban Areas", deltaLandInUrbanAreas);
            
            Integer deltaOtherLand =
                    v.get(1).getOtherLand() - v.get(0).getOtherLand();
            landUseDeltas.put("Other Land", deltaOtherLand);
                      
            // Each region's landUseDeltas hashmaps are then added to the regionDeltas
            // hashmap.
            regionDeltas.put(k, landUseDeltas);
        });
        
        
        
        // Now, I need to find the max delta for each region, and then find the
        // region that has the maximum delta in land use.
        // Initialize hashmap to hold max land use changes by region (i.e., 
        // {Pacific = {Forest Use Land Not Grazed = -28720}})
        HashMap<String, HashMap<String, Integer>> maxByRegion = new HashMap<String, HashMap<String, Integer>>();

        // Iterate over each key,value pair in the regionDeltas hashmap.
        regionDeltas.forEach((k,v) -> {
            
            // Initialize inner hashmap to hold the maximum land use change for 
            // this region, (i.e., {Cropland Used for Crops = 4082}).
            HashMap<String, Integer> allMaxLandUseDeltas = new HashMap<String, Integer>();
            
            // Stream the entrySet from the value in regionDeltas. The value in regionDeltas
            // is the sub-hashmap that contains the individual land use types and values (i.e., 
            // {Other Land = -566}).
            // Then find the max value by comparing the absolute of that value. We need to 
            // compare absolute values because we are looking for the largest change and that 
            // can be either an increase (+) or a decrease (-).
            // Then get the entry that contains the maximum value and add the key and that value 
            // to the allMaxLandUseDeltas hashmap.
            // Finally, add the region name/key and the allMaxLandUseDeltas sub-hashmap to the 
            // external hashmap. This external hashmap shows the maximum land use change type and 
            // value for each region (i.e., {Pacific Northwest = {Forest Use Land Not Grazed = 12,419}}).
            
            Entry<String, Integer> maxLandUseDelta = 
                    v.entrySet().stream()
                    .max(Map.Entry.comparingByValue(Comparator.comparing(e1 -> Math.abs(e1))))
                    .get();

            allMaxLandUseDeltas.put(maxLandUseDelta.getKey(), maxLandUseDelta.getValue());

            maxByRegion.put(k, allMaxLandUseDeltas);
        });
        
        // Create a list to hold instances of the RegionMaxLandUseDelta objects.
        // From the maxbyRegion hashmap, I am creating object instances that 
        // contain the maximum land use delta and the land type for this maximum 
        // delta for each region. Creating these objects allows me to easily find 
        // the region with the maximum shift in land use between 1945 and 2012.
        List<RegionMaxLandUseDelta> RegionMaxLandUseDeltaObjects = new ArrayList<>();
        
        // Iterate over the maxByRegion hashmap.
        maxByRegion.forEach((k,v) -> {
            
            // Then, iterate over the sub-hashmap that contains the land type and the 
            // land use delta.
            v.forEach((key, value) -> {
                
                // Create new instances of RegionMaxLandUseDelta and add these to the 
                // list.
                RegionMaxLandUseDelta RegionMaxLandUseDeltaInstance = 
                        new RegionMaxLandUseDelta(value, key, k);
                RegionMaxLandUseDeltaObjects.add(RegionMaxLandUseDeltaInstance);
            });
        });
        
        // Now, we can stream the list of RegionMaxLandUseDelta objects, and 
        // find the maximum land use delta by using a Comparator that looks at 
        // the MaxLandValue() field.
        // Then, get the object instance with the maximum shift and return it.
        RegionMaxLandUseDelta regionMaxLandUseDelta19452012 = 
                RegionMaxLandUseDeltaObjects.stream()
                .max(Comparator.comparing(dataInstance -> dataInstance.getMaxLandValue()))
                .get();
       
        return regionMaxLandUseDelta19452012;
         
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
        System.out.println("Question 1: " + findRegionMaxGrasslandPasture1974(processedData) + "\n");
        
        // Call findRegionsUrbanLand2000Prior1987() to answer question 2.
        // Output the result to the console.
        System.out.println("Question 2: " + findRegionsUrbanLand2000Prior1987(processedData)+ "\n");
    
        // Call findAverageCroplandForPasturePacificMountain1964() to answer question 3.
        // Output result to the console.
        System.out.println("Question 3: " + findAverageCroplandForPasturePacificMountain1964(processedData)+ "\n");
   
        // Call findMaxForestUseland13Colonies2012 to answer question 4. 
        // Output result to console.
        System.out.println("Question 4: " + findMaxForestUseland13Colonies2012(processedData)+ "\n");
    
        // Call findRegionMaxShiftLandUse1945To2012 to answer question 5. 
        // Output result to console. 
        System.out.println("Question 5: " + findRegionMaxShiftLandUse1945To2012(processedData) + "\n");
    }

}
