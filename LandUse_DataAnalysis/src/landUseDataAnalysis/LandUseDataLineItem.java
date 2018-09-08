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
	private int sortOrder;
	private String region;
	private String regionOrState;
	private String year;
	private int totalLand;
	private int totalCropland;
	private int croplandUsedForCrops;
	private int croplandUsedForPasture;
	private int croplandIdled;
	private int grasslandPastureAndRange;
	private int forestUseLand;
	private int forestUseLandGrazed;
	private int forestUseLandNotGrazed;
	private int allSpecialUsesOfLand;
	private int landInRuralTransportationFacilities;
	private int landInRuralParksAndWildlifeAreas;
	private int landInDefenseAndIndustrialAreas;
	private int farmsteadsRoadsAndMiscellaneousFarmland;
	private int landInUrbanAreas;
	private int otherLand;
	
	// Constructor includes all fields from csv data as well.
	public LandUseDataLineItem(int sortOrder, String region, 
								String regionOrState, String year, 
								int totalLand, int totalCropland, 
								int croplandUsedForCrops, int croplandUsedForPasture, 
								int croplandIdled, int grasslandPastureAndRange, 
								int forestUseLand, int forestUseLandGrazed, 
								int forestUseLandNotGrazed, int allSpecialUsesOfLand, 
								int landInRuralTransportationFacilities,
								int landInRuralParksAndWildlifeAreas, 
								int landInDefenseAndIndustrialAreas, 
								int farmsteadsRoadsAndMiscellaneousFarmland, 
								int landInUrbanAreas, int otherLand) {
		this.sortOrder = sortOrder;
		this.region = region;
		this.regionOrState = regionOrState;
		this.year = year;
		this.totalLand = totalLand;
		this.totalCropland = totalCropland;
		this.croplandUsedForCrops = croplandUsedForCrops;
		this.croplandUsedForPasture = croplandUsedForPasture;
		this.croplandIdled = croplandIdled;
		this.grasslandPastureAndRange = grasslandPastureAndRange;
		this.forestUseLand = forestUseLand;
		this.forestUseLandGrazed = forestUseLandGrazed;
		this.forestUseLandNotGrazed = forestUseLandNotGrazed;
		this.allSpecialUsesOfLand = allSpecialUsesOfLand;
		this.landInRuralTransportationFacilities = landInRuralTransportationFacilities;
		this.landInRuralParksAndWildlifeAreas = landInRuralParksAndWildlifeAreas;
		this.landInDefenseAndIndustrialAreas = landInDefenseAndIndustrialAreas;
		this.farmsteadsRoadsAndMiscellaneousFarmland = farmsteadsRoadsAndMiscellaneousFarmland;
		this.landInUrbanAreas = landInUrbanAreas;
		this.otherLand = otherLand;
		
	}
	
	/**
	 * Gets Sort Order for line item.
	 * @return int, Sort Order
	 */
	public int getSortOrder() {
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
	 * @return int, Acres of Total Land
	 */
	public int getTotalLand() {
		return totalLand;
	}
	
	/** 
	 * Gets Total Cropland for line item.
	 * @return int, Acres of Total Cropland
	 */
	public int getTotalCropland() {
		return totalCropland;
	}
	
	/** 
	 * Gets Cropland Used for Crops for line item.
	 * @return int, Acres of Cropland Used for Crops
	 */
	public int getCroplandUsedForCrops() {
		return croplandUsedForCrops;
	}
	
	/**
	 * Gets Cropland Use for Pasture for line item.
	 * @return int, Acres of Cropland Used for Pasture
	 */
	public int getCroplandUsedForPasture() {
		return croplandUsedForPasture;
	}
	
	/** 
	 * Gets Cropland Idled for line item.
	 * @return int, Acres of Cropland Idled
	 */
	public int getCroplandIdled() {
		return croplandIdled;
	}
	
	/** 
	 * Gets Grassland Pasture and Range for line item.
	 * @return int, Acres of Grassland Pasture and Range
	 */
	public int getGrasslandPastureAndRange() {
		return grasslandPastureAndRange;
	}
	
	/** 
	 * Gets Forest Use Land for line item.
	 * @return int, Acres of Forest Use Land
	 */
	public int getForestUseLand() {
		return forestUseLand;
	}
	
	/** 
	 * Gets Forest Use Land Grazed for line item.
	 * @return int, Acres of Forest Use Land Grazed 
	 */
	public int getForestUseLandGrazed() {
		return forestUseLandGrazed;
	}
	
	/** 
	 * Gets Forest Use Land Not Grazed for line item.
	 * @return int, Acres of Forest Use Land Not Grazed.
	 */
	public int getForestUseLandNotGrazed() {
		return forestUseLandNotGrazed;
	}
	
	/** 
	 * Gets All Special Uses of Land for line item.
	 * @return int, Acres of Special Uses of Land
	 */
	public int getAllSpecialUsesOfLand() {
		return allSpecialUsesOfLand;
	}
	
	/** 
	 * Gets Land in Rural Transportation Facilities for line item.
	 * @return int, Acres of Rural Transportation Facilities
	 */
	public int getLandInRuralTransportationFacilities() {
		return landInRuralTransportationFacilities;
	}
	
	/** 
	 * Gets Land in Rural Parks and Wildlife Areas for line item.
	 * @return int, Acres of Land in Rural Parks and Wildlife Areas
	 */
	public int getLandInRuralParksAndWildlifeAreas() {
		return landInRuralParksAndWildlifeAreas;
	}
	
	/** 
	 * Gets Land in Defence and Industrial Areas for line item.
	 * @return int, Acres of Land in Defense and Industrial Areas
	 */
	public int getLandInDefenseAndIndustrialAreas() {
		return landInDefenseAndIndustrialAreas;
	}
	
	/** 
	 * Gets Farmsteads Roads and Miscelleaneous Farmland for line item.
	 * @return int, Acres of Farmsteads, Roads, Miscellaneous Farmland
	 */
	public int getFarmsteadsRoadsAndMiscellaneousFarmland() {
		return farmsteadsRoadsAndMiscellaneousFarmland;
	}
	
	/** 
	 * Gets Land In Urban Areas for line item.
	 * @return int, Acres of Land in Urband Areas
	 */
	public int getLandInUrbanAreas() {
		return landInUrbanAreas;
	}
	
	/** 
	 * Gets Other Land for line item.
	 * @return int, Acres of Other Land
	 */
	public int getOtherLand() {
		return otherLand;
	}
	
}

