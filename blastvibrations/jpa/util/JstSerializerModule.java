package com.blastvibrations.jpa.util;

import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.vividsolutions.jts.geom.Geometry;

public class JstSerializerModule extends SimpleModule {

	/**
	 *
	 */
	private static final long serialVersionUID = 3778067686183868843L;

	public JstSerializerModule() {
		super("GeoJson", new Version(1, 0, 0, null, "com.blastvibrations",
				"jackson-geojson"));

		addSerializer(Geometry.class, new GeometrySerializer());
		addDeserializer(Geometry.class, new GeometryDeserializer());
	}
}