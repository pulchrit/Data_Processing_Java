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
 * @return No specific return value.
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
	
	// Getter methods for each field of csv data.
	public int getSortOrder() {
		return sortOrder;
	}
	
	public String getRegion() {
		return region;
	}
	
	public String getRegionOrState() {
		return regionOrState;
	}
	
	public String getYear() {
		return year;
	}
	
	public int getTotalLand() {
		return totalLand;
	}
	
	public int getTotalCropland() {
		return totalCropland;
	}
	
	public int getCroplandUsedForCrops() {
		return croplandUsedForCrops;
	}
	
	public int getCroplandUsedForPasture() {
		return croplandUsedForPasture;
	}
	
	public int getCroplandIdled() {
		return croplandIdled;
	}
	
	public int getGrasslandPastureAndRange() {
		return grasslandPastureAndRange;
	}
	
	public int getForestUseLand() {
		return forestUseLand;
	}
	
	public int getForestUseLandGrazed() {
		return forestUseLandGrazed;
	}
	
	public int getForestUseLandNotGrazed() {
		return forestUseLandNotGrazed;
	}
	
	public int getAllSpecialUsesOfLand() {
		return allSpecialUsesOfLand;
	}
	
	public int getLandInRuralTransportationFacilities() {
		return landInRuralTransportationFacilities;
	}
	
	public int getLandInRuralParksAndWildlifeAreas() {
		return landInRuralParksAndWildlifeAreas;
	}
	
	public int getLandInDefenseAndIndustrialAreas() {
		return landInDefenseAndIndustrialAreas;
	}
	
	public int getFarmsteadsRoadsAndMiscellaneousFarmland() {
		return farmsteadsRoadsAndMiscellaneousFarmland;
	}
	
	public int getLandInUrbanAreas() {
		return landInUrbanAreas;
	}
	
	public int getOtherLand() {
		return otherLand;
	}
	
}

