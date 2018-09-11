package landUseDataAnalysis;


/**
 * United States (U.S.) Land Use Survey Data (1945-2012) from
 * the U.S. Department of Agriculture.
 * 
 * Object instances represent individual line items
 * from the csv data source.
 * Land totals are in acres.
 *  
 * @param sortOrder: int, order in which line items were sorted by source.
 * @param region: String, geographic region of the U.S.
 * @param regionOrState: String, geographic region or state of the U.S.
 * @param year: String, year during which survey data was taken.
 * @param totalLand: int, total acres of land used for region or state.
 * @param totalCropland: int, subtotal of cropland for crops, for pasture
 * and idled.  
 * @param croplandUsedForCrops: int, crops harvested, failed, summer fallow.
 * @param croplandUsedForPasture: int, crop land used for animal pasture.
 * @param croplandIdled: int, land in cover and soil-improvement, or not farmed.
 * @param grasslandPastureAndRange: int, all open land used for pasture and grazing.
 * @param forestUseLand: int, subtotal of forest land grazed and not grazed.
 * @param forestUseLandGrazed: int, forested land used for pasture and grazing.
 * @param forestUseLandNotGrazed: int, forested land not grazed.
 * @param allSpecialUsesOfLand: int, subtotal of acres used for transportation, 
 * parks, defense/industrial, farmsteads and farm roads.
 * @param landInRuralTransportationFacilities: int, highways, roads, airports 
 * not located in census-defined urban areas.
 * @param landInRuralParksAndWildlifeAreas: int, rural parks, recreation and wildlife 
 * refuge areas.
 * @param landInDefenseAndIndustrialAreas: int, all National Defense and 
 * Department of Energy land including homes, airports, bases, research facilities.
 * @param farmsteadsRoadsAndMiscellaneousFarmland: int, farmstead related land.
 * @param landInUrbanAreas: int, all land in census-defined urban areas.
 * @param otherLand: int, miscellaneous land used for cemeteries, gold courses,
 * quarries, mines, etc.
 * 
 * @author M Lafranchise
 * @email pulchrit@gmail.com
 */
public class LandUseDataLineItem {
	
	// Creating fields for each column of the csv data file.
	// Please note: All fields designated as ints below will be
	// converted from Strings using a helper method in the 
	// constructor.
	private Integer sortOrder;
	private String region;
	private String regionOrState;
	private String year;
	private Integer totalLand;
	private Integer totalCropland;
	private Integer croplandUsedForCrops;
	private Integer croplandUsedForPasture;
	private Integer croplandIdled;
	private Integer grasslandPastureAndRange;
	private Integer forestUseLand;
	private Integer forestUseLandGrazed;
	private Integer forestUseLandNotGrazed;
	private Integer allSpecialUsesOfLand;
	private Integer landInRuralTransportationFacilities;
	private Integer landInRuralParksAndWildlifeAreas;
	private Integer landInDefenseAndIndustrialAreas;
	private Integer farmsteadsRoadsAndMiscellaneousFarmland;
	private Integer landInUrbanAreas;
	private Integer otherLand;
	
	// Constructor assigns values to fields.
	// Number Strings will be converted to ints here. I'm not 
	// sure if this is the best place to do so????
	public LandUseDataLineItem(String sortOrder, String region, 
								String regionOrState, String year, 
								String totalLand, String totalCropland, 
								String croplandUsedForCrops, String croplandUsedForPasture, 
								String croplandIdled, String grasslandPastureAndRange, 
								String forestUseLand, String forestUseLandGrazed, 
								String forestUseLandNotGrazed, String allSpecialUsesOfLand, 
								String landInRuralTransportationFacilities,
								String landInRuralParksAndWildlifeAreas, 
								String landInDefenseAndIndustrialAreas, 
								String farmsteadsRoadsAndMiscellaneousFarmland, 
								String landInUrbanAreas, String otherLand) {
		this.sortOrder = convertStringToInt(sortOrder);
		this.region = region;
		this.regionOrState = regionOrState;
		this.year = year;
		this.totalLand = convertStringToInt(totalLand);
		this.totalCropland = convertStringToInt(totalCropland);
		this.croplandUsedForCrops = convertStringToInt(croplandUsedForCrops);
		this.croplandUsedForPasture = convertStringToInt(croplandUsedForPasture);
		this.croplandIdled = convertStringToInt(croplandIdled);
		this.grasslandPastureAndRange = convertStringToInt(grasslandPastureAndRange);
		this.forestUseLand = convertStringToInt(forestUseLand);
		this.forestUseLandGrazed = convertStringToInt(forestUseLandGrazed);
		this.forestUseLandNotGrazed = convertStringToInt(forestUseLandNotGrazed);
		this.allSpecialUsesOfLand = convertStringToInt(allSpecialUsesOfLand);
		this.landInRuralTransportationFacilities = convertStringToInt(landInRuralTransportationFacilities);
		this.landInRuralParksAndWildlifeAreas = convertStringToInt(landInRuralParksAndWildlifeAreas);
		this.landInDefenseAndIndustrialAreas = convertStringToInt(landInDefenseAndIndustrialAreas);
		this.farmsteadsRoadsAndMiscellaneousFarmland = convertStringToInt(farmsteadsRoadsAndMiscellaneousFarmland);
		this.landInUrbanAreas = convertStringToInt(landInUrbanAreas);
		this.otherLand = convertStringToInt(otherLand);
		
	}
	
