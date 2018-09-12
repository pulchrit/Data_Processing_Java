package landUseDataAnalysis;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * Tests for LandUseDataLineItem.java, LandUseDataProcessing.java, and
 * LandUseDataAnalyis.java.
 * 
 * @author M Lafranchise
 * @email pulchrit@gmail.com
 *
 */
public class LandUseDataAnalysisTest {

    /**
     * Tests that assertions are enabled.
     */
    @Test(expected = AssertionError.class)
    public void testAssertionsEnabled() {
        assert false;
    }

    /**
     * Tests LandUseDataLineItem.java and its toString() method. This class should
     * create instances of LandUseDataLineItem class. Each instance when printed
     * should be formatted like: "Column Name1: Value1 Column Name2: Value2 etc."
     * 
     * For example: "Sort Order: 885 Region: Pacific ..."
     */
    @Test
    public void LandUseDataLineItemToStringTest() {

        // Tests toString() method to ensure proper formatting of instance contents.
        String test4Sort885 = "Sort Order: 885 \n" + "Region: Pacific \n" + "Region or State: California \n"
                + "Year: 2012 \n" + "Total Land: 99699 \n" + "Total Cropland: 9577 \n"
                + "Cropland Used for Crops: 8316 \n" + "Cropland Used for Pasture: 481 \n" + "Cropland Idled: 780 \n"
                + "Grassland Pasture and Range: 26667 \n" + "Forest Use Land: 16991 \n"
                + "Forest Use Land Grazed: 13409 \n" + "Forest Use Land Not Grazed: 3582 \n"
                + "All Special Uses of Land: 24896 \n" + "Land in Rural Transportation Facilities: 1062 \n"
                + "Land in Rural Park and Wildlife Areas: 19623 \n" + "Land in Defense and Industrial Areas: 3935 \n"
                + "Farmsteads, Roads, and Miscellaneous Farmland: 275 \n" + "Land in Urban Areas: 5299 \n"
                + "Otherland: 16269 \n";
        LandUseDataLineItem test4Sort885Instance = new LandUseDataLineItem("885", "Pacific", "California", "2012",
                "99699", "9577", "8316", "481", "780", "26667", "16991", "13409", "3582", "24896", "1062", "19623",
                "3935", "275", "5299", "16269");
        assertEquals(test4Sort885, test4Sort885Instance.toString());
    }

    /**
     * Tests LandUseDataLineItem.java and its convertStringToInt() method.
     * 
     * This should convert a String to an Integer. If the string equals "N.A.", then
     * the Integer 0 should be returned.
     */
    @Test
    public void LandUseDataLineItemConvertStringToIntTest() {

        int convertedInt = 885;
        assertEquals(convertedInt, LandUseDataLineItem.convertStringToInt("885"));

        int converted0 = 0;
        assertEquals(converted0, LandUseDataLineItem.convertStringToInt("N.A."));

    }

