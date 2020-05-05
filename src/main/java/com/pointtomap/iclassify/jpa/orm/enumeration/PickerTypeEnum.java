package com.pointtomap.iclassify.jpa.orm.enumeration;

public enum PickerTypeEnum {
    pattern_type("patternType"), mining_method("miningMethod"), detonation_method(
	    "detonationMethod"), firing_location("firingLocation"), rock_type(
	    "rockType"), stemming("stemming"), bench("bench"), quarry_site(
	    "quarrySite"), wind_velocity("windVelocity"), blaster_name(
	    "blasterName"), wind_direction("windDirection"), weather("weather"), blast_detail_comments(
	    "blastDetailComments");

    public static final Class<PickerTypeEnum> TYPE = PickerTypeEnum.class;

    private String camelName = "";

    PickerTypeEnum(String camelName) {
	this.camelName = camelName;
    }

    public String getCamelName() {
	return camelName;
    }

}