	/** 
	 * Converts String numbers to Integers. Helper method.
	 * 
	 * It is necessary to convert these strings to Integer
	 * for future calculations in LandUseDataAnalysis class.
	 * 
	 * Using try/catch block as some String entries are "N.A."
	 * These entries will trigger NumberFormatExceptions when 
	 * attempting to ParseInt() on the String. The exception  
	 * will be handled by returning Integer 0 in place of "N.A."
	 * It is assumed that, for data analysis purposes, "N.A." 
	 * will be equivalent to 0. THIS MAY BE AN INCORRECT 
	 * ASSUMPTION. 
	 * 
	 * @param stringNumber, number of type String
	 * @return Integer, String number converted to Integer
	 */
	public static int convertStringToInt(String stringNumber) {
		
		// Try to convert String number to Integer.
		// If successful, return Integer.
		try {
			Integer convertedInt = Integer.valueOf(stringNumber);
			return convertedInt;
		
		// Catch NumberFormatException errors that will occur
		// when "N.A." is encountered. In these cases, return the int 0.
		// Again, the assumption is that 0 is equivalent to "N.A."
		// and will allow for calculation/data analysis where 
		// "N.A." will not.
		} catch (NumberFormatException nfe) {
			Integer zero = 0;
		    return zero; 
		}
	}
	
	/**
	 * Gets Sort Order for line item.
	 * @return Integer, Sort Order
	 */
	public Integer getSortOrder() {
		return sortOrder;
	}
	
	/**
	 * Gets Region for line item.
	 * @return String, Region surveyed
	 */
	public String getRegion() {
		return region;
	}
	
	/** 
	 * Gets Region or State for line item.
	 * @return String, Region or State surveyed
	 */
	public String getRegionOrState() {
		return regionOrState;
	}
	
	/** 
	 * Gets Year for line item.
	 * @return String, survey year
	 */
	public String getYear() {
		return year;
	}
	
	/**
	 * Gets Total Land for line item.
	 * @return Integer, Acres of Total Land
	 */
	public Integer getTotalLand() {
		return totalLand;
	}
	
	/** 
	 * Gets Total Cropland for line item.
	 * @return Integer, Acres of Total Cropland
	 */
	public Integer getTotalCropland() {
		return totalCropland;
	}
	
	/** 
	 * Gets Cropland Used for Crops for line item.
	 * @return Integer, Acres of Cropland Used for Crops
	 */
	public Integer getCroplandUsedForCrops() {
		return croplandUsedForCrops;
	}
	
	/**
	 * Gets Cropland Use for Pasture for line item.
	 * @return Integer, Acres of Cropland Used for Pasture
	 */
	public Integer getCroplandUsedForPasture() {
		return croplandUsedForPasture;
	}
	
	/** 
	 * Gets Cropland Idled for line item.
	 * @return Integer, Acres of Cropland Idled
	 */
	public Integer getCroplandIdled() {
		return croplandIdled;
	}
	
	/** 
	 * Gets Grassland Pasture and Range for line item.
	 * @return Integer, Acres of Grassland Pasture and Range
	 */
	public Integer getGrasslandPastureAndRange() {
		return grasslandPastureAndRange;
	}
	
	/** 
	 * Gets Forest Use Land for line item.
	 * @return Integer, Acres of Forest Use Land
	 */
	public Integer getForestUseLand() {
		return forestUseLand;
	}
	