    /**
     * Tests LandUseDataLineItem.java to ensure appropriate String arguments are
     * converted to ints during creation of object instances.
     * 
     * The following fields will be passed into the constructor as Strings, but
     * converted to ints: Sort Order, Total Land: Total Cropland, Cropland Used for
     * Crops, Cropland Used for Pasture, Cropland Idled, Grassland Pasture and
     * Range, Forest Use Land, Forest Use Land Grazed, Forest Use Land Not Grazed,
     * All Special Uses of Land, Land in Rural Transportation Facilities, Land in
     * Rural Park and Wildlife Areas, Land in Defense and Industrial Areas,
     * Farmsteads, Roads, and Miscellaneous Farmland, Land in Urban Areas, Other
     * land
     */
    @Test
    public void LandUseDataLineItemStringConversionTest() {
        LandUseDataLineItem testConversion = new LandUseDataLineItem("17", "Northeast", "Maine", "1949", "19866",
                "1407", "1186", "221", "N.A.", "273", "16685", "783", "15902", "482", "169", "209", "13", "91", "104",
                "915");
        assertEquals(Integer.class, testConversion.getSortOrder().getClass());
        assertEquals(Integer.class, testConversion.getTotalLand().getClass());
        assertEquals(Integer.class, testConversion.getTotalCropland().getClass());
        assertEquals(Integer.class, testConversion.getCroplandUsedForCrops().getClass());
        assertEquals(Integer.class, testConversion.getCroplandUsedForPasture().getClass());
        assertEquals(Integer.class, testConversion.getCroplandIdled().getClass());
        assertEquals(Integer.class, testConversion.getGrasslandPastureAndRange().getClass());
        assertEquals(Integer.class, testConversion.getForestUseLand().getClass());
        assertEquals(Integer.class, testConversion.getForestUseLandGrazed().getClass());
        assertEquals(Integer.class, testConversion.getForestUseLandNotGrazed().getClass());
        assertEquals(Integer.class, testConversion.getAllSpecialUsesOfLand().getClass());
        assertEquals(Integer.class, testConversion.getLandInRuralTransportationFacilities().getClass());
        assertEquals(Integer.class, testConversion.getLandInRuralParksAndWildlifeAreas().getClass());
        assertEquals(Integer.class, testConversion.getLandInDefenseAndIndustrialAreas().getClass());
        assertEquals(Integer.class, testConversion.getFarmsteadsRoadsAndMiscellaneousFarmland().getClass());
        assertEquals(Integer.class, testConversion.getLandInUrbanAreas().getClass());
        assertEquals(Integer.class, testConversion.getOtherLand().getClass());
    }

    /**
     * Test LandUseProcessing.java to ensure the IOException is thrown if there is 
     * an issue with the file path or file name.
     * 
     * Incorrect file path and incorrect file names are tested.
     * 
     * Using JUnit 5's assertThrows() method.
     * Attribution: https://www.baeldung.com/junit-assert-exception
     */
    @Test
    public void LandUseProcessingIOExceptionTest() {
        
        // Incorrect file path
        assertThrows(IOException.class, () -> {
            LandUseDataProcessing.processData("/Users/phrit/ada/C11_App_DataAnalysis/LandUse_DataAnalysis/src/USDA_MajorLandUse_1945-2012.csv");
        });
        
        // Incorrect file name
        assertThrows(IOException.class, () -> {
            LandUseDataProcessing.processData("/Users/pulchrit/ada/C11_App_DataAnalysis/LandUse_DataAnalysis/src/USDA_MajorLandUse_195-2012.sv");
        });
    }
    
    /**
     * Tests LandUseDataProcessing.java to ensure the header row of the csv file
     * has been skipped.
     * 
     * When header row has been skipped, the first object instance of the List
     * will return 1 for getSortOrder(), 1945 for getYear(), and 61788 for 
     * getForestUseLand().
     * @throws IOException 
     * 
     */
    @Test
    public void LandUseDataProcessingSkipHeaderRowTest() throws IOException {
        
        // Call processData and save resulting list to processedData variable.
        List<LandUseDataLineItem> processedData = LandUseDataProcessing.processData("/Users/pulchrit/ada/C11_App_DataAnalysis/LandUse_DataAnalysis/src/USDA_MajorLandUse_1945-2012.csv");

        // The first object instance should contain data, not column headers from the csv.
        // Sort Order should be 1.
        Integer sortOrder = 1;
        Integer dataSortOrder = processedData.get(0).getSortOrder();
        assertEquals(sortOrder, dataSortOrder);
        
        // Year should be 1945.
        String year = "1945";
        String dataYear = processedData.get(0).getYear();
        assertEquals(year, dataYear);
        
        // Forest Use Land should be 61788.
        Integer forestUseLand = 61788;
        Integer dataForestUseLand = processedData.get(0).getForestUseLand();
        assertEquals(forestUseLand, dataForestUseLand);
              
    }
    
