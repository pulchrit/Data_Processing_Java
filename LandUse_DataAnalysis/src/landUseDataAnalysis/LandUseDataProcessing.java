package landUseDataAnalysis;

import java.util.List;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/** 
 * Processes land use data from csv file using Streams instead of 
 * FileReader and BufferedReader. Streams allow data to be filtered 
 * and mapped multiple time without interim data structures being created,
 * meaning Streams should save space and a bit of time in comparison.
 * 
 * The land use data is filtered to exclude the line items specified in 
 * the instructions. Then LandUseDataLineItem object instances are created
 * and stored in a list which is then returned. The resulting list will be 
 * analyzed in the LandUseDataAnalysis class to answer five questions. 
 * 
 * @author M Lafranchise
 * @email pulchrit@gmail.com
 *
 */
public class LandUseDataProcessing {

	/**
	 * Processes data from United States Department of Agriculture
	 * Land Use Survey data provided in csv file.
	 * 
	 * Excludes the following data:
	 * 1. Region is "AK and HI", "48 States", and "U.S. Total"
	 * 2. State is "District of Columbia"
	 * 3. State includes the letter "y"
	 * 
	 * @param filePath, path to csv file of land use data
	 * @return List, list of LandUseDataLineItem instances
	 * 
	 * Sites instrumental in developing this code:
	 * https://brushmyskills.com/java-8/read-csv-file-stream-java-8/
	 * https://www.oracle.com/technetwork/articles/java/ma14-java-se-8-streams-2177646.html
	 * https://www.oracle.com/technetwork/articles/java/architect-streams-pt2-2227132.html
	 * https://stackoverflow.com/questions/15730134/java-opposite-of-contains-does-not-contain
	 * @throws IOException 
	 */
	public static List<LandUseDataLineItem> processData(String filePath) throws IOException {
		
		// Create list to hold landUseDataLineItem objects.
		List<LandUseDataLineItem> landUseData = new ArrayList<LandUseDataLineItem>();
		
		// Use try/catch block and Files.lines to get a stream of data 
		// from the csv file.
		try (Stream<String> initialDataStream = Files.lines(Paths.get(filePath))) {
			
			landUseData = initialDataStream
							
							// Skips the first row/header row of csv file.
							.skip(1)
							
							// Filter out lines that contain "AK and HI", "48 States"
							// and "U.S. total" and "District of Columbia". This filter
							// should catch these specific strings in the Region and States
							// columns of the csv file. Meaning, it should work even
							// though I'm not specifically looking at the Region or 
							// State data fields.
							.filter(line -> !line.contains("AK and HI") 
									&& !line.contains("48 States")
									&& !line.contains("U.S. total")
									&& !line.contains("District of Columbia"))
							
							// Use map to split each line at commas, save 
							// resulting elements to array of Strings.
							// Still using map, create new LandUseDataLineItem
							// instances from each array. 
							// Return each instance to map Stream.
							.map(line -> {
								String[] lineSplit = line.split(",");
								LandUseDataLineItem landUseInstance = new LandUseDataLineItem(lineSplit[0],
													lineSplit[1], lineSplit[2], lineSplit[3], lineSplit[4],
													lineSplit[5], lineSplit[6], lineSplit[7], lineSplit[8],
													lineSplit[9], lineSplit[10], lineSplit[11], lineSplit[12],
													lineSplit[13], lineSplit[14], lineSplit[15], lineSplit[16],
													lineSplit[17], lineSplit[18], lineSplit[19]);
								return landUseInstance;
							})
							
							// Filter the stream again to remove any state that contains the letter y/Y.
							// I'm filtering separately so that I can restrict the filter to only the
							// "Region or State" field and not to the entire line from the csv file (as
							// is the case in the above filters).
							// State is included in the "Region or State" column. So, technically, 
							// we should only check for y's in states, not regions. However, I manually
							// reviewed the data and none of the region's present contain the letter y.
							// So, by default, we are only filtering out states that contain y.
							.filter(instance -> !instance.getRegionOrState().contains("Y")
									&& !instance.getRegionOrState().contains("y"))
							
							// Collect the filtered LandUseDataLineItem instances to the list.
							.collect(Collectors.toList());
		
		// Catch any IO Exceptions, print the stack trace, and rethrow the IOException
		// for testing purposes.
		} catch (IOException ioe) {
		    ioe.printStackTrace();
		    throw new IOException(ioe);
		}
 
		// Return the list of filtered LandUseDataLineItem instances.
		return landUseData;
	}
	
}
