package landUseDataAnalysis;

/**
 * 
 * United States (U.S.) Land Use Survey Data (1945-2012) from
 * the U.S. Department of Agriculture.
 * 
 * Object instances represent the maximum amount and type of land use
 * change in a region between 1945 and 2012.
 * 
 * @param maxLandValue: int, the change in acres between 1945 and 2012 (2012 minus 1945).
 * @param maxLandType: String, the U.S. Department of Agriculture land use type that 
 * experienced the most change between 1945 and 2012.
 * @param maxRegion: String, the U.S. Department of Agriculture region.
 * 
 * @author M Lafranchise
 * @email pulchrit@gmail.com
 *
 */
public class RegionMaxLandUseDelta {
    
    // Creating private fields for each parameter.
    private int maxLandValue;
    private String maxLandType;
    private String maxRegion;

    // Constructor assigns values to fields.
    public RegionMaxLandUseDelta(int maxLandValue, String maxLandType, String maxRegion) {
        this.maxLandValue = maxLandValue;
        this.maxLandType = maxLandType;
        this.maxRegion = maxRegion;
    }

    /**
     * Gets value of maximum land use change. 
     * @return Int, value.
     */ 
    public int getMaxLandValue() {
        return maxLandValue;
    }
    
    /**
     * Gets Land Type of maximum land use change. 
     * @return String, Land Type.
     */ 
    public String getMaxLandType() {
        return maxLandType;
    }

    /**
     * Gets region associated with land use change. 
     * @return String, Region.
     */    
    public String getMaxRegion() {
        return maxRegion;
    }
    
    /**
     * Gets sign of value. Helper method.
     * 
     * Uses signum() to determine if value is positive or negative.
     * 
     * @param value, Integer to be checked for sign.
     * @return String, 'increased' for positive values, and 'decreased' for
     * negative values.
     */
    public String getSignMaxLandValue(Integer value) {
       
        // Use signum() to determine sign. signum() returns 1.0 for positive 
        // and -1.0 for negative.
        // Attribution: https://docs.oracle.com/javase/8/docs/api/java/lang/Math.html#signum-float-
        // Attribution: https://stackoverflow.com/questions/13988805/fastest-way-to-get-sign-in-java
        // Save and return appropriate message of 'increased' for positive 
        // or 'decreased' for negative.
        
        String increaseOrDecrease = "";
        
        if (Math.signum(value) == 1.0) {
            increaseOrDecrease = "increased";
        } else if (Math.signum(value) == -1.0) {
            increaseOrDecrease = "decreased";
        }
        return increaseOrDecrease;
    }

    /**
     * Formats and prints content of RegionMaxLandUseDelta instance.
     * Overrides toString() method.
     * 
     * Instructions from:
     * https://www.geeksforgeeks.org/overriding-tostring-method-in-java/
     * 
     */
    @Override
    public String toString() {
        
        String regionMaxLandUseDeltaOutput = String.format(
                "The region in which the land use changed the most between \n" 
                + "1945 and 2012 is %s. The land type of %s  \n" 
                + "%s by %d acres.", 
                this.getMaxRegion(), this.getMaxLandType(), 
                this.getSignMaxLandValue(this.getMaxLandValue()), 
                this.getMaxLandValue());
        return regionMaxLandUseDeltaOutput;
    }
}