    /** 
     * Test LandUseDataProcessing.java to ensure no Region fields contain 
     * "AK and HI", "48 States", "U.S. Total", no Region or State field
     * contains "District of Columbia" and no state name contains
     * the letter y.
     * 
     * I'm testing each set of filters separately because I think it will 
     * provide more clarity to the test and results.
     * 
     * Uses Java Streams to filter data. 
     * Attribution: https://www.oracle.com/technetwork/articles/java/ma14-java-se-8-streams-2177646.html
     * @throws IOException 
     */
    @Test
    public void LandUseDataProcessingRegionStateFiltersTest() throws IOException {
        
        // Call processData and get list of Objects
        List<LandUseDataLineItem> processedData = LandUseDataProcessing.processData("/Users/pulchrit/ada/C11_App_DataAnalysis/LandUse_DataAnalysis/src/USDA_MajorLandUse_1945-2012.csv");

        // Create empty array to check against in tests below.
        List<String> emptyArray = new ArrayList<>();
        
        // Get a stream from processedData of only Region fields.
        // Filter that stream for object instances where getRegion equals 
        // "AK and HI", "48 States", or "U.S. Total".
        // Get the region strings for each object instance that satisfies 
        // the filter by mapping.
        // Collect those region streams into the regions List.
        // We expect this regions List to be empty because these three
        // regions should be filtered out during data processing.
        List<String> regions = 
                processedData.stream()
                            .filter(dataInstance -> dataInstance.getRegion().equals("AK and HI")
                                    && dataInstance.getRegion().equals("48 States")
                                    && dataInstance.getRegion().equals("U.S.Total"))
                            .map(dataInstance -> dataInstance.getRegion())
                            .collect(Collectors.toList());
        
        // Assert that the regions List is empty by comparing it to previously created
        // emptyArray List.
        assertEquals(emptyArray, regions);
        
        // Get a stream of only Region or State fields. 
        // Filter that stream for object instances where getRegionOrState equals
        // "District of Columbia".
        // Get the regionOrState strings for each object instance that satisfies 
        // the filter by mapping.
        // Collect those region streams into the regionsOrStates List.
        // We expect this regionOrStates List to be empty because "District of Columbia"
        // regions should be filtered out during data processing.
        List<String> regionOrStates = 
                processedData.stream()
                            .filter(dataInstance -> dataInstance.getRegionOrState().equals("District of Columbia"))
                            .map(dataInstance -> dataInstance.getRegionOrState())
                            .collect(Collectors.toList());
                
        // Assert that the regionOrStates List is empty by comparing it to the previously
        // created emptyArray List.
        assertEquals(emptyArray, regionOrStates);
        
        // Get a stream of only Region or State fields. 
        // Filter that stream for object instances where getRegionOrState contains
        // the letter y (uppercase and lowercase).
        // Get the regionOrState strings for each object instance that satisfies 
        // the filter by mapping.
        // Collect those region streams into the states List.
        // We expect this states List to be empty because states containing a 'y'
        // should be filtered out during data processing.
        List<String> states = 
                processedData.stream()
                            .filter(dataInstance -> dataInstance.getRegionOrState().contains("y")
                                    && dataInstance.getRegionOrState().contains("Y"))
                            .map(dataInstance -> dataInstance.getRegionOrState())
                            .collect(Collectors.toList());
        
        // Assert that the states List is empty by comparing it to the previously
        // created emptyArray List.
        assertEquals(emptyArray, states);
    }
    
    /** 
     * Test LandUseDataProcessing.java to ensure that LandUseDataLineItem
     * object instances are created and stored correctly in the landUseInstances List.
     * @throws IOException 
     * 
     * 
     */
    @Test
    public void LandUseDataProcessingObjectCreationTest() throws IOException {
        
        // Call processData method and get List of LandUseDataLineItem objects.
        List<LandUseDataLineItem> processedData = LandUseDataProcessing.processData("/Users/pulchrit/ada/C11_App_DataAnalysis/LandUse_DataAnalysis/src/USDA_MajorLandUse_1945-2012.csv");

        // Using, Stream, get and print three object instances (SortOrder: 1 (first), 448 (middle-ish), 
        // and 885 (last) and ensure they match data from csv file.
        
        
        // Double check that several object instances that should have been filtered
        // out were in fact filtered out. SortOrder 938 is a "U.S. Total" and should 
        // not appear. SortOrder 491 is a state (Kentucky) that contains the letter y.
    }
    
    

}