	/** 
	 * Gets Forest Use Land Grazed for line item.
	 * @return Integer, Acres of Forest Use Land Grazed 
	 */
	public Integer getForestUseLandGrazed() {
		return forestUseLandGrazed;
	}
	
	/** 
	 * Gets Forest Use Land Not Grazed for line item.
	 * @return Integer, Acres of Forest Use Land Not Grazed.
	 */
	public Integer getForestUseLandNotGrazed() {
		return forestUseLandNotGrazed;
	}
	
	/** 
	 * Gets All Special Uses of Land for line item.
	 * @return Integer, Acres of Special Uses of Land
	 */
	public Integer getAllSpecialUsesOfLand() {
		return allSpecialUsesOfLand;
	}
	
	/** 
	 * Gets Land in Rural Transportation Facilities for line item.
	 * @return Integer, Acres of Rural Transportation Facilities
	 */
	public Integer getLandInRuralTransportationFacilities() {
		return landInRuralTransportationFacilities;
	}
	
	/** 
	 * Gets Land in Rural Parks and Wildlife Areas for line item.
	 * @return Integer, Acres of Land in Rural Parks and Wildlife Areas
	 */
	public Integer getLandInRuralParksAndWildlifeAreas() {
		return landInRuralParksAndWildlifeAreas;
	}
	
	/** 
	 * Gets Land in Defence and Industrial Areas for line item.
	 * @return Integer, Acres of Land in Defense and Industrial Areas
	 */
	public Integer getLandInDefenseAndIndustrialAreas() {
		return landInDefenseAndIndustrialAreas;
	}
	
	/** 
	 * Gets Farmsteads Roads and Miscelleaneous Farmland for line item.
	 * @return Integer, Acres of Farmsteads, Roads, Miscellaneous Farmland
	 */
	public Integer getFarmsteadsRoadsAndMiscellaneousFarmland() {
		return farmsteadsRoadsAndMiscellaneousFarmland;
	}
	
	/** 
	 * Gets Land In Urban Areas for line item.
	 * @return Integer, Acres of Land in Urband Areas
	 */
	public Integer getLandInUrbanAreas() {
		return landInUrbanAreas;
	}
	
	/** 
	 * Gets Other Land for line item.
	 * @return Integer, Acres of Other Land
	 */
	public Integer getOtherLand() {
		return otherLand;
	}
	
	/**
	 * Formats and prints content of LandUseDataLineItem instance.
	 * Overrides toString() method.
	 * 
	 * Instructions from:
	 * https://www.geeksforgeeks.org/overriding-tostring-method-in-java/
	 * 
	 */
	@Override
	public String toString() { 
		String landUseOutput = String.format(
											"Sort Order: %d \n" +
											"Region: %s \n" +
											"Region or State: %s \n" +
											"Year: %s \n" +
											"Total Land: %d \n" +
											"Total Cropland: %d \n" +
											"Cropland Used for Crops: %d \n" +
											"Cropland Used for Pasture: %d \n" +
											"Cropland Idled: %d \n" +
											"Grassland Pasture and Range: %d \n" +
											"Forest Use Land: %d \n" +
											"Forest Use Land Grazed: %d \n" +
											"Forest Use Land Not Grazed: %d \n" +
											"All Special Uses of Land: %d \n" +
											"Land in Rural Transportation Facilities: %d \n" +
											"Land in Rural Park and Wildlife Areas: %d \n" +
											"Land in Defense and Industrial Areas: %d \n" +
											"Farmsteads, Roads, and Miscellaneous Farmland: %d \n" +
											"Land in Urban Areas: %d \n" +
											"Otherland: %d \n",
											this.getSortOrder(), this.getRegion(), this.getRegionOrState(), this.getYear(),
											this.getTotalLand(), this.getTotalCropland(), this.getCroplandUsedForCrops(),
											this.getCroplandUsedForPasture(), this.getCroplandIdled(), 
											this.getGrasslandPastureAndRange(), this.getForestUseLand(), 
											this.getForestUseLandGrazed(), this.getForestUseLandNotGrazed(),
											this.getAllSpecialUsesOfLand(), this.getLandInRuralTransportationFacilities(),
											this.getLandInRuralParksAndWildlifeAreas(), this.getLandInDefenseAndIndustrialAreas(),
											this.getFarmsteadsRoadsAndMiscellaneousFarmland(), this.getLandInUrbanAreas(),
											this.getOtherLand()
											);		
	
		return landUseOutput;
	}
	
}

